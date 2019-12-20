package com.briup.web.listener;

import java.util.List;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Category;
import com.briup.service.ICategoryService;
import com.briup.service.impl.CategoryServiceImpl;

@WebListener
public class IndexLisenter implements ServletContextAttributeListener, ServletContextListener {
	private ApplicationContext context 
		= new ClassPathXmlApplicationContext("spring-mybatis.xml");
	
    public IndexLisenter() {
    }
    
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
    }

    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
    }
    
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("context init");
        ICategoryService service = context.getBean(ICategoryService.class);
        System.out.println(service != null);
        List<Category> list = service.getCategories();
        System.out.println(list != null);
        sce.getServletContext().setAttribute("category", list);
    }
	
}
