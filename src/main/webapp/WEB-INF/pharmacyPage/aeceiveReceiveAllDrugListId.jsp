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
<title>麻醉精神药品显示</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all">
  <script type="text/javascript" src="../js/jquery.min.js"></script>
  <script type="text/javascript" src="../js/public.js"></script>
  <script type="text/javascript" src="../js/external.js"></script>
</head>
<style>
  .ctybtn{
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
<div class="x-nav"> <span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>麻醉精神药房库存</cite></a> </span> <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a> </div>
<div class="x-body">

<table>
  药品类型：<select  name="drugClassificationAllStyleList" id="styleShowListId" onchange="changeStyle()">
  <option value="" style='display:none;'>-请选择-</option>
  <c:forEach items="${requestScope.drugClassificationAllStyleList}" var="styleShowList">
      <option value="${styleShowList.drugClassificationId}" id="styleShowListId" name="styleShowListId">${styleShowList.drugClassificationName}</option>
    </c:forEach>
    </select >
  <td class="ctybtn">
    <a style="color: white"  href="/anesthesia/anesthesiaReceiveAllDrug.action" target="main" >查看所有特殊药品销售明细</a>
  </td>
</table>
  <form class="layui-form x-center" action="${pageContext.request.contextPath}/phamacy/phamacyAllDrugs.action" style="width:85%">
    <div class="layui-form-pane">
    </div>
  </form>
  <table class="tablelist">
    <thead>
      <tr>
        <th> 药品名字 </th>
        <th> 药品详情 </th>
        <th> 剂型</th>
        <th> 规格/单位</th>
        <th> 药品价格</th>
        <th> 批注文号</th>

        <th> 购买人</th>
        <th> 购买日期</th>
        <th> 销售数量</th>
      </tr>
    </thead>
    <tbody id="alarmStyleClick">
    <c:choose>
      <c:when test="${not empty requestScope.specialAllPageList.list}">
        <c:forEach items="${requestScope.specialAllPageList.list}" var="specialAllPageList">
            <tr>
              <td>${specialAllPageList.drugName}</td>
              <td>${specialAllPageList.drugDetails}</td>
              <td>${specialAllPageList.formulation}</td>
              <td>${specialAllPageList.norm}/${specialAllPageList.unit}</td>
              <td>${specialAllPageList.drugPrice}</td>
              <td>${specialAllPageList.approvalnumber}</td>

              <td style="color: red">${specialAllPageList.userId}</td>
              <td style="color: red">${specialAllPageList.receiveDate}</td>
              <td style="color: red">${specialAllPageList.phamacyDrugQuantity}</td>
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
      <td colspan="3" align="left">共有${specialAllPageList.total}条记录，当前第${specialAllPageList.pageNum}页，共${specialAllPageList.pages}页</td>
      <td colspan="9" align="right">
        <a href="/anesthesia/aeceiveReceiveAllDrugListId.action?pageNum=1&&drugClassificationId=${requestScope.drugClassificationIdNum}"    target="main">首页</a>
        <a href="/anesthesia/aeceiveReceiveAllDrugListId.action?pageNum=${specialAllPageList.prePage}&&drugClassificationId=${requestScope.drugClassificationIdNum}"  target="main">上一页</a>
        <a href="/anesthesia/aeceiveReceiveAllDrugListId.action?pageNum=${specialAllPageList.nextPage}&&drugClassificationId=${requestScope.drugClassificationIdNum}"  target="main">下一页</a>
        <a href="/anesthesia/aeceiveReceiveAllDrugListId.action?pageNum=${specialAllPageList.navigateLastPage}&&drugClassificationId=${requestScope.drugClassificationIdNum}"  target="main">尾页</a>
      </td>
    </tr> 
    </tbody>
  </table>

<br />
<br />
<br />
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script> 
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
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
  <script>
      function  changeStyle(){
          var id = document.getElementById('styleShowListId').value;
          window.location.href="<%=request.getContextPath()%>/anesthesia/aeceiveReceiveAllDrugListId.action?&&drugClassificationId="+id;
      }

  </script>
</body>
</html>