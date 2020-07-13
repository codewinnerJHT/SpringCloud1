<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>al公司后台管理系统</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
</head>

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
                        <a class="" href="sysConfig.jsp">个人信息</a>
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
                        <a href="/check.jsp">账单管理</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="layui-body">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">
                <fieldset class="layui-elem-field">
                    <legend>管理员个人信息</legend>
                    <div class="layui-field-box">
                        <div class="layui-btn-group">
                            <!-- <button class="layui-btn layui-btn-xs layui-btn-normal dw-dailog" dw-url="create.html" dw-title="新增系统变量">
                        <i class="layui-icon">&#xe654;</i>新增
                    </button> -->
                            <button class="layui-btn layui-btn-xs dw-refresh">
                        <i class="layui-icon">&#x1002;</i>刷新
                    </button>
                        </div>
                        <hr>
                        <form class="layui-form" action="">
                            <div class="layui-form-item">
                                <label class="layui-form-label">管理员账号</label>
                                <div class="layui-input-inline">
                                    <input type="password" disabled="disabled" name="password" required lay-verify="required" placeholder="admin" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">在主页修改</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" disabled="disabled" name="password" required lay-verify="required" placeholder="123" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">在主页修改</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-inline">
                                    <input type="password" disabled="disabled" name="password" required lay-verify="required" placeholder="管理员" autocomplete="off" class="layui-input">
                                </div>
                                <!-- <div class="layui-form-mid layui-word-aux">在主页修改</div> -->
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">电话</label>
                                <div class="layui-input-inline">
                                    <input type="password" disabled="disabled" name="password" required lay-verify="required" placeholder="15625876589" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </form>
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
    <script type="text/javascript" src="./javascript/sys_config.js"></script>
</body>

</html>