package test.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TargetInterceptor implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		boolean invokeFlag = true;//(Math.round(Math.random()) - 1 >= 0);

		String className = invocation.getClass().getName();
		System.out.println(className.substring(className.lastIndexOf(".") + 1) + " will" + (invokeFlag ? "" : " not")
				+ " proceed " + invocation.getMethod().getName());
		Object result = null;
		// System.out.println("method proceed:" + invokeFlag);
		if (invokeFlag) {
			result = invocation.proceed();
		}
		return result;
	}

	public static void main(String[] args) {
		double random = Math.random();
		System.out.println(random);
		System.out.println(Math.round(random));
		System.out.println(Boolean.getBoolean(Math.round(random) + ""));
	}
}
