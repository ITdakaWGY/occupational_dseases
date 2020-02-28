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
            var urls = 'InquiryWk/list/1/1';
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
                var jzx = result[0].jzx;
                $('input[name="jzx"]').each(function() {
                    if($(this).val() == jzx) {
                        $(this).prop('checked', true);
                    }
                });
                var qblbj = result[0].qblbj;
                $('input[name="qblbj"]').each(function() {
                    if($(this).val() == qblbj) {
                        $(this).prop('checked', true);
                    }
                });
                $('input[name="jzxms"]').val(result[0].jzxms);
                $('input[name="jxzbz"]').val(result[0].jxzbz);
                $('input[name="qblbjms"]').val(result[0].qblbjms);
                $('input[name="qblbjbz"]').val(result[0].qblbjbz);
                $('input[name="qt"]').val(result[0].qt);
                $('input[name="ysqz"]').val(result[0].ysqz);
                form.render(); //更新渲染
            }

            getnull();
        }
        //执行保存的data对象
        $('#saveWk').click(function() {
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
            //甲状腺
            var jzx = $('input[name="jzx"]:checked').val();
            //甲状腺描述
            var jzxms = $('#jzxms').val();
            //甲状腺备注
            var jxzbz = $('#jxzbz').val();
            //浅表淋巴结
            var qblbj = $('input[name="qblbj"]:checked').val();
            //浅表淋巴结描述
            var qblbjms = $('#qblbjms').val();
            //浅表淋巴结备注
            var qblbjbz = $('#qblbjbz').val();
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
                jzx:jzx,
                jzxms:jzxms,
                jxzbz:jxzbz,
                qblbj:qblbj,
                qblbjms:qblbjms,
                qblbjbz:qblbjbz,
                qt:qt,
                ysqz:ysqz,
                ysqzurl:ysqzurl,
                createtime:createtime
            }
            // debugger;
            $.ajax({
                type: "post",
                url: BaseUrl + '/InquiryWk/add',
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


