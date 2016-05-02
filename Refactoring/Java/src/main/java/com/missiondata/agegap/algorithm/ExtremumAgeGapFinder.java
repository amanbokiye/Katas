package com.missiondata.agegap.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.missiondata.agegap.domain.Person;
import com.missiondata.agegap.domain.PersonPair;
import com.missiondata.agegap.util.AgeGap;

/** 
 * This class is an algorithm that forms all possible pairs list of persons and
 * determine the closest or the furthest age gap pairs.
 * 
 * @author Aman
 * 
 */
public class ExtremumAgeGapFinder {
	private final List<Person> PERSONS;

	public ExtremumAgeGapFinder(List<Person> persons) {
		PERSONS = persons;
	}

	/**
	 * This method takes an enum of age gap ( values: CLOSEST or FURTHEST) as parameter and returns the
	 * PersonPair object with closest or furthest age gap depending on the value of the enum parameter
	 *  
	 * @param ageGap  list of personPairs for which the closest age gap required
	 * @return  with closest or furthest age gap depending on the @param value
	 */
	public PersonPair findAgeGapPersonPair(AgeGap ageGap) {
		
		// form list of person pairs from PERSONS
		List<PersonPair> parsonPairs = this.formPersonPairs();

		PersonPair personPair = null; 
		
		if (parsonPairs.isEmpty()) {
			personPair = new PersonPair();
		} 
		//person pair closest age gap
		else if (ageGap.equals(AgeGap.CLOSEST)) {
			personPair = this.getClosestAgeGapPersonPair(parsonPairs);
		} 
		//person pair with furthest age gap
		else if (ageGap.equals(AgeGap.FURTHEST)) {
			personPair = this.getFurthestAgeGapPersonPair(parsonPairs);
		}

		return personPair;
	}

	/**
	 * This method takes list of personPair as parameter and returns the
	 * PersonPair object with closest age gap between the two Person objects
	 * encapsulated
	 * 
	 * @param parsonPairs list of personPairs for which the closest age gap required
	 * @return  with closest age gap
	 */
	private PersonPair getClosestAgeGapPersonPair(List<PersonPair> parsonPairs) {
		PersonPair closestAgeGapPersonPair = parsonPairs.get(0);
		for (PersonPair personpair : parsonPairs) {
			if (personpair.getAgeGap() < closestAgeGapPersonPair.getAgeGap()) {
				closestAgeGapPersonPair = personpair;
			}
		}
		return closestAgeGapPersonPair;
	}

	/**
	 * This method takes list of personPair as parameter and returns the
	 * PersonPair object with largest age gap between the two person objects
	 * encapsulated
	 * 
	 * @param parsonPairs  list of personPairs for which the closest age gap required
	 * @return  with largest age gap
	 */
	private PersonPair getFurthestAgeGapPersonPair(List<PersonPair> parsonPairs) {
		PersonPair furthestAgeGapPersonPair = parsonPairs.get(0);
		for (PersonPair personpair : parsonPairs) {
			if (personpair.getAgeGap() > furthestAgeGapPersonPair.getAgeGap()) {
				furthestAgeGapPersonPair = personpair;
			}
		}
		return furthestAgeGapPersonPair;
	}

	/**
	 * This method forms a list of PersonPair object from instance field PERSONS pairing 
	 * each possible person in the PERSONS list
	 * 
	 * @return list of PersonPair after forming the list from the list PERSONS in this
	 *         class
	 */
	public List<PersonPair> formPersonPairs() {
		List<PersonPair> parsonPairs = new ArrayList<PersonPair>();
		for (int i = 0; i < PERSONS.size() - 1; i++) {
			for (int j = i + 1; j < PERSONS.size(); j++) {
				PersonPair personPair = new PersonPair();
				if (PERSONS.get(i).getBirthDate().getTimeInMillis() < PERSONS.get(j).getBirthDate().getTimeInMillis()) {
					personPair.setOlderPerson(PERSONS.get(i));
					personPair.setYoungerPerson(PERSONS.get(j));
				} else {
					personPair.setOlderPerson(PERSONS.get(j));
					personPair.setYoungerPerson(PERSONS.get(i));
				}
				personPair.setAgeGap(personPair.getYoungerPerson().getBirthDate().getTimeInMillis() 
						- personPair.getOlderPerson().getBirthDate().getTimeInMillis());
				parsonPairs.add(personPair);
			}
		}

		return parsonPairs;
	}
}
