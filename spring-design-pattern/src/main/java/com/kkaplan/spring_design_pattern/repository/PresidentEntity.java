package com.kkaplan.spring_design_pattern.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PRESIDENT")
@Getter
@Setter
@ToString
public class PresidentEntity {
	
	@Id
	@GeneratedValue
	@Column(name="PRESIDENT_ID")
	private long id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="MIDDLE_INITIAL")
	private String middleInitial;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;
}
