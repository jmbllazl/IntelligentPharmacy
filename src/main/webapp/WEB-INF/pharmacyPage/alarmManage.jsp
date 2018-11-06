<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/26 0026
  Time: 下午 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
<meta charset="utf-8">
<title>药品低限警报消息显示</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all">

</head>
<style>
  #btnClick{
    background-color:#1ab7ea;
    border: none;
    color: white;
    padding: 5px 20px;
    align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
  }
  #aClick{
    background-color:#1ab7ea;
    border: none;
    color: white;
    padding: 5px 20px;
    align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
  }
</style>
<body>
<div class="x-nav"> <span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>警报消息显示</cite></a> </span> <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a> </div>
<div class="x-body">
  <form class="layui-form x-center" action="${pageContext.request.contextPath}/phamacy/phamacyAllDrugs.action" style="width:85%">

  </form>
  <table class="tablelist">
    <thead>
    <tr>
      <th>药品类别</th>
      <th> 药品名字 </th>
      <th> 药品批号 </th>
      <th> 药品数量</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
      <c:when test="${not empty requestScope.alarmManageList.list}">
        <c:forEach items="${requestScope.alarmManageList.list}" var="drugList">
          <tr>
            <td>${drugList.drugClassificationName}</td>
            <td>
              ${drugList.drugName}
            </td>
            <td>${drugList.approvalnumber}</td>
            <td style="color: red">${drugList.drugQuantity}</td>
          </tr>
        </c:forEach>
      </c:when>
      <c:otherwise>
        <tr>
          <td rowspan="6" >查无数据！</td>
        </tr>
      </c:otherwise>
    </c:choose>
    <tr>
      <td colspan="3" align="left">共有${alarmManageList.total}条记录，当前第${alarmManageList.pageNum}页，共${alarmManageList.pages}页</td>
      <td colspan="9" align="right">
        <a href="/alarm/alarmManage.action?pageNum=1&alarmId=${requestScope.alarmIdList}&alarmStyleId=${requestScope.alarmStyleIdList}"    target="main">首页</a>
        <a href="/alarm/alarmManage.action?pageNum=${alarmManageList.prePage}&alarmId=${requestScope.alarmIdList}&alarmStyleId=${requestScope.alarmStyleIdList}"  target="main">上一页</a>
        <a href="/alarm/alarmManage.action?pageNum=${alarmManageList.nextPage}&alarmId=${requestScope.alarmIdList}&alarmStyleId=${requestScope.alarmStyleIdList}"  target="main">下一页</a>
        <a href="/alarm/alarmManage.action?pageNum=${alarmManageList.navigateLastPage}&alarmId=${requestScope.alarmIdList}&alarmStyleId=${requestScope.alarmStyleIdList}"  target="main">尾页</a>
      </td>
    </tr>

    </tbody>
  </table>


  <br>

  <div class="layui-form-item">
    <input id="btnClick" value="已查看" type="button" onClick="btnClick(${requestScope.alarmIdList})"/>
    <input id="aClick" value="返回" type="button" onClick="cClick()"/>
  </div>
  <div>
    <span style="color: red;font-size:18px "   >请及时处理该警报信息！！</span>
  </div>
</div>

<br />
<br />
<br />

<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
<script>
    function btnClick(id){
        var isDel = confirm("请及时处理该警报信息！！");
        if(isDel==true){
            window.location.href="<%=request.getContextPath()%>/alarm/alarmSeeDetails.action?alarmId="+id;
        }else{
            window.location.href="<%=request.getContextPath()%>/alarm/alarmAllList.action";
        };
    }
    function cClick(){
        window.location.href="<%=request.getContextPath()%>/alarm/alarmAllList.action";
    }
</script>

<script>
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

            });
             /*用户-添加*/
            function user_management_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
            /*用户-查看*/
            function user_management_show(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
            // 用户-编辑
            function user_management_edit (title,url,w,h) {
                x_admin_show(title,url,w,h); 
            }
            </script>


<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>