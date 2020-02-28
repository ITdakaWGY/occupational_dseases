$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		var laydate = layui.laydate;
		 laydate.render({
			    elem: '#starttime' //指定元素
			  });
		$('body').on('click', '#AddBtn', function() {
			var id=$(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '总检查查看',
				shadeClose: true,
				shade: 0.8,
				area: ['90%', '90%'],
//				content: 'page/tjqy/addtjqy.html?id='+id,
			});
		})
		$('body').on('click', '.lookBtn', function() {
					var id=$(this).attr('data-id');
					top.layer.open({
						type: 2,
						title: '体检结果汇总',
						shadeClose: true,
						shade: 0.8,
						area: ['90%', '90%'],
						content: 'page/tjgl/chakan.html?id='+id,
					});
				})
		
	});
})