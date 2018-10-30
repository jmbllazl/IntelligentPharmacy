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
  <form class="layui-form x-center" action="" style="width:85%">
    <div class="layui-form-pane">
      <div class="layui-form-item">
        <label class="layui-form-label">药品编号</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="name"  placeholder="编号" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">药品品名</label>
        <div class="layui-input-inline" style="width:100px">
          <input type="text" name="name"  placeholder="姓名" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">有效期</label>
        <div class="layui-input-inline" style="width:150px">
          <input type="text" name="name"  placeholder="被测时间" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline" style="width:200px">
          <input type="text" name="link"  placeholder="搜索" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-input-inline" style="width:80px">
          <button class="layui-btn"  lay-submit="" lay-filter="*">搜索</button>
        </div>
      </div>
    </div>
  </form>
  
  <div class="tools">
    <ul class="toolbar">
      <li><span><img src="${pageContext.request.contextPath}/images/t03.png" /></span>批量删除</li>
      <li onclick="user_management_add('添加用户','Dangan-add.html','1000','600')"><span><img src="${pageContext.request.contextPath}/images/t01.png" /></span>添加</li>
      <li onclick="user_management_edit('用户编辑','Dangan-edit.html','600','500')"><span><img src="${pageContext.request.contextPath}/images/t02.png" /></span>编辑</li>
      <li onclick="user_management_show('用户查看','Dangan-look.html','600','500')"><span><img src="${pageContext.request.contextPath}/images/t06.png" /></span>查看</li>
    </ul>
  </div>
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
        <th> 数量 </th>
        <th> 价格 </th>
        <th> 生产厂商 </th>
        <th> 操作 </th>
      </tr>
    </thead>
    <tbody>
    <c:choose>
      <c:when test="${not empty sessionScope.drugpage.list}">
        <c:forEach items="${sessionScope.drugpage.list}" var="drugTemp">
            <tr>
              <td></td>
              <td>${drugTemp.drugNumber}</td>
              <td>${drugTemp.drugName}</td>
              <td>${drugTemp.formulation}</td>
              <td>${drugTemp.norm}</td>
              <td>${drugTemp.produtionDate}</td>
              <td>${drugTemp.lotNumber}</td>
              <td>${drugTemp.validaityperiod}</td>
              <td>${drugTemp.drugQuantity}</td>
              <td>${drugTemp.drugPrice}</td>
              <td>${drugTemp.manufacturer}</td>
              <td>
                <input type="button" value="查看详情" onclick="selectDetails(${userTemp.userId})">
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
      <td colspan="3" align="left">共有${drugpage.total}条记录，当前第${drugpage.startRow}页，共${drugpage.pages}页</td>
      <td colspan="9" align="right">
        <a href="#" onclick="chageNum(1)"   target="mainframe">首页</a>
        <a href="#" onclick="chageNum(${drugpage.prePage})"  target="mainframe">上一页</a>
        <a href="#" onclick="chageNum(${drugpage.nextPage})"   target="mainframe">下一页</a>
        <a href="#" onclick="chageNum(${drugpage.navigateLastPage})"   target="mainframe">尾页</a>
      </td>
    </tr> 
    </tbody>
  </table>
     <div class="page"  v-show="show">
  <div class="pagelist"> <span class="jump">上一页</span> <span class="jump">1</span> <span class="jump">2</span> <span class="jump">3</span> <span class="jump">4</span> <span class="jump">5</span> <span class="jump">6</span> <span class="ellipsis">...</span> <span class="jump">下一页</span> <span class="jumppoint">跳转到：</span> <span class="jumpinp">
    <input type="text">
    </span> <span class="jump gobtn">GO</span> </div>
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