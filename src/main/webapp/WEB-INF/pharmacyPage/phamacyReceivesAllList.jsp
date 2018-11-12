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
<title>药房药品报损信息</title>
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
<div class="x-nav"> <span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>药房药品报损</cite></a> </span> <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a> </div>
<div class="x-body">
  <form class="layui-form x-center" action="${pageContext.request.contextPath}/report/selectPhamacyReceivesAllList.action" style="width:85%">
    <input type="hidden" name="num">
    <div class="layui-form-pane">
      <div class="layui-form-item">
        <label class="layui-form-label">药品品名</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="drugName" value="${param.drugName}"  placeholder="药品品名" autocomplete="off" class="layui-input">
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
        <th> 药品</th>
        <th> 类型</th>
        <th> 报损数量 </th>
        <th> 操作 </th>
      </tr>
    </thead>
    <tbody>
    <c:choose>
      <c:when test="${not empty requestScope.phamacyReceive.list}">
        <c:forEach items="${requestScope.phamacyReceive.list}" var="receiveDrugTemp">
            <tr>
              <td>${receiveDrugTemp.drugName}</td>
              <td>${receiveDrugTemp.receiverDrug}</td>
              <td>${receiveDrugTemp.phamacyDrugQuantity}</td>
              <td>
                <input type="button" value="查看详情" onclick="user_management_show('药品信息','selectPhamacyDrugReceiveDetilsAllId.action?receiverId=${receiveDrugTemp.receiverId}&&drugName=${receiveDrugTemp.drugName}','600','500')">
              </td>
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
      <td colspan="3" align="left">共有${phamacyReceive.total}条记录，当前第${phamacyReceive.pageNum}页，共${phamacyReceive.pages}页</td>
      <td colspan="9" align="right">
        <a href="/report/selectPhamacyReceivesAllList.action?pageNum=1"    target="main">首页</a>
        <a href="/report/selectPhamacyReceivesAllList.action?pageNum=${phamacyReceive.prePage}"  target="main">上一页</a>
        <a href="/report/selectPhamacyReceivesAllList.action?pageNum=${phamacyReceive.nextPage}"  target="main">下一页</a>
        <a href="/report/selectPhamacyReceivesAllList.action?pageNum=${phamacyReceive.navigateLastPage}"  target="main">尾页</a>
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
        form.action="${pageContext.request.contextPath}/report/selectPhamacyReceivesAllList.action";
        $("input[name='num']").val(num);
        form.method="post";
        form.submit();
    }
    function check(receiverId,state,receiverDrug,phamacyDrugQuantity,pharmacyId){
        $.post("${pageContext.request.contextPath}/report/selectPhamacyReceivesAllList.action",
            {receiverId:receiverId,state:state,receiverDrug:receiverDrug,phamacyDrugQuantity:phamacyDrugQuantity,pharmacyId:pharmacyId},
            function(result) {
                if (result.success == 1) {
                    window.alert("操作成功！")
                    window.location.href="${pageContext.request.contextPath}/report/selectPhamacyReceivesAllList.action";
                }else if(result.success == 0){
                    window.alert("操作失败！")
                }
            })
    }
</script>
</div>
</script></div>
</body>
</html>