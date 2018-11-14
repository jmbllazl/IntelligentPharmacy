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
        <input class="layui-input" name="id" id="drugReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
    <legend>药品详情</legend>
</fieldset>

<div class="layui-tab layui-tab-card" lay-filter="drugTab">
    <ul class="layui-tab-title">
        <li lay-id="allDrug">所有药品</li>
        <li>药房药品出库表</li>
        <li>药房药品入库表</li>
    </ul>
    <div class="layui-tab-content" style="height: 100px;">
        <div class="layui-tab-item layui-show "><table class="layui-hide" id="drugTable" lay-filter="drugTable"></table></div>
        <div class="layui-tab-item"><table class="layui-hide" id="sortTable" lay-filter="sortTable"></table></div>
        <div class="layui-tab-item"><table class="layui-hide" id="batchTable" lay-filter="batchTable"></table></div>
    </div>
</div>
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
            , url: '/phamacy/batchList.action'
            , title: '药库所有药品'
            , where: {state: 1}
            , method: 'post'
            , cols: [[
                , {field: 'drugId', title: 'ID', unresize: true, sort: true}
                , {field: 'drugClassificationName', title: '药品种类名'}
                , {field: 'drugName', title: '药品名字'}
                , {field: 'validaityperiod', title: '有效期'}
                , {field: 'drugPrice', title: '价格'}
                , {field: 'dayConsumption', title: '每日用量'}
                , {field: 'drugQuantity', title: '剩余数量'}
            ]]
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['prev', 'page', 'next', 'skip'] //自定义分页布局
                , limit: 5
                , groups: 5 //只显示 5 个连续页码
                , first: "1" //显示首页
                , last: false//显示尾页
            }
        });

            //药品出库
        var sortTable = table.render({
            id: "sortTable"
            , elem: '#sortTable'
            , url: '/phamacy/batchList.action'
            , title: '药房药品出库表'
            ,where: {state: 3}
            , method: 'post'
            , cols: [[
                , {field: 'drugstoreoutid', title: '出库ID', unresize: true, sort: true}
                , {field: 'drugName', title: '药品名'}
                , {field: 'receivedate', title: '出库日期'}
                , {field: 'drugquantity', title: '出库数量'}
            ]]
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['prev', 'page', 'next', 'skip'] //自定义分页布局
                , limit: 5
                , groups: 5 //只显示 5 个连续页码
                , first: "1" //显示首页
                , last: false//显示尾页
            }
        });

        //入库详情
        var batchTable = table.render({
            id: "batchTable"
            , elem: '#batchTable'
            , url: '/phamacy/batchList.action'
            , title: '药房药品入库表'
            ,where: {state: 2}
            , method: 'post'
            , cols: [[
                , {field: 'storageTime', title: '入库时间', unresize: true, sort: true}
                , {field: 'drugClassificationName', title: '药品种类名'}
                , {field: 'drugName', title: '药品名字'}
                , {field: 'validaityperiod', title: '有效期'}
                , {field: 'drugPrice', title: '价格'}
                , {field: 'drugQuantity', title: '数量'}
                , {field: 'drugQuantity', title: '剩余数量'}
            ]]
            , page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['prev', 'page', 'next', 'skip'] //自定义分页布局
                , limit: 5
                , groups: 5 //只显示 5 个连续页码
                , first: "1" //显示首页
                , last: false//显示尾页
            }
        });
            element.on('tab(drugTab)', function (data) {
                var table = layui.table;
                if(data.index==0){
                    tableIns.reload();
                }else if(data.index==1){
                    sortTable.reload();
                }else if(data.index==2){
                    batchTable.reload();
                }
            });
            table.on('row(batchTable)', function (obj) {
            var data = obj.data;
            var drugName=data.drugName;
            console.log(data.drugName);
                console.log(obj);
                console.log(data);
            sortEdit('药品出入库详细表','/phamacy/batchList.action?drugName='+drugName+'&&state='+4,'600','800');

            //标注选中样式
            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
        });

        table.on('row(sortTable)', function (obj) {
            var data = obj.data;
            console.log(obj);
            console.log(data);
            var drugName=data.drugName;
            console.log(data.drugName);
            sortEdit('药品出入库详细表','/phamacy/batchList.action?drugName='+drugName+'&&state='+11,'600','800');

            //标注选中样式
            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
        });

       var sortEdit = function sortEdit(title, url, id, w, h) {
            x_admin_show(title, url, w, h);
        }

            // 监听搜索
            var $$ = layui.$
                , active = {
                tabChange: function(){
                    //切换到指定Tab项
                    element.tabChange('drugTab', 'allDrug'); //切换到：用户管理
                }

               , reload: function () {
                    element.tabChange('drugTab', 'allDrug'); //切换到：用户管理
                    let demoReload = $$('#drugReload');
                    //执行重载
                    table.reload('drugTable', {
                        url: '/phamacy/batchList.action'
                        , page: {curr: 1}//重新从第 1 页开始
                        , where: {conditionQuery: demoReload.val(),state:12}
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
