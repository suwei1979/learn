package test.spring.beanfactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * ��ʾ������ע��
 * 
 * @author worldheart
 */
public class BeanFactoryDemo4 {

	protected static final Log log = LogFactory.getLog(BeanFactoryDemo4.class);

	public void getContent(){
		//��classpath·����װ��XML������Ϣ
		Resource resource = new ClassPathResource("beanFactory4.xml");
		//ʵ����IoC����
		BeanFactory factory = new XmlBeanFactory(resource);
		//����ܹ�POJO
		IHelloStr hs1 = (IHelloStr) factory.getBean("fileHello1");
		IHelloStr hs2 = (IHelloStr) factory.getBean("fileHello2");
		IHelloStr hs3 = (IHelloStr) factory.getBean("fileHello3");
		IHelloStr hs4 = (IHelloStr) factory.getBean("fileHello4");
		IHelloStr hs5 = (IHelloStr) factory.getBean("fileHello5");
		IHelloStr hs6 = (IHelloStr) factory.getBean("fileHello6");
		IHelloStr hs7 = (IHelloStr) factory.getBean("fileHello6");
	}

	public static void main(String[] args) {
		BeanFactoryDemo4 bfd = new BeanFactoryDemo4();
		bfd.getContent();
	}
	
}