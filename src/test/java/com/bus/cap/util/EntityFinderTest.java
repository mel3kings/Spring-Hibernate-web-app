package com.bus.cap.util;

import org.junit.Test;

import com.bus.cap.entities.Business;

public class EntityFinderTest {
	@Test
	public void test() {
		// TODO Auto-generated method stub
		String test = new String("test");
		Business b = new Business();
		System.out.println("String: " + EntityFinder.isValidEntity(test));
		System.out.println("Business: " + EntityFinder.isValidEntity(b));
	}
}
