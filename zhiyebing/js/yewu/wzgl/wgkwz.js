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

		$('#searchBtn').click(function() {
			var tmh = $('#sstmh').val();
			var sfz = $('#sssfz').val();
			var tjrq = $('#tjrq').val();
			if(tjrq.trim() == '') {
				layer.msg('请选择体检日期');
				$('#ssxm').focus();
				return false;
			} else {
				tjrq = new Date(tjrq);
			}

			if(tmh.trim() == '' && sfz.trim() == '') {
				layer.msg('条码号或身份证必须输入一个');
				$('#sstmh').focus();
				return false;
			}

			var params = {
				tmh: tmh,
				sfz: sfz,
				tjrq: tjrq,
			}
			debugger;
			var loading = layer.msg('正在查询...', {
				icon: 16,
				shade: 0.2,
				time: false
			});
			var urls = 'InquiryWgk/list/1/' + pageSize;
			$.ajax({
				type: "get",
				url: BaseUrl + urls,
				async: true,
				data: params,
				success: function(data) {
					layer.close(loading);
					if(data.success) {
						var list = data.queryResult.list;
						if(list.length > 0) {
							var data = list[0];
							$('input[name="tmh"]').val(data.tmh);
							$('input[name="xm"]').val(data.xm);
							$('input[name="sfz"]').val(data.sfz);
							$('input[name="zysl"]').val(data.zysl);
							$('input[name="yysl"]').val(data.yysl);
							$('input[name="zyjzsl"]').val(data.zyjzsl);
							$('input[name="yyjzsl"]').val(data.yyjzsl);
							$('input[name="slbz"]').val(data.slbz);
							intRadio('wy', data.wy);
							$('input[name="wyms"]').val(data.wyms);
							$('input[name="wybz"]').val(data.wybz);
							intRadio('jt', data.jt);
							$('input[name="jtms"]').val(data.jtms);
							$('input[name="jtbz"]').val(data.jtbz);
							intRadio('sjrt', data.sjrt);
							$('input[name="sjrtms"]').val(data.sjrtms);
							$('input[name="ydbz"]').val(data.ydbz);
							intRadio('swmxg', data.swmxg);
							$('input[name="swmxgms"]').val(data.swmxgms);
							intRadio('hbq', data.hbq);
							$('input[name="hbqms"]').val(data.hbqms);
							intRadio('ek', data.ek);
							$('input[name="ekms"]').val(data.ekms);
							$('input[name="webz"]').val(data.webz);
							intRadio('wed', data.wed);
							$('input[name="wedms"]').val(data.wedms);
							$('input[name="ztl"]').val(data.ztl);
							$('input[name="ytl"]').val(data.ytl);
							$('input[name="tlbz"]').val(data.tlbz);
							intRadio('bwx', data.bwx);
							intRadio('bzg', data.bzg);
							intRadio('bqnm', data.bqnm);
							intRadio('bdqyt', data.bdqyt);
							intRadio('kc', data.kc);
							//齿列多选框
							if(data.cl != null) {
								var cl = data.cl.split(',');
								intCheckbox('cl', cl);
							}
							intRadio('kqyb', data.kqyb);
							intRadio('yhyb', data.yhyb);
							intRadio('btt', data.btt);
							intRadio('kyb', data.kyb);
							$('input[name="bwxms"]').val(data.bwxms);
							$('input[name="bbz"]').val(data.bbz);
							$('input[name="bzgms"]').val(data.bzgms);
							$('input[name="bdqytms"]').val(data.bdqytms);
							$('input[name="kqbz"]').val(data.kqbz);
							$('input[name="yhybms"]').val(data.yhybms);
							$('input[name="bttms"]').val(data.bttms);
							$('input[name="kybms"]').val(data.kybms);
							$('input[name="ysqz"]').val(data.ysqz);
							$('input[name="createtime"]').val(data.createtime);
							$('input[name="qczs"]').val(data.qczs);
							$('input[name="qczx"]').val(data.qczx);
							$('input[name="qcys"]').val(data.qcys);
							$('input[name="qcyx"]').val(data.qcyx);
							$('input[name="yczs"]').val(data.yczs);
							$('input[name="yczx"]').val(data.yczx);
							$('input[name="ycys"]').val(data.ycys);
							$('input[name="ycyx"]').val(data.ycyx);
							$('input[name="jczs"]').val(data.jczs);
							$('input[name="jczx"]').val(data.jczx);
							$('input[name="jcys"]').val(data.jcys);
							$('input[name="jcyx"]').val(data.jcyx);
							$('input[name="yhbz"]').val(data.yhbz);
							$('input[name="bqnmms"]').val(data.bqnmms);
							if(data.cl.indexOf('缺齿')>=0){
								$('#qcdoms').show();
							}
							
							if(data.cl.indexOf('龋齿')>=0){
								$('#jcdoms').show();
							}
							if(data.cl.indexOf('义齿')>=0){
								$('#ycdoms').show();
							}
							form.render();
						}else{
							layer.msg('暂无相关信息');
						}
					} else {
						layer.msg(data.message);
					}
				},
				error: function(data) {
					layer.close(loading);
					layer.msg(data.message);
				}

			});

		})

		$('.saveTijian').click(function() {
			var loading = layer.msg('正在保存...', {
				icon: 16,
				shade: 0.2,
				time: false
			});
			var params = {
				tmh: $('input[name="tmh"]').val(),
				xm: $('input[name="xm"]').val(),
				sfz: $('input[name="sfz"]').val(),
				zysl: $('input[name="zysl"]').val(),
				yysl: $('input[name="yysl"]').val(),
				zyjzsl: $('input[name="zyjzsl"]').val(),
				yyjzsl: $('input[name="yyjzsl"]').val(),
				slbz: $('input[name="slbz"]').val(),
				wy: $('input[name="wy"]:checked').val(),
				wyms: $('input[name="wyms"]').val(),
				wybz: $('input[name="wybz"]').val(),
				jt: $('input[name="jt"]:checked').val(),
				jtms: $('input[name="jtms"]').val(),
				jtbz: $('input[name="jtbz"]').val(),
				sjrt: $('input[name="sjrt"]:checked').val(),
				sjrtms: $('input[name="sjrtms"]').val(),
				ydbz: $('input[name="ydbz"]').val(),
				swmxg: $('input[name="swmxg"]:checked').val(),
				swmxgms: $('input[name="swmxgms"]').val(),
				hbq: $('input[name="hbq"]:checked').val(),
				hbqms: $('input[name="hbqms"]').val(),
				ek: $('input[name="ek"]:checked').val(),
				ekms: $('input[name="ekms"]').val(),
				webz: $('input[name="webz"]').val(),
				wed: $('input[name="wed"]:checked').val(),
				wedms: $('input[name="wedms"]').val(),
				ztl: $('input[name="ztl"]').val(),
				ytl: $('input[name="ytl"]').val(),
				tlbz: $('input[name="tlbz"]').val(),
				bwx: $('input[name="bwx"]:checked').val(),
				bzg: $('input[name="bzg"]:checked').val(),
				bqnm: $('input[name="bqnm"]:checked').val(),
				bqnmms:$('input[name="bqnmms"]').val(),
				bdqyt: $('input[name="bdqyt"]:checked').val(),
				kc: $('input[name="kc"]:checked').val(),
				cl: getCheckArry('cl'),
				kqyb: $('input[name="kqyb"]:checked').val(),
				yhyb: $('input[name="yhyb"]:checked').val(),
				btt: $('input[name="btt"]:checked').val(),
				kyb: $('input[name="kyb"]:checked').val(),
				bwxms: $('input[name="bwxms"]').val(),
				bbz: $('input[name="bbz"]').val(),
				bzgms: $('input[name="bzgms"]').val(),
				bdqytms: $('input[name="bdqytms"]').val(),
				kqbz: $('input[name="kqbz"]').val(),
				yhybms: $('input[name="yhybms"]').val(),
				bttms: $('input[name="bttms"]').val(),
				kybms: $('input[name="kybms"]').val(),
				yhbz: $('input[name="yhbz"]').val(),
				ysqz: $('input[name="ysqz"]').val(),
				createtime: $('input[name="createtime"]').val(),
				qczs: $('input[name="qczs"]').val(),
				qczx: $('input[name="qczx"]').val(),
				qcys: $('input[name="qcys"]').val(),
				qcyx: $('input[name="qcyx"]').val(),
				yczs: $('input[name="yczs"]').val(),
				yczx: $('input[name="yczx"]').val(),
				ycys: $('input[name="ycys"]').val(),
				ycyx: $('input[name="ycyx"]').val(),
				jczs: $('input[name="jczs"]').val(),
				jczx: $('input[name="jczx"]').val(),
				jcys: $('input[name="jcys"]').val(),
				jcyx: $('input[name="jcyx"]').val(),
			}
			$.ajax({
				type: "post",
				url: BaseUrl + '/InquiryWgk/add',
				async: true,
				data: JSON.stringify(params),
				processData: false,
				contentType: "application/json",
				success: function(data) {
					layer.close(loading);
					debugger;
					if(data.success) {
						layer.alert('保存成功', {
							skin: 'layui-layer-lan',
							closeBtn: 0,
							anim: 4 //动画类型
						}, function(tc, layero) {
							window.location.reload();
						});
					} else {
						layer.msg(data.message);
					}
				},
				error: function(data) {
					layer.close(loading);
					layer.msg(data.message);
				}
			});
		})

		//展示既往史的选项
		form.on('checkbox(chilie)', function(data) {
			if(data.elem.checked) {
				$('input[name="cl"]').eq(0).prop('checked', false);
			}
			if(data.value.indexOf('缺齿') >= 0 && data.elem.checked) {
				$('.chilieyc').show();
				$('#qcdoms').show();
			} else if(data.value.indexOf('缺齿') >= 0 && !(data.elem.checked)) {
				$('#qcdoms').hide();
			}
			if(data.value.indexOf('龋齿') >= 0 && data.elem.checked) {
				$('.chilieyc').show();
				$('#jcdoms').show();
			} else if(data.value.indexOf('龋齿') >= 0 && !(data.elem.checked)) {
				$('#jcdoms').hide();
			}

			if(data.value.indexOf('义齿（假牙）') >= 0 && data.elem.checked) {
				$('.chilieyc').show();
				$('#ycdoms').show();
			} else if(data.value.indexOf('义齿（假牙）') >= 0 && !(data.elem.checked)) {
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