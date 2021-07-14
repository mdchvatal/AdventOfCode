package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static final String BYR = "byr";
	public static final String IYR = "iyr";
	public static final String EYR = "eyr";
	public static final String HGT = "hgt";
	public static final String HCL = "hcl";
	public static final String ECL = "ecl";
	public static final String PID = "pid";
	public static final String CID = "cid";
	
	public static void main(String[] args) throws IOException {
		passportChecker();
	}
	
	public static void passportChecker() throws IOException {
		ArrayList<Passport> passportList = new ArrayList<>();
		Passport firstPassport = new Passport();
		passportList.add(firstPassport);
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(new File("resources/passportBatchData.txt")))){
			while ((line = br.readLine()) != null) {
				
				if (line.length() == 0) {
					passportList.add(new Passport());
					continue;
				}
				String[] attributeArray = line.split(" ");
				Passport tempPass = passportList.get(passportList.size() - 1);
				for (String attributePair : attributeArray) {
					//System.out.println(attributePair);
					String[] keyValueArr = attributePair.split(":");
					if (keyValueArr[0].equals(BYR)) {
						passportList.get(passportList.size() - 1).setBirthYear(Integer.parseInt(keyValueArr[1]));
					} else if (keyValueArr[0].equals(IYR)) {
						passportList.get(passportList.size() - 1).setIssueYear(Integer.parseInt(keyValueArr[1]));
					} else if (keyValueArr[0].equals(EYR)) {
						passportList.get(passportList.size() - 1).setExpirationYear(Integer.parseInt(keyValueArr[1]));
					} else if (keyValueArr[0].equals(HGT)) {
						passportList.get(passportList.size() - 1).setHeight(keyValueArr[1]);
					} else if (keyValueArr[0].equals(HCL)) {
							passportList.get(passportList.size() - 1).setHairColor(keyValueArr[1]);
					} else if (keyValueArr[0].equals(ECL)) {
						passportList.get(passportList.size() - 1).setEyeColor(keyValueArr[1]);
					} else if (keyValueArr[0].equals(PID)) {
						passportList.get(passportList.size() - 1).setPassportId(keyValueArr[1]);
					} else if (keyValueArr[0].equals(CID)) {
						passportList.get(passportList.size() - 1).setCountryId(Integer.parseInt(keyValueArr[1]));
					} else {
						System.out.println("nothing to see here");
					}
				}
			}
		}
		
		
		System.out.println(passportList.stream()
			.filter(pass -> pass.checkForAttributes() == true)
			.filter(pass -> pass.validate() == true)
			.filter(pass -> pass.checkHeight() == true)
			.count());
		
		
	}

}
//initialize new List of Passports
//add a blank starter passport
//begin loop
//read lines from file and split on " "
//sort attributes based on substring[0, 2] - match to one of 8 attributes
//add attributes to last item in list as they are sorted
//if there is a new line, create new Passport
//begin loop again
//
//loop through each Passport in list - add a method to check if all attributes are there (except for country id, which is optional - it'll be automatically initalized to zero for easy check)
//count how many "true"s come out
//return that number