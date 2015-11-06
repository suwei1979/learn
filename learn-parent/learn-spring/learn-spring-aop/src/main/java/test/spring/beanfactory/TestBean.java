package test.spring.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * ʵ����BeanFactoryAware��BeanNameAware�ص��ӿ�
 * 
 * @author worldheart
 *
 */
public class TestBean implements ITestBean, BeanFactoryAware, BeanNameAware {

	private BeanFactory bf;
	
	private String beanName;
		
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.bf = beanFactory;
	}

	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	public void testBean() {
	}
	
}
