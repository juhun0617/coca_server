package com.example.coca_server.Controller;


import com.example.coca_server.Entity.TableConfig;
import com.example.coca_server.Entity.TableStatus;
import com.example.coca_server.Model.TableConfigRequest;
import com.example.coca_server.Model.TableFloorRemoveRequest;
import com.example.coca_server.Repository.TableConfigRepository;
import com.example.coca_server.Repository.TableStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tableapi")
public class TableConfigController {

    @Autowired
    private TableConfigRepository tableConfigRepository;

    @Autowired
    TableStatusRepository tableStatusRepository;

    @PostMapping("/tableconfig")
    public ResponseEntity<List<TableConfig>> sendTableConfig(@RequestBody TableConfigRequest request){
        String membername = request.getMembername();

        List<TableConfig> tableConfigs = tableConfigRepository.findByMembername(membername);
        return ResponseEntity.ok(tableConfigs);

    }

    @PutMapping("/tableconfigadd")
    public void addTableConfig(@RequestBody TableConfig request){
        tableConfigRepository.save(request);

        TableStatus newStatus = new TableStatus();
        newStatus.setMembername(request.getMembername());
        newStatus.setFloor(request.getFloor());
        newStatus.setTablenum(request.getTablenum());
        newStatus.setIson(false);

        tableStatusRepository.save(newStatus);

    }

    @PutMapping("/tableconfig")
    public void writeTableConfig(@RequestBody List<TableConfig> request) {
        String membername = request.isEmpty() ? null : request.get(0).getMembername();
        String floor = request.isEmpty() ? null : request.get(0).getFloor();

        // 기존 데이터베이스에 저장된 모든 TableConfig 데이터를 가져옴
        List<TableConfig> existingConfigs = tableConfigRepository.findByMembernameAndFloor(membername, floor);


        List<TableStatus> statuses = tableStatusRepository.findByMembernameAndFloor(membername, floor);
        tableStatusRepository.deleteAll(statuses);

        // 기존 데이터베이스에 있는 모든 데이터 삭제
        tableConfigRepository.deleteAll(existingConfigs);
        tableStatusRepository.deleteAll(statuses);

        if (!request.isEmpty() && request.get(0).getTablenum() != -1) {
            // 새롭게 들어온 데이터 저장
            for (TableConfig newConfig : request) {
                tableConfigRepository.save(newConfig);

                // TableStatus 동기화
                TableStatus newStatus = new TableStatus();
                newStatus.setMembername(newConfig.getMembername());
                newStatus.setFloor(newConfig.getFloor());
                newStatus.setTablenum(newConfig.getTablenum());
                newStatus.setIson(false);  // 초기 상태를 false로 설정

                tableStatusRepository.save(newStatus);
            }
        }
    }

    @PutMapping("/tablefloorremove")
    public ResponseEntity<String> removeFloor(@RequestBody TableFloorRemoveRequest tableFloorRemoveRequest) {
        String membername = tableFloorRemoveRequest.getMembername();
        String floor = tableFloorRemoveRequest.getFloor();

        List<TableConfig> configs = tableConfigRepository.findByMembernameAndFloor(membername, floor);
        tableConfigRepository.deleteAll(configs);

        // 해당 floor의 TableStatus도 모두 삭제
        List<TableStatus> statuses = tableStatusRepository.findByMembernameAndFloor(membername, floor);
        tableStatusRepository.deleteAll(statuses);

        return ResponseEntity.ok("Success");
    }





}
