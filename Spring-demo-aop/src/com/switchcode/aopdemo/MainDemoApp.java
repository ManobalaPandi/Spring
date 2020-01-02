package com.switchcode.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.switchcode.aopdemo.dao.AccountDao;
import com.switchcode.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao theAccountDao =   context.getBean("accountDao",AccountDao.class);
		
		MembershipDao theMembershipDao =   context.getBean("membershipDao",MembershipDao.class);
		
		Account theAccount = new Account();
		theAccountDao.addAccount(theAccount, true);
		
		theMembershipDao.addAccount();
		
		theMembershipDao.addSilly();
		
		context.close();

	}

}
