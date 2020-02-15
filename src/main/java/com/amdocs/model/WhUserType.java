package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "whusertab")
public class WhUserType {
	
	@Id
	@GeneratedValue
	private String userId;
	private String userType;
	private String userCode;
	private String userFor;
	private String userMail;
	private String userContact;
	private String userIdType;
	private String other;
	private String idNumber;
}
