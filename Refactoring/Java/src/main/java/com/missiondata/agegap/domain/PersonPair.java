package com.missiondata.agegap.domain;

/**
 * This is a domain model POJO with setters and getters and it is to construct
 * an object of PersonPair containing two person objects and the difference
 * between their ages in milliseconds.
 * 
 * @author Aman
 *
 */
public class PersonPair {
	private Person olderPerson;
	private Person youngerPerson;
	// age difference between older and younger persons in millisecond
	private long ageGap;

	public Person getOlderPerson() {
		return olderPerson;
	}

	public void setOlderPerson(Person olderPerson) {
		this.olderPerson = olderPerson;
	}

	public Person getYoungerPerson() {
		return youngerPerson;
	}

	public void setYoungerPerson(Person youngerPerson) {
		this.youngerPerson = youngerPerson;
	}

	public long getAgeGap() {
		return ageGap;
	}

	public void setAgeGap(long ageGap) {
		this.ageGap = ageGap;
	}

}
