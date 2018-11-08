<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/15 0015
  Time: 下午 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<html>
<head>
    <title>医保药品核对页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all">
</head>

<script type="text/javascript">



</script>

<body >
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>医保药品核对</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="/phamacy/drugStoreOut.action" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="tools">

</div>
<form  action="#" method="post">
    请选择药品类别：<select  name="drugClassifications" id="drugClassifications">
    <option value="">请选择</option>
    <c:forEach items="${drugClassification}" var="drugClassifications">
        <option value="${drugClassifications.drugClassificationId}" id="drugClassification" }>${drugClassifications.drugClassificationName}</option>
    </c:forEach>
</select >
</form>
<form  id="recevieDrug" action="/phamacy/submitMedicalInsurance.action" method="post">
    <input type="hidden" name="num">
    <table align="center" class="tablelist" >
        <thead>
        <tr>
            <th>
                <input onclick="selectAll()" type="checkbox" name="controlAll" style="" id="controlAll"></th>
            <th> 药品品名 </th>
            <th> 剂型</th>
            <th> 规格</th>
            <th> 批准文号 </th>
            <th> 生产厂商 </th>
            <th> 设置为医保药品 </th>
            <th> 选择报销比例 </th>
        </tr>
        </thead>

        <tbody id="pharmacyDrugTable">
        </tbody>
    </table>
    <div align="center">
        <input type="submit"  class="layui-btn"  value="提 交" onclick="return check()" style="width: 150px;height: 28px">
    </div>
</form>
</body>
</html>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
<script>
    $("#drugClassifications").change(function () {
        var drugClassifications = document.getElementById("drugClassifications").value;
        console.log(drugClassifications);
        $.post("${pageContext.request.contextPath}/phamacy/selectDrugStore.action",
            {"drugClassifications":drugClassifications},
            function (res) {
                var pharmacyDrugTable = $("#pharmacyDrugTable");
                for (var i = 0; i < res.list.length; i++) {
                    pharmacyDrugTable.append($(`<tr>
                    <td><input type="checkbox" value="\${res.list[i].drugId}" name="selected" id="selected"></td>
                    <td>\${res.list[i].drugName}</td>
                    <td>\${res.list[i].formulation}</td>
                    <td>\${res.list[i].norm}</td>
                    <td>\${res.list[i].approvalnumber}</td>
                    <td>\${res.list[i].manufacturer}</td>
                    <td><select name="medicalinsurance" id="medicalinsurance" style="width: 100px;height: 22px" >
                         <option value='无' style='display:none;' >-请选择-</option>";
                         <option value="0">是</option>
                         <option value="1">否</option>
                         </select></td>
                     <td><select name="reimbursementRatio" id="reimbursementRatio" style="width: 100px;height: 22px" >
                         <option value='无' style='display:none;' >-请选择-</option>";
                         <option value="0.30">0.30</option>
                         <option value="0.35">0.35</option>
                         <option value="0.40">0.40</option>
                         <option value="0.45">0.45</option>
                         <option value="0.50">0.50</option>
                         <option value="0.55">0.55</option>
                         <option value="0.60">0.60</option>
                         <option value="0.65">0.65</option>
                         <option value="0.70">0.70</option>
                         <option value="0.75">0.75</option>
                         <option value="0.80">0.80</option>
                         <option value="0.85">0.85</option>
                         <option value="0.90">0.90</option>
                         </select></td>
</tr>`));
                }
                pharmacyDrugTable.append($(`<tr>
        <td colspan="3" align="left">共有\${res.total}条记录，当前第\${res.pageNum}页，共\${res.pages}页</td>
        <td colspan="9" align="right">
        <a href="#" onclick="chageNum(1)"   target="main">首页</a>
        <a href="#" onclick="chageNum(\${res.prePage})"  target="main">上一页</a>
        <a href="#" onclick="chageNum(\${res.nextPage})"   target="main">下一页</a>
        <a href="#" onclick="chageNum(\${res.navigateLastPage})"   target="main">尾页</a>
      </td>
</tr>`));

            }, "json");
    });

    function chageNum(num) {
        console.log(num);
        var form = $("form");
        form.action="${pageContext.request.contextPath}/phamacy/selectDrugStore.action";
        $("input[name='num']").val(num);
        form.method="post";
        form.submit();
    }


</script>