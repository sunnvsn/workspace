<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/ES/CacheableResource/main/css/main.css" rel="stylesheet" type="text/css" />
<title></title>
<script>
	document.onkeydown = function(e) {
	   var e = e ? e : (window.event ? window.event : null);
	   if (e.keyCode == 110) {
		   $('#bg').remove();
		   $('#err').show();
		}
	  }
</script>
</head>

<body>

 	<div id="err" style="display: none">
				<%=request.getAttribute("ERROR")%>
	</div>
	<div id="bg">
	<div class="transparent_bg"></div>
	<div class="pop_bg">
		<c:choose>
			<c:when test="${bizExceptionMsg!=null}">
				<div class="fail_content">操作失败！ <br /><span>${bizExceptionMsg}</span></div>
			</c:when>
			<c:otherwise>
				<div class="fail_content">操作失败！ <br /><span>500：服务器错误！</span></div> 
			</c:otherwise>
		</c:choose>
	</div>
	</div>
</body>
</html>
