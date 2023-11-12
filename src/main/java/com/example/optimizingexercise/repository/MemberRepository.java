package com.example.optimizingexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.optimizingexercise.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
