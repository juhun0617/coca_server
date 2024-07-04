package com.example.coca_server.Controller;


import com.example.coca_server.Entity.TableConfig;
import com.example.coca_server.Model.TableConfigRequest;
import com.example.coca_server.Repository.TableConfigRepository;
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

    @PostMapping("/tableconfig")
    public ResponseEntity<List<TableConfig>> sendTableConfig(@RequestBody TableConfigRequest request){
        String membername = request.getMembername();

        List<TableConfig> tableConfigs = tableConfigRepository.findByMembername(membername);
        return ResponseEntity.ok(tableConfigs);

    }

    @PutMapping("/tableconfig")
    public void writeTableConfig(@RequestBody List<TableConfig> request) {
        String membername = request.isEmpty() ? null : request.get(0).getMembername();
        // 기존 데이터베이스에 저장된 모든 TableConfig 데이터를 가져옴
        List<TableConfig> existingConfigs = membername != null ? tableConfigRepository.findByMembername(membername) : new ArrayList<>();

        // 기존 데이터베이스에 있는 모든 데이터 삭제
        for (TableConfig existingConfig : existingConfigs) {
            tableConfigRepository.delete(existingConfig);
        }

        if (!request.isEmpty() && request.get(0).getTablenum() != -1){
          // 새롭게 들어온 데이터 저장
            for (TableConfig newConfig : request) {
                tableConfigRepository.save(newConfig);
            }
        }



    }




}
