package com.example.optimizingexercise.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.optimizingexercise.dto.AccountRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String accountNumber;
	private Long money;

	/* 연관 관계 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id")
	private Club club;

	public void setClub(Club club) {
		club.setAccount(this);
		this.club = club;
	}

	public void setMember(Member member) {
		member.setAccount(this);
		this.member = member;
	}

	@Builder
	private Account(String accountNumber, Long money, Member member, Club club) {
		this.accountNumber = accountNumber;
		this.money = money;
		this.member = member;
		this.club = club;
	}

	public static Account createAccount(AccountRequest accountRequest, Member member, Club club) {
		return Account.builder()
			.accountNumber(accountRequest.getAccountNumber())
			.money(accountRequest.getMoney())
			.member(member)
			.club(club)
			.build();
	}

	/**
	 * 입금
	 */
	public Long deposit(Long money) {
		this.money += money;
		return this.money;
	}

	/**
	 * 출금
	 */
	public Long withdraw(Long money) {
		this.money -= money;
		return this.money;
	}
}
