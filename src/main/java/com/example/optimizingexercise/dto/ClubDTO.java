package com.example.optimizingexercise.dto;

import com.example.optimizingexercise.entity.Club;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClubDTO {

	private Long id;
	private String clubName;

	public static ClubDTO fromEntity(Club club) {
		return ClubDTO.builder()
			.id(club.getId())
			.clubName(club.getClubName())
			.build();
	}
}
