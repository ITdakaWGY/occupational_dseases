$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
			var laydate = layui.laydate;
			laydate.render({
			  elem: '#starttime' //指定元素
			});
			laydate.render({
			  elem: '#endtime' //指定元素
			});
		//体检人员登记
		$('body').on('click', '#AddBtn', function() {
			top.layer.open({
				type: 2,
				title: '职工信息登记',
				shadeClose: true,
				shade: 0.8,
				area: ['80%', '95%'],
				content: 'page/tjgl/dengji.html',
			});
		})
		
		$('body').on('dblclick', '.tableTop table tbody tr', function() {
			var id=$(this).find('.hiddenValue').val();
			top.layer.open({
				type: 2,
				title: '职工信息详情',
				shadeClose: true,
				shade: 0.8,
				area: ['80%', '95%'],
				content: 'page/tjgl/dengji.html?id='+id,
			});
		})
		
		$('body').on('click', '.editBtn', function() {
			var id=$(this).attr('data-id');
			top.layer.open({
				type: 2,
				title: '职工信息详情',
				shadeClose: true,
				shade: 0.8,
				area: ['80%', '95%'],
				content: 'page/tjgl/dengji.html?id='+id,
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