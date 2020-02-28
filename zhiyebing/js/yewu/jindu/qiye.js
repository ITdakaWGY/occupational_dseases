$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		var laydate = layui.laydate;
		 laydate.render({
			    elem: '#starttime' //指定元素
			  });

		$('body').on('click', '.allPeople', function() {
			var id=$(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '应体检人员信息',
				shadeClose: true,
				shade: 0.8,
				area: ['80%', '80%'],
				content: 'page/jindu/qiyeall.html?id='+id,
			});
		})
		$('body').on('click', '.yiPeople', function() {
			var id=$(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '已体检人员信息',
				shadeClose: true,
				shade: 0.8,
				area: ['80%', '80%'],
				content: 'page/jindu/qiyeyi.html?id='+id,
			});
		})
		$('body').on('click', '.weiPeople', function() {
			var id=$(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '未体检人员信息',
				shadeClose: true,
				shade: 0.8,
				area: ['80%', '80%'],
				content: 'page/jindu/qiyewei.html?id='+id,
			});
		})
		
	});
})