<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>朋友圈登陆</title>
    <style type="text/css">
    	#container{
    		width: 1000px;
			height: 1000px;
			margin-right: auto; 
			margin-left: auto;
    	}

    	#backgrundimg{
    		width: 970px;
			height: 620px; 
			background-image: url(/WeChat/CacheableResource/images/ds.png);
			filter:alpha(opacity=60);
			z-index: -1;
    	}
    	#loginInfo{
    		width:400px;
			height:150px;
			position:relative;
			left:85px; 
			bottom:490px;
			filter:alpha(opacity=60);
    	}
    	#loginInfo input{
    		width:200px;
			height:35px;
			color:#000080;
			font-size: 24px;
			font-height:31px;
    	}
    	#loginInfo span{
    		color:#000080;
			font-size: 24px;
			font-height:31px;
    	}
    	#loginInfo button{
    		width:45px;
			height:41px;
    	}
	</style>	
	<script type="text/javascript" charset="utf-8" src="/WeChat/CacheableResource/jquery200/jquery-3.1.0.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function (){
			$(":button").click(function(){
				
				var name = $("#uName").val();
				var ps = $("#password").val();
				$.ajax({
		             type: "POST",
		             url: "loginToIndex",
		             async: false,
		             data: {userName:name,password:ps},
		             dataType: "json",
		              success: function(data){
		            	  if(data.status){
		                         alert('登陆成功！');
		                         window.location.replace('index');
		            	  }
		            	  else{
		                         alert('用户名、密码错误！');	            		 	
		            	  }
		                      },
                      error: function(XMLHttpRequest, textStatus, errorThrown){
                    	  alert(errorThrown);
                    	  window.location.reload();
                      } 
		         	});					
			});
		})
		
		
	</script>
  </head>
  
  <body>
  	<div id="container"> 
	  	<div id="backgrundimg"></div>
	  	<div id="loginInfo">
	  		<table>
	  			<p><span>用户名：</span><input class="userInfo" id="uName" type="text" name="uName"></p>
		  		<p><span>密&nbsp码：</span><input class="userInfo" id="password" type="password" name="password">
		  		<button><span>go</span></button></p>
	  		</table>	  			
	  	</div>		
  	</div>
  </body>
</html>