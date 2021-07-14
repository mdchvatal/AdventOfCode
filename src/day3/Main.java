package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(countTrees1by1() * countTrees3by1() * countTrees5by1() * countTrees7by1() * countTrees1by2());
	}
	
	public static int countTrees1by1() throws FileNotFoundException, IOException {
		int treeCounter = 0;
		ArrayList<char[]> mapList = new ArrayList<>();
		String line;
		int horizontalCounter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("resources/treeMap.txt")))){
			while ((line = br.readLine()) != null) {
				mapList.add(line.toCharArray());
			}
			for (int i = 1; i < mapList.size(); i++) {
				if (horizontalCounter + 1 >= mapList.get(i).length) {
					horizontalCounter = (horizontalCounter + 1) - 31;
				} else {
					horizontalCounter += 1;
				}
				if (mapList.get(i)[horizontalCounter] == '#') {
					treeCounter++;
				}
			}
			System.out.println(treeCounter);
			return treeCounter;
		}
		
	}
	
	public static int countTrees3by1() throws FileNotFoundException, IOException {
		int treeCounter = 0;
		ArrayList<char[]> mapList = new ArrayList<>();
		String line;
		int horizontalCounter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("resources/treeMap.txt")))){
			while ((line = br.readLine()) != null) {
				mapList.add(line.toCharArray());
			}
			for (int i = 1; i < mapList.size(); i++) {
				if (horizontalCounter + 3 >= mapList.get(i).length) {
					horizontalCounter = (horizontalCounter + 3) - 31;
				} else {
					horizontalCounter += 3;
				}
				if (mapList.get(i)[horizontalCounter] == '#') {
					treeCounter++;
				}
			}
			System.out.println(treeCounter);

			return treeCounter;
		}
		
	}
	
	public static int countTrees5by1() throws FileNotFoundException, IOException {
		int treeCounter = 0;
		ArrayList<char[]> mapList = new ArrayList<>();
		String line;
		int horizontalCounter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("resources/treeMap.txt")))){
			while ((line = br.readLine()) != null) {
				mapList.add(line.toCharArray());
			}
			for (int i = 1; i < mapList.size(); i++) {
				if (horizontalCounter + 5 >= mapList.get(i).length) {
					horizontalCounter = (horizontalCounter + 5) - 31;
				} else {
					horizontalCounter += 5;
				}
				if (mapList.get(i)[horizontalCounter] == '#') {
					treeCounter++;
				}
			}
			System.out.println(treeCounter);

			return treeCounter;
		}
		
	}
	
	public static int countTrees7by1() throws FileNotFoundException, IOException {
		int treeCounter = 0;
		ArrayList<char[]> mapList = new ArrayList<>();
		String line;
		int horizontalCounter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("resources/treeMap.txt")))){
			while ((line = br.readLine()) != null) {
				mapList.add(line.toCharArray());
			}
			for (int i = 1; i < mapList.size(); i++) {
				if (horizontalCounter + 7 >= mapList.get(i).length) {
					horizontalCounter = (horizontalCounter + 7) - 31;
				} else {
					horizontalCounter += 7;
				}
				if (mapList.get(i)[horizontalCounter] == '#') {
					treeCounter++;
				}
			}
			System.out.println(treeCounter);

			return treeCounter;
		}
	}
	
	public static int countTrees1by2() throws FileNotFoundException, IOException {
		int treeCounter = 0;
		ArrayList<char[]> mapList = new ArrayList<>();
		String line;
		int horizontalCounter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("resources/treeMap.txt")))){
			while ((line = br.readLine()) != null) {
				mapList.add(line.toCharArray());
			}
			for (int i = 2; i < mapList.size(); i += 2) {
				if (horizontalCounter + 1 >= mapList.get(i).length) {
					horizontalCounter = (horizontalCounter + 1) - 31;
				} else {
					horizontalCounter += 1;
				}
				if (mapList.get(i)[horizontalCounter] == '#') {
					treeCounter++;
				}
			}
			System.out.println(treeCounter);

			return treeCounter;
		}
		
	}
}
