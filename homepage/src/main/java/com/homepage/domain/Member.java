package com.homepage.domain;

import java.util.Date;

import lombok.Data;
@Data
public class Member {
	private String id;
    private String pass;
    private String name;
    private String phone;
    private String email;
    private String gender;
    private String zipcode;
    private String address1;
    private String address2;
    private Date regDate;
    private int money;
}
