$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		$('body').on('click', '#AddBtn', function() {
			
			var frameId=$(window.frameElement).attr('data-id');
			top.layer.open({
				type: 2,
				title: '岗位信息添加',
				shadeClose: true,
				shade: 0.8,
				area: ['70%', '50%'],
				content: 'page/gwxxgl/addgwxxgl.html?frameId='+frameId,
			});
		})

		$('body').on('click', '.editBtn', function() {
			var id = $(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '岗位信息修改',
				shadeClose: true,
				shade: 0.8,
				area: ['70%', '50%'],
				content: 'page/gwxxgl/editgwxxgl.html?id=' + id,
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