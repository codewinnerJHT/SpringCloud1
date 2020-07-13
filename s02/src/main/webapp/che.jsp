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
                <legend>账单管理</legend>
                <div class="layui-field-box">
                    <form class="layui-form" action="${pageContext.request.contextPath}/addOrUpdateBill">
                        <div class="layui-form-item">
                            <label class="layui-form-label">账单ID</label>
                            <div class="layui-input-block">
                                <input type="text" name="billid" required lay-verify="required" placeholder="请输入账单ID" autocomplete="off" class="layui-input" value="${bill.billid}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">账务账号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="billacount" required lay-verify="required" placeholder="请输入账务账号" autocomplete="off" class="layui-input" value="${bill.billacount}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">账单日期</label>
                            <div class="layui-input-block">
                                <input type="text" name="billtime" required lay-verify="required" placeholder="请输入账单日期" autocomplete="off" class="layui-input" value="${bill.billtime}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">金额</label>
                            <div class="layui-input-block">
                                <input type="text" name="billtransactionamount" required lay-verify="required" placeholder="请输入金额" autocomplete="off" class="layui-input" value="${bill.billtransactionamount}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">支付状态</label>
                            <div class="layui-input-block">
                                <input type="text" name="payment" required lay-verify="required" placeholder="请输入支付状态" autocomplete="off" class="layui-input" value="${bill.payment}">
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