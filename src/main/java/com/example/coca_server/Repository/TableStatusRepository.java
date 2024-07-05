package com.example.coca_server.Repository;

import com.example.coca_server.Entity.TableStatus;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableStatusRepository extends JpaRepository<TableStatus, Integer> {

    List<TableStatus> findByMembernameAndFloor(String membername, String floor);

    TableStatus findByMembernameAndTablenumAndFloor(String membername, int tablenum, String floor);
}
