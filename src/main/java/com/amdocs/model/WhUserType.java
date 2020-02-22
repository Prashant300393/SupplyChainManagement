package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "whusertab")
@NoArgsConstructor
public class WhUserType {
	
	@Id
	@GeneratedValue
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
