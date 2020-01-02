package com.switchcode.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	
public void addAccount() {
		
		System.out.println(getClass()+" inside addAcount Aop in Member ship");
	}
public String addSilly() {
	
	System.out.println(getClass()+" inside Sily Aop in Member ship");
	return null;
}

}
