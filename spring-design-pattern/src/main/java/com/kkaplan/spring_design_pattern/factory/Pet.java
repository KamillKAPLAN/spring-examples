package com.kkaplan.spring_design_pattern.factory;

public interface Pet {
	
	void setName(String name);
	String getName();
	boolean isHungry();
	void feed();
	String getType();
	
}
