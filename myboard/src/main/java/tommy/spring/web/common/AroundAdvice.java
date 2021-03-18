package tommy.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* tommy.spring.web..*Impl.getNumber(..))")
	public void allPointcut() {
		
	}
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint )throws Throwable{
		String method = joinPoint.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = joinPoint.proceed();
		stopWatch.stop();
		System.out.println(method+"수행중에 걸린시간 : "+stopWatch.getTotalTimeMillis() + "(ms)초");
		return  5;
		
	}
}
