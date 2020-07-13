package com.athaitao.food.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athaitao.food.bean.Food;
import com.athaitao.food.bean.FoodType;
import com.athaitao.food.service.FoodServiceImp;

public class FoodAction{
	
	private ApplicationContext ctx = null;    
	private FoodServiceImp foodService=null;
    public void init() {  
    	ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");  
    	foodService = (FoodServiceImp) ctx.getBean("foodService"); 
        
    } 
    
     @ResponseBody
    @RequestMapping("/getFoodByShop")
	public List<Food>  getFood(String shop_id)
	{
    	init();
    	List<Food> list=foodService.getFoodsByShop(shop_id);
		return list;		
	}

     @ResponseBody
    @RequestMapping("/getFoodBySearch")
	public List<Food>  getFoodBySearch(String search)
	{
    	init();
    	List<Food> list=foodService.getFoodsBySearch(search);
    	System.out.println(list);
		return list;		
	}
     
     @ResponseBody
     @RequestMapping("/getFoodType")
 	public List<FoodType>  getFoodType()
 	{
     	init();
     	List<FoodType> list=foodService.getFoodType();
 		return list;		
 	}
     
     @ResponseBody
    @RequestMapping("/getFoodById")
	public Food getFoodById(String food_id)
	{
    	init();
    	return foodService.getFoodById(food_id);
		
	}
     @RequestMapping("/foodManager")
  	public ModelAndView foodManager(String shop_id)
  	{
  		init();
  		Map<String ,Object> model=new HashMap<String,Object>();
 		model.put("shop_id", shop_id);
  		String forward="foodmanager";
  		return new ModelAndView(forward,model);
  			
  	}
     @RequestMapping("/newfoodmanager")
   	public ModelAndView newfoodmanager(String shop_id)
   	{
   		init();
   		Map<String ,Object> model=new HashMap<String,Object>();
  		model.put("shop_id", shop_id);
   		String forward="newfoodmanager";
   		return new ModelAndView(forward,model);
   			
   	}
     @ResponseBody
     @RequestMapping("/insertFood")
 	public Map<String, String> insertFood(String shop_id,String foodname,String type_id,String pic,double price,String intro,String recommand)
 	{
    	 System.out.println(shop_id);
     	 Map map=new HashMap<String, String>();
     	init();    	
     	int result=foodService.insertFood(shop_id,foodname,type_id,pic,price,intro,recommand);
     	map.put("success", result+"");     	
 		return map;		
 	}
    @RequestMapping("/editFood")
    	public ModelAndView editFood(String food_id,String shop_id)
    	{
    	 init();
    	 Food food=foodService.getFoodById(food_id);
    	 System.out.println(food);
     	 Map map=new HashMap<String, Object>();
     	 map.put("food", food);
     	map.put("shop_id", shop_id);
     	 System.out.println(food.toString());
    	 String forward="newfoodmanager";
    	return new ModelAndView(forward,map);
    			
    }
    @ResponseBody
    @RequestMapping("/updateFood")
	public Map<String, String> updateFood(int food_id,String foodname,int type_id,String pic,double price,String intro,int recommand)
	{
   	 System.out.println(foodname);
   	 Food food=new Food();
   	 food.setFood_id(food_id);
   	 food.setFoodname(foodname);
   	 food.setIntro(intro);
   	 food.setType_id(type_id);
   	 food.setRecommand(recommand);
   	 food.setPrice(price);
   	 food.setPic(pic);
    	 Map map=new HashMap<String, String>();
    	init();    	
    	int result=foodService.updateFood(food);
    	map.put("success",result+"");     	
		return map;		
	}
    @ResponseBody
    @RequestMapping("/deleteFood")
	public Map<String, String> deleteFood(String food_id)
	{
   	 System.out.println(food_id);
   	 Map map=new HashMap<String, String>();
    	init();    	
    	int result=foodService.deleteFood(food_id);
    	map.put("success", result+"");     	
		return map;		
	}
    
    /*@RequestMapping({ "/uploadFile" })
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
 			     	 result=foodService.insertShop(shop);
 			     		
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
*/
}
