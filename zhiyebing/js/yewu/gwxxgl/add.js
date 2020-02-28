$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form','laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
			var laydate = layui.laydate;
		laydate.render({
		  elem: '#bgwcsj' //指定元素
		});
		var frameId=window.location.href.split('?')[1].split('=')[1];
		alert(frameId);
		//监听其他
		form.on('checkbox(whyszlqt)', function(data){
			if(data.elem.checked){
				$('#whyszlqt').show();
			}else{
				$('#whyszlqt').hide();
			}
		});
		
		$('.saveTijian').click(function(){
			layer.alert('保存成功', {
							skin: 'layui-layer-lan',
							closeBtn: 0,
							anim: 4 //动画类型
						}, function(tc, layero) {
							var dom=$(top.window[frameId].document.getElementById('AddBtn'));
							dom.trigger('click');
							parent.layer.closeAll();
						});
		})

	});
})