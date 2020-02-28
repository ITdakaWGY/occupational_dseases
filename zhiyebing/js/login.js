$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form','laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
			var laydate = layui.laydate;
		laydate.render({
		  elem: '#qyrq' //指定元素
		});
		
		$('.dlbtn').click(function(){
			var username=$('.username').val();
			var userpass=$('.userpass').val();
			if(username==''){
				layer.msg('用户名不能为空', {
				  shade: 0.8,
				  time: 1000
				});
					$('.username').focus();
					return false;
			}
			if(userpass==''){
				 layer.msg('密码不能为空', {
				  shade: 0.8,
				  time: 1000
				});
				return false;
			}
			localStorage.setItem('token','1');
			window.location.href="welcome.html";
		})
	});
})