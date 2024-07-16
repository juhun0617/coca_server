package com.example.coca_server.Repository;

import com.example.coca_server.Entity.Member;
import com.example.coca_server.Entity.MemberConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberConfigRepository extends JpaRepository<MemberConfig, Integer> {
    Optional<MemberConfig> findByMembername(String membername);
    List<MemberConfig> findByMembernameContainingIgnoreCase(String memebername);
    List<MemberConfig> findByMembercategory(String membercategory);

}
