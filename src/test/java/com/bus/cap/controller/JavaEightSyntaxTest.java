package com.bus.cap.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.bus.cap.entities.Business;

public class JavaEightSyntaxTest {
	ArrayList<Business> listOfBusiness = new ArrayList<Business>();
	ArrayList<String> words = new ArrayList<String>();

	@Before
	public void initializeTestData() {
		Business b = new Business();
		b.setBusinessName("TEST A");
		Business b2 = new Business();
		b2.setBusinessName("asdasd B");
		Business b3 = new Business();
		b3.setBusinessName("AAA");
		Business b4 = new Business();
		b4.setBusinessName("AAAASDASDASDASDASDASDAD");
		listOfBusiness.add(b);
		listOfBusiness.add(b2);
		listOfBusiness.add(b3);
		listOfBusiness.add(b4);

		words.add("RANDOM");
		words.add("CAT");
		words.add("TEST");
		words.add("JAVAEIGHT");
	}

	@Test
	public void lambdaTest() {
		Runnable r = () -> {
			System.out.println("RUNNING");
		};
		new Thread(r).start();
	}

	@Test
	public void CollectionsLambdaComparator() {
		Collections.sort(
				listOfBusiness,
				(Business compare1, Business compare2) -> {
					return compare1.getBusinessName().compareTo(
							compare2.getBusinessName());
				});
		System.out.println("=====listOfBusiness RESULT=====");
		for (Business results : listOfBusiness) {
			System.out.println(results.getBusinessName());
		}
	}

	@Test
	public void testForLoopLambda() {
		String[] names = { "Peter", "Paul", "Mary" };
		List<Runnable> runners = new ArrayList<>();
		for (String name : names)
			runners.add(() -> System.out.println(name));
		for (Runnable r : runners) {
			new Thread(r).start();
		}
	}

	@Test
	public void streamsGetFromIterations() {
		Stream<Business> generated = listOfBusiness.stream().filter(
				b -> b.getBusinessName().equals("TEST A"));
		assertNotNull(generated);
		Stream<String> song = Stream.of("TEST", "TEST2");
		assertNotNull(song);
	}

	@Test
	public void iteratorForEach() {
		System.out.println("=====iteratorForEach RESULT=====");
		listOfBusiness.forEach(System.out::println);
	}

	@Test
	public void transformStreams() {
		Stream<Business> streamer = listOfBusiness.stream();
		Stream<String> convertedNames = streamer
				.map(JavaEightSyntaxTest::lowerCaseBusinessName);
		System.out.println("=====transformStreams RESULT=====");
		convertedNames.forEach(System.out::println);
	}
	
	@Test
	public void optionalStreams(){
		Stream<String> wordStream = words.stream();
		Optional<String> check = wordStream.findAny();
		if(check.isPresent()){
			assertNotNull(check);
		}
		//cannot operate on same stream twice
		Stream<String> wordsStream2 = words.stream();
		Optional<String> startsWithQ = wordsStream2.filter(s -> s.startsWith("Q")).findFirst();
		assertFalse(startsWithQ.isPresent());
	}

	public static String lowerCaseBusinessName(Business b) {
		return b.getBusinessName().toLowerCase();
	}
	
}
