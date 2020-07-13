<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>al公司后台管理系统</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="./css/global.css">
    <link rel="stylesheet" href="./icheck/minimal/red.css">
</head>
<script>

    /*window.onload=function () {

        document.getElementById("del_but").onclick=function () {

            var boo=false;

            var cbox_all=document.getElementsByName("id");
            for(var i=0;i<cbox_all.length;i++){

                if(cbox_all[i].checked){

                    boo=true;
                    break;
                }
            }
            if(boo){

                document.getElementById("del_all").submit();
            }

        }

    }*/

    function delSubmit(){


        $('#tb1').find(':checkbox').each(function(){
            if ($(this).is(":checked")) {
                //操作
                var del = $(this).val()+"/";
                console.log(del);
            }
        });
    }

    $(function () {

        $("#flush_but").click(function () {
            $.ajax({ url: "/index",
                type:"get",
                success: function(){
                    $(this).addClass("done");
                }});
        });

    });

</script>
<script type="text/javascript" src="./javascript/jquery.min.js"></script>

<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">al公司后台管理系统</div>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="http://t.cn/RCzsdCq" class="layui-nav-img"> 管理员
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="sysConfig.jsp">基本资料</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="login.jsp">退出系统</a></li>
            </ul>
        </div>

        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item">
                        <a class="" href="${pageContext.request.contextPath}/sysConfig.jsp">个人信息</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/index">员工信息</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/dept">部门信息</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/salary">员工工资</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/check">账单管理</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="layui-body">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">
                <fieldset class="layui-elem-field">
                    <legend>员工信息</legend>
                    <div class="layui-field-box">
                        <form class="layui-form" action="${pageContext.request.contextPath}/selectOne">
                            <div class="layui-form-item" style="text-align:center;">
                                <div class="layui-inline">
                                    <div class="layui-input-inline">
                                        <input autocomplete="off" class="layui-input" placeholder="请输入员工工号" type="text" name="enumber">
                                    </div>
                                </div>
                                <div class="layui-inline" style="text-align:left;">
                                    <div class="layui-input-inline">
                                        <button class="layui-btn"><i class="layui-icon">&#xe615;</i>查询</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <hr>
                        <div class="layui-btn-group">
                            <button class="layui-btn layui-btn-xs layui-btn-normal dw-dailog" dw-url="./create.jsp" dw-title="新增">
                      <i class="layui-icon">&#xe654;</i>新增
                  </button>
<%--                            dw-url="./delete.json"--%>
                            <button id="del_but" class="layui-btn layui-btn-xs layui-btn-danger dw-batch-delete"  dw-url="./delete.json">
                      <i class="layui-icon">&#xe640;</i>删除
                  </button>
                            <button id="flush_but" class="layui-btn layui-btn-xs dw-refresh">
                      <i class="layui-icon">&#x1002;</i>刷新
                  </button>
                        </div>
                        <hr>
                        <%--<form id="del_all" action="/deleteAll">--%>
                            <table class="layui-table">
                                <colgroup>
                                    <col width="150">
                                    <col width="150">
                                    <col width="200">
                                    <col>
                                    <col>
                                </colgroup>
                                <thead>
                                    <tr>
                                        <th class="selectAll"><input type="checkbox"></th>
                                        <th>工号</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>地址</th>
                                        <th>出生日期</th>
                                        <th>电话</th>
                                        <th>职位</th>
                                        <th style="text-align:center;">操作</th>
                                    </tr>
                                </thead>


                                <tbody id="tb1">

                                    <c:forEach var="user" items="${users}">

                                        <tr>
                                            <td><input type="checkbox" name="delValue" value="${user.enumber}"></td>
                                            <td>${user.enumber}</td>
                                            <td>${user.ename}</td>
                                            <c:if test="${user.sexx==1}">
                                                <td>男</td>
                                            </c:if>

                                            <c:if test="${user.sexx==0}">
                                                <td>女</td>
                                            </c:if>
                                            <td>${user.address}</td>
                                            <td>${user.date}</td>
                                            <td>${user.phone}</td>
                                            <td>${user.position}</td>
                                            <td class="text-center">
                                                <div class="layui-btn-group">
                                                    <button class="layui-btn layui-btn-xs layui-btn-normal dw-dailog" dw-url="updateSelect?enumber=${user.enumber}" dw-title="编辑">
                                                        <i class="layui-icon">&#xe642;</i>编辑
                                                    </button>
                                                    <button class="layui-btn layui-btn-xs layui-btn-danger dw-delete" dw-url="${pageContext.request.contextPath}/delete?enumber=${user.enumber}" dw-title="${user.ename}">
                                                        <i class="layui-icon">&#xe640;</i>删除
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        <%--</form>--%>
                    </div>
                </fieldset>
            </div>
        </div>

        <div class="layui-footer">
            <!-- 底部固定区域 -->
        </div>
    </div>
    <script type="text/javascript" src="./javascript/jquery.min.js"></script>
    <script type="text/javascript" src="./layui/layui.js"></script>
    <script type="text/javascript" src="./icheck/icheck.js"></script>
    <script type="text/javascript" src="./javascript/dw.js"></script>

</body>

</html>