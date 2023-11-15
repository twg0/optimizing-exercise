package com.example.optimizingexercise.dto;

import com.example.optimizingexercise.entity.Club;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClubRequest {
	private String clubName;
}
