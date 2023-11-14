package com.example.optimizingexercise.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.optimizingexercise.dto.AccountDTO;
import com.example.optimizingexercise.dto.AccountRequest;
import com.example.optimizingexercise.entity.Account;
import com.example.optimizingexercise.entity.Club;
import com.example.optimizingexercise.entity.Member;
import com.example.optimizingexercise.repository.AccountRepository;
import com.example.optimizingexercise.repository.ClubRepository;
import com.example.optimizingexercise.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository accountRepository;
	private final MemberRepository memberRepository;
	private final ClubRepository clubRepository;

	public AccountDTO create(AccountRequest accountRequest, Long memberId, Long clubId) {
		Account save = null;
		if(memberId == null) {
			Club club = clubRepository.findById(clubId).get();
			save = accountRepository.save(Account.createAccount(accountRequest, null, club));
			save.setClub(club);
		} else {
			Member member = memberRepository.findById(memberId).get();
			save = accountRepository.save(Account.createAccount(accountRequest, member, null));
			save.setMember(member);
		}
		return AccountDTO.fromEntity(save);
	}
}
