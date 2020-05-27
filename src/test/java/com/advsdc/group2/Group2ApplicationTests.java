package com.advsdc.group2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.advsdc.group2.Group2Application;

@SpringBootTest
class Group2ApplicationTests {
	Group2Application obj = new Group2Application();

	// Sample Test Case
	@Test
	void contextLoads() {
		obj.setTest("TestClass");

		assertTrue(obj.getTest().equals("TestClass"));
	}

}
