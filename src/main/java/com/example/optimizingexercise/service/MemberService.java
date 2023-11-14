package com.example.optimizingexercise.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.optimizingexercise.dto.MemberDTO;
import com.example.optimizingexercise.dto.MemberRequest;
import com.example.optimizingexercise.entity.Club;
import com.example.optimizingexercise.entity.Member;
import com.example.optimizingexercise.repository.ClubRepository;
import com.example.optimizingexercise.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	private final ClubRepository clubRepository;

	public MemberDTO create(MemberRequest memberRequest, Long clubId) {
		Member save = memberRepository.save(Member.createMember(memberRequest));
		Club club = clubRepository.findById(clubId).get();
		save.setClub(club);
		return MemberDTO.fromEntity(save);
	}

	public MemberDTO readById(Long id) {
		Optional<Member> byId = memberRepository.findById(id);
		return MemberDTO.fromEntity(byId.get());
	}
}
