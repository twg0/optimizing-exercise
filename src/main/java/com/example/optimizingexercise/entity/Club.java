package com.example.optimizingexercise.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.optimizingexercise.dto.ClubDTO;
import com.example.optimizingexercise.dto.ClubRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club {
	@Id @GeneratedValue
	private Long id;

	@Column(unique = true)
	private String clubName;

	/* 연관 관계 */
	@OneToMany(mappedBy = "club")
	private List<Member> members = new ArrayList<>();

	@OneToMany(mappedBy = "club")
	private List<Account> accounts = new ArrayList<>();

	public void setMember(Member member) {
		this.members.add(member);
	}

	public void setAccount(Account account) {
		this.accounts.add(account);
	}

	@Builder
	private Club(String clubName) {
		this.clubName = clubName;
	}

	public static Club createClub(ClubRequest clubRequest) {
		return Club.builder()
			.clubName(clubRequest.getClubName())
			.build();
	}
}
