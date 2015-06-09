package com.datastatistics.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.datastatistics.annotations.Intent;
import com.datastatistics.model.entity.RestfulEntity;
import com.datastatistics.util.AfReflecter;
import com.datastatistics.util.ServiceException;

/**
 * Controller 数据异常处理切面
 * @author 树朾
 * @date 2015-06-10 02:46:08 中国标准时间 
 */
@Aspect
@Component
public class ControllerAspect {

	@Around("execution(public Object com.datastatistics.controller.*.*(..))")
	public Object around(ProceedingJoinPoint point) {
		Object result = null;
		Signature signature = point.getSignature();
		Class<?> type = point.getTarget().getClass();
		String methodName = signature.getName();
		Intent annotation = AfReflecter.getMethodAnnotation(type , methodName, Intent.class);
		String intent = "请求";
		if (annotation != null) {
			intent = annotation.value();
		}
		annotation = type.getAnnotation(Intent.class);
		String model = "";
		if (annotation != null) {
			model = annotation.value();
		}
		intent = String.format(intent, model);
		try {
			result = point.proceed();
		} catch (ServiceException e) {
			return RestfulEntity.getFailure(e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			return RestfulEntity.getFailure(intent+"失败"+"-"+e.getMessage());
		}
		if(result == null){
			return RestfulEntity.getSuccess(intent+"成功");
		}else if ("null".equals(result)) {
			result = null;
		}
		
		return RestfulEntity.getSuccess(result);
	}

}
