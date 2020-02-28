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
		$('body').on('click', '.yingtj', function() {
			var id=$(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '应体检项目数',
				shadeClose: true,
				shade: 0.8,
				area: ['80%', '80%'],
				content: 'page/jindu/gerenAll.html?id='+id,
			});
		})
		$('body').on('click', '.yitj', function() {
			var id=$(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '已体检项目数',
				shadeClose: true,
				shade: 0.8,
				area: ['80%', '80%'],
				content: 'page/jindu/gerenWei.html?id='+id,
			});
		})
		$('body').on('click', '.weitj', function() {
			var id=$(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '未体检项目数',
				shadeClose: true,
				shade: 0.8,
				area: ['80%', '80%'],
				content: 'page/jindu/gerenWei.html?id='+id,
			});
		})
		
	});
})