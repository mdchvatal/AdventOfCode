package day2;

import java.util.*;
import java.util.stream.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;


public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		characterValidator();
//		passwordCounter();
	}
	
	public static void passwordCounter() throws FileNotFoundException, IOException {
		int counter = 0;
		int charCounter = 0;
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("passwordList.txt")))){
			while ((line = br.readLine()) != null) {
				String[] lineArr = line.split(" ");
				System.out.println(lineArr[1].charAt(0));
				for (int i = 0; i < lineArr[2].toCharArray().length; i++) {
					if (lineArr[2].toCharArray()[i] == lineArr[1].charAt(0)) {
						charCounter++;
					}
				}
				System.out.println(charCounter);
				String[] numbers = lineArr[0].split("-");
				if (charCounter >= Integer.parseInt(numbers[0]) && charCounter <= Integer.parseInt(numbers[1])) {
					counter++;
				}
				charCounter = 0;
			}
		}
		System.out.println(counter);
	}
	
	public static void characterValidator() throws IOException {
		String line;
		int firstChar;
		int secondChar;
		int counter = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("passwordList.txt")))){
			while ((line = br.readLine()) != null) {
				String[] lineArr = line.split(" ");
				String[] numbers = lineArr[0].split("-");
				firstChar = Integer.parseInt(numbers[0]) - 1;
				secondChar = Integer.parseInt(numbers[1]) - 1;
				if ((lineArr[2].charAt(firstChar) == lineArr[1].charAt(0) && lineArr[2].charAt(secondChar) != lineArr[1].charAt(0)) 
						|| (lineArr[2].charAt(firstChar) != lineArr[1].charAt(0) && lineArr[2].charAt(secondChar) == lineArr[1].charAt(0))) {
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
	
	
	
	
	
}


