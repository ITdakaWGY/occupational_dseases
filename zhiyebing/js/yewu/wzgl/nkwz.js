$(function() {
	//一般直接写在一个js文件中
	layui.use(['layer', 'form', 'laydate'], function() {
		var layer = layui.layer,
			form = layui.form;
		var laydate = layui.laydate;
		 laydate.render({
			    elem: '#tjrq' //指定元素
			  });
        laydate.render({
            elem: '#createtime',
        });
        //条件查询事件
        $('body').on('click','#searchBtn',function(){
            var xm=$('#xm').val();
            var sfz=$('#sfz').val();
            var tmh=$('#tmh').val();
            var tjrq=new Date($('#tjrq').val()); //字符串日期格式转换成Date()
            var searchdata={
                xm:xm,
                sfz:sfz,
                tmh:tmh,
                tjrq:tjrq
            };
            getData(searchdata);
        });
        //初次请求第一页的数据，并初始化分页,如果条件查询，请传入data
        function getData(data) {
            if(typeof(data)=="undefined"){
                data={};
            }
            var urls = 'InquiryNk/list/1/1';
            var loading = layer.msg('正在查询...', {
                icon: 16,
                shade: 0.2,
                time: false
            });
            var total;
            var result;
            $.ajax({
                type: "get",
                url: BaseUrl + urls,
                data: data,
                async: true,
                dataType: "json"   ,//请求页面返回的数据类型
                success: function(data) {
                    if(data.success) {
                        result = data.queryResult.list;
                        total = data.queryResult.total;
                        setdata(result);
                    } else {
                        layer.msg(data.message);
                    }
                    layer.close(loading);
                },
                error: function(data) {
                    layer.msg(data.message);
                    layer.close(loading);
                }

            });
        }
//接受结果集，往表格进行数据填充
        function setdata(result) {
            if(result.length == 0) {
                var nodata = '<div class="nodata">暂无数据!</div>';
                $('#tbody').html(nodata);
                return false;
            }else {
                var xk = result[0].xk;
                $('input[name="xk"]').each(function() {
                    if($(this).val() == xk) {
                        $(this).prop('checked', true);
                    }
                });
                var xlqk = result[0].xlqk;
                $('input[name="xlqk"]').each(function() {
                    if($(this).val() == xlqk) {
                        $(this).prop('checked', true);
                    }
                });
                var zy = result[0].zy;
                $('input[name="zy"]').each(function() {
                    if($(this).val() == zy) {
                        $(this).prop('checked', true);
                    }
                });
                var hxy = result[0].hxy;
                $('input[name="hxy"]').each(function() {
                    if($(this).val() == hxy) {
                        $(this).prop('checked', true);
                    }
                });
                var hxy = result[0].hxy;
                $('input[name="hxy"]').each(function() {
                    if($(this).val() == hxy) {
                        $(this).prop('checked', true);
                    }
                });
                var ly = result[0].ly;
                $('input[name="ly"]').each(function() {
                    if($(this).val() == ly) {
                        $(this).prop('checked', true);
                    }
                });
                var yt = result[0].yt;
                $('input[name="yt"]').each(function() {
                    if($(this).val() == yt) {
                        $(this).prop('checked', true);
                    }
                });
                var bk = result[0].bk;
                $('input[name="bk"]').each(function() {
                    if($(this).val() == bk) {
                        $(this).prop('checked', true);
                    }
                });
                var gd = result[0].gd;
                $('input[name="gd"]').each(function() {
                    if($(this).val() == gd) {
                        $(this).prop('checked', true);
                    }
                });
                var pd = result[0].pd;
                $('input[name="pd"]').each(function() {
                    if($(this).val() == pd) {
                        $(this).prop('checked', true);
                    }
                });
                var ydxzy = result[0].ydxzy;
                $('input[name="ydxzy"]').each(function() {
                    if($(this).val() == ydxzy) {
                        $(this).prop('checked', true);
                    }
                });
                $('input[name="xkqt"]').val(result[0].xkqt);
                $('input[name="xkbz"]').val(result[0].xkbz);
                $('input[name="xlnumber"]').val(result[0].xlnumber);
                $('input[name="zyms"]').val(result[0].zyms);
                $('input[name="xzbz"]').val(result[0].xzbz);
                $('input[name="hxyms"]').val(result[0].hxyms);
                $('input[name="lyms"]').val(result[0].lyms);
                $('input[name="fbz"]').val(result[0].fbz);
                $('input[name="ytms"]').val(result[0].ytms);
                $('input[name="bkms"]').val(result[0].bkms);
                $('input[name="dams"]').val(result[0].dams);
                $('input[name="pdms"]').val(result[0].pdms);
                $('input[name="ydxzyms"]').val(result[0].ydxzyms);
                $('input[name="fbbz"]').val(result[0].fbbz);
                $('input[name="qt"]').val(result[0].qt);
                $('input[name="ysqz"]').val(result[0].ysqz);

                form.render(); //更新渲染
            }

            getnull();
        }
        //执行保存的data对象
        $('#saveNk').click(function() {
            //身份证
            var sfz = $('#sfz').val();
            //姓名
            var xm = $('#xm').val();
            //体检日期
            var tjrq = $('#tjrq').val();
            //用户id
            var personalid = $('#personalid').val();
            //条码号
            var tmh = $('#tmh').val();
            //体检标识
            var tjflag = $('#tjflag').val();
            //胸廓
            var xk = $('input[name="xk"]:checked').val();
            //胸廓其他
            var xkqt = $('#xkqt').val();
            //胸廓备注
            var xkbz = $('#xkbz').val();
            //心率次数
            var xlnumber = $('#xlnumber').val();
            //心率情况
            var xlqk = $('input[name="xlqk"]:checked').val();
            //杂音
            var zy = $('input[name="zy"]:checked').val();
            //杂音描述
            var zyms = $('#zyms').val();
            //心脏备注
            var xzbz = $('#xzbz').val();
            //呼吸音
            var hxy = $('input[name="hxy"]:checked').val();
            //呼吸音描述
            var hxyms = $('#hxyms').val();
            //呼吸音备注
            var hxybz = $('#hxybz').val();
            //罗音
            var ly = $('input[name="ly"]:checked').val();
            //罗音描述
            var lyms = $('#lyms').val();
            //肺备注
            var fbz = $('#fbz').val();
            //压痛
            var yt = $('input[name="yt"]:checked').val();
            //压痛描述
            var ytms = $('#ytms').val();
            //包块
            var bk = $('input[name="bk"]:checked').val();
            //包块描述
            var bkms = $('#bkms').val();
            //压痛
            var yt = $('input[name="yt"]:checked').val();
            //压痛描述
            var ytms = $('#ytms').val();
            //肝大
            var gd = $('input[name="gd"]:checked').val();
            //肝大描述
            var dams = $('#dams').val();
            //脾大
            var pd = $('input[name="pd"]:checked').val();
            //脾大描述
            var pdms = $('#pdms').val();
            //移动性浊音
            var ydxzy = $('input[name="ydxzy"]:checked').val();
            //浊音描述
            var ydxzyms = $('#ydxzyms').val();
            //腹部备注
            var fbbz = $('#fbbz').val();
            //其他
            var qt = $('#qt').val();
            //医师签字
            var ysqz = $('#ysqz').val();
            //医师签字URL
            var ysqzurl = $('#ysqzurl').val();
            //创建时间
            var createtime = $('#createtime').val();

            var params = {
                sfz:sfz,
                xm:xm,
                tjrq:tjrq,
                personalid:personalid,
                tmh:tmh,
                tjflag:tjflag,
                xk:xk,
                xkqt:xkqt,
                xkbz:xkbz,
                xlnumber:xlnumber,
                xlqk:xlqk,
                zy:zy,
                zyms:zyms,
                xzbz:xzbz,
                hxy:hxy,
                hxyms:hxyms,
                hxybz:hxybz,
                ly:ly,
                lyms:lyms,
                fbz:fbz,
                yt:yt,
                ytms:ytms,
                bk:bk,
                bkms:bkms,
                gd:gd,
                dams:dams,
                pd:pd,
                pdms:pdms,
                ydxzy:ydxzy,
                ydxzyms:ydxzyms,
                fbbz:fbbz,
                qt:qt,
                ysqz:ysqz,
                ysqzurl:ysqzurl,
                createtime:createtime
            }
            // debugger;
            $.ajax({
                type: "post",
                url: BaseUrl + '/InquiryNk/add',
                async: true,
                data:JSON.stringify(params),
                processData: false,
                contentType: "application/json",
                success: function(data) {
                    // debugger;
                    if(data.success) {
                        layer.alert(data.message, {
                            skin: 'layui-layer-lan',
                            closeBtn: 0,
                            anim: 4 //动画类型
                        }, function(tc, layero) {
                            parent.layer.closeAll();
                            // debugger;
                            /*var dom=$(top.window[frameId].document.getElementById('intSearch'));
                            dom.trigger('click');*/
                            window.location.reload();
                        });
                    } else {
                        layer.msg(data.message);
                    }

                }
            });

        })

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


