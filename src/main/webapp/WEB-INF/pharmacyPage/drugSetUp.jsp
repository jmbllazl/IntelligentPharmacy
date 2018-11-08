<%--
  Created by IntelliJ IDEA.
  User: x1c
  Date: 2018/11/1
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        药品采购
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin.css" media="all">

    <link href="${pageContext.request.contextPath}/css/jquery-ui-1.9.2.custom.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui-1.9.2.custom.js"></script>
    <script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
</head>

<body >
<div class="x-body">
    <form class="layui-form" action="/phamacy/submitDrugSetUp.action" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>药品名称</label>
            <div class="layui-input-inline">
                <input type="text"  name="drugName" id="drugName"
                       class="layui-input" onblur="checkName()">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>药品编号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="drugNumber" name="drugNumber" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span class="x-red">* </span>药品类别</label>
            <div class="layui-input-inline">
                <select name="drugClass" id="drugClass">
                    <option value='' style='display:none;' >请选择</option>";
                    <option value="1">抗生素</option>
                    <option value="2">心脑血管用药</option>
                    <option value="3">消化系统用药</option>
                    <option value="4">呼吸系统用药</option>
                    <option value="5">麻醉类药品</option>
                    <option value="6">精神类药品</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>药品详情
            </label>
            <div class="layui-input-inline">
                <input type="text" id="drugDetailed" name="drugDetailed" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><span class="x-red" >* </span>剂型</label>
            <div class="layui-input-inline">
                <select name="formUlarion" id="formUlarion">
                    <option value="" style='display:none;'>请选择</option>
                    <option value="片剂">片剂</option>
                    <option value="注射液">注射液</option>
                    <option value="中药">包</option>
                    <option value="颗粒">颗粒</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>规格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="norm" name="norm" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label"><span class="x-red" >* </span>单位</label>
            <div class="layui-input-inline">
                <select name="unit" id="unit">
                    <option value="" style='display:none;'> 请选择</option>
                    <option value="盒/元">盒/元</option>
                    <option value="瓶/元">瓶/元</option>
                    <option value="包/元">包/元</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>药品价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="drugPrice" name="drugPrice" class="layui-input">
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label"><span class="x-red" >* </span>日次数</label>
            <div class="layui-input-inline">
                <select name="dayConsumption" id="dayConsumption">
                    <option value="" style='display:none;'> 请选择</option>
                    <option value="一日/一次">一日/一次</option>
                    <option value="一日/二次">一日/二次</option>
                    <option value="一日/三次">一日/三次</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>批注文号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="approvalNumber" name="approvalNumber" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>生产日期
            </label>
            <div class="layui-input-inline">
                <input type="text" class="inline laydate-icon" id="test1" name="produtionDate" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>批号
            </label>
            <div class="layui-input-inline">
                <input type="text" id="lotNumber" name="lotNumber" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>有效期
            </label>
            <div class="layui-input-inline">
                <input type="text" class="inline laydate-icon" id="test2" name="validaiTypeRiod" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>生产厂商
            </label>
            <div class="layui-input-inline">
                <input type="text" id="manufacTurer" name="manufacTurer" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>入库日期
            </label>
            <div class="layui-input-inline">
                <input type="text" class="inline laydate-icon" id="test3" name="storageTime" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>图片路径
            </label>
            <div class="layui-input-inline">
                <input type="text" id="drugPhoto" name="drugPhoto"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <input type="submit" class="layui-btn"  value="提交" >
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8">
</script>
<script src="${pageContext.request.contextPath}/js/x-layui.js" charset="utf-8">
</script>

<script>

    !function(){
        laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
        laydate({elem: '#demo'});//绑定元素
    }();
    var start = {
        elem: '#start',
        format: 'YYYY-MM-DD hh:mm:ss',
        max: '2099-06-16', //最大日期
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY-MM-DD hh:mm:ss',
        max: '2099-06-16',
        istime: true,
        istoday: false,
        choose: function(datas){
            start.max = datas; //结束日选好后，充值开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);
    //自定义日期格式
    laydate({
        elem: '#test1',
        format: 'YYYY-MM-DD',
        festival: true, //显示节日
        choose: function(datas){ //选择日期完毕的回调
        }
    });

    //自定义日期格式
    laydate({
        elem: '#test2',
        format: 'YYYY-MM-DD',
        festival: true, //显示节日
        choose: function(datas){ //选择日期完毕的回调
        }
    });

    //自定义日期格式
    laydate({
        elem: '#test3',
        format: 'YYYY-MM-DD',
        festival: true, //显示节日
        choose: function(datas){ //选择日期完毕的回调
        }
    });
    //日期范围限定在昨天到明天
    laydate({
        elem: '#hello3',
        min: laydate.now(-7), //-1代表昨天，-2代表前天，以此类推
        max: laydate.now(+7) //+1代表明天，+2代表后天，以此类推
    });

    layui.use(['element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层


    });

</script>
<script>
    layui.use('form',function(){});
</script>
<script type="text/javascript">
    layui.use('form',function(){
        var form = layui.form;
        form.render();
    });
</script>
</body>
</html>
