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
</head>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-lg12">
            <fieldset class="layui-elem-field">
                <legend>员工信息</legend>
                <div class="layui-field-box">
                    <form class="layui-form" action="/update">
                        <div class="layui-form-item">
                            <label class="layui-form-label">工号</label>
                            <div class="layui-input-block">
                                <input type="hidden" value="${updateuser.enumber}" name="enumber" required lay-verify="required" placeholder="请输入工号" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" value="${updateuser.ename}" name="ename" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-inline">
                                <c:if test="${updateuser.sexx==1}">

                                    男<input type="radio" name="sex" value="男" checked="checked">
                                    女<input type="radio" name="sex" value="女">
                                </c:if>
                                <c:if test="${updateuser.sexx==0}">

                                    男<input type="radio" name="sex" value="男">
                                    女<input type="radio" name="sex" value="女"  checked="checked">
                                </c:if>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">地址</label>
                            <div class="layui-input-block">
                                <input type="text"  value="${updateuser.address}"  name="address" required lay-verify="required" placeholder="请输入地址" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">出生日期</label>
                            <div class="layui-input-block">
                                <input type="text" value="${updateuser.date}"  name="date" required lay-verify="required" placeholder="请输入出生日期" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">电话</label>
                            <div class="layui-input-block">
                                <input type="text" value="${updateuser.phone}"  name="phone" required lay-verify="required" placeholder="请输入电话" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">职位</label>
                            <div class="layui-input-block">
                                <input type="text" value="${updateuser.position}"  name="position" required lay-verify="required" placeholder="请输入职位" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">

                                <p><font>${errormsg}</font></p>
                                <button class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </fieldset>
        </div>
    </div>
</div>
<script type="text/javascript" src="./javascript/jquery.min.js"></script>
<script type="text/javascript" src="./layui/layui.js"></script>
<script type="text/javascript" src="./javascript/dw_form_submit.js"></script>
</body>

</html>