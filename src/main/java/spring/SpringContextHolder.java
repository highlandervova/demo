package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextHolder {
    private static final ApplicationContext context;
    static {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
    }
    public static ApplicationContext getContext() {
        return context;
    }
    public static Object getBean(String beanId) {
        return context.getBean(beanId);
    }
}
