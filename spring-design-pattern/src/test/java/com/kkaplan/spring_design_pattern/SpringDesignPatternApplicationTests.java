package com.kkaplan.spring_design_pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kkaplan.spring_design_pattern.adapter.Apple;
import com.kkaplan.spring_design_pattern.adapter.AppleAdapter;
import com.kkaplan.spring_design_pattern.adapter.MoroOrange;
import com.kkaplan.spring_design_pattern.adapter.Orange;
import com.kkaplan.spring_design_pattern.decorator.Pepperoni;
import com.kkaplan.spring_design_pattern.decorator.Pizza;
import com.kkaplan.spring_design_pattern.decorator.ThickCrustPizza;
import com.kkaplan.spring_design_pattern.prototype.NotPrototype;
import com.kkaplan.spring_design_pattern.prototype.Prototype;
import com.kkaplan.spring_design_pattern.repository.PresidentRespository;
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
	
	@Autowired
	Prototype protoA;
	@Autowired
	Prototype protoB;
	@Autowired
	NotPrototype notProtoA;
	@Autowired
	NotPrototype notProtoB;
	
	@Test
	public void testPrototype() {
		Assertions.assertSame(notProtoA, notProtoB);
		Assertions.assertSame(protoA, protoB);
	}
	
	@Test
	public void testAdapter() {
		Orange orange = new MoroOrange();
		Apple apple = new AppleAdapter(orange);
		System.out.println(apple.getVariety());
		apple.eat();
	}
	
	@Test
	public void testDecorator() {
		Pizza pizza = new ThickCrustPizza();
		System.out.println(pizza.getCost());
		System.out.println(pizza.getDescription());
		
		Pepperoni pepperoniPizza = new Pepperoni(pizza);
		System.out.println(pepperoniPizza.getCost());
		System.out.println(pepperoniPizza.getDescription());
		
		Pepperoni doublePepperoniPizza = new Pepperoni(pepperoniPizza);
		System.out.println(doublePepperoniPizza.getCost());
		System.out.println(doublePepperoniPizza.getDescription());	
	}
	
	@Autowired
	PresidentRespository presidentRespository;
	
	@Test
	public void testRepository() {
		System.out.println(presidentRespository.findById(1L));
		System.out.println(presidentRespository.findByEmailAddress("John.Adams@wh.gov"));
	}
}
