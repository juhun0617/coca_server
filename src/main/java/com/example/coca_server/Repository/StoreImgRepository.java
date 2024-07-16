package com.example.coca_server.Repository;

import com.example.coca_server.Entity.StoreImg;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreImgRepository extends JpaRepository<StoreImg, Integer> {

    Optional<StoreImg> findByMembername(String membername);
}
