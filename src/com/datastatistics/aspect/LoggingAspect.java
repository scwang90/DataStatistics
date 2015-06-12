package com.datastatistics.aspect;

import static java.lang.System.out;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;

import com.datastatistics.util.JacksonUtil;

/**
 * 日志处理切面
 * @author 树朾
 * @date 2015-06-12 17:21:15 中国标准时间 
 */
@Aspect
public class LoggingAspect {
	
	public void before(JoinPoint point) {
		out.print(LoggingAspect.class.getSimpleName()+"-");
		out.print(point.getTarget().getClass().getSimpleName()+".");
		out.print(point.getSignature().getName()+"-begin-args-");
		out.print(JacksonUtil.toJson(point.getArgs()));
		out.println();
	}
	
	public void after(JoinPoint point) {
		out.print(LoggingAspect.class.getSimpleName()+"-");
		out.print(point.getTarget().getClass().getSimpleName()+".");
		out.print(point.getSignature().getName()+"-after-");
		out.println();
	}
	
	public void returned(JoinPoint point,Object result) {
		out.print(LoggingAspect.class.getSimpleName()+"-");
		out.print(point.getTarget().getClass().getSimpleName()+".");
		out.print(point.getSignature().getName()+"-returned-result-");
		out.print((result instanceof String)?result:JacksonUtil.toJson(result));
		out.println();
	}
	
	public void throwed(JoinPoint point,Throwable ex) {
		out.print(LoggingAspect.class.getSimpleName()+"-");
		out.print(point.getTarget().getClass().getSimpleName()+".");
		out.print(point.getSignature().getName()+"-throwed-ex-");
		out.print(ex.getMessage()+"-"+ex.getClass().getSimpleName());
		out.println();
	}

}
