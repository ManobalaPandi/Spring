package com.switchcode.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.switchcode.aopdemo.Account;

@Component
public class AccountDao {
	
	public void addAccount(Account theAccount, boolean b) {
		
		System.out.println(getClass()+" inside addAcount Aop");
	}

}
