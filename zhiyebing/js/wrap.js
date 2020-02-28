// var BaseUrl = 'http://60.216.10.28:8181/';
var BaseUrl = 'http://127.0.0.1:8181/';
var pageSize = 10;
$(function() {
	var token = localStorage.getItem('token');
	if(token != 1) {
		window.location.href = "login.html";
	}
	$('.goWelcome').click(function() {
		window.location.href = "welcome.html";
	})

	$('.loginOut').click(function() {
		localStorage.removeItem('token');
		window.location.href = "login.html";
	})
})

//格式化日期
function getriqi(riqi) {
	var a;
	if(riqi == '' || riqi == null || riqi == undefined) {
		a = '';
	} else {
		a = new Date(parseInt(riqi.substring(6, riqi.length - 2)));
		a = a.getFullYear() + '-' + (a.getMonth() + 1) + '-' + a.getDate();
	}

	return a;
}

//获取checkbox的所有选中值，并用逗号分隔
function getCheckArry(checkName) {
	var ids = '';
	$('input[name="' + checkName + '"]:checked').each(function(i) {
		ids += $(this).val() + ',';
	})
	ids = ids.substring(0, ids.length - 1);
	return ids;
}

//如果页面有原始数据null 则置空
function getnull() {
	$('.layui-table tr td').each(function() {
		var _this = $(this);
		if(_this.html() == 'null' || _this.html() == 'undefined') {
			_this.html('');
		}
	})
}

/*function loadPage(total,data) {
	var totalPage = total % pageSize == 0 ? (total / pageSize) : (Math.floor(total / pageSize) + 1);
	$("#pagination3").pagination({
		//totalPage---总条数   isshow:是否显示上一页下一页 首页末页   cunt  渲染的页码展示总数
		pageCount: total,
		totalPage: totalPage,
		isShow: true,
		count: 10,
		homePageText: "首页",
		endPageText: "尾页",
		prevPageText: "上一页",
		nextPageText: "下一页",
		callback: function(current) {
			getData(current,data);
		}
	});
}*/

//传入符合的数组，初始化checkbox----》 checkbox的name值需要与传入的数组名称保持一致
function intCheckbox(dom,arry) {
	for(var i = 0; i < arry.length; i++) {
		$('input[name="'+dom+'"]').each(function() {
			if($(this).val() == arry[i]) {
				$(this).prop('checked', true);
			}
		})
	}
	debugger;
}
