package com.example.coca_server.Repository;

import com.example.coca_server.Entity.MemberState;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberStateRepository extends JpaRepository<MemberState, Integer> {


    Optional<MemberState> findByMembername(String membername);
}
