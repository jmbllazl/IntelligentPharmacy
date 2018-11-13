<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>药品出入库明细表</title>
    <link href="${pageContext.request.contextPath}/css/jquery-ui-1.9.2.custom.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui-1.9.2.custom.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
    <script  src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
</head>
<body>

<div class="demoTable">
    搜索ID：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<table class="layui-hide" id="drugTable" lay-filter="drugTable"></table>
<script src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
</body>

<script>
    layui.use(['layer', 'jquery','form', 'table','element'], function () {
        var layer = layui.layer
            , form = layui.form
            , table = layui.table
            , $ = layui.jquery
            , element = layui.element//Tab的切换功能，切换事件监听等，需要依赖element模块
        var tableIns = table.render({
            id: "drugTable"
            , elem: '#drugTable'
            , url: '/phamacy/purchase.action'
            , title: '采购清单'
            , where: {state: 1}
            , method: 'post'
            , cols: [[
                , {field: 'drugId', title: 'ID', unresize: true, sort: true}
                , {field: 'adminName', title: '管理员姓名'}
                , {field: 'drugName', title: '药品名字'}
                , {field: 'drugQuantity', title: '数量'}
                , {field: 'purchasePrice', title: '采购价格'}
            ]]
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['prev', 'page', 'next', 'skip'] //自定义分页布局
                , limit: 5
                , groups: 5 //只显示 5 个连续页码
                , first: "1" //显示首页
                , last: false//显示尾页
            }
        });






        // 监听搜索
        var $$ = layui.$
            , active = {
            reload: function () {
                let demoReload = $$('#demoReload');
                //执行重载
                table.reload('drugTable', {
                    url: '/phamacy/purchase.action'
                    , page: {curr: 1}//重新从第 1 页开始
                    , where: {conditionQuery: demoReload.val(),state:2}
                    ,done:function(){
                        active[type] ? active[type].call('tabChange') : '';
                    }

                });
            }

        };

        $$('.demoTable .layui-btn').on('click', function () {
            let type = $(this).data('type');
            console.log(type);
            active[type] ? active[type].call(this) : '';

        });

    });


</script>
</html>
