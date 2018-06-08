package com.baidu.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineTest
 *
 */
public class OnlineTest implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private ServletContext application=null;
    public OnlineTest() {
        
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
        
        
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
//         List list = (List)application.getAttribute("alluser");
//         String user = (String)arg0.getSession().getAttribute("users");//获取要销毁的用户名
//         list.remove(user);//将销毁的用户名从集合中移除
//         application.setAttribute("alluser", list);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
//    	List list = (List)application.getAttribute("alluser");//从application中获取用户列表集合
//    	if(list!=null) {
//    		list.add(arg0.getValue());//将通过session添加的属性获取值后添加到集合中
//    	}else {
//			list = new ArrayList<>();
//			list.add(arg0.getValue());
//		}
//    	
//    	application.setAttribute("alluser", list);//重新将list集合存入application中
    	String username = (String)arg0.getValue();
		List<String> list = (List<String>) application.getAttribute("userlist");
		list.add(username);
		application.setAttribute("userlist", list);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
        
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	application = arg0.getServletContext();
		ArrayList<String> userlist = new ArrayList<String>();
		application.setAttribute("userlist", userlist);
    }
	
}
