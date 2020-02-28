$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form','laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
			var laydate = layui.laydate;
		laydate.render({
		  elem: '#bgwcsj' //指定元素
		});
		
		
		//监听其他
		form.on('checkbox(whyszlqt)', function(data){
			if(data.elem.checked){
				$('#whyszlqt').show();
			}else{
				$('#whyszlqt').hide();
			}
		});
		

	});
})