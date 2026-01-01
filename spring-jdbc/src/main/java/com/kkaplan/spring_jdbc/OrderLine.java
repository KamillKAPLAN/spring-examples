package com.kkaplan.spring_jdbc;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderLine {

	private int quantity;
    private String productCode;
    private String productName;
    private int productSize;
    private String productVariety;
    private BigDecimal productPrice;
}
