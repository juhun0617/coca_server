package com.example.coca_server.Repository;

import com.example.coca_server.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByMembername(String membername);
}
