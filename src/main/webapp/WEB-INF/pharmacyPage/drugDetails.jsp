<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>药品出库详情统计</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/jquery-ui-1.9.2.custom.min.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script	src="${pageContext.request.contextPath}/js/jquery-ui-1.9.2.custom.js"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/js/layui.js" charset="utf-8"></script>
</head>


<body>
<input type="hidden" id="drugName" value="${requestScope.drugName}">
<div align="center">
    <div class="layui-input-inline">
        <button type="button" 	class="layui-btn layui-btn-radius layui-btn-normal" id="week">本周</button>
    </div>
    <div class="layui-input-inline">
        <button type="button" 	class="layui-btn layui-btn-radius layui-btn-normal" id="mouth" >本月</button>
    </div>
    <div class="layui-input-inline">
        <button type="button" class="layui-btn layui-btn-radius layui-btn-normal" id="year" >今年</button>
    </div>

    <div id="container" style="width: 550px; height: 400px; margin: 0 auto"></div>
</div>
</body>

<script type='text/javascript' >
    $(document).ready(function() {
        var drugName=$("#drugName").val();
        SeriesData(drugName);
        function SeriesData(drugName){
            $.post("/phamacy/batchList.action",{"drugName":drugName,"state":5},function(data,statues){
                var chart=new Highcharts.Chart({
                    //常规图表选项设置
                    chart: {
                        renderTo: 'container',        //在哪个区域呈现，对应HTML中的一个元素ID
                        plotBackgroundColor: null,    //绘图区的背景颜色
                        plotBorderWidth: null,        //绘图区边框宽度
                        plotShadow: false,            //绘图区是否显示阴影
                        type: 'column'
                    },
                    title:{
                        text:'药品详细统计'
                    },
                    xAxis:{
                        categories : data.dataDrugMonth,
                        crosshair: true
                    },
                    yAxis:{
                        min: 0,
                        title: {
                            text: '数量'
                        }
                    },
                    tooltip:{
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                        '<td style="padding:0"><b>{point.y:.1f} 人次</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions:{
                        column: {
                            pointPadding: 0.2,
                            borderWidth: 0
                        }
                    },
                    credits : {
                        enabled: false
                    },

                    series : [ {
                        name: '药品出库统计',
                        data: data.outDrug
                    }, {
                        name: '药品入库统计',
                        data: data.inDrug
                    }, {
                        name: '药品批次',
                        data: data.batch
                    }]

                });
            },"json");
        };
    });


</script>
<script>
    layui.use(['form','element','jquery'], function() {
        var form = layui.form,
            layer = layui.layer,
            element=layui.element,
            $=layui.jquery;
        var drugName=$("#drugName").val();
        $(document).on('click','#week',function(){
            $.post("/phamacy/batchList.action",{"drugName":drugName,"state":6},function(data,statues){
                var chart=new Highcharts.Chart({
                    //常规图表选项设置
                    chart: {
                        renderTo: 'container',        //在哪个区域呈现，对应HTML中的一个元素ID
                        plotBackgroundColor: null,    //绘图区的背景颜色
                        plotBorderWidth: null,        //绘图区边框宽度
                        plotShadow: false,            //绘图区是否显示阴影
                        type: 'column'
                    },
                    title:{
                        text:'药品详细统计'
                    },
                    xAxis:{
                        categories : data.dataDrugMonth,
                        crosshair: true
                    },
                    yAxis:{
                        min: 0,
                        title: {
                            text: '数量'
                        }
                    },
                    tooltip:{
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                        '<td style="padding:0"><b>{point.y:.1f} 人次</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions:{
                        column: {
                            pointPadding: 0.2,
                            borderWidth: 0
                        }
                    },
                    credits : {
                        enabled: false
                    },

                    series : [ {
                        name: '药品出库统计',
                        data: data.outDrug
                    }, {
                        name: '药品入库统计',
                        data: data.inDrug
                    }, {
                        name: '药品批次',
                        data: data.batch
                    }]

                });
            },"json");
        });
        $(document).on('click','#mouth',function(){
            $.post("/phamacy/batchList.action",{"drugName":drugName,"state":7},function(data,statues){
                var chart=new Highcharts.Chart({
                    //常规图表选项设置
                    chart: {
                        renderTo: 'container',        //在哪个区域呈现，对应HTML中的一个元素ID
                        plotBackgroundColor: null,    //绘图区的背景颜色
                        plotBorderWidth: null,        //绘图区边框宽度
                        plotShadow: false,            //绘图区是否显示阴影
                        type: 'column'
                    },
                    title:{
                        text:'药品详细统计'
                    },
                    xAxis:{
                        categories : data.dataDrugMonth,
                        crosshair: true
                    },
                    yAxis:{
                        min: 0,
                        title: {
                            text: '数量'
                        }
                    },
                    tooltip:{
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                        '<td style="padding:0"><b>{point.y:.1f} 人次</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions:{
                        column: {
                            pointPadding: 0.2,
                            borderWidth: 0
                        }
                    },
                    credits : {
                        enabled: false
                    },

                    series : [ {
                        name: '药品出库统计',
                        data: data.outDrug
                    }, {
                        name: '药品入库统计',
                        data: data.inDrug
                    }, {
                        name: '药品批次',
                        data: data.batch
                    }]

                });
            },"json");
        });
        $(document).on('click','#year',function(){
            $.post("/phamacy/batchList.action",{"drugName":drugName,"state":5},function(data,statues){
                var chart=new Highcharts.Chart({
                    //常规图表选项设置
                    chart: {
                        renderTo: 'container',        //在哪个区域呈现，对应HTML中的一个元素ID
                        plotBackgroundColor: null,    //绘图区的背景颜色
                        plotBorderWidth: null,        //绘图区边框宽度
                        plotShadow: false,            //绘图区是否显示阴影
                        type: 'column'
                    },
                    title:{
                        text:'药品详细统计'
                    },
                    xAxis:{
                        categories : data.dataDrugMonth,
                        crosshair: true
                    },
                    yAxis:{
                        min: 0,
                        title: {
                            text: '数量'
                        }
                    },
                    tooltip:{
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                        '<td style="padding:0"><b>{point.y:.1f} 人次</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions:{
                        column: {
                            pointPadding: 0.2,
                            borderWidth: 0
                        }
                    },
                    credits : {
                        enabled: false
                    },

                    series : [ {
                        name: '药品出库统计',
                        data: data.outDrug
                    }, {
                        name: '药品入库统计',
                        data: data.inDrug
                    }, {
                        name: '药品批次',
                        data: data.batch
                    }]

                });
            },"json");
        });
    });
</script>
</html>