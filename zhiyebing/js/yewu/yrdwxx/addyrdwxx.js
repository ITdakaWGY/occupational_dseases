$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		var laydate = layui.laydate;
		/*laydate.render({
			elem: '#createtime' //指定元素
		});*/
		//获取上一步业务流--》增加弹窗的id，用作执行页面刷新方法。
		var frameId = parseInt(window.location.href.split('?')[1].split('=')[1])-1;
		//监听危害因素种类其他
		form.on('checkbox(whyszlqt)', function(data) {
			if(data.elem.checked) {
				$('#harmtypeqt').show();
			} else {
				$('#harmtypeqt').hide();
			}
		});
		//执行保存的data对象
		$('.saveTijian').click(function() {
			//用人单位全称
			var companyname = $('#companyname').val();
			//地址
			var address = $('#address').val();
			//行业分类
			var Industrypaging = $('#Industrypaging').val();
			//企业规模
			var companytype = $('input[name="companytype"]:checked').val();
			//法定代表人
			var legalperson = $('#legalperson').val();
			//主管负责人
			var linkman = $('#linkman').val();
			//职业卫生管理机构负责人
			var principal = $('#principal').val();
			//联系电话
			var phone = $('#phone').val();
			//职业病危害风险分类
			var risktype = $('input[name="risktype"]:checked').val();
			//在岗职工总人数
			var staffnumber = $('#staffnumber').val();
			//接触职业病危害人数
			var harmperson = $('#harmperson').val();
			//存在的职业病危害因素种类
			var harmtype = getCheckArry('harmtype');
			//存在的职业病危害因素种类其他
			var harmtypeqt = $('#harmtypeqt').val();
			//职业病危害检测(评价)报告类型
			var harmevaluatetype = getCheckArry('harmevaluatetype');
			//职业病危害检测(评价)报告名称及编号
			var harmevaluatenamecode = $('#harmevaluatenamecode').val();
			//职业卫生技术服务机构
			var orgname = $('#orgname').val();

			var params = {
				companyname: companyname,
				address: address,
				industrypaging: Industrypaging,
				companytype: companytype,
				legalperson: legalperson,
				linkman: linkman,
				principal: principal,
				phone: phone,
				risktype: risktype,
				staffnumber: staffnumber,
				harmperson: harmperson,
				harmtype: harmtype,
				harmtypeqt: harmtypeqt,
				harmevaluatetype: harmevaluatetype,
				harmevaluatenamecode: harmevaluatenamecode,
				orgname: orgname,
			}
			debugger;
			$.ajax({
				type: "post",
				url: BaseUrl + '/companyinfo/add',
				async: true,
                data:JSON.stringify(params),
                processData: false,
                contentType: "application/json", 
				success: function(data) {
					debugger;
					if(data.success) {
						layer.alert('保存成功', {
							skin: 'layui-layer-lan',
							closeBtn: 0,
							anim: 4 //动画类型
						}, function(tc, layero) {
							parent.layer.closeAll();
							debugger;
							var dom=$(top.window[frameId].document.getElementById('intSearch'));
							dom.trigger('click');
						});
					} else {
						layer.msg(data.message);
					}

				}
			});

		})

	});
})

function handleFile() {
	var formData = new FormData();
	var fileArry = $('#file')[0].files;
	for(var i = 0; i < fileArry.length; i++) {
		if(/.(PDF|pdf|DOC|doc|DOCX|docx)$/.test(fileArry[i].name)) { //文件必须为文档
			formData.append("files", fileArry[i]); //文件上传处理
		} else {
			alert('上传文件必须是PDF或DOC !!');
			return false;
		}
	}
	//请求上传接口
	//提交请求后,置空file的选项，需要返回对应的文件名称和uuid，最后提交的是uuid，（循环页面上的相关uuid即可）
	/*$.ajax({
		type:"post",
		url:"",
		async:true,
		cache: false,//上传文件无需缓存
       	processData: false,//用于对data参数进行序列化处理 这里必须false
		success:function(){
			$('#files').val('');
			
		}
	});*/

}