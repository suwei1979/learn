package org.suw.learn.metis.commons.validate.aspect;

import org.apache.commons.lang3.Validate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.suw.learn.gaea.dubbo.Request;
import org.suw.learn.gaea.dubbo.Response;
import org.suw.learn.gaea.dubbo.factory.ResponseFactory;
import org.suw.learn.metis.commons.utils.AspectUtils;
import org.suw.learn.metis.commons.validate.annotation.ValidationHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Handling BindingResult errors of validation.
 */
@Aspect
public class ValidationContraintsAspect {

    @Pointcut(value = "@annotation(com.bocsoft.metis.commons.validate.annotation.ValidationHandler)")
    private void validation() {
    }

    @Around(value = "validation()")
    public final Object failMsgReturnWhenValidationFail(final ProceedingJoinPoint pjp) throws Throwable {
        final ValidationHandler anno = AspectUtils.getAnnotation(pjp, ValidationHandler.class);

        if (anno != null && anno.layer() == ValidationHandler.Layer.CONTROLLER) {
            final Object[] args = pjp.getArgs();
            BindingResult result = null;
            for (Object arg : args) {
                if (arg instanceof BindingResult) {
                    result = (BindingResult) arg;
                    break;
                }
            }
            if (result != null && result.hasErrors()) {
                Map<String, String> errorMap = new HashMap<>();
                for (FieldError objectError : result.getFieldErrors()) {
                    errorMap.put(objectError.getField(), objectError.getDefaultMessage());
                }
                return new ResponseEntity<>(errorMap, HttpStatus.NOT_ACCEPTABLE);
            }
        }
        return pjp.proceed();
    }

    @AfterThrowing(value = "validation()", throwing = "voilation")
    public final Response<?> handlerContraintViolation(final JoinPoint jp, ConstraintViolationException voilation) {
        final ValidationHandler anno = AspectUtils.getAnnotation(jp, ValidationHandler.class);

        Set<String> voilationMsg = new HashSet<>();
        Request<?> request = null;
        for (Object arg : jp.getArgs()) {
            if (arg instanceof Request) {
                request = (Request<?>) arg;
                break;
            }
        }
        for (ConstraintViolation<?> constraintViolation : voilation.getConstraintViolations()) {
            voilationMsg.add(constraintViolation.getMessage());
        }
        Validate.notNull(request);
        return ResponseFactory.getFailResponse("validation failed", voilationMsg.toString(), request);
    }
}