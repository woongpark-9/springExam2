package tommy.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
	@Pointcut("execution(* tommy.spring.web..*Impl.*(..))")
	public void allPointcut() {
		
	}
	@AfterThrowing(pointcut = "allPointcut()",throwing= "e")
	public void afterLog(JoinPoint joinpoint , Exception e) {
		String method = joinpoint.getSignature().getName();
		System.out.println("[예외처리] :" + e.getMessage());
		
		System.out.println("[사후처리] : 비즈니스 로직 수행 후 처리");
	}
}
