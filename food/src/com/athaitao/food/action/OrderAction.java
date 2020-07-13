package com.athaitao.food.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athaitao.food.bean.Collection;
import com.athaitao.food.bean.Order;
import com.athaitao.food.service.OrderServiceImp;

public class OrderAction{
	
	private ApplicationContext ctx = null;    
	private OrderServiceImp orderService=null;
    public void init() {  
    	ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");  
    	orderService = (OrderServiceImp) ctx.getBean("orderService"); 
        
    } 
 
    @ResponseBody
    @RequestMapping("/insertOrder")
	public Map<String, String> insertOrder(int user_id,int food_id,int num,double sum,String suggesttime)    
	{
   	  init();
   	  Order order=new Order();
   	  order.setUser_id(user_id);
   	  order.setFood_id(food_id);
   	  order.setNum(num);
   	  order.setSum(sum);
   	  order.setSuggesttime(suggesttime);
   	  System.out.println(order);   			
      Map map=new HashMap<String, String>();   	
      int result=orderService.insertOrder(order);
      map.put("success", result+""); 
      return map;
	}
    @ResponseBody
    @RequestMapping("/insertComment")
	public Map<String, String> insertComment(int order_id,String content)    
	{
   	  init();  			
      Map map=new HashMap<String, String>();   	
      int result=orderService.insertComment(order_id, content);
      map.put("success", result+""); 
      return map;
	}
    @ResponseBody
    @RequestMapping("/updateComment")
	public Map<String, String> updateComment(int order_id,String content)    
	{
   	  init();  	
   	  System.out.println(content);
      Map map=new HashMap<String, String>();   	
      int result=orderService.updateComment(order_id, content);
      map.put("success", result+""); 
      return map;
	}
    @ResponseBody
    @RequestMapping("/deleteComment")
	public Map<String, String> deleteComment(int order_id)    
	{
   	  init();  			
      Map map=new HashMap<String, String>();   	
      int result=orderService.deleteComment(order_id);
      map.put("success", result+""); 
      return map;
	}
    @ResponseBody
    @RequestMapping("/getAllUserOrder")
	public List<Order> getAllUserOrder(String user_id)
	{
    	init();    	
    	List<Order> result=orderService.getAllUserOrder(user_id);
    	System.out.println(result);
    	return result;		
	}
    @ResponseBody
    @RequestMapping("/getAllOrder")
	public List<Order> getAllOrder()
	{
    	init();    	
    	List<Order> result=orderService.getAllOrder();
    	return result;		
	}
    @ResponseBody
    @RequestMapping("/getAllUserFoodOrder")
	public List<Order> getAllUserFoodOrder(String food_id)
	{
    	init();    	
    	List<Order> result=orderService.getAllFoodOrder(food_id);
    	return result;		
	}
    @ResponseBody
    @RequestMapping("/getAllUserComment")
	public List<Order> getAllUserComment(String user_id)
	{
    	init();    	
    	List<Order> result=orderService.getAllUserComment(user_id);
    	return result;		
	}
    
    @RequestMapping("/orderManager")
 	public ModelAndView orderManager()
 	{
 		init();
 		String forward="ordermanager";
 		return new ModelAndView(forward,null);
 			
 	}

}
