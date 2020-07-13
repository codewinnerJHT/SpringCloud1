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
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-lg12">
            <fieldset class="layui-elem-field">
                <legend>员工工资</legend>
                <div class="layui-field-box">
                    <form class="layui-form" action="${pageContext.request.contextPath}/addOrUpdateSalary">
                        <div class="layui-form-item">
                            <label class="layui-form-label">员工工号</label>
                            <div class="layui-input-block">
                                <input type="text" name="enumber" required lay-verify="required" placeholder="请输入员工工号" autocomplete="off" class="layui-input" value="${param.enumber}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">员工姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="ename" required lay-verify="required" placeholder="请输入员工姓名" autocomplete="off" class="layui-input" value="${param.ename}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">基本工资</label>
                            <div class="layui-input-block">
                                <input type="text" name="salry" required lay-verify="required" placeholder="请输入基本工资" autocomplete="off" class="layui-input" value="${param.salry}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
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