$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		var laydate = layui.laydate;
		laydate.render({
			    elem: '#tjrq' //指定元素
			  });
		
	});
	
	
	// 选项卡
	$('.leftTiJian ul').hide()
	$('.leftTiJian ul').eq(0).show()
	$('.leftTiJian p').click(function(){
		id = $(this).index()
		$(this).siblings().removeClass('active');
		$(this).addClass('active');
		$('.leftTiJian ul').hide();
		$('.leftTiJian ul').eq(id).show()
	})
})