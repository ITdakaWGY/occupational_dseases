$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		var laydate = layui.laydate;
		laydate.render({
			elem: '#csny' //指定元素
		});

		//日期
		laydate.render({
			elem: '#date'
		});
		laydate.render({
			elem: '#date1'
		});
		
		$.ajax({
			type:"get",
			url:"../../json/minzu.json",
			async:true,
			success:function(data){
				var list=data.data;
				var html='';
				for(var i=0;i<list.length;i++){
					html += `<option  data-id="${list[i].id}" value="${list[i].name}">${list[i].name}</option>`
				}
				$('#minzu').html(html);
				form.render();
			}
		});
		
		$('body').on('click','#personJcxm',function(){
			layer.open({
			  type: 1,
			  skin: 'layui-layer-rim', //加上边框
			  area: ['420px', '240px'], //宽高
			  content:$('.hiddenJcxm'),
			});
		})

	});
})