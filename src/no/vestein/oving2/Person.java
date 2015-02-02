package no.vestein.oving2;

import java.util.Date;
import java.util.Locale;

public class Person {

	private String fornavn;
	private String etternavn;
	private String name;
	private String email;
	private Date birthday;
	private char gender;

	public void setName(String name) {
		if (checkName(name)) { 
			String[] s = name.split("\\s");
			fornavn = s[0].toLowerCase();
			etternavn = s[1].toLowerCase();
			this.name = name;
		}
	}
	
	private boolean checkName(String name) {
		if (name.matches("[a-zA-Z]{2,}\\s[a-zA-Z]{2,}")) return true;
		throw new IllegalArgumentException("invalid name");
	}
	
	public void setEmail(String email) {
		if (checkEmail(email)) this.email = email;
	}
	
	private boolean checkEmail(String email) {
		if (email.matches("\\w+\\.\\w+@\\w+\\.\\w{2}")) {
			if (name == null) return true;
			if (email.contains(fornavn + "." + etternavn)) {
				String[] locales = Locale.getISOCountries();
				for (String landskode : locales) {
					if (email.endsWith(landskode.toLowerCase())) return true;
				}
			} else {
				throw new IllegalStateException("invalid email");
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
	
}
