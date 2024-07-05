package com.example.coca_server.Controller;


import com.example.coca_server.Entity.TableConfig;
import com.example.coca_server.Entity.TableStatus;
import com.example.coca_server.Model.TableStatusRequest;
import com.example.coca_server.Repository.TableStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tablestatusapi")
public class TableStatusController {

    @Autowired
    TableStatusRepository tableStatusRepository;

    @PostMapping("tableison")
    public ResponseEntity<TableStatus> sendTableStatus(@RequestBody TableStatusRequest request){
        String membername = request.getMembername();
        String floor = request.getFloor();
        int tablenum = request.getTablenum();

        TableStatus tableStatus = tableStatusRepository.findByMembernameAndTablenumAndFloor(membername,tablenum,floor);

        return ResponseEntity.ok(tableStatus);

    }

    @PutMapping("tableseton")
    public void writeTableSet(@RequestBody TableStatus request){
        String membername = request.getMembername();
        String floor = request.getFloor();
        int tablenum = request.getTablenum();

        TableStatus tableStatus = tableStatusRepository.findByMembernameAndTablenumAndFloor(membername,tablenum,floor);
        tableStatusRepository.delete(tableStatus);
        tableStatusRepository.save(request);


    }

}
