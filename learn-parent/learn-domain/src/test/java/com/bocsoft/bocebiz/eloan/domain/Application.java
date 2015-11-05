package com.bocsoft.bocebiz.eloan.domain;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

import com.bocsoft.bocebiz.eloan.domain.service.apply.ApplyService;
import com.bocsoft.bocebiz.eloan.domain.service.apply.impl.ApplyServiceImpl;
import com.bocsoft.bocebiz.eloan.domain.service.spi.impl.spring.ExtensionProcessAssembler;
import com.bocsoft.metis.commons.loader.Loader;
import com.bocsoft.metis.commons.log.listener.AppArgsLogInitializationListener;
import com.bocsoft.metis.commons.utils.SpringUtils;

/**
 * Top Configuration of spring.
 */
@ComponentScan(basePackages = "com.bocsoft.bocebiz.eloan.domain",
    includeFilters = @ComponentScan.Filter(value = Aspect.class, type = FilterType.ANNOTATION))
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAutoConfiguration
public class Application implements Loader{

	  private ApplicationContext ctx;

	  @Override
	  public void start() {
	    SpringApplication application = new SpringApplicationBuilder()
	        .sources(Application.class)
	        .showBanner(false).web(false).build();
	    application.addListeners(new AppArgsLogInitializationListener());
	    ctx = application.run();
	  }

	  @Override
	  public void stop() {
	    if (ctx != null) {
	      SpringApplication.exit(ctx);
	    }
	  }
	  
	  @Bean
	  public ApplyService applyService() {
		  return new ApplyServiceImpl();
	  }
	  
	  @Bean
	  public ExtensionProcessAssembler extensionProcessAssembler() {
		  return new ExtensionProcessAssembler();
	  }
	  
	  @Bean
	  public SpringUtils springUtils() {
		  return new SpringUtils();
	  }
}
