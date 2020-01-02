package com.switchcode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
					
	@Before("execution (public * add*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n Executing beforeAddAccountAdvice ");
	}
 
}
