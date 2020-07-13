package com.athaitao.food.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.athaitao.food.bean.Shop;
import com.athaitao.food.service.ShopServiceImp;

public class ShopAction{
	
	private ApplicationContext ctx = null;    
	private ShopServiceImp shopService=null;
    public void init() {  
    	ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");  
    	shopService = (ShopServiceImp) ctx.getBean("shopService"); 
        
    } 
    
     @ResponseBody
    @RequestMapping("/getAllShops")
	public List<Shop>  getAllShops()
	{
    	init();
    	List<Shop> shops=shopService.getAllShops();
		return shops;		
	}
     @ResponseBody
     @RequestMapping("/getAllShop")
 	public List<Shop>  getAllShop()
 	{
     	init();
     	List<Shop> shops=shopService.getAllShops();
 		return shops;		
 	}
     
     @ResponseBody
     @RequestMapping("/getShopById")
 	public Shop  getShopById(String shop_id)
 	{
     	init();
     	Shop shop=shopService.getShopById(shop_id);
 		return shop;		
 	}
     @RequestMapping("/shopManager")
   	public ModelAndView shopManager()
   	{
   		String forward="shopmanager";
   		return new ModelAndView(forward,null);
   			
   	}
     @RequestMapping("/editShop")
    	public ModelAndView editShop(String shop_id)
    	{
    	 init();
    	 Shop shop=shopService.getShopById(shop_id);
     	 Map map=new HashMap<String, Object>();
     	 map.put("shop", shop);
    		String forward="newshopmanager";
    		return new ModelAndView(forward,map);
    			
    	}
     
     @ResponseBody
     @RequestMapping("/insertShop")
 	public Map<String, String> insertShop(String shopname,String address,String phonenum,int level,String pic,String intro)
 	{
    	 Shop shop=new Shop();
    	 shop.setShopname(shopname);
    	 shop.setAddress(address);
    	 shop.setIntro(intro);
    	 shop.setLevel(level);
    	 shop.setPhonenum(phonenum);
    	 shop.setPic(pic);
    	 System.out.println(shop.toString());
     	 Map map=new HashMap<String, String>();
     	init();    	
     	int result=shopService.insertShop(shop);
     	map.put("success", result+"");     	
 		return map;		
 	}
     @ResponseBody
     @RequestMapping("/updateShop")
 	public Map<String, String> updateShop(String shopname,String address,String phonenum,int level,String pic,String intro,int shop_id)
 	{
    	 System.out.println(shopname);
    	 Shop shop=new Shop();
    	 shop.setShop_id(shop_id);
    	 shop.setShopname(shopname);
    	 shop.setAddress(address);
    	 shop.setIntro(intro);
    	 shop.setLevel(level);
    	 shop.setPhonenum(phonenum);
    	 shop.setPic(pic);
     	 Map map=new HashMap<String, String>();
     	init();    	
     	int result=shopService.updateShop(shop);
     	map.put("success",result+"");     	
 		return map;		
 	}
     
     @ResponseBody
     @RequestMapping("/deleteShop")
 	public Map<String, String> deleteShop(String shop_id)
 	{
    	 System.out.println(shop_id);
    	 Map map=new HashMap<String, String>();
     	init();    	
     	int result=shopService.deleteShop(shop_id);
     	map.put("success", result+"");     	
 		return map;		
 	}
     
 	@RequestMapping({ "/uploadFile" })
 	public @ResponseBody
 	 Map<String, String> uploadFile(HttpServletRequest request) throws IllegalStateException, IOException {
 		System.out.println("uploadFile=="+request);
 		Map map=new HashMap<String, String>();
 		
 		int result = 0;
 		try {
 			// ����������
 			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
 					request.getSession().getServletContext());
 			// ���form�Ƿ���enctype="multipart/form-data"
 			if (multipartResolver.isMultipart(request)) {
 				System.out.println("==============");
 				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
 				Iterator<String> iter = multiRequest.getFileNames();
 				if (iter.hasNext()) {
 					MultipartFile file = multiRequest.getFile(iter.next());
 					// ���ļ������д���ȡ������6���ַ���Ȼ����"."Ϊ�ָ���ȡ���ļ���׺
 					String originalFileName = file.getOriginalFilename();
 					System.out.println(originalFileName);
 					// ȡ�ú�׺
 					String suffixString = originalFileName
 							.substring(originalFileName.lastIndexOf(".") + 1);
 					// ��ȡ��������
 					Shop shop=new Shop();
 			    	 shop.setShopname(request.getParameter("shopname"));
 			    	 shop.setAddress(request.getParameter("address"));
 			    	 shop.setIntro(request.getParameter("intro"));
 			    	 shop.setLevel(Integer.parseInt(request.getParameter("level")));
 			    	 shop.setPhonenum(request.getParameter("phonenum"));
 			    	 shop.setPic(request.getParameter("pic"));
 			     	 init();    	
 			     	 result=shopService.insertShop(shop);
 			     		
 					// ���չ����������ϴ��ļ�
 					String fileName = shop.getPic();
 					String basepath = request.getSession().getServletContext().getRealPath("/");
 					String strdirection = "/upload/shop/";
 					File direction = new File(basepath + strdirection);// ����ϵ+רҵ+ѧ������
 					// ����ļ��в������򴴽�
 					if (!direction.exists())
 						direction.mkdirs(); // ���ɶ��Ŀ¼
 					long t1 = System.currentTimeMillis();
 					String relative_path = strdirection + fileName+ "." + suffixString;
 					String path = basepath + relative_path;
 					try {
 						File localFile = new File(path);
 						if (!localFile.exists())
 							localFile.createNewFile();
 						file.transferTo(localFile);
 						
 					} catch (IllegalStateException e) {
 						e.printStackTrace();
 					} catch (IOException e) {
 						e.printStackTrace();
 					} 

 				}
 			}
 		} catch (Exception e) {

 		} 
 		map.put("success", result+"");     	
 		return map;
 	} 

}
