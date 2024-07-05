package com.example.coca_server.Repository;

import com.example.coca_server.Entity.TableConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TableConfigRepository extends JpaRepository<TableConfig, Integer> {
    List<TableConfig> findByMembername(String membername);

    List<TableConfig> findByMembernameAndFloor(String membername, String floor);



}
