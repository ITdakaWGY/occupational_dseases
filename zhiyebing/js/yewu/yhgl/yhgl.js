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
			top.layer.open({
				type: 2,
				title: '新增用户管理',
				shadeClose: true,
				shade: 0.8,
				area: ['65%', '80%'],
				content: 'page/yhgl/add.html',
			});
		})

		$('body').on('click', '.editBtn', function() {
			var id = $(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '用户管理修改',
				shadeClose: true,
				shade: 0.8,
				area: ['65%', '80%'],
				content: 'page/yhgl/edit.html?id=' + id,
			});
		})
		
		
		// $('body').on('click', '.glryBtn', function() {
		// 	var id = $(this).attr('data-id');
		// 	top.layer.open({
		// 		type: 2,
		// 		title: '体检人员信息管理',
		// 		shadeClose: true,
		// 		shade: 0.8,
		// 		area: ['90%', '90%'],
		// 		content: 'page/tjryxxgl/tjryxxglList.html?id=' + id,
		// 	});
		// })

		$('body').on('click', '.deleteBtn', function() {
			layer.confirm('确定删除数据', {
				btn: ['确定', '取消'] //按钮
			}, function(index, layero) {
				//确定函数
				var id = $(this).attr('data-id');
				layer.alert('删除成功', {
					skin: 'layui-layer-lan',
					closeBtn: 0,
					anim: 4 //动画类型
				}, function(tc, layero) {
					layer.close(tc);
				});

			}, function(index, layero) {
				//取消函数
				layer.close(index);

			})

		})

	});
})