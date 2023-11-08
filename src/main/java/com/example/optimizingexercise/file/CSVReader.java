package com.example.optimizingexercise.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CSVReader {
	private List<List<String>> csvList;

	protected CSVReader() {
		readCSV();
	}

	private void readCSV() {
		this.csvList = new ArrayList<>();
		File csv = new File("C:\\Users\\twg0\\Desktop\\Develop\\LikeLion\\optimizing-exercise\\src\\main\\resources\\csv\\k_soccer_player.csv");
		BufferedReader br = null;
		String line = "";

		try {
			br = new BufferedReader(new FileReader(csv));
			while ((line = br.readLine()) != null) {
				String[] lineArr = line.split(",");
				List<String> aLine = Arrays.asList(lineArr);
				this.csvList.add(aLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<List<String>> getCsvList() {
		return this.csvList;
	}
}