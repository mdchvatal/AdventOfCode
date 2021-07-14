package day4;

public class Passport {
	int birthYear = 0;
	int issueYear = 0;
	int expirationYear = 0 ;
	String height = "";
	String hairColor = "";
	String eyeColor = "";
	String passportId = "";
	int countryId = 0;
	
	public Passport() {
		
	}
	
	public Passport(int birthYear, int issueYear, int expirationYear, String height, String hairColor, String eyeColor, String passportId) {
		this.birthYear = birthYear;
		this.issueYear = issueYear;
		this.expirationYear = expirationYear;
		this.height = height;
		this.hairColor = hairColor;
		this.eyeColor = eyeColor;
		this.passportId = passportId;
	}
	
	public boolean checkForAttributes() {
		if (this.birthYear == 0 || this.issueYear == 0 || this.expirationYear == 0 || this.height == "" 
				|| this.hairColor == "" || this.eyeColor == "" || this.passportId == "") {
			return false;
		} else { return true; }
	}
	
	public boolean validate() {
		if (this.getBirthYear() < 1920 || this.getBirthYear() > 2002 || this.getIssueYear() < 2010 || this.getIssueYear() > 2020 ||
				this.getExpirationYear() < 2020 || this.getExpirationYear() > 2030 ||
				 !this.getHairColor().matches("#[0-9a-zA-Z]{6}") || !(this.getEyeColor().equalsIgnoreCase("amb") 
						|| this.getEyeColor().equalsIgnoreCase("blu") || this.getEyeColor().equalsIgnoreCase("brn") || this.getEyeColor().equalsIgnoreCase("gry") ||
						this.getEyeColor().equalsIgnoreCase("gry") || this.getEyeColor().equalsIgnoreCase("grn") || this.getEyeColor().equalsIgnoreCase("hzl")
						|| this.getEyeColor().equalsIgnoreCase("oth")) || !this.getPassportId().matches("[0-9]{9}")) {
				return false;
			} else {
				return true;
			}
		}
	
	public boolean checkHeight() {
		if (this.getHeight().contains("cm")) {
			if (Integer.parseInt(this.getHeight().substring(0, this.getHeight().length()-2)) >= 150 
					&& Integer.parseInt(this.getHeight().substring(0, this.getHeight().length()-2)) <= 193) {
				return true;
			} 
		} else if (this.getHeight().contains("in")) {
			if (Integer.parseInt(this.getHeight().substring(0, this.getHeight().length()-2)) >= 59 
					&& Integer.parseInt(this.getHeight().substring(0, this.getHeight().length()-2)) <= 76) {
				return true;
			}
		} 
		return false;
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public int getIssueYear() {
		return issueYear;
	}
	public void setIssueYear(int issueYear) {
		this.issueYear = issueYear;
	}
	public int getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String keyValueArr) {
		this.passportId = keyValueArr;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "Birth Year: " + this.getBirthYear() + "\n"
				+ "Issue Year: " + this.getIssueYear() + "\n"
				+ "Exp Year: " + this.getExpirationYear() + "\n"
				+ "Height: " + this.getHeight() + "\n"
				+ "Hair Color: " + this.getHairColor() + "\n"
				+ "Eye Year: " + this.getEyeColor() + "\n"
				+ "Pass Id: " + this.getPassportId() + "\n"
				+ "Country Id: " + this.getCountryId() + "\n"
				+ " " ;
	}
	
	
	
}
