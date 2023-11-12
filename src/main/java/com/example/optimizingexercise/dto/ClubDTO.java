package com.example.optimizingexercise.dto;

import com.example.optimizingexercise.entity.Club;

import lombok.Builder;

@Builder
public class ClubDTO {

	private Long id;
	private String clubName;

	public ClubDTO fromEntity(Club club) {
		return ClubDTO.builder()
			.id(club.getId())
			.clubName(club.getClubName())
			.build();
	}
}
