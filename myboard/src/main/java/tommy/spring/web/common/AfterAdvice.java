package tommy.spring.web.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	@Pointcut("execution(* tommy.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
	@After("allPointcut()") 
		public void finallyLog() {
			System.out.println("사후처리 : 비즈니스 동작 후 무조건 동작");
		}
	}

