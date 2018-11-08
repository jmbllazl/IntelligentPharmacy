<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" import="com.cy.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
    <link rel="stylesheet" href="../css/style.css" media="all">
    <link rel="stylesheet" type="text/css" href="../css/public.css" />
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/public.js"></script>
    <script type="text/javascript" src="../js/external.js"></script>
    <style>
        /* 弹窗 (background) */
        .modal {
            display: none; /* 默认隐藏 */
            position: fixed;
            z-index: 1;
            padding-top: 100px;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0,0.4);
        }

        /* 弹窗内容 */
        .modal-content {
            position: relative;
            background-color: #fefefe;
            margin: auto;
            padding: 0;
            border: 1px solid #888;
            width: 30%;

            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
            -webkit-animation-name: animatetop;
            -webkit-animation-duration: 0.4s;
            animation-name: animatetop;
            animation-duration: 0.4s
        }

        /* 添加动画 */
        @-webkit-keyframes animatetop {
            from {top:-300px; opacity:0}
            to {top:0; opacity:1}
        }

        @keyframes animatetop {
            from {top:-300px; opacity:0}
            to {top:0; opacity:1}
        }

        /* 关闭按钮 */
        .close {
            color: white;
            float: right;
            font-size: 20px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }

        .modal-header {
            width: 100%;
            height: 30px;
            text-align: center;

            background-color: #d70101;
            color: white;
        }

        .modal-body {
            width: 100%;
            height: 50px;
            margin-top: 20px;
            text-align: center;
        }
        .modal-but1{
            width: 100%;
            height: 50px;
            text-align: center;
        }
        .button1{
            background-color: #d70101;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
        }
        .button2{
            background-color: #d70101;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
        }
        h8{
            color: white;
            font-size: 20px;
            font-weight: bold;
        }
        h9{
            color: black;
            font-size: 20px;
            font-style: italic;
            font-weight: bold;
        }
    </style>

</head>

<body  background=" " onload="load()">
<div class="clearfix" id="contentBox">
<input type="hidden" name="nameId" value="0">
    <c:when test="${not empty sessionScope.adminList}">
        <c:forEach items="${sessionScope.adminList}" var="adminList">
            <input type="hidden" name="adminName" id="adminName" value="${adminList.adminName}"/>
            <input type="hidden" name="adminRoleId" id="adminRoleId" value="${adminList.adminRoleId}">
        </c:forEach>
    </c:when>

</div>


<!-- 弹窗 -->
<div id="myModal" class="modal">

    <!-- 弹窗内容 -->
    <div class="modal-content">
        <div class="modal-header">
            <span class="close">&times;</span>
            <h8>警报提醒!!</h8>
        </div>
        <div class="modal-body">
            <img src="../images/gantan.jpg" alt= width="38" height="38" />
            <h9>您有警报消息，请及时查看!!!!</h9>

        </div>
        <div class="modal-but1">
            <input type="button" class="button1"  onclick="button1()" value="确定">
            <span class="button2">
            <a style="color: white" href="/alarm/alarmAllList.action"   target="main">查看详情</a>
            </span>
        </div>
        <%--  <div class="modal-but2">
              <input type="button" id="button2" value="查看详情">
          </div>--%>
    </div>
</div>
</body>
<script>
    //<!--药品低限内容-->
    function phamacyNum() {
        var adminRoleId = $('#adminRoleId').val();
        if (adminRoleId == 1) {
            return;
        }
        else {
            var adminName = $('#adminName').val();
            $.post("/alarm/alarmAllDrugs.action",
                {adminName: adminName},
                function (data) {
                    var info = data;
                    if (info.success) {
                        alert("低限警报")
                        //window.open ("/alarm/alarmTable.action") ;
                    } else {

                    }
                }, "json");
        }
    }
    function phamacyDate() {
        var adminRoleId = $('#adminRoleId').val();
        if (adminRoleId == 1) {
            return;
        }
        else {
            var adminName = $('#adminName').val();
            $.post("/alarm/alarmPhamacyDate.action",
                {adminName: adminName},
                function (data) {
                    var info = data;
                    if (info.success) {
                        btn();
                        alert("日期警报")
                    } else {

                    }
                }, "json");
        }
    }

</script>

<script>
    function load() {
        phamacyNum();
        phamacyDate();
    }
</script>

<script>

    // 获取弹窗
    var modal = document.getElementById('myModal');

    // 获取 <span> 元素，用于关闭弹窗 that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // 点击按钮打开弹窗
    function btn() {
        modal.style.display = "block";
    }
    //确定按钮
    function button1(){
        modal.style.display = "none";
    }
    //查看详情
    function button2(){
        window.onload("/alarm/alarmAllList.action");
    }
    // 点击 <span> (x), 关闭弹窗
    span.onclick = function() {
        modal.style.display = "none";
    }

    // 在用户点击其他地方时，关闭弹窗
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

</script>



</html>