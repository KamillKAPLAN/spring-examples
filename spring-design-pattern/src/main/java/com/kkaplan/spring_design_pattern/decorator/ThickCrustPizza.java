package com.kkaplan.spring_design_pattern.decorator;

import java.math.BigDecimal;

public class ThickCrustPizza extends Pizza {
	
	public ThickCrustPizza() {
		super();
		this.description = "This Crust Pizza";
	}

	@Override
	public BigDecimal getCost() {
		return BigDecimal.valueOf(15.00);
	}

}
