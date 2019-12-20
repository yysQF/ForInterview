package com.briup.web.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

import com.briup.bean.ShoppingCar;


@WebListener
public class sessionListener implements HttpSessionListener
 ,HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener, HttpSessionIdListener{

    public sessionListener() {
    	System.out.println("listener init");

    }


    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Session 被创建");
    	ShoppingCar car  = new ShoppingCar();
    	se.getSession().setAttribute("shopCar", car);
    	System.out.println("购物车对象创建");
    }

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ShoppingCar car = (ShoppingCar) se.getSession().getAttribute("shopCar");
		car.getLines().clear();
		System.out.println("购物车对象销毁");
	}


	@Override
	public void sessionIdChanged(HttpSessionEvent arg0, String arg1) {
		
	}


	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		
	}


	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		
	}


	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		
	}


	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		
	}


	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		
	}


	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		
	}


	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		
	}

}

