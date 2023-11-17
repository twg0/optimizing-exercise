package com.example.optimizingexercise.service;

import java.util.List;
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

	public AccountDTO create(AccountRequest accountRequest, Long memberId, String clubName) {
		Account save = null;
		if(memberId == null) {
			Club club = clubRepository.findByClubName(clubName).get();
			save = accountRepository.save(Account.createAccount(accountRequest, null, club));
			save.setClub(club);
		} else {
			Member member = memberRepository.findById(memberId).get();
			save = accountRepository.save(Account.createAccount(accountRequest, member, null));
			save.setMember(member);
		}
		return AccountDTO.fromEntity(save);
	}

	public AccountDTO readById(Long id) {
		Optional<Account> byId = accountRepository.findById(id);
		return AccountDTO.fromEntity(byId.get());
	}

	/**
	 * 전체 구단에 입금
	 */
	public void depositToAllClub(Long money) {
		log.info("전체 {}원 입금", money);
		List<Account> all = accountRepository.findAll();
		for (Account account : all) {
			account.deposit(money);
		}
		log.info("입금 완료");
	}
}
