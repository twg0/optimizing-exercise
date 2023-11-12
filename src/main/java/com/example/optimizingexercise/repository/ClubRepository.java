package com.example.optimizingexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.optimizingexercise.entity.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}
