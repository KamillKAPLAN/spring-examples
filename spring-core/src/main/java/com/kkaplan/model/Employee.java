package com.kkaplan.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
	private Integer id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String title;
	private String secondarySchool;
	private String university;
	private String course;
	private String campus;
}
