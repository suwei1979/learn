package com.bocsoft.bocebiz.eloan.domain.service.contract;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import com.bocsoft.bocebiz.eloan.domain.model.application.LoanApplication.State;
import com.bocsoft.bocebiz.eloan.domain.model.application.ProductType;
import com.bocsoft.bocebiz.eloan.domain.service.spi.ProcessRouteTable;

@Component("signContractRouteTable")
@Slf4j
//TODO: Modify SignContractRouteTable
public class SignContractRouteTable implements ProcessRouteTable {
	static HashMap<String, HashMap<String, String>> routeTable = new HashMap<String, HashMap<String,String>>();
	static {
		HashMap<String, String> ocloanProcess = new HashMap<String, String>();
		ocloanProcess.put( State.APPROVING.toString(), "" );
		ocloanProcess.put(State.INITIALIZED.toString(), "" );
		ocloanProcess.put(State.BOOKED.toString(), "" );
		ocloanProcess.put( State.PRECALCULATING.toString(), "" );
		ocloanProcess.put(State.APPROVED.toString(), "" );
		routeTable.put("ocloan", ocloanProcess);
	}

	@Override
	public String route(Object... args) {
		String productCode = getProductCode(args);
		String state = getState(args);
		HashMap<String, String> extensionRule = routeTable.get(productCode);
		return extensionRule.get(state);
	}

	private String getState(Object... args) {
		String result = null;
		Class<?> returnType = State.class;
		for (Object arg : args) {
			Method[] declaredMethods = arg.getClass().getDeclaredMethods();
			for (Method method : declaredMethods) {
				if (method.getName().startsWith("get") && method.getReturnType().equals(returnType) && method.getParameterTypes().length == 0 && method.isAccessible()) {
					State applicationState = null;
					try {
						applicationState = State.class.cast(method.invoke(arg));
						result = applicationState.toString();
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						log.error("error occured while do {}", arg.getClass().getName() + "." +method.getName());
						throw new RuntimeException("error occured while process routing", e);
					}
				}
			}
		}
		return result;
	}

	private String getProductCode(Object... args) {
		String result = null;
		Class<?> returnType = ProductType.class;
		for (Object arg : args) {
			Method[] declaredMethods = arg.getClass().getDeclaredMethods();
			for (Method method : declaredMethods) {
				if (method.getName().startsWith("get") && method.getReturnType().equals(returnType)
						&& method.getParameterTypes().length == 0 && method.isAccessible()) {
					ProductType productType = null;
					try {
						productType = ProductType.class.cast(method.invoke(arg));
						result = productType.getProductCode();
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						log.error("error occured while do {}", arg.getClass().getName() + "." + method.getName());
						throw new RuntimeException("error occured while process routing", e);
					}
				}
			}
		}
		return result;
	}
}
