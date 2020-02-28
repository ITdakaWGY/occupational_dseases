$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		var laydate = layui.laydate;
		laydate.render({
			elem: '#tjrq',
		});
		laydate.render({
			elem: '#createtime',
		});
		form.on('checkbox(chiliezc)', function(data) {
			if(data.elem.checked) {
				$('input[name="cl"]:not(:first)').each(function() {
					$(this).prop('checked', false);
					$('.chilieyc').hide();
					$('.chilieyc input').each(function() {
						$(this).val('');
					})
					form.render();
				})
			}
		});

		//展示既往史的选项
		form.on('checkbox(chilie)', function(data) {
			if(data.elem.checked) {
				$('input[name="cl"]').eq(0).prop('checked', false);
			}
			if(data.value.indexOf('缺齿')>=0 && data.elem.checked) {
				$('.chilieyc').show();
				$('#qcdoms').show();
			} else if(data.value.indexOf('缺齿')>=0 && !(data.elem.checked)) {
				$('#qcdoms').hide();
			}
			if(data.value.indexOf('龋齿')>=0 && data.elem.checked) {
				$('.chilieyc').show();
				$('#jcdoms').show();
			} else if(data.value.indexOf('龋齿')>=0 && !(data.elem.checked)) {
				$('#jcdoms').hide();
			}

			if(data.value.indexOf('义齿（假牙）')>=0 && data.elem.checked) {
				$('.chilieyc').show();
				$('#ycdoms').show();
			} else if(data.value.indexOf('义齿（假牙）')>=0  && !(data.elem.checked)) {
				$('#ycdoms').hide();
			}
			form.render();
		});
	});

	// 选项卡
	$('.leftTiJian ul').hide()
	$('.leftTiJian ul').eq(0).show()
	$('.leftTiJian p').click(function() {
		id = $(this).index()
		$(this).siblings().removeClass('active');
		$(this).addClass('active');
		$('.leftTiJian ul').hide();
		$('.leftTiJian ul').eq(id).show()
	})
})