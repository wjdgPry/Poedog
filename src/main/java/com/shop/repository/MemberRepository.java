package com.shop.repository;

import com.shop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    @Query("SELECT m.id FROM Member m WHERE m.name = :name AND m.address = :address")
    String findIdByNameAndAddress(@Param("name") String name, @Param("address") String address);
}
