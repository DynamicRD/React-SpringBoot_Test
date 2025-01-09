package com.kh.homePageProject.model;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String pass;
	private String name;
	private String phone;
	private String email;
	private String zipcode;
	private String address1;
	private String address2;
	private int money;
}
