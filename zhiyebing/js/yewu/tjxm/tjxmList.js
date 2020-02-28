$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		$('body').on('click', '#AddBtn', function() {
			top.layer.open({
				type: 2,
				title: '新增体检项目',
				shadeClose: true,
				shade: 0.8,
				area: ['65%', '80%'],
				content: 'page/tjxmxx/addTjxm.html',
			});
		})


		$('body').on('click', '.editBtn', function() {
			var id = $(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '体检项目修改',
				shadeClose: true,
				shade: 0.8,
				area: ['65%', '80%'],
				content: 'page/tjxmxx/editTjxm.html?id=' + id,
			});
		})
		
		$('body').on('click', '.lookTjzb', function() {
			var id = $(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '查看体检指标',
				shadeClose: true,
				shade: 0.8,
				area: ['90%', '90%'],
				content: 'page/tjxmxx/tjzb.html?id=' + id,
			});
		})
		
		$('body').on('click', '.addTjzb', function() {
			var id = $(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '新增体检指标',
				shadeClose: true,
				shade: 0.8,
				area: ['65%', '80%'],
				content: 'page/tjxmxx/addtjzb.html?id=' + id,
			});
		})


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