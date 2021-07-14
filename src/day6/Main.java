package day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println(countAnswers());
	}
	
	public static int countAnswers() throws FileNotFoundException, IOException {
		int answerCount = 0;
		ArrayList<HashMap<Character, Integer>> groupAnswerList = new ArrayList<>();
		String line;
		int groupLineCounter = 0;
		try (BufferedReader buffRead = new BufferedReader(new FileReader(new File("resources/answers.txt")))) {
			HashMap<Character, Integer> initialMap = new HashMap<>();
			groupAnswerList.add(initialMap);
			while ((line = buffRead.readLine()) != null) {
				if (line.isBlank()) {
//					answerCount += groupAnswerList.get(groupAnswerList.size() - 1).size();
					for (Integer yesCount : groupAnswerList.get(groupAnswerList.size() - 1).values()) {
						if (yesCount == groupLineCounter) {
							answerCount++;
						}
					}
					groupAnswerList.add(new HashMap<Character, Integer>());
					groupLineCounter = 0;
				} else {
					groupLineCounter++;
					HashMap<Character, Integer> currentMap = groupAnswerList.get(groupAnswerList.size() - 1);
					for (char lineCharacter : line.toCharArray()) {
						if (currentMap.containsKey(lineCharacter)) {
							currentMap.replace(lineCharacter, currentMap.get(lineCharacter) + 1);
						} else {
							currentMap.put(lineCharacter, 1);
						}
					}
					
				}
			}
			answerCount += groupAnswerList.get(groupAnswerList.size() - 1).size();
		}
		return answerCount;
	}
}
