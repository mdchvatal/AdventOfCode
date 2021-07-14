package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(findMySeat());
	}
	
	public static int findHighestId() throws FileNotFoundException, IOException {
		int highestSeatId = 0;
		String line;
		int row = 0;
		int column = 0;
		int currentSeatId;
		int maxRow = 127; //47
		int minRow = 0;
		int minColumn = 0;
		int maxColumn = 7;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("resources/seatNumbers.txt")))) {
			while ((line = br.readLine()) != null) {
				char[] searchArray = line.toCharArray();
				for (int i = 0; i < searchArray.length; i++) {
					if (i < 6) {
						if (searchArray[i] == 'F') {
							maxRow = (int) Math.floor(((float)maxRow - (float) minRow)/2);
						} else if (searchArray[i] == 'B') {
							minRow = (int) Math.ceil(((float)maxRow - (float) minRow)/2);
						}  
					} else if (i == 6){
						if (searchArray[i] == 'F') {
							row = minRow;
						} else {
							if (searchArray[i] == 'B') {
								row = maxRow;
							}
						}
					} else if (i < 9) {
						if (searchArray[i] == 'R') {
							minColumn =+ (int) Math.ceil((maxColumn-minColumn)/2)+1;
						} else if (searchArray[i] == 'L') {
							maxColumn -= (int) Math.ceil((maxColumn-minColumn)/2)+1;
						} 
					} else {
						if (searchArray[i] == 'R') {
							column = maxColumn;
						} else {
							column = minColumn;
						}
					}
				}
				currentSeatId = row * 8 + column;
				//System.out.println(currentSeatId);
				if (currentSeatId > highestSeatId) {
					highestSeatId = currentSeatId;
				}
				maxRow = 127; //47
				minRow = 0;
				minColumn = 0;
				maxColumn = 7;
			}
			
		}
		return highestSeatId;
	}
	
	public static int findMySeat() throws FileNotFoundException, IOException {
		String line;
		int row = 0;
		int column = 0;
		int currentSeatId;
		int maxRow = 127; //63
		int minRow = 0;
		int minColumn = 0;
		int maxColumn = 7;
		ArrayList<BoardingPass> passList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File("resources/seatNumbers.txt")))) {
			while ((line = br.readLine()) != null) {
				char[] searchArray = line.toCharArray();
				for (int i = 0; i < searchArray.length; i++) {
					if (i < 6) {
						if (searchArray[i] == 'F') {
							maxRow -= (int) Math.ceil(((float)maxRow - (float) minRow)/2);
						} else if (searchArray[i] == 'B') {
							minRow += (int) Math.ceil(((float)maxRow - (float) minRow)/2);
						}  
					} else if (i == 6){
						if (searchArray[i] == 'F') {
							row = minRow;
						} else {
							if (searchArray[i] == 'B') {
								row = maxRow;
							}
						}
					} else if (i < 9) {
						if (searchArray[i] == 'R') {
							minColumn += (int) Math.ceil(((float) maxColumn - (float) minColumn)/2);
						} else if (searchArray[i] == 'L') {
							maxColumn -= (int) Math.ceil(((float) maxColumn - (float) minColumn)/2);
						} 
					} else {
						if (searchArray[i] == 'R') {
							column = maxColumn;
						} else {
							column = minColumn;
						}
					}
				}
				
				currentSeatId = row * 8 + column;
				passList.add(new BoardingPass(column, row, currentSeatId));
				maxRow = 127; //47
				minRow = 0;
				minColumn = 0;
				maxColumn = 7;
			}
			
		}
		return findMissingId(passList).getSeatId();
	}
	
	public static BoardingPass findMissingId(ArrayList<BoardingPass> seatList) {
		
		///ArrayList<BoardingPass>[] seatChart = (ArrayList<BoardingPass>[]) new ArrayList[8];
		Collections.sort(seatList);
		BoardingPass[][] seatChart = new BoardingPass[127][8];
		int currentColumn;
		int currentRow;
		BoardingPass currentPass;
		for (int i = 1; i < seatList.size(); i++) {
			currentPass = seatList.get(i);
			currentRow = currentPass.getRow();
			currentColumn = currentPass.getColumn();
			seatChart[currentRow][currentColumn] = seatList.get(i);
		}
		
		for (int i = 0; i < seatChart.length; i++) {
			if (checkForOneNullValue(seatChart[i]) == true){
				for (int j = 0; j < seatChart[i].length; j++) {
					if (seatChart[i][j] == null) {
						return new BoardingPass(j, i, ((i * 8) + j));
					}
				}
			}
		}
			
		return null;
	}
	
	public static boolean checkForOneNullValue(BoardingPass[] boardinPassYall) {
		int countinNulls = 0;
		for (int i = 0; i < boardinPassYall.length; i++) {
			if (boardinPassYall[i] == null) {
				countinNulls++;
			}
		}
		if (countinNulls == 1) {
			return true;
		} else {
			return false;
		}
	}
	
}
