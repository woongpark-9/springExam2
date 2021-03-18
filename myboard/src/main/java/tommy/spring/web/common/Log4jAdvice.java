package tommy.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
public class Log4jAdvice {
//	@Pointcut("execution(* tommy.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
//	@Before("allPointcut()")
	public void printLog() {
		System.out.println("[로그 - Log4jAdvice] : 비즈니스 로직 수행 전 동작");
	}
}
