package com.kkaplan.spring_jdbc;

import com.kkaplan.spring_jdbc.util.DataTransferObject;

import lombok.Data;

@Data
public class Customer implements DataTransferObject {

	private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    
	@Override
	public long getId() {
		return 0;
	}

}
