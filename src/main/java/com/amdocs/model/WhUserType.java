package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "whusertab")
@NoArgsConstructor
public class WhUserType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userId;
	private String userType;
	private String userCode;
	private String userFor;
	private String userMail;
	private String userContact;
	private String userIdType;
	private String other;
	private String idNumber;
}
