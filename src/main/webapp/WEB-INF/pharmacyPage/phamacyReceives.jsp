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
<title>药房药品审核</title>
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
<div class="x-nav"> <span class="layui-breadcrumb"> <a><cite>首页</cite></a> <a><cite>药品审核档案</cite></a> </span> <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a> </div>
<div class="x-body">
  <form class="layui-form x-center" action="${pageContext.request.contextPath}/phamacy/selectPhamacyReceive.action" style="width:85%">
    <input type="hidden" name="num">
    <div class="layui-form-pane">
      <div class="layui-form-item">
        <label class="layui-form-label">药品品名</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="drugName" value="${param.drugName}"  placeholder="药品品名" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">状态</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="state" value="${param.state}" placeholder="状态" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">申请日期</label>
        <div class="layui-input-inline" style="width:150px">
          <input type="text" name="receiveDate" value="${param.receiveDate}"  placeholder="申请日期" autocomplete="off" class="layui-input">
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
        <th> 申请日期 </th>
        <th> 申请人 </th>
        <th> 药品</th>
        <th> 申请类型</th>
        <th> 申请数量 </th>
        <th> 状态 </th>
        <th> 操作 </th>
      </tr>
    </thead>
    <tbody>
    <c:choose>
      <c:when test="${not empty requestScope.phamacyReceive.list}">
        <c:forEach items="${requestScope.phamacyReceive.list}" var="receiveDrugTemp">
            <tr>
              <td></td>
              <td>${receiveDrugTemp.receiveDate}</td>
              <td>${receiveDrugTemp.adminName}</td>
              <td>${receiveDrugTemp.drugName}</td>
              <td>${receiveDrugTemp.receiverDrug}</td>
              <td>${receiveDrugTemp.phamacyDrugQuantity}</td>
              <td>${receiveDrugTemp.state}</td>
              <td>
                  <c:if test="${receiveDrugTemp.state=='审核中'}">
                      <input type="button" value="删除" onclick="deltReceive('${receiveDrugTemp.receiverId}')">
                  </c:if>
                <c:if test="${sessionScope.admin.adminRoleId==3}">
                  <input type="button" id="btn" value="审核通过" onclick="updateReceive('${receiveDrugTemp.receiverId}','${receiveDrugTemp.receiverDrug}','${receiveDrugTemp.phamacyDrugQuantity}','${receiveDrugTemp.pharmacyId}')">
                  <input type="button" id="btn1" value="审核不通过" onclick="updateReceives('${receiveDrugTemp.receiverId}','${receiveDrugTemp.receiverDrug}')">
                </c:if>
                
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
        <a href="#" onclick="chageNum(1)"   target="main">首页</a>
        <a href="#" onclick="chageNum(${phamacyReceive.prePage})"  target="main">上一页</a>
        <a href="#" onclick="chageNum(${phamacyReceive.nextPage})"   target="main">下一页</a>
        <a href="#" onclick="chageNum(${phamacyReceive.navigateLastPage})"   target="main">尾页</a>
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
        form.action="${pageContext.request.contextPath}/phamacy/selectPhamacyReceive.action";
        $("input[name='num']").val(num);
        form.method="post";
        form.submit();
    }
    function deltReceive(id) {
        var isDel = window.confirm("亲！是否删除！")
        var receiverId = id;
        if(isDel){
            $.post("${pageContext.request.contextPath}/phamacy/delectPhamacyReceive.action",
                {receiverId:receiverId},
                function(result) {
                        
                    if (result.success == 1) {
                        window.alert("删除成功！")
                        window.location.href="${pageContext.request.contextPath}/phamacy/selectPhamacyReceive.action";
                    }else if(result.success == 0){
                        window.alert("删除失败！")
                    }
                })
        }else {
            return;
        }
    }
    function updateReceive(id,receiverDrug,phamacyDrugQuantity,pharmacyId) {
        var isDel = window.confirm("亲！是否审核通过！")
        var receiverId = id;
        var receiverDrug = receiverDrug;
        var phamacyDrugQuantity = phamacyDrugQuantity;
        var pharmacyId = pharmacyId;
        var state = $('#btn').val();
        if(isDel){
           check(receiverId,state,receiverDrug,phamacyDrugQuantity,pharmacyId)
        }else {
            return;
        }
    }
    function updateReceives(id,receiverDrug) {
        var isDel = window.confirm("亲！是否审核不通过！")
        var receiverId = id;
        var receiverDrug = receiverDrug;
        var state = $('#btn1').val();
        if(isDel){
            check(receiverId,state,receiverDrug)
        }else {
            return;
        }
    }
    function check(receiverId,state,receiverDrug,phamacyDrugQuantity,pharmacyId){
        $.post("${pageContext.request.contextPath}/phamacy/updatePhamacyReceive.action",
            {receiverId:receiverId,state:state,receiverDrug:receiverDrug,phamacyDrugQuantity:phamacyDrugQuantity,pharmacyId:pharmacyId},
            function(result) {
                if (result.success == 1) {
                    window.alert("操作成功！")
                    window.location.href="${pageContext.request.contextPath}/phamacy/selectPhamacyReceive.action";
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