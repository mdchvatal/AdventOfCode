package day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	static HashMap<String, String[]> bagMap = new HashMap<>(); 
	static HashSet<String> bagColorList = new HashSet<>();
	
	public static void main(String[] args) {
		try {
			findBags();
		} catch(FileNotFoundException fnf) {
			System.out.println("File not found");
		} catch (IOException ioe) {
			System.out.println("Cannot read file");
		}
		System.out.println(countBags("shiny gold"));
	}
	
	public static void findBags() throws FileNotFoundException, IOException {
		String line;
		try (BufferedReader buffRead = new BufferedReader(new FileReader(new File("resources/bagRules.txt")))) {
			while ((line = buffRead.readLine()) != null) {
				String[] lineArray = line.split("bags contain ");
				String bagIndex = lineArray[0];
				if (lineArray[1].equals("no other bags")) {
					bagMap.put(bagIndex, new String[1]);
				} else {
					String[] containedBags = lineArray[1].split("bags?,?.?\\s?");
					bagMap.put(bagIndex, containedBags);
				}
				 
			}
		}
	}
	
	public static int countBags(String bagName) {
		bagMap.forEach((key, value) -> {
			for (String bag : value) {
				if (bag.contains(bagName)) {
					bagColorList.add(key);
					countBags(key);
				}
			}
		});
		return bagColorList.size();
	}
	
	
}
