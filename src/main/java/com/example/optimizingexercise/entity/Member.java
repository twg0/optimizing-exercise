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

	/* 연관 관계 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id")
	private Club club;

	@OneToMany(mappedBy = "member")
	private List<Account> accounts = new ArrayList<>();
}
