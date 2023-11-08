package com.example.optimizingexercise.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.optimizingexercise.file.CSVReader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController("/")
@RequiredArgsConstructor
public class HomeController {
	private final CSVReader csvReader;

	@GetMapping("list")
	public ResponseEntity home() {
		List<List<String>> csvList = csvReader.getCsvList();
		if(csvList != null)
			log.info("success");
		return ResponseEntity.ok(csvList);
	}
}
