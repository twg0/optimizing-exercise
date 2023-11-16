package com.example.optimizingexercise.file;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.optimizingexercise.dto.ClubRequest;
import com.example.optimizingexercise.dto.MemberRequest;
import com.example.optimizingexercise.repository.ClubRepository;
import com.example.optimizingexercise.service.AccountService;
import com.example.optimizingexercise.service.ClubService;
import com.example.optimizingexercise.service.MemberService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FileService {
	private final AccountService accountService;
	private final ClubService clubService;
	private final ClubRepository clubRepository;
	private final MemberService memberService;
	private final CSVReader csvReader;

	@PostConstruct
	public void setUp() {
		log.info("setUp 시작");
		List<List<String>> csvList = csvReader.getCsvList();
		int i = 0;
		for (List<String> strings : csvList) {
			if(strings.get(0).equals("이름")) continue;
			String clubName = strings.get(9);
			if(!clubRepository.existsByClubName(clubName)) {
				clubService.create(
					ClubRequest.builder()
						.clubName(clubName)
						.build()
				);
			}
			log.info("line " + i++);
			while(strings.size() < 13) {
				strings.add("-1");
			}
			memberService.create(
				MemberRequest.builder()
					.userName(strings.get(0))
					.teamName(strings.get(1))
					.backNumber(Integer.parseInt(strings.get(2).equals("") ? "-1":strings.get(2).replaceAll(" ","")))
					.birth(strings.get(3))
					.height(Integer.parseInt(strings.get(4).equals("") ? "-1":strings.get(4).replaceAll(" ","")))
					.position(strings.get(5))
					.nationality(strings.get(6))
					.weight(Integer.parseInt(strings.get(7).equals("") ? "-1":strings.get(7).replaceAll(" ","")))
					.year(Integer.parseInt(strings.get(8).equals("") ? "-1":strings.get(8).replaceAll(" ","")))
					.inGame(Integer.parseInt(strings.get(10).equals("") ? "-1":strings.get(10).replaceAll(" ","")))
					.goal(Integer.parseInt(strings.get(11).equals("") ? "-1":strings.get(11).replaceAll(" ","")))
					.assist(Integer.parseInt(strings.get(12).equals("") ? "-1":strings.get(12).replaceAll(" ","")))
					.build()
				, clubName
			);
		}
		log.info("setUp 끝");
	}
}
