var urlType;
//判断 ，如果直接进入首页，跳转菜单界面，如果没有登录，菜单界面会直接跳转登录界面
if(window.location.href.indexOf('?')>=0){
	 urlType = window.location.href.split('?')[1].split('=')[1];	
}else{
	window.location.href="welcome.html";
}
var navs = [];
if(urlType == 1) {
	navs = [{
		"title": "基础信息管理",
		"icon": "&#xe61c;",
		"href": "",
		"spread": true,
		"children": [{
				"title": "用人单位信息管理",
				"icon": "&#xe631;",
				"href": "page/yrdwxx/yrdwxxglList.html",
				"spread": true
			},
			{
				"title": "体检项目信息管理",
				"icon": "&#xe631;",
				"href": "page/tjxmxx/tjxmList.html",
				"spread": false
			},
			{
				"title": "职业病危害因素管理",
				"icon": "&#xe631;",
				"href": "page/tjxmxx/zybwhysList.html",
				"spread": false
			},
			{
				"title": "职工岗位信息管理",
				"icon": "&#xe631;",
				"href": "page/gwxxgl/gwxxglList.html",
				"spread": false
			},
			{
				"title": "签约管理",
				"icon": "&#xe631;",
				"href": "page/tjqy/tjqylList.html",
				"spread": false
			},
			{
				"title": "用户管理",
				"icon": "&#xe631;",
				"href": "page/yhgl/yhgl.html",
				"spread": false
			}

		]
	}]
} else if(urlType == 2) {
	navs = [
		{
			"title": "体检管理",
			"icon": "&#xe61c;",
			"href": "",
			"spread": true,
			"children": [{
					"title": "体检签约管理",
					"icon": "&#xe61c;",
					"href": "page/tjqy/tjqylList.html",
					"spread": false
				}, {
					"title": "体检人员查询",
					"icon": "&#xe631;",
					"href": "page/tjgl/todaytj.html",
					"spread": false
				},
				{
					"title": "体检基础信息采集",
					"icon": "&#xe631;",
					"href": "page/tjgl/jbxxcj.html",
					"spread": false
				},
				{
					"title": "症状信息采集",
					"icon": "&#xe631;",
					"href": "page/tjgl/zzxxcj.html",
					"spread": false
				},

			]
		},
		{
			"title": "问诊管理",
			"icon": "&#xe61c;",
			"href": "",
			"spread": false,
			"children": [{
					"title": "内科问诊",
					"icon": "&#xe631;",
					"href": "page/wzgl/nkwz.html",
					"spread": false
				},
				{
					"title": "外科问诊",
					"icon": "&#xe631;",
					"href": "page/wzgl/wkwz.html",
					"spread": false
				},
				{
					"title": "五官科问诊",
					"icon": "&#xe631;",
					"href": "page/wzgl/wgkwz.html",
					"spread": false
				},
				{
					"title": "神经科问诊",
					"icon": "&#xe631;",
					"href": "page/wzgl/sjkwz.html",
					"spread": false
				}

			]
		}
	]
} else if(urlType == 3) {
	navs = [{
		"title": "总检管理",
		"icon": "&#xe61c;",
		"href": "page/zjgl/zjglList.html",
		"spread": false
	}
	]
} else if(urlType == 4) {
	navs = [{
			"title": "体检结果查询",
			"icon": "&#xe61c;",
			"href": "page/zjgl/tjjgList.html",
			"spread": false
		},
		{
			"title": "体检反馈",
			"icon": "&#xe61c;",
			"href": "",
			"spread": false,
			"children": [{
					"title": "建议复查",
					"icon": "&#xe631;",
					"href": "page/tjfk/jyfcList.html",
					"spread": false
				},
				{
					"title": "疑似职业病",
					"icon": "&#xe631;",
					"href": "page/tjfk/yszybList.html",
					"spread": false
				},
				{
					"title": "职业禁忌症",
					"icon": "&#xe631;",
					"href": "page/tjfk/zyjjzList.html",
					"spread": false
				}

			]
		}
	]
} else if(urlType == 5) {
	navs = [{
			"title": "体检进度查询",
			"icon": "&#xe61c;",
			"href": "",
			"spread": true,
			"children": [{
					"title": "用人单位体检进度查询",
					"icon": "&#xe631;",
					"href": "page/jindu/qiye.html",
					"spread": false
				},
				{
					"title": "个人体检进度查询",
					"icon": "&#xe631;",
					"href": "page/jindu/geren.html",
					"spread": false
				},

			]
		}

	]
}