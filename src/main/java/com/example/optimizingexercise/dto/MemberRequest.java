package com.example.optimizingexercise.dto;

import com.example.optimizingexercise.entity.Member;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberRequest {
	private Long id;

	private String userName;
	private String birth;
	private Integer height;
	private Integer weight;
	private String nationality;

	private String teamName;
	private String position;
	private Integer backNumber;
	private Integer inGame;
	private Integer goal;
	private Integer assist;
}
