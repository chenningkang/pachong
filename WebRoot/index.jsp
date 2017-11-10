<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form  >
    	<td>
    		<input type="hidden" name="post_id" value="1" />
            <input type="hidden" name="type" value="pk10" />
    	 
    	</td>
    
    </form>
  </body>
  <script>
  //定时获取冠军数据
  ajax_index();
      //  setInterval(ajax_index,5000);

		function ajax_index(type){
			alert(123);
		  var post_id = $("input[name=post_id]").val();
		  var type = type?type:$("input[name=type]").val();
		   // console.log(post_id);
		  $.ajax({
		      url: "http://caipiaotj.com/index.php/Home/Pk10/ajax_index",
		      type: "POST",
				dataType: 'JSON',
				crossDomain: true,  
		      data:{id:post_id,type:type},
		        success: function (data) {
		
					 
					  console.log(data.count);
		
		
		
		         
		
		      }
		  });
		}
		  
  </script>
  
</html>
