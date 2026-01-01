package com.kkaplan.spring_jdbc;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.kkaplan.spring_jdbc.util.DataTransferObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order implements DataTransferObject {
	
	private long id;
    private String customerFirstName;
    private String customerLastLane;
    private String customerEmail;
    private Date creationDate;
    private BigDecimal totalDue;
    private String status;
    private String salespersonFirstName;
    private String salespersonLastName;
    private String salespersonEmail;
    private List<OrderLine> orderLines;
    
	@Override
	public long getId() {
		return id;
	}
}
