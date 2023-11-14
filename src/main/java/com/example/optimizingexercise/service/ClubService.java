package com.example.optimizingexercise.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.optimizingexercise.dto.ClubDTO;
import com.example.optimizingexercise.dto.ClubRequest;
import com.example.optimizingexercise.entity.Club;
import com.example.optimizingexercise.repository.ClubRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ClubService {
	private final ClubRepository clubRepository;

	public ClubDTO create(ClubRequest clubRequest) {
		Club save = clubRepository.save(Club.createClub(clubRequest));
		log.info("club 생성");
		return ClubDTO.fromEntity(save);
	}

	public ClubDTO readById(Long id) {
		Optional<Club> byId = clubRepository.findById(id);
		return ClubDTO.fromEntity(byId.get());
	}

	public ClubDTO readByClubName(String clubName) {
		Club club = clubRepository.findByClubName(clubName).get();
		return ClubDTO.fromEntity(club);
	}

	public void delete(Long id) {
		clubRepository.deleteById(id);
		log.info("club 삭제");
	}
}
