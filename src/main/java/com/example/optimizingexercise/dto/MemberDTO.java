package com.example.optimizingexercise.dto;

import com.example.optimizingexercise.entity.Member;

import lombok.Builder;

@Builder
public class MemberDTO {
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

	public MemberDTO fromEntity(Member member) {
		return MemberDTO.builder()
			.id(member.getId())
			.userName(member.getUserName())
			.birth(member.getBirth())
			.height(member.getHeight())
			.weight(member.getWeight())
			.nationality(member.getNationality())
			.teamName(member.getTeamName())
			.position(member.getPosition())
			.backNumber(member.getBackNumber())
			.inGame(member.getInGame())
			.goal(member.getGoal())
			.assist(member.getAssist())
			.build();
	}
}
