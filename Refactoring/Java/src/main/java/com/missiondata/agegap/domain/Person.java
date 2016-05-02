package com.missiondata.agegap.domain;

import java.util.Calendar;

/**
 * This is a domain model which is a POJO with setters and getters and it is to
 * construct Person object with property name and date of birth.
 * 
 * @author Aman
 *
 */
public class Person {

	private String name;
	private Calendar birthDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
}

