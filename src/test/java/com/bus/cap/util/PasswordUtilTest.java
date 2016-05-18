package com.bus.cap.util;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class PasswordUtilTest extends PasswordUtil{
	@Test
	public void test() throws UnsupportedEncodingException{
		String password = "password";
		String test = PasswordUtil.securePassword(password, "salt");
		System.out.println(test);
	}
}
