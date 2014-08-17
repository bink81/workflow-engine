package com.marzeta.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CsvImporter {
	public CsvImporter() {
		List<String[]> lines = Collections.emptyList();
		try {
			CSVReader reader = new CSVReader(new FileReader("data.csv"));
			lines = reader.readAll();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String[] line : lines) {
			for (String element : line) {
				System.out.print(element + "\t---\t");
			}
			System.out.println("\n---");
		}
	}

	public static void main(String[] args) {
		new CsvImporter();
	}
}