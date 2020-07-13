
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>新增菜谱</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-table.min.css" />
</head>
<body>
<div class="container">

  <nav class="navbar navbar-default" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="#">后台管理</a>
   </div>
   <div>
      <ul class="nav navbar-nav">
         <li><a href="userManager.do">用户管理</a></li>
         <li class="active"><a href="shopManager.do">餐厅&菜谱管理</a></li>
         <li><a href="orderManager.do">订单&评论管理</a></li>
         
      </ul>
   </div>
</nav>
<form role="form" id="form" enctype="multipart/form-data">
   <div class="form-group">
      <label for="foodname">名称</label>
      <input type="text" class="form-control" id="foodname" name="foodname"
         placeholder="请输入名称">
   </div>
   <div class="form-group">
      <label for="price">价钱</label>
      <input type="text" class="form-control" id="price" name="price" 
         placeholder="请输入价钱">
   </div>

   <div class="form-group">
      <label for="intro">简介</label>
      <input type="text" class="form-control" name="intro" id="intro" 
         placeholder="请输入简介">
   </div>
   <div class="form-group">
      <label for="foodtype">种类</label>
     <select name="foodtype" id="foodtype">
     </select>
   </div>
   <div class="form-group">
      <label for="recommand">是否推荐</label>
      
   <div class="radio">
	   <label>
	      <input type="radio" name="recommand" id="recommand1" 
	         value="1" checked> 是
	   </label>
	</div>
	<div class="radio">
	   <label>
	      <input type="radio" name="recommand" id="recommand2"
	         value="0">否
	   </label>
	</div>
</div>
   <div class="form-group">
      <label for="pic">选择图片</label>
      <input type="text" id="pic" name="pic">
   </div>
   <button type="button" class="btn btn-success" id="submit">提交</button>
</form>
</div>
<script src="js/jQuery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.min.js"></script>
<script src="js/bootstrap-table-zh-CN.min.js"></script>
<script>

$(function () {
	 var food_id="${food.food_id}";//是否为修改内容
		
	 $.ajax({
			cache: true,
			type: "POST",
			url:"getFoodType.do",
			data:null,
			async: false,
		    error: function(request) {
		        alert("连接失败");
		    },
		    success: function(data) {
		    	var optionstring = "";   
		    	for (var i in data) {  
                    var jsonObj =data[i];                    
                     optionstring += "<option value='" + jsonObj.type_id +"'";
                     if(food_id!=""&&"${food.type_id}"==jsonObj.type_id)
                    	 optionstring +=" selected ";
                     optionstring+=">" + jsonObj.typename + "</option>";                     
                }  
		    	 $("#foodtype").html("<option value='0'>请选择口味...</option> "+optionstring);  
		    	
		    }
		});
	
		if(food_id!="")
			{
			console.log(food_id);
			$("#foodname").val("${food.foodname}");
			$("#price").val("${food.price}");
			$("#foodtype").val("${food.type_id}");
			$("#intro").val("${food.intro}");
			if("${food.type_id}"=="0")
				$("#recommand2").attr("checked",true);
			//$("#pic").val("${food.pic}");
			}
		$('#submit').click(function () {
    	var foodname=$("#foodname").val();
    	var price=$("#price").val();
    	var type_id=$("#foodtype").val();
    	var intro=$("#intro").val();
    	var pic=$("#pic").val();
    	var recommand= $("input[name='recommand'][checked]").val();
    	if(food_id!="")
    		$.ajax({
				cache: true,
				type: "POST",
				url:"updateFood.do",
				data:{food_id:food_id,foodname:foodname,price:price,type_id:type_id,intro:intro,pic:pic,recommand:recommand},
				async: false,
			    error: function(request) {
			        alert("连接失败");
			    },
			    success: function(data) {
			    	if(data.success==1)
				  		 alert("修改成功");
			    	else
			    		alert("修改失败");
			    }
			});
    	else
        $.ajax({
 					cache: true,
 					type: "POST",
 					url:"insertFood.do",
 					data:{foodname:foodname,price:price,type_id:type_id,intro:intro,shop_id:${shop_id},pic:pic,recommand:recommand},
 					async: false,
 				    error: function(request) {
 				        alert("连接失败");
 				    },
 				    success: function(data) {
 				    	if(data.success==1)
 					  		 alert("增加成功");
 				    	else
 				    		alert("增加失败");
 				    }
 				});

    });
});
</script>
</body>
</html>