package com.kkaplan.spring_design_pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kkaplan.spring_design_pattern.singleton.SingletonA;
import com.kkaplan.spring_design_pattern.singleton.SingletonB;

@SpringBootTest
class SpringDesignPatternApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	SingletonB singletonB1;
	
	@Autowired
	SingletonB singletonB2;
	
	@Test
	public void testSingleton() {
		SingletonA singletonA1 = SingletonA.getInstance();
		SingletonA singletonA2 = SingletonA.getInstance();
		Assertions.assertNotNull(singletonA1);
		Assertions.assertNotNull(singletonA2);
		
		Assertions.assertSame(singletonA1, singletonA2);
		Assertions.assertSame(singletonB1, singletonB2);
	}
}
