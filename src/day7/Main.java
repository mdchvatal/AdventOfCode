package day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
	static HashMap<String, String[]> bagMap = new HashMap<>(); 
	static HashMap<String, HashMap<Integer, String>> bagMap2 = new HashMap<>(); 
	static HashSet<String> bagColorList = new HashSet<>();
	static long bagTotal = 0;
	
	public static void main(String[] args) {
		try {
			findBags();
		} catch(FileNotFoundException fnf) {
			System.out.println("File not found");
		} catch (IOException ioe) {
			System.out.println("Cannot read file");
		}
		//System.out.println(bagMap2.size());
		System.out.println(countBagsAgain("shiny gold "));
		
	}
	
	
	public static void findBags() throws FileNotFoundException, IOException {
		String line;
		try (BufferedReader buffRead = new BufferedReader(new FileReader(new File("resources/bagRules.txt")))) {
			while ((line = buffRead.readLine()) != null) {
				String[] lineArray = line.split("bags contain ");
				String bagIndex = lineArray[0];
				if (lineArray[1].equals("no other bags.")) {
					bagMap.put(bagIndex, new String[1]);
					bagMap.get(bagIndex)[0] = "0 bags";
				} else {
					String[] containedBags = lineArray[1].split("bags?,?.?\\s?");
					bagMap.put(bagIndex, containedBags);
				}
				 
			}
		}
	}
	
	public static void findBagsAgain() throws FileNotFoundException, IOException {
		String line;
		try (BufferedReader buffRead = new BufferedReader(new FileReader(new File("resources/bagRules.txt")))) {
			while ((line = buffRead.readLine()) != null) {
				String[] lineArray = line.split("bags contain ");
				String bagIndex = lineArray[0];
				if (lineArray[1].equals("no other bags.")) {
					bagMap2.put(bagIndex, new HashMap<Integer, String>());
					bagMap2.get(bagIndex).put(0, "bags");
				} else {
					String[] containedBags = lineArray[1].split("bags?,?.?\\s?");
					bagMap2.put(bagIndex, new HashMap<Integer, String>());
					for (String bag : containedBags) {
						bagMap2.get(bagIndex).put(Integer.parseInt(String.valueOf(bag.charAt(0))), bag.substring(2));
					}
				}
				 
			}
		}
	}
	
	public static int countBags(String bagName) {
		System.out.println(bagMap.size());
		bagMap.forEach((key, value) -> {
			for (String bag : value) {
				if (bag == null) {
					return;
				} else if (bag.contains(bagName)) {
					bagColorList.add(key);
					countBags(key);
				}
			}
		});
		return bagColorList.size();
	}
	
	public static long countBagsAgain(String bagName) {
		for (Map.Entry<String, String[]> mapEntry : bagMap.entrySet()) {
			if (mapEntry.getKey().contains(bagName)) {
				for (String bag : mapEntry.getValue()) {
					if (Long.parseLong(String.valueOf(bag.charAt(0))) == 0) {
						return 1;
					} else {
						int multiplier = Integer.parseInt(String.valueOf(bag.charAt(0)));
						bagTotal += multiplier + (multiplier * countBagsAgain(bag.substring(2)));
					}
				}
			}
		}
		return bagTotal;
	}
	
	
	
}
