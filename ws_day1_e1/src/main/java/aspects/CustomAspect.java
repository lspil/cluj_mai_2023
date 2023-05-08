package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspect {

//  @Before("execution(* repositories.ProductRepository.sayHello(..))")
//  public void before() {
//    System.out.println("BEFORE");
//  }

//  @After("execution(* repositories.ProductRepository.sayHello(..))")
//  public void after() {
//    System.out.println("AFTER");
//  }
//
//  @Around("execution(* repositories.ProductRepository.sayHello(..))")
//  public void demo(ProceedingJoinPoint interceptedMethod) throws Throwable {
//    System.out.println(":(");
//    interceptedMethod.proceed();
//    System.out.println(":)");
//  }

  @Around("@annotation(MyCustomAnnotation)")
  public void qualifier(ProceedingJoinPoint interceptedMethod) throws Throwable {
    System.out.println(":(");
    interceptedMethod.proceed();
    System.out.println(":)");
  }
}
