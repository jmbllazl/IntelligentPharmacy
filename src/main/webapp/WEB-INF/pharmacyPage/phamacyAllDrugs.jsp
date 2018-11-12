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
<title>药房药品管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all">

</head>
<body>
<div class="x-nav"> <span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>药品档案</cite></a> </span> <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a> </div>
<div class="x-body">
  <form class="layui-form x-center" action="${pageContext.request.contextPath}/phamacy/phamacyAllDrugs.action" style="width:85%">
    <input type="hidden" name="num">
    <div class="layui-form-pane">
      <div class="layui-form-item">
        <label class="layui-form-label">药品编号</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="drugNumber"  value="${param.drugNumber}" placeholder="药品编号" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">药品品名</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="drugName" value="${param.drugName}" placeholder="药品品名" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">剂型</label>
        <div class="layui-input-inline" style="width:150px">
          <input type="text" name="formulation" value="${param.formulation}"  placeholder="剂型" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline" style="width:100px;color: #01AAED">
          <input type="submit" name="link"  placeholder="搜索" autocomplete="off" class="layui-input">
        </div>
      </div>
    </div>
  </form>
  
  <table class="tablelist">
    <thead>
      <tr>
        <th><input onclick="selectAll()" type="checkbox" name="controlAll" style="" id="controlAll">
        </th>
        <th> 药品编号 </th>
        <th> 药品品名 </th>
        <th> 剂型</th>
        <th> 规格</th>
        <th> 生产日期</th>
        <th> 批号 </th>
        <th> 有效期 </th>
        <th> 价格 </th>
        <th> 生产厂商 </th>
        <th> 库存数量 </th>
        <th> 盘点数量 </th>
        <th> 操作 </th>
      </tr>
    </thead>
    
    <tbody>
    <c:choose>
      <c:when test="${not empty requestScope.drugpage.list}">
        <form action="${pageContext.request.contextPath}/phamacy/addCheckDrug.action" method="post">
          <input type="submit" align="right" name="subscribe" value="盘点修改" style="background-color: #83fff5;width: 200px;height: 28px">
        <c:forEach items="${requestScope.drugpage.list}" var="drugTemp">
            <tr>
              <td><input type="checkbox" value="${drugTemp.pharmacyId}" name="selected"></td>
              <td>${drugTemp.drugNumber}</td>
              <td>${drugTemp.drugName}</td>
              <td>${drugTemp.formulation}</td>
              <td>${drugTemp.norm}</td>
              <td>${drugTemp.produtionDate}</td>
              <td>${drugTemp.lotNumber}</td>
              <td>${drugTemp.validaityperiod}</td>
              <td>${drugTemp.drugPrice}</td>
              <td>${drugTemp.manufacturer}</td>
              <td>${drugTemp.drugQuantity}</td>
              <td><input type="text" style="height: 23px;width: 45px"  name="drugQuantity"></td>
              <td>
                <input type="button" value="查看详情" onclick="user_management_show('药品信息','phamacyDrugDetils.action?pharmacyId=${drugTemp.pharmacyId}','600','500')">
            </tr>
        </c:forEach>  </form>
      </c:when>
      <c:otherwise>
        <tr>
          <td rowspan="6" >查无数据！</td>
        </tr>
      </c:otherwise>
    </c:choose>

  <tr>
      <td colspan="5" align="left">共有${drugpage.total}条记录，当前第${drugpage.pageNum}页，共${drugpage.pages}页</td>
      <td colspan="8" align="right">
        <a href="${pageContext.request.contextPath}/phamacy/phamacyAllDrugs.action?num=1"    target="main">首页</a>
        <c:if test="${drugpage.prePage != 0}" >
        <a href="${pageContext.request.contextPath}/phamacy/phamacyAllDrugs.action?num=${drugpage.prePage}"   target="main">上一页</a>
        </c:if><c:if test="${drugpage.nextPage != 0}" >
        <a href="${pageContext.request.contextPath}/phamacy/phamacyAllDrugs.action?num=${drugpage.nextPage}"   target="main">下一页</a>
        </c:if>
        <a href="${pageContext.request.contextPath}/phamacy/phamacyAllDrugs.action?num=${drugpage.navigateLastPage}"    target="main">尾页</a>
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
    function chageNum(num) {
        console.log(num);
        var form = $("form");
        form.action="${pageContext.request.contextPath}/phamacy/phamacyAllDrugs.action";
        $("input[name='num']").val(num);
        form.method="post";
        form.submit();
    }
</script></div>
</body>
</html>
