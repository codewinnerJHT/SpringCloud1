package com.athaitao.food.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.athaitao.food.bean.Collection;
import com.athaitao.food.service.CollectServiceImp;

public class CollectAction{
	
	private ApplicationContext ctx = null;    
	private CollectServiceImp collectService=null;
	//private CollectServiceImp collectService=null;
    public void init() {  
    	ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");  
    	collectService = (CollectServiceImp) ctx.getBean("collectService"); 
        
    } 
 
     @ResponseBody
     @RequestMapping("/getAllUserCollection")
 	public List<Collection> getAllUserCollection(int user_id,int flag)
 	{
     	init();    	
     	List<Collection> result=collectService.getAllUserCollection(user_id,flag);
     	return result;		
 	}
     @ResponseBody
     @RequestMapping("/userCollectFood")
 	public Map<String, String> userCollectFood(int user_id,int food_id)
 	{
     	 Map map=new HashMap<String, String>();
     	init();    	
     	int result=collectService.changeFoodCollection(user_id,food_id);
     	map.put("success", result+"");     	
 		return map;		
 	}
     @ResponseBody
     @RequestMapping("/userCollectShop")
 	public Map<String, String> userCollectShop(int user_id,int shop_id)
 	{
     	 Map map=new HashMap<String, String>();
     	init();    	
     	int result=collectService.changeShopCollection(user_id,shop_id);
     	map.put("success", result+"");     	
 		return map;		
 	}
     @ResponseBody
     @RequestMapping("/isCollected")
 	public Map<String, String> isCollected(int user_id,int shop_food_id,int flag)
 	{
     	 Map map=new HashMap<String, String>();
     	init();    	
     	int result=collectService.isCollected(user_id,shop_food_id,flag);
     	map.put("collected", result+"");  
 		return map;		
 	}

}
