package dudy.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by admin on 18.11.2018.
 */
@Aspect
@Component
public class CRMLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());
    @Pointcut("execution(* dudy.springdemo.controller.*.* (..))")
    private void forController(){}

    @Pointcut("execution(* dudy.springdemo.service.*.* (..))")
    private void forService(){}

    @Pointcut("execution(* dudy.springdemo.dao.*.* (..))")
    private void forDAO(){}

    @Pointcut("forController() || forService() || forDAO()")
    private void appFlow(){}

    @Before("appFlow()")
    private void before(JoinPoint jp){
        String method = jp.getSignature().toShortString();
        myLogger.info("====>"+method);
        Object[] obj = jp.getArgs();
        for(Object o:obj)
            myLogger.info(o.toString());
    }
}
