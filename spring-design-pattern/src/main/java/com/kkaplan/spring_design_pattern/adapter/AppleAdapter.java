package com.kkaplan.spring_design_pattern.adapter;

public class AppleAdapter implements Apple {
	
	private final Orange orange;
	
	public AppleAdapter(Orange orange) {
		this.orange = orange;
	}

	@Override
	public String getVariety() {
		return this.orange.getVariety();
	}

	@Override
	public void eat() {
		orange.peel();
		orange.eat();
	}
	
}
