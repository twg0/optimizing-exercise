package com.example.optimizingexercise.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.optimizingexercise.entity.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

	Optional<Club> findByClubName(String clubName);

	boolean existsByClubName(String clubName);
}
