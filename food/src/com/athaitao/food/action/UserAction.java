package com.athaitao.food.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athaitao.food.bean.User;
import com.athaitao.food.service.UserServiceImp;

public class UserAction{
	
	private ApplicationContext ctx = null;    
	private UserServiceImp userService=null;
    public void init() {  
    	ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");  
    	userService = (UserServiceImp) ctx.getBean("userService"); 
        
    } 
    
     @ResponseBody
    @RequestMapping("/userLogin")
	public Map<String, String> userLogin(String username, String userpass)
	{
    	 Map map=new HashMap<String, String>();
    	 if(username.equals("")||userpass.equals(""))
    	 {
    		 map.put("userid", "-1");//�û��������벻��Ϊ��
    	 }
    	
    	init();
    	User checkuser=userService.getValidUser(username, userpass);
    	System.out.println(checkuser);
    	if(checkuser==null)
    		map.put("userid", "0");
    	else
    		map.put("userid", checkuser.getUser_id()+"");
		return map;		
	}
     @ResponseBody
     @RequestMapping(value = "/userRegister")   
 	public Map<String, String> userRegister(String username, String userpass,String mobilenum,String address,String comment)
 	{
    	// try{
    	 System.out.println(address); 
    	 User user=new User();
    	 user.setUsername(username);
    	 user.setUserpass(userpass);
    	 user.setMobilenum(mobilenum);
    	 user.setAddress(address);
    	 user.setComment(comment);
    	 Map map=new HashMap<String, String>();
     	 init();
     	
     	int result=userService.insertUser(user);
     	map.put("success", result+"");     	
 		return map;	
    	 /*}catch (UnsupportedEncodingException e) {  
             e.printStackTrace();  
             return null;  
         }*/ 
     		
 	}
  
     @ResponseBody
     @RequestMapping("/getUserById")
 	public User getUserById(String user_id)
 	{
     	init();
     	return userService.getUserById(user_id);
 		
 	}
     @ResponseBody
     @RequestMapping("/updateUserById")
 	public Map<String, String> updateUserById(String user_id,String username,String userpass,String address,String mobilenum)
 	{
     	init();
     	Map map=new HashMap<String, String>();
     	map.put("success", userService.updateUserById(user_id,username,userpass,address,mobilenum)+"");
     	return map;
 		
 	}
     @RequestMapping("/userManager")
 	public ModelAndView userManager()
 	{
 		init();
 		String forward="main";
 		return new ModelAndView(forward,null);
 			
 	}
     
     @ResponseBody
     @RequestMapping("/getAllUsers")
 	public List<User>  getAllUsers()
 	{
     	init();
     List<User> users=userService.getAllUsers();
     System.out.println(users);
     return users;
 		
 	}
     @ResponseBody
     @RequestMapping("/resetPassword")
 	public Map<String, String>  resetPassword(String user_id)
 	{
     	init();
    	Map map=new HashMap<String, String>();
     	map.put("success", userService.resetPassword(user_id));
     	return map;
 		
 	}

}
