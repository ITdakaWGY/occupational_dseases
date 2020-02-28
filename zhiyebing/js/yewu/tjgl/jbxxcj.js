$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		var laydate = layui.laydate;
		laydate.render({
			elem: '#csny' //指定元素
		});
		
		laydate.render({
			elem: '#tjrq' //指定元素
		});
		//初始化相关事件dom
		loadsj('kssj');
		loadsj('jssj');
		loadsj('jwssj');
		loadsj('sssj');
		
		//展示民族其他的选项
		form.on('radio(minzu)', function(data) {
			if(data.value == 2) {
				$('#mzqt').show();
			} else {
				$('#mzqt').hide();
			}
		});
		//展示婚姻其他的选项
		form.on('radio(hunyin)', function(data) {
			if(data.value == 6) {
				$('#hyzkqt').show();
			} else {
				$('#hyzkqt').hide();
			}
		});
		//展示职业病危害因素其他的选项
		form.on('checkbox(jcwhysqt)', function(data) {
			if(data.elem.checked) {
				$('#jcwhysqt').show();
			} else {
				$('#jcwhysqt').hide();
			}
		});

		//展示饮酒种类其他其他的选项
		form.on('checkbox(yjzlqt)', function(data) {
			if(data.elem.checked) {
				$('#yjzlqt').show();
			} else {
				$('#yjzlqt').hide();
			}
		});
		//展示既往史无的选项
		form.on('checkbox(jwswu)', function(data) {
			if(data.elem.checked) {
				$('input[name="jws"]:not(:first)').each(function() {
					$(this).prop('checked', false);
				})
				$('.jwsjb').hide();
				$('#exzltext').hide();
				$('#zybtext').hide();
				form.render();
			}
		});
		
		
		
		
		//展示既往史的选项
		form.on('checkbox(jwsjb)', function(data) {
			if(data.value == 13 && data.elem.checked) {
				$('.jwsjb').show();
			} else if(data.value == 13 && !(data.elem.checked)) {
				$('.jwsjb').hide();
			}
			if(data.value == 6 && data.elem.checked) {
				$('#exzltext').show();
			} else if(data.value == 6 && !(data.elem.checked)) {
				$('#exzltext').hide();
			}

			if(data.value == 12 && data.elem.checked) {
				$('#zybtext').show();
			} else if(data.value == 12 && !(data.elem.checked)) {
				$('#zybtext').hide();
			}

			if(data.elem.checked) {
				$('input[name="jws"]').eq(0).prop('checked', false);
				form.render();
			}
		});
		
		//展示家族史-父亲无的选项
		form.on('checkbox(jzswufq)', function(data) {
			if(data.elem.checked) {
				$('input[name="jzsfq"]:not(:first)').each(function() {
					$(this).prop('checked', false);
				})
				form.render();
			}
		});
		//展示家族史父亲的选项
		form.on('checkbox(jzsfq)', function(data) {
			if(data.elem.checked) {
				$('input[name="jzs"]').eq(0).prop('checked', false);
				form.render();
			}
		});
		
		
		//展示家族史-母亲无的选项
		form.on('checkbox(jzswumq)', function(data) {
			if(data.elem.checked) {
				$('input[name="jzsmq"]:not(:first)').each(function() {
					$(this).prop('checked', false);
				})
				form.render();
			}
		});
		//展示家族史母亲的选项
		form.on('checkbox(jzsmq)', function(data) {
			if(data.elem.checked) {
				$('input[name="jzsmq"]').eq(0).prop('checked', false);
				form.render();
			}
		});
		
		
		//展示家族史-兄弟姐妹无的选项
		form.on('checkbox(jzswuxdjm)', function(data) {
			if(data.elem.checked) {
				$('input[name="jzsxdjm"]:not(:first)').each(function() {
					$(this).prop('checked', false);
				})
				form.render();
			}
		});
		//展示家族史兄弟姐妹的选项
		form.on('checkbox(jzsxdjm)', function(data) {
			if(data.elem.checked) {
				$('input[name="jzsxdjm"]').eq(0).prop('checked', false);
				form.render();
			}
		});
		
		//展示家族史-子女无的选项
		form.on('checkbox(jzswuzn)', function(data) {
			if(data.elem.checked) {
				$('input[name="jzszn"]:not(:first)').each(function() {
					$(this).prop('checked', false);
				})
				form.render();
			}
		});
		//展示家族史子女的选项
		form.on('checkbox(jzszn)', function(data) {
			if(data.elem.checked) {
				$('input[name="jzszn"]').eq(0).prop('checked', false);
				form.render();
			}
		});
		
		
		//展示药物过敏史无的选项
		form.on('checkbox(ywgmswu)', function(data) {
			if(data.elem.checked) {
				$('input[name="ywgms"]:not(:first)').each(function() {
					$(this).prop('checked', false);
				})
				form.render();
			}
		});
		//展示药物过敏史的选项
		form.on('checkbox(ywgms)', function(data) {
			if(data.elem.checked) {
				$('input[name="ywgms"]').eq(0).prop('checked', false);
				form.render();
			}
		});
		

		$('body').on('click', '#addzys', function() {
			var addzys = `<div class="fl p-l">
									<span class="fl">
										<input  type="text" class="layui-input width100 kssj" />
									</span>

									<span class="fl">
										<input  type="text" class="layui-input width100 jssj" />
									</span>
									<span class="fl">
											<input type="text" class="layui-input width100" placeholder="请输入工作单位" />
									</span>

									<span class="fl">
										<input type="text" class="layui-input width100" placeholder="车间" />
									</span>
									<span class="fl">
											<input type="text" class="layui-input width100" placeholder="工种" />
										
									</span>
									<span class="fl">
											<input type="text" class="layui-input width100" placeholder="有害因素" />
										
									</span>
									<span class="fl">
											<input type="text" class="layui-input width100" placeholder="防护措施" />
										
									</span>
									<font class="pum">-</font>
								</div>`;
			$('.zhiyeshi').append(addzys);
			loadsj('kssj');
			loadsj('jssj');
		})
		$('body').on('click', '.pum', function() {
			$(this).parent().remove();
		})

		$('body').on('click', '#addjws', function() {
			var addjws = `
								<div class="p-l">
									<span>
										<input  type="text" class="layui-input" placeholder="疾病名称"/>
									</span>
									<span>
										<input  type="text" class="layui-input jwssj" placeholder="确诊时间"/>
									</span>
									<font class="pum">--</font>
								</div>`;
			$('.jwsjb').append(addjws);
			loadsj('jwssj');
		})
		$('body').on('click', '#addsss', function() {
			var addjws = `
								<div class="fl p-l">
      									<span>
      										<input type="text" class="layui-input" placeholder="手术名称"/>
      									</span>
      									<span>
      										<input type="text" class="layui-input sssj" placeholder="手术时间"/>
      									</span>
      									<font class="pum">--</font>
      								</div>`;
			$('#ssparent').append(addjws);
			loadsj('sssj');
		})
		
		$('body').on('click', '#addws', function() {
			var addjws = `
								<div class="fl p-l">
      									<span>
      										<input type="text" class="layui-input" placeholder="手术名称"/>
      									</span>
      									<span>
      										<input type="text" class="layui-input wssj" placeholder="手术时间"/>
      									</span>
      									<font class="pum">--</font>
      								</div>`;
			$('#wsparent').append(addjws);
			loadsj('wssj');
		})
		
		$('body').on('click', '#addsx', function() {
			var addjws = `
								<div class="fl p-l">
      									<span>
      										<input type="text" class="layui-input" placeholder="手术名称"/>
      									</span>
      									<span>
      										<input type="text" class="layui-input sxsj" placeholder="手术时间"/>
      									</span>
      									<font class="pum">--</font>
      								</div>`;
			$('#sxparent').append(addjws);
			loadsj('sxsj');
		})

		function loadsj(a) {
			$('.'+a).each(function() {
				laydate.render({
					elem: this, //指定元素
					trigger: 'click'
				});
			})
		}

	

	});
	
	
	// 选项卡
	$('.leftTiJian ul').hide()
	$('.leftTiJian ul').eq(0).show()
	$('.leftTiJian p').click(function(){
		id = $(this).index()
		$(this).siblings().removeClass('active');
		$(this).addClass('active');
		$('.leftTiJian ul').hide();
		$('.leftTiJian ul').eq(id).show()
	})
	
})