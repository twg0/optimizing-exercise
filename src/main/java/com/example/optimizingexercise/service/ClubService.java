package com.example.optimizingexercise.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.optimizingexercise.dto.ClubDTO;
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

	public ClubDTO create(ClubDTO clubDTO) {
		Club save = clubRepository.save(Club.createClub(clubDTO));
		log.info("club 생성");
		return ClubDTO.fromEntity(save);
	}

	public void delete(Long id) {
		clubRepository.deleteById(id);
		log.info("club 삭제");
	}
}
