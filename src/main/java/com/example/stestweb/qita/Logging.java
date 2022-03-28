package com.example.stestweb.qita;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Pointcut("execution(* com.example.stestweb.qita.Com.*(..))")
    public void logPointCut() {}

    @Before("logPointCut()")
    public void doBeforeTask(JoinPoint joinPoint)
    {
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("public void doBeforeTask()");
    }

    @After("logPointCut()")
    public void doAfterTask()
    {
        System.out.println("public void doAfterTask()");
    }

    // 两个retVal是相关联的
    @AfterReturning(value = "logPointCut()",returning = "retVal")
    public void doAfterReturnTask(Object retVal)
    {
        System.out.println("返回值"+retVal);
        System.out.println("public void doAfterReturnTask()");
    }

    @AfterThrowing(value = "logPointCut()",throwing = "ex")
    public void doAfterThrowing(Exception ex)
    {
        System.out.println("public void doAfterThrowing(Exception ex)");
    }
}
