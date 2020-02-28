$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form','laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
			var laydate = layui.laydate;
		laydate.render({
		  elem: '#qyrq' //指定元素
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

function handleFile() {
	var formData = new FormData();
	var fileArry = $('#file')[0].files;
	for(var i = 0; i < fileArry.length; i++) {
		if(/.(PDF|pdf|DOC|doc|DOCX|docx)$/.test(fileArry[i].name)) { //文件必须为文档
			formData.append("files", fileArry[i]); //文件上传处理
		} else {
			alert('上传文件必须是PDF或DOC !!');
			return false;
		}
	}
	//请求上传接口
	//提交请求后,置空file的选项，需要返回对应的文件名称和uuid，最后提交的是uuid，（循环页面上的相关uuid即可）
	/*$.ajax({
		type:"post",
		url:"",
		async:true,
		cache: false,//上传文件无需缓存
       	processData: false,//用于对data参数进行序列化处理 这里必须false
		success:function(){
			$('#files').val('');
			
		}
	});*/
	
	
}