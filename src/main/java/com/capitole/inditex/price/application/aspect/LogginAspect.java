package com.capitole.inditex.price.application.aspect;

import com.capitole.inditex.price.infrastructure.inbound.PriceController;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogginAspect {



    @Pointcut ( "within(@org.springframework.web.bind.annotation.RestController *)" +
            " || within(@org.springframework.stereotype.Service *)" )
    public void springComponentsPointcut( )
    {
    }


    @Around ( "springComponentsPointcut()" )
    public Object logForComponents( ProceedingJoinPoint joinPoint )
            throws
            Throwable
    {

        log.info( "Entered: {} with argument[{}] ",
                joinPoint
                        .getSignature( )
                        .toShortString( ),
                Arrays.toString( joinPoint.getArgs( ) ) );

        Object result = joinPoint.proceed( );

        log.info( "Exit: {} with result = {}",
                joinPoint
                        .getSignature( )
                        .toShortString( ),
                result );

        return result;
    }


}
