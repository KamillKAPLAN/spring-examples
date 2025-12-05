package com.kkaplan.spring_design_pattern.singleton;

public class SingletonA {

	private static SingletonA instance;
	
	private SingletonA() {
		super();
	}
	
	public static SingletonA getInstance() {
		if (instance == null) {
			synchronized (SingletonA.class) {
				if (instance == null) {
					instance = new SingletonA();
				}
			}
		}
		return instance;
	}
}
