package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class NumberFinder {
	public static int find() throws IOException {
		int ultimateNumber = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("expenseReport.txt")))){
			ArrayList<Integer> expenseNumbers = new ArrayList<>();
			String st;
			while ((st = br.readLine()) != null) {
				Integer newNumber = Integer.parseInt(st);
				expenseNumbers.add(newNumber);
		    	for (int i = 0; i < expenseNumbers.size(); i++) {
		    		for (int j = 0; j < expenseNumbers.size(); j++)
		    		if ((expenseNumbers.get(i) + expenseNumbers.get(j) + newNumber) == 2020) {
		    			ultimateNumber =  expenseNumbers.get(i) * expenseNumbers.get(j) * newNumber;
		    		}
		    	}
			}
		}
		return ultimateNumber;	
	}
	
	public static void findBy8() throws IOException {
		int ultimateNumber = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("expenseReport.txt")))){
			ArrayList<Integer> expenseNumbers = new ArrayList<>();
			String st;
			while ((st = br.readLine()) != null) {
				Integer newNumber = Integer.parseInt(st);
				expenseNumbers.add(newNumber);
		    	for (Integer number : expenseNumbers) {
		    		if ((newNumber + number) == 2020) {
		    			ultimateNumber =  newNumber * number;
		    		}
		    	}
			}
		}	
	}
	
}
