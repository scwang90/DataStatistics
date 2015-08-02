package com.datastatistics.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import com.datastatistics.annotations.Intent;
import com.datastatistics.model.entity.RestfulEntity;
import com.datastatistics.util.AfDesHelper;
import com.datastatistics.util.AfMD5;
import com.datastatistics.util.AfReflecter;
import com.datastatistics.util.ServiceException;

/**
 * Controller 数据异常处理切面
 * @author 树朾
 * @date 2015-06-09 02:10:51 中国标准时间 
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
			//------------------------------------------------------------------------------
			//校验远程token
			verifyToken(AfReflecter.getMethod(type, methodName, point.getArgs()),point);
			//------------------------------------------------------------------------------
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

	private void verifyToken(Method method, JoinPoint point) throws ServiceException {
		// TODO Auto-generated method stub
		if (method != null) {
			Annotation[][] parameterAnnotations = method.getParameterAnnotations();
			if (parameterAnnotations.length > 0) {
				for (int i = 0; i < parameterAnnotations.length; i++) {
					Annotation[] annotations = parameterAnnotations[i];
					for (Annotation annotate : annotations) {
						if (annotate instanceof RequestHeader) {
							RequestHeader requestHeader = (RequestHeader) annotate;
							if ("token".equals(requestHeader.value())) {
								verifyToken(point.getArgs()[i]);
							}
						}
					}
				}
			}
		}
	}
	
	private void verifyToken(Object token) throws ServiceException {
		// TODO Auto-generated method stub
		if (token == null) {
			throw new ServiceException("无效访问");
		}
		String strKey = AfMD5.getMD5("");
		AfDesHelper helper = new AfDesHelper(strKey);
		try {
			token = helper.decrypt(token.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServiceException("无效访问");
		}
		String token0 = token.toString();
		String token1 = token0.substring(0,token0.length()/2);
		String token2 = token0.substring(token0.length()/2);
		token2 = new StringBuffer(token2).reverse().toString();
		if (!token1.equals(token2)) {
			throw new ServiceException("无效访问");
		}
	}

}
