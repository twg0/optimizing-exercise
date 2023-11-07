package com.example.optimizingexercise.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.optimizingexercise.file.CSVReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController("/")
public class HomeController {

	@GetMapping("list")
	public ResponseEntity home() {
		List<List<String>> csvList = CSVReader.getCsvList();
		if(csvList != null)
			log.info("success");
		return ResponseEntity.ok(csvList);
	}
}
