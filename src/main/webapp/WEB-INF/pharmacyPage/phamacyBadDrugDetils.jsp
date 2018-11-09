<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<html>
    
    <head>
        <meta charset="utf-8">
        <title>
            申请查看-查看
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">
    </head>
    
    <body>
       
        <div class="x-body">
           <form class="layui-form layui-form-pane">
                
              <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        申请人
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="title" required lay-verify="title" value="${phamacyReceive.adminName}" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                 <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        申请类型
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="title" required lay-verify="title" value="${phamacyReceive.receiverDrug}" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        申请日期
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="title" required lay-verify="title" value="${phamacyReceive.receiveDate}" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        申请数量
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="title" required lay-verify="title" value="${phamacyReceive.phamacyDrugQuantity}" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">
                        申请状态
                    </label>
                <div class="layui-input-block">
                  <input type="text" id="L_title" name="title" required lay-verify="title" value="${phamacyReceive.state}" 
                        autocomplete="off" class="layui-input">
                </div>
                </div>
                 <div class="layui-form-item">
                   <img src="${pageContext.request.contextPath}/phamacy/images.action?receiverId=${phamacyReceive.receiverId}">
                </div>
          </form>
    </div>
    <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
        </script>
    <script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
        </script>
    <script>
            layui.use(['form','layer','layedit'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer
              ,layedit = layui.layedit;
            });
        </script>
    </body>

</html>