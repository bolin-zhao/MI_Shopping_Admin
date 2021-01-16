<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="plugins/layui/css/layui.css" rel="stylesheet" /><!-- 引入layui的样式 -->
<script charset="utf-8" src="plugins/layui/layui.js"></script>
<script charset="utf-8" src="jquery-1.8.3.js"></script>
</head>
<body>

	<script>
		layui.use(['form','layer'],function(){
			var form=layui.form;
			var $=layui.jquery;
			var layer=layui.layer;
			var index=parent.layer.getFrameIndex(window.name);

			
			form.on('submit(btnAdd)',function(data){
				$.ajax({
					type:"post",
					url:"add?str="+JSON.stringify(data.field),//data.field从数据中难道字段的值
					dataType:"text",
					success:function(data){
					
						if(data==1){
							layer.alert("成功");
							parent.layer.close(index);
						}
						//layer.msg("fasefewgf");
						//layer.closeAll();
					}
				});
				return false;
			});
			
			
			$(function(){
				$("[name=buildingid]").click(function(){
					
				
					$.ajax({
						url:'findallbu',
						type:'get',
						dataType:"json",
						success:function(data){
							layer.msg("aa");
							//var res=eval('('+data+')');
						
							 /* for(int i=0;i<res.length;i++){
								var r="<option value="+res[i].building_ID+">"+res[i].building_Name+"</option>"
								$("[name=buildingid]").append(r);
							  }*/
						}
					});
				});
			});
			
			
			
		});
	</script>
	<form class="layui-form layui-form-pane" action="#" method="post">
	
		
		
		<div class="layui-form-item">
					<label class="layui-form-label">请选择公寓</label>
					<div class="layui-input-inline">
						<select name="buildingid" >
							
								<option value="0">请选择</option>
							
						</select>
					</div>
		</div>
		
		
		<div class="layui-form-item">
					<label class="layui-form-label">宿管密码</label>
					<div class="layui-input-block">
						<input type="password" name="teacher_Password"  class="layui-input" />
					</div>
		</div>
		<div class="layui-form-item">
					<label class="layui-form-label">宿管姓名</label>
					<div class="layui-input-block">
						<input type="text" name="teacher_Name"  class="layui-input" />
					</div>
		</div>
		
		<div class="layui-form-item">
					<label class="layui-form-label">宿管性别</label>
					<div class="layui-input-block">
						<input type="text" name="teacher_Sex"  class="layui-input" />
					</div>
		</div>
		<div class="layui-form-item">
					<label class="layui-form-label">宿管电话</label>
					<div class="layui-input-block">
						<input type="text" name="teacher_Tel"  class="layui-input" />
					</div>
		</div>
		
		<div class="layui-form-item">
					
					<div class="layui-input-block">
						<button class="layui-btn" value="提交" lay-submit lay-filter="btnAdd">提交</button>
					</div>
		</div>
		
	</form>
</body>
</html>