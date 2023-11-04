package com.example.optimizingexercise.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
	public List<List<String>> readCSV() {
		List<List<String>> csvList = new ArrayList<>();
		File csv = new File("csv파일의 절대경로 입력");
		BufferedReader br = null;
		String line = "";

		try {
			br = new BufferedReader(new FileReader(csv));
			while ((line = br.readLine()) != null) {
				String[] lineArr = line.split(",");
				List<String> aLine = Arrays.asList(lineArr);
				csvList.add(aLine);
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
}
