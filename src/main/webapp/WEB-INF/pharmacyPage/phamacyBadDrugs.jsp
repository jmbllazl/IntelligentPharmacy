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
  <title>药品报损页面</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pag.css" media="all">
</head>
<body >
<h1 align="center" style="font-size: 40px;color: #5747ff;">药品报损申请单</h1>
<form  action="${pageContext.request.contextPath}/phamacy/selectPharmacyClassification" method="post">
  药品分类：<select  name="drugClassifications" id="drugClassifications" >
  <option value="">请选择</option>
  <c:forEach items="${drugClassification}" var="drugClassifications">
    <option value="${drugClassifications.drugClassificationId}" id="drugClassification" }>${drugClassifications.drugClassificationName}</option>
  </c:forEach>
</select >
</form>
<form  id="recevieDrug" action="${pageContext.request.contextPath}/phamacy/addPet.action" method="post" enctype="multipart/form-data">
  <input type="hidden" name="num">
  申请选择：<select name="drugDetails" id="drugDetails" style="width: 105px;height: 22px" >
  <option >请选择</option>
  <option name="drugDetails">报损</option>
</select>
  药品查询：<input type="text" name="drugsName" id="drugsName"> <input type="button" name="drugName" id="drugName" value="查询" onclick="selectDrugs()">
  <table align="center" class="tablelist" >
    <thead>
    <tr>
      <th><input onclick="selectAll()" type="checkbox" name="controlAll" style="" id="controlAll">
      </th>
      <th> 药品品名 </th>
      <th> 剂型</th>
      <th> 规格</th>
      <th> 单位</th>
      <th> 药品价格 </th>
      <th> 批准文号 </th>
      <th> 生产厂商 </th>
      <th> 报损数量 </th>
    </tr>
    </thead>

    <tbody id="pharmacyDrugTable">

    </tbody>


  </table>
  <input type=file name="pic" id="doc" onchange="javascript:setImagePreview();">
  <p><div id="localImag"><img id="preview" width=-1 height=-1 style="diplay:none" /></div></p>
  <input type="submit" align="right" name="subscribe" value="提 交" style="background-color: #83fff5;width: 200px;height: 28px">
  
</form>

</body>
</html>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery2.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/js.js" charset="utf-8"></script>
<script>
    $("#drugClassifications").change(function () {
        var drugClassificationId = document.getElementById("drugClassifications").value;
        console.log(drugClassificationId);
        $.post("${pageContext.request.contextPath}/phamacy/selectPharmacyClassificationPhamacyDrugDetils.action",
            {"drugClassificationId":drugClassificationId},
            function (res) {
                var pharmacyDrugTable = $("#pharmacyDrugTable");
                for (var i = 0; i < res.list.length; i++) {
                    pharmacyDrugTable.append($(`<tr>  
                    <td><input type="checkbox" value="\${res.list[i].pharmacyId}" name="selected"></td>
                    <td>\${res.list[i].drugName}</td>
                    <td>\${res.list[i].formulation}</td>
                    <td>\${res.list[i].norm}</td>
                    <td>\${res.list[i].unit}</td>
                    <td>\${res.list[i].drugPrice}</td>
                    <td>\${res.list[i].approvalnumber}</td>
                    <td>\${res.list[i].manufacturer}</td>
                    <td><input type="text"  name="drugQuantity"></td>
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

    function selDate() {
        var couId = document.getElementById("couId").value;
        var counselorDate = document.getElementById("orderDate1").value;
        window.location.href="${pageContext.request.contextPath}/servlet/foreUserServlet?login=selCounselorDate&counselorDate="+counselorDate;
    }
    function chageNum(num) {
        console.log(num);
        var form = $("form");
        form.action="${pageContext.request.contextPath}/phamacy/selectPharmacyClassificationPhamacyDrugDetils.action";
        $("input[name='num']").val(num);
        form.method="post";
        form.submit();
    }
    function selectDrugs() {
        var drugName = document.getElementById("drugsName").value;
        console.log(drugName);
        $.post("${pageContext.request.contextPath}/phamacy/selectPhamacyLedDrugs.action",
            {"drugName":drugName},
            function (res) {
                var pharmacyDrugTable = $("#pharmacyDrugTable");
                for (var i = 0; i < res.list.length; i++) {
                    pharmacyDrugTable.append($(`<tr>  
                    <td><input type="checkbox" value="\${res.list[i].pharmacyId}" name="selected"></td>
                    <td>\${res.list[i].drugName}</td>
                    <td>\${res.list[i].formulation}</td>
                    <td>\${res.list[i].norm}</td>
                    <td>\${res.list[i].unit}</td>
                    <td>\${res.list[i].drugPrice}</td>
                    <td>\${res.list[i].approvalnumber}</td>
                    <td>\${res.list[i].manufacturer}</td>
                    <td><input type="text"  name="drugQuantity"></td>
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
    }
</script>

<script>
    function setImagePreview() {
        var docObj=document.getElementById("doc");
        var imgObjPreview=document.getElementById("preview");
        if(docObj.files && docObj.files[0]){
//火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '300px';
            imgObjPreview.style.height = '120px';
//imgObjPreview.src = docObj.files[0].getAsDataURL();
//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
        }else{
//IE下，使用滤镜
            docObj.select();
            var imgSrc = document.selection.createRange().text;
            var localImagId = document.getElementById("localImag");
//必须设置初始大小
            localImagId.style.width = "300px";
            localImagId.style.height = "250px";
//图片异常的捕捉，防止用户修改后缀来伪造图片
            try{
                localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            }catch(e){
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    }
</script>

