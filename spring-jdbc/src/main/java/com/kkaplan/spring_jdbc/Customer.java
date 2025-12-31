package com.kkaplan.spring_jdbc;

import com.kkaplan.spring_jdbc.util.DataTransferObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
}
