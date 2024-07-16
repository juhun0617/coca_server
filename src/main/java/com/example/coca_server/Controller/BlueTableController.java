package com.example.coca_server.Controller;


import com.example.coca_server.Entity.*;
import com.example.coca_server.Function.JaccardSimilarity;
import com.example.coca_server.Function.LevenshteinDistance;
import com.example.coca_server.Model.MapResponse;
import com.example.coca_server.Model.MemberDetailResponse;
import com.example.coca_server.Model.RecommendResonse;
import com.example.coca_server.Model.TableConfigModel;
import com.example.coca_server.Repository.*;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BlueTableController {

    @Autowired
    StoreImgRepository storeImgRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberConfigRepository memberConfigRepository;

    @Autowired
    MemberStateRepository memberStateRepository;

    @Autowired
    TableStatusRepository tableStatusRepository;

    @Autowired
    TableConfigRepository tableConfigRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/recommand")
    public ResponseEntity<List<RecommendResonse>> recommendResonses(){
        List<StoreImg> storeImgList = storeImgRepository.findAll();
        Collections.shuffle(storeImgList, new Random());
        List<StoreImg> responseList = storeImgList.subList(0,3);

        List<RecommendResonse> recommendResonseList = new ArrayList<>();
        for (StoreImg storeImg : responseList){

            Optional<MemberConfig> memberConfigOptional = memberConfigRepository.findByMembername(storeImg.getMembername());
            MemberConfig memberConfig = memberConfigOptional.get();

            Optional<Member> memberOptional = memberRepository.findByMembername(storeImg.getMembername());
            Member member = memberOptional.get();

            List<TableStatus> tableStatusList = tableStatusRepository.findByMembername(storeImg.getMembername());
            int alltable = tableStatusList.size();

            List<TableStatus> leftTable = new ArrayList<>();
            for (TableStatus tableStatus : tableStatusList){
                if (!tableStatus.isIson()){
                    leftTable.add(tableStatus);
                }
            }
            int lefttable = leftTable.size();

            RecommendResonse recommendResonse = new RecommendResonse();
            recommendResonse.setMembername(storeImg.getMembername());
            recommendResonse.setImg("data:image/jpeg;base64,"+Base64.getEncoder().encodeToString(storeImg.getImg()));
            recommendResonse.setMemberstorepoint(member.getMemberstorepoint());
            recommendResonse.setMemberposition(memberConfig.getMemberposition());
            recommendResonse.setAlltable(alltable);
            recommendResonse.setLefttable(lefttable);
            recommendResonseList.add(recommendResonse);
        }
        return ResponseEntity.ok(recommendResonseList);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{membername}")
    public ResponseEntity<MemberDetailResponse> sendMemberDetail(@PathVariable("membername") String membername){

        Optional<StoreImg> storeImgOptional = storeImgRepository.findByMembername(membername);
        StoreImg storeImg = storeImgOptional.get();
        String img = "data:image/jpeg;base64,"+Base64.getEncoder().encodeToString(storeImg.getImg());

        Optional<Member> memberOptional = memberRepository.findByMembername(membername);
        Member member = memberOptional.get();
        String memberstorepoint = member.getMemberstorepoint();

        Optional<MemberConfig> memberConfigOptional = memberConfigRepository.findByMembername(membername);
        MemberConfig memberConfig = memberConfigOptional.get();
        String memberposition = memberConfig.getMemberposition();
        String memberopentimehour = memberConfig.getMemberopentimehour();
        String memberopentimemin = memberConfig.getMemberopentimemin();
        String memberclosedtimehour = memberConfig.getMemberclosedtimehour();
        String memberclosedtimemin = memberConfig.getMemberclosedtimemin();

        Optional<MemberState> memberStateOptional = memberStateRepository.findByMembername(membername);
        MemberState memberState = memberStateOptional.get();
        boolean memberstate = memberState.isMemberstate();

        String membermobile = memberConfig.getMembermobile();
        String memberspec = memberConfig.getMemberspec();

        List<TableStatus> tableStatusList = tableStatusRepository.findByMembername(membername);
        int alltable = tableStatusList.size();

        List<TableStatus> leftTable = new ArrayList<>();
        for (TableStatus tableStatus : tableStatusList){
            if (!tableStatus.isIson()){
                leftTable.add(tableStatus);
            }
        }
        int lefttable = leftTable.size();

        MemberDetailResponse memberDetailResponse = new MemberDetailResponse();
        memberDetailResponse.setImg(img);
        memberDetailResponse.setMembername(membername);
        memberDetailResponse.setMemberstorepoint(memberstorepoint);
        memberDetailResponse.setMemberposition(memberposition);
        memberDetailResponse.setMemberopentimehour(memberopentimehour);
        memberDetailResponse.setMemberopentimemin(memberopentimemin);
        memberDetailResponse.setMemberclosedtimehour(memberclosedtimehour);
        memberDetailResponse.setMemberclosedtimemin(memberclosedtimemin);
        memberDetailResponse.setMemberstate(memberstate);
        memberDetailResponse.setMembermobile(membermobile);
        memberDetailResponse.setMemberspec(memberspec);
        memberDetailResponse.setAlltable(alltable);
        memberDetailResponse.setLefttable(lefttable);

        return ResponseEntity.ok(memberDetailResponse);

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/search/{membername}")
    public ResponseEntity<List<RecommendResonse>> searching(@PathVariable("membername") String membername) {
        List<MemberConfig> memberConfigSearchResult = memberConfigRepository.findAll();

        int levenshteinThreshold = 5; // Levenshtein Distance 임계값
        double jaccardThreshold = 0.5; // Jaccard Similarity 임계값

        List<MemberConfig> filteredMemberConfigs = memberConfigSearchResult.stream()
                .filter(p -> LevenshteinDistance.calculate(p.getMembername(), membername) <= levenshteinThreshold
                        || JaccardSimilarity.calculate(p.getMembername(), membername) >= jaccardThreshold)
                .sorted(Comparator.comparingInt(p -> LevenshteinDistance.calculate(p.getMembername(), membername)))
                .collect(Collectors.toList());

        List<RecommendResonse> recommendResonseList = new ArrayList<>();
        for (MemberConfig memberConfig : filteredMemberConfigs) {
            RecommendResonse recommendResonse = new RecommendResonse();
            recommendResonse.setMembername(memberConfig.getMembername());

            Optional<StoreImg> storeImgOptional = storeImgRepository.findByMembername(memberConfig.getMembername());
            if (storeImgOptional.isPresent()) {
                StoreImg storeImg = storeImgOptional.get();
                String img = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(storeImg.getImg());
                recommendResonse.setImg(img);
            } else {
                recommendResonse.setImg(null);
            }

            Optional<Member> memberOptional = memberRepository.findByMembername(memberConfig.getMembername());
            if (memberOptional.isPresent()) {
                Member member = memberOptional.get();
                recommendResonse.setMemberstorepoint(member.getMemberstorepoint());
            } else {
                recommendResonse.setMemberstorepoint(null);
            }

            recommendResonse.setMemberposition(memberConfig.getMemberposition());

            List<TableStatus> tableStatusList = tableStatusRepository.findByMembername(memberConfig.getMembername());
            int alltable = tableStatusList.size();
            long lefttable = tableStatusList.stream().filter(ts -> !ts.isIson()).count();

            recommendResonse.setAlltable(alltable);
            recommendResonse.setLefttable((int) lefttable);

            recommendResonseList.add(recommendResonse);
        }

        return ResponseEntity.ok(recommendResonseList);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/map")
    public ResponseEntity<List<MapResponse>> sendMapResponse(){
        List<MemberConfig> memberConfigs = memberConfigRepository.findAll();
        List<MapResponse> mapResponses = new ArrayList<>();

        for (MemberConfig memberConfig : memberConfigs){
            MapResponse mapResponse = new MapResponse();
            mapResponse.setMembername(memberConfig.getMembername());
            mapResponse.setMemberposition(memberConfig.getMemberposition());
            mapResponses.add(mapResponse);
        }

        return ResponseEntity.ok(mapResponses);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/category/{category}")
    public ResponseEntity<List<RecommendResonse>> sendCategoryResponse(@PathVariable("category") String category){
        List<MemberConfig> memberConfigs = memberConfigRepository.findByMembercategory(category);
        List<RecommendResonse> recommendResonseList = new ArrayList<>();

        for (MemberConfig memberConfig : memberConfigs){
            RecommendResonse recommendResonse = new RecommendResonse();
            recommendResonse.setMembername(memberConfig.getMembername());

            Optional<StoreImg> storeImgOptional = storeImgRepository.findByMembername(memberConfig.getMembername());
            if (storeImgOptional.isPresent()) {
                StoreImg storeImg = storeImgOptional.get();
                String img = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(storeImg.getImg());
                recommendResonse.setImg(img);
            } else {
                recommendResonse.setImg(null);
            }

            Optional<Member> memberOptional = memberRepository.findByMembername(memberConfig.getMembername());
            if (memberOptional.isPresent()) {
                Member member = memberOptional.get();
                recommendResonse.setMemberstorepoint(member.getMemberstorepoint());
            } else {
                recommendResonse.setMemberstorepoint(null);
            }

            recommendResonse.setMemberposition(memberConfig.getMemberposition());

            List<TableStatus> tableStatusList = tableStatusRepository.findByMembername(memberConfig.getMembername());
            int alltable = tableStatusList.size();
            long lefttable = tableStatusList.stream().filter(ts -> !ts.isIson()).count();

            recommendResonse.setAlltable(alltable);
            recommendResonse.setLefttable((int) lefttable);

            recommendResonseList.add(recommendResonse);

        }
        return ResponseEntity.ok(recommendResonseList);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{membername}/table")
    public ResponseEntity<List<TableConfigResponse>> sendTableConfig(@PathVariable("membername") String membername){
        List<TableConfig> tableConfigList = tableConfigRepository.findByMembername(membername);
        List<String> floorList = new ArrayList<>();
        for (TableConfig tableConfig : tableConfigList){
            if (!floorList.contains(tableConfig.getFloor())){
                floorList.add(tableConfig.getFloor());
            }
        }

        List<TableConfigResponse> tableConfigResponses = new ArrayList<>();

        Collections.sort(floorList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                boolean isO1Numeric = o1.matches(".*\\d.*");
                boolean isO2Numeric = o2.matches(".*\\d.*");

                if (isO1Numeric && isO2Numeric) {
                    // 두 문자열 모두 숫자를 포함하는 경우, 숫자로 비교
                    int num1 = Integer.parseInt(o1.replaceAll("[^0-9]", ""));
                    int num2 = Integer.parseInt(o2.replaceAll("[^0-9]", ""));
                    return Integer.compare(num1, num2);
                } else if (isO1Numeric) {
                    // o1만 숫자를 포함하는 경우, o1이 앞에 오도록 함
                    return -1;
                } else if (isO2Numeric) {
                    // o2만 숫자를 포함하는 경우, o2가 앞에 오도록 함
                    return 1;
                } else {
                    // 두 문자열 모두 숫자를 포함하지 않는 경우, 알파벳 순서로 비교
                    return o1.compareTo(o2);
                }
            }
        });

        for (String floor : floorList){
            TableConfigResponse tableConfigResponse = new TableConfigResponse();
            tableConfigResponse.setFloor(floor);
            List<TableConfigModel> tableConfigModels = new ArrayList<>();

            List<TableStatus> tableStatusList = tableStatusRepository.findByMembernameAndFloor(membername,floor);
            int alltable = tableStatusList.size();
            long lefttable = tableStatusList.stream().filter(ts -> !ts.isIson()).count();
            tableConfigResponse.setAlltable(alltable);
            tableConfigResponse.setLefttable((int) lefttable);



            for (TableConfig tableConfig : tableConfigList){
                if (tableConfig.getFloor().equals(floor)){
                    tableConfigResponse.setDisplaysizex(tableConfig.getDisplaysizex());
                    tableConfigResponse.setDisplaysizey(tableConfig.getDisplaysizey());
                    TableConfigModel tableConfigModel = new TableConfigModel();
                    tableConfigModel.setPeoples(tableConfig.getPeoples());
                    tableConfigModel.setPx(tableConfig.getPx());
                    tableConfigModel.setPy(tableConfig.getPy());
                    tableConfigModel.setLx(tableConfig.getLx());
                    tableConfigModel.setLy(tableConfig.getLy());
                    TableStatus tableStatus = tableStatusRepository.findByMembernameAndTablenumAndFloor(
                            tableConfig.getMembername(),
                            tableConfig.getTablenum(),
                            tableConfigResponse.getFloor());
                    tableConfigModel.setIson(!tableStatus.isIson());
                    tableConfigModels.add(tableConfigModel);
                }
            }
            tableConfigResponse.setTableConfigModels(tableConfigModels);
            tableConfigResponses.add(tableConfigResponse);
        }
        return ResponseEntity.ok(tableConfigResponses);
    }


}
