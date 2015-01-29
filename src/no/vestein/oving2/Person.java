package no.vestein.oving2;

import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

//	private String fornavn;
//	private String etternavn;
	private String name;
	private String email;
	private Date birthday;
	private char gender;
	
//	private final String email_regex = "\\w+\\.\\w+@\\w+\\.\\w{2}";
//	private final Pattern email_pattern = Pattern.compile(email_regex);
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", birthday="
				+ birthday + ", gender=" + gender + "]";
	}

	public void setName(String name) {
		if (checkName(name)) { 
//			String[] s = name.split("\\s");
//			fornavn = s[0];
//			etternavn = s[1];
			this.name = name;
		}
	}
	
	private boolean checkName(String s) {
		String[] splitString =  s.split("\\s");
		if (splitString.length != 2) {
			throw new IllegalArgumentException("invalid name");
		} else if (splitString[0].matches("[a-zA-Z]+") && splitString[0].length() >= 2 && splitString[1].matches("[a-zA-Z]+") && splitString[1].length() >= 2) {
			return true;
		} else {
			throw new IllegalArgumentException("invalid name");
		}
	}
	
	public void setEmail(String email) {
		if (checkEmail(email)) this.email = email;
	}
	
	private boolean checkEmail(String email) {
		//Matcher emailMatcher = email_pattern.matcher(email);
		//if (emailMatcher.matches()) {
		
		if (email.matches("\\w+\\.\\w+@\\w+\\.\\w{2}")) {
			if (name != null) {
				String[] splitName =  name.split("\\s");
				if (email.matches(splitName[0].toLowerCase() + "\\." + splitName[1].toLowerCase() + "@\\w+\\.\\w{2}")) {
					String[] splitString = email.split("\\.");
					String[] locales = Locale.getISOCountries();
					for (String landskode : locales) {
						if (splitString[2].equals(landskode.toLowerCase())) return true;
					}
				} else {
					throw new IllegalStateException("invalid email, compared to name");
				}
			} else {
				return true;
			}
		}
		throw new IllegalArgumentException("invalid email");
	}
	
	public void setBirthday(Date birthday) {
		if (birthday.before(new Date())) {
			this.birthday = birthday;
		} else {
			throw new IllegalArgumentException("invalid date");
		}
	}
	
	public void setGender(char gender) {
		if (gender == 'M'|| gender == 'F' || gender == '\0' ) {
			this.gender = gender;
		} else {
			throw new IllegalArgumentException("invalid gender");
		}
	}
	
	public String getName() { return name;}
	
	public String getEmail() { return email; }
	
	public Date getBirthday() { return birthday; }
	
	public char getGender() { return gender; }
	
	public static void main(String[] args) {
		Person test = new Person();
		
		System.out.println(test);
		test.setName("Vestein Dahl");
		System.out.println(test);
		test.setEmail("vestein.dahl@gmail");
		System.out.println(test);
	}
	
}
