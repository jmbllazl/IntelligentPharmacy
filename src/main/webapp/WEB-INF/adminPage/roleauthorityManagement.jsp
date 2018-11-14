<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${pageContext.request.contextPath}/css/jquery-ui-1.9.2.custom.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui-1.9.2.custom.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css" media="all">


</head>
<body>

<input id="roleId" type="hidden" value="${requestScope.adminRoleId}">
<table class="layui-hide" id="roleAuthorityManage" lay-filter="roleAuthorityManage"></table>

<script src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>

<script>
    layui.use(['table', 'layer'], function () {
        var table = layui.table;
        var $ = layui.jquery;
var table1=   table.render({
            id: "tableId"
            , elem: '#roleAuthorityManage'
            , url: '/adminPage/roleAuthorityManage.action'
            , title: '角色权限表'
            , where: {adminRoleId: $('#roleId').val()}
            , method: 'post'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'phamacySecondId', title: 'ID', unresize: true, sort: true}
                , {field: 'phamacyFirstName', title: '一级菜单名'}
                , {field: 'phamacySecondName', title: '二级菜单名'}
            ]]
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['prev', 'page', 'next', 'skip'] //自定义分页布局
                , limit: 5
                , groups: 5 //只显示 5 个连续页码
                , first: "1" //显示首页
                , last: false//显示尾页
            }
        })

        //监听复选框
        table.on('checkbox(roleAuthorityManage)', function (obj) {
            var data = obj.data;
            console.log(obj);
            if (obj.checked == true) {
                if (obj.type == 'one') {
                    layer.confirm('确认添加吗', {btn: ['确定', '取消'], title: "提示"},function() {
                        $.ajax({
                            type: "POST",
                            url: "/adminPage/addRoleAuthority.action",
                            data: {"phamacySecondId": data.phamacySecondId, "roleId": $('#roleId').val(), "state": 0},
                            dataType: "json",
                            success: function (data) {
                                layer.msg("添加成功", {icon: 6, time: 2000})
                            }
                        });
                    }, function(){
                        obj.LAY_CHECKED=false;
                        table1.reload();
                    });
                } else if (obj.type = 'all') {
                    var checkStatus = table.checkStatus('tableId');
                    var array = new Array(5)
                    for (var i; i < checkStatus.data.length; i++) {
                        array.push(checkStatus.data[i].phamacySecondId);
                    }
                    console.log(array.length);
                    console.log(checkStatus.data[0].phamacySecondId);
                    console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
                    layer.confirm('确认添加当前页所有权限吗', {btn: ['确定', '取消'], title: "提示"}, function () {
                        $.ajax({
                            type: "POST",
                            url: "/adminPage/addRoleAuthority.action",
                            data: {"menuList": array, "state": 1, "roleId": $('#roleId').val(), "state": 1},
                            dataType: "json",
                            success: function (data) {
                                layer.msg("添加成功", {icon: 6, time: 2000})
                            }
                        });

                    },function(){
                        table1.reload();
                        }
                    );
                }
            } else {
                layer.confirm('确认取消权限吗', {btn: ['确定', '取消'], title: "提示"}, function () {
                    $.ajax({
                        type: "POST",
                        url: "/adminPage/delOneBoxManage.action",
                        data: {"phamacySecondId": data.phamacySecondId, "roleId": $('#roleId').val()},
                        dataType: "json",
                        success: function (data) {
                            layer.msg("删除成功", {icon: 6, time: 2000})
                        }
                    });
                    obj.update({
                        checkbox: false
                    });
                },function(){
                        obj.update({
                            checkbox: true
                        });
                    }
                );
            }


        });
    });
</script>
</body>
</html>
