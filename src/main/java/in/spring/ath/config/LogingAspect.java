package in.spring.ath.config;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component 
public class LogingAspect {

	private static final Logger LOGGER=LoggerFactory.getLogger(LogingAspect.class);
	
	@Before("execution(* in.spring.ath.controller.*.*(..))")
	private void log(JoinPoint j) {    // This will Execute When Execution starts....
		LOGGER.info(new Date() +" Execution Started...!   "+j.getSignature().getDeclaringType()+ "    ::    " +j.getSignature().getName());
	}
	
	@After("execution(* in.spring.ath.controller.*.*(..))")
	public void logAfter(JoinPoint j) {    // This will Execute weather it is successfully Executed or not....
		LOGGER.info(new Date() +" Every Time Executed...!   "+j.getSignature().getDeclaringType()+ "    ::    " +j.getSignature().getName());
	}
	
	@AfterReturning(pointcut="execution(* in.spring.ath.controller.*.*(..))")
	public void logAfterExecuting(JoinPoint j) {    // This will Execute when it is successfully Executed...
		LOGGER.info(new Date() +" Successfully Executed...!   "+j.getSignature().getDeclaringType()+ "    ::    " +j.getSignature().getName());
	}
	
	@AfterThrowing(pointcut="execution(* in.spring.ath.controller.*.*(..))")
	public void logAfterException(JoinPoint j) {    // This will Execute when Exception is Throw...
		LOGGER.error(new Date() +" Error Throwed...!   "+j.getSignature().getDeclaringType()+ "    ::    " +j.getSignature().getName());
	}
}
