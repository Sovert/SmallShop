package com.qch.shop.aspect;

import com.qch.shop.annotation.LogAnnotation;
import com.qch.shop.model.entity.Log;
import com.qch.shop.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Objects;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.qch.shop.annotation.LogAnnotation)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try{
           // do method
           result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // do all time
        long time = System.currentTimeMillis() - beginTime;
        saveLog(point, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Log log = new Log();
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        if (logAnnotation != null) {
            log.setOperation(logAnnotation.value());
        }
        // request method
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.setMethod(className + "." + methodName + "()");

        // request param
        Object[] args = point.getArgs();
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = discoverer.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            for(int i = 0; i < args.length &&  i < paramNames.length; i++) {
                params.append(" ").append(paramNames[i]).append(": ").append(args[i]);            }
            log.setParams(params.toString());
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            log.setIp(request.getHeader("x-forwarded-for"));
            log.setUsername("test");
            log.setTime((int) time);
            log.setCreateTime(new Date());

            logService.add(log);
        }


    }
}
