package com.missiondata.agegap.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.missiondata.agegap.domain.Person;
import com.missiondata.agegap.domain.PersonPair;
import com.missiondata.agegap.util.AgeGap;

public class AgeGapFinderTest {

	Person sue = new Person();
	Person greg = new Person();
	Person sarah = new Person();
	Person mike = new Person();

	@Before
	public void setup() {
		sue.setName("Sue");
		sue.setBirthDate(new GregorianCalendar(50, 0, 1));
		greg.setName("Greg");
		greg.setBirthDate(new GregorianCalendar(52, 5, 1));
		sarah.setName("Sarah");
		sarah.setBirthDate(new GregorianCalendar(82, 0, 1));
		mike.setName("Mike");
		mike.setBirthDate(new GregorianCalendar(79, 0, 1));
	}

	@Test
	public void returns_Empty_Results_When_Given_Empty_List() {
		List<Person> persons = new ArrayList<Person>();
		ExtremumAgeGapFinder extremumGapFinder = new ExtremumAgeGapFinder(persons);

		PersonPair result = extremumGapFinder.findAgeGapPersonPair(AgeGap.CLOSEST);

		assertEquals(null, result.getOlderPerson());
		assertEquals(null, result.getYoungerPerson());
	}

	@Test
	public void returns_Empty_Results_When_Given_One_Person_List() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(sue);

		ExtremumAgeGapFinder extremumAgeGapFinder = new ExtremumAgeGapFinder(persons);

		PersonPair result = extremumAgeGapFinder.findAgeGapPersonPair(AgeGap.CLOSEST);

		assertEquals(null, result.getOlderPerson());
		assertEquals(null, result.getYoungerPerson());
	}

	@Test
	public void returns_Closest_Two_For_Two_Person_List() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(sue);
		persons.add(greg);
		ExtremumAgeGapFinder extremumAgeGapFinder = new ExtremumAgeGapFinder(persons);

		PersonPair result = extremumAgeGapFinder.findAgeGapPersonPair(AgeGap.CLOSEST);

		assertEquals(sue, result.getOlderPerson());
		assertEquals(greg, result.getYoungerPerson());
	}

	@Test
	public void returns_Furthest_Two_For_Two_People() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(mike);
		persons.add(greg);

		ExtremumAgeGapFinder extremumAgeGapFinder = new ExtremumAgeGapFinder(persons);

		PersonPair result = extremumAgeGapFinder.findAgeGapPersonPair(AgeGap.FURTHEST);

		assertEquals(greg, result.getOlderPerson());
		assertEquals(mike, result.getYoungerPerson());
	}

	@Test
	public void returns_Furthest_Two_For_Four_People() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(sue);
		persons.add(sarah);
		persons.add(mike);
		persons.add(greg);
		ExtremumAgeGapFinder extremumAgeGapFinder = new ExtremumAgeGapFinder(persons);

		PersonPair result = extremumAgeGapFinder.findAgeGapPersonPair(AgeGap.FURTHEST);

		assertEquals(sue, result.getOlderPerson());
		assertEquals(sarah, result.getYoungerPerson());
	}

	@Test
	public void returns_Closest_Two_For_Four_Person_List() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(sue);
		persons.add(sarah);
		persons.add(mike);
		persons.add(greg);

		ExtremumAgeGapFinder extremumAgeGapFinder = new ExtremumAgeGapFinder(persons);

		PersonPair result = extremumAgeGapFinder.findAgeGapPersonPair(AgeGap.CLOSEST);

		assertEquals(sue, result.getOlderPerson());
		assertEquals(greg, result.getYoungerPerson());
	}

}
