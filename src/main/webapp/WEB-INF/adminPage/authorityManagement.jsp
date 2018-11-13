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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<table class="layui-hide" id="role" lay-filter="role"></table>


<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>


<script src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>

<script>
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#role'
            , url: '/adminPage/authorityManage.action'
            , title: '角色权限表'
            , method: 'post'
            , cols: [[
                {field: 'adminRoleId', title: 'ID', fixed: 'left', unresize: true, sort: true}
                , {field: 'adminRoleName', title: '角色名', edit: 'text'}
                , {field: 'adminRoleState', title: '角色启停状态', edit: 'text'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
            ]]
        })


        //监听事件
        table.on('tool(role)', function (obj) {
            var roleId = obj.data.adminRoleId;
            if (obj.event === 'edit') {
                window.location.href = "/adminPage/roleAuthorityManageJump.action?adminRoleId=" + roleId;
            }
        });
    });
</script>

</body>
</html>
