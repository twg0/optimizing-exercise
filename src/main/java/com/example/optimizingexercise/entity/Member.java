package com.example.optimizingexercise.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Builder
	private Member(Long id, String userName, String birth, Integer height, Integer weight, String nationality,
		String teamName, String position, Integer backNumber, Integer inGame, Integer goal, Integer assist) {
		this.id = id;
		this.userName = userName;
		this.birth = birth;
		this.height = height;
		this.weight = weight;
		this.nationality = nationality;
		this.teamName = teamName;
		this.position = position;
		this.backNumber = backNumber;
		this.inGame = inGame;
		this.goal = goal;
		this.assist = assist;
	}

	/* 연관 관계 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id")
	private Club club;

	@OneToMany(mappedBy = "member")
	private List<Account> accounts = new ArrayList<>();

	public void setAccount(Account account) {
		this.accounts.add(account);
	}

	public void setClub(Club club) {
		this.club = club;
		club.setMember(this);
	}
}
