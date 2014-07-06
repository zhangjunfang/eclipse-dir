<%--
      功能描述 ：消费卡发卡
  Author : Wangjian
  Date   : 2014-02-26
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="page" uri="/page-tag"%>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<%@ include file="/WEB-INF/inc/head.inc"%>
		<!-- common framework -->
		<link type="text/css" rel="stylesheet" href="${path}/common/css/main.css">
		<script type='text/javascript' src='${path}/common/plugins/My97DatePicker/WdatePicker.js'></script>		
		<script type="text/javascript" src="${path}/common/js/common.js"></script>
		<script type="text/javascript" src="${path}/common/js/fn2.js"></script>
		<!-- end common framework -->
		<!-- global -->
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/google/google.css">
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/font-awesome/css/font-awesome.min.css">
		<!-- end global -->
		<!-- bootstrap -->
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/bootstrap-3.1.1/css/bootstrap.min.css">
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/bootstrap-3.1.1/css/bootstrap-theme.min.css">
		<script type="text/javascript" src="${path}/common/plugins/jQuery_1.10/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${path}/common/plugins/bootstrap-3.1.1/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${path}/common/plugins/bootstrap-plugins/bootstrap3-validation.js"></script>
    <!--[if lt IE 9]>
    <link type="text/css" rel="stylesheet" href="${path}/common/plugins/bootstrap-plugins/bootstrap-ie78.css"/>
    <script type="text/javascript" src="${path}/common/plugins/bootstrap-plugins/respond.min.js"></script> 
    <script type="text/javascript" src="${path}/common/plugins/bootstrap-plugins/html5.js"></script>
    <![endif]-->
    <!-- end bootstrap -->
    <!-- theme styles -->
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/metronic2.0.2/plugins/uniform/css/uniform.default.css">
		<script type="text/javascript" src="${path}/common/plugins/metronic2.0.2/plugins/uniform/jquery.uniform.min.js"></script>
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/metronic2.0.2/css/style-metronic.css">
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/metronic2.0.2/css/style.css">
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/metronic2.0.2/css/style-responsive.css">
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/metronic2.0.2/css/plugins.css">
		<link type="text/css" rel="stylesheet" href="${path}/common/plugins/metronic2.0.2/css/themes/light.css">
		<script type="text/javascript" src="${path}/common/plugins/metronic2.0.2/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"></script>
		<script type="text/javascript" src="${path}/common/plugins/metronic2.0.2/plugins/jquery.blockui.min.js"></script>
		<script type="text/javascript" src="${path}/common/plugins/metronic2.0.2/scripts/core/app.js"></script>
		<script type="text/javascript" src="${path}/common/plugins/metronic2.0.2/scripts/custom/portlet-draggable.js"></script>
		<!-- end theme styles -->
		<script type="text/javascript">
			jQuery(document).ready(function(){
			    App.init();// initiate layout and plugins
			    PortletDraggable.init();
			});
			  $(function(){
			      //1. 简单写法：
			      $("#form1").validation();
			  })
		</script>

	</head>
<body>
<div class="page-container">
	<!-- 导航 -->
	<div class="row">
		<div class="col-md-12">
			<ul class="page-breadcrumb breadcrumb">
				<li><i class="fa fa-home"></i><a href="#">卡务管理平台</a></li>
				<li><a href="#">消费卡管理</a></li>
				<li class="active">发卡</li>
			</ul>
		</div>
	</div>

	<!-- 结算提示信息
	<%@ include file="/WEB-INF/inc/settle.inc"%>
	 -->
	<div class="row" id="sortable_portlets">
		<!-- 当前充值员售卡信息 -->
		<%@ include file="/WEB-INF/inc/userCard.inc"%>
			
			<!-- 客户信息 -->
			<div class="col-md-12 column sortable">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-user"></i>客户信息
						</div>
						<div class="tools">
								<button type="button" class="btn btn-default btn-sm" role="button">
									<i class="fa fa-credit-card"></i>&nbsp;&nbsp;&nbsp;读卡 &nbsp;&nbsp;&nbsp;
								</button>
								&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn btn-default btn-sm" role="button">
									<i class="fa fa-cogs"></i>读身份证
								</button>
							<a href="javascript:;" class="collapse"></a> <a
								href="javascript:;" class="reload"
							></a> <a href="javascript:;" class="remove"></a>
						</div>
					</div>
					<div class="portlet-body tabs-below">
						<div class="tab-content">
							<div class="tab-pane active" id="tab_1">
								<form class="form-horizontal" role="form" id="form1" action="#">
									<div class="form-group">
										<label for="cardNo" class="col-sm-2 control-label">客户卡号</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="cardNo"
												check-type="required" placeholder="客户卡号"
												required-message="请填写或读取客户一卡通卡号。"
											>
										</div>
									</div>
									<div class="form-group">
										<label for="customerName" class="col-sm-2 control-label">客户姓名</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="customerName"
												check-type="required" placeholder="客户姓名"
												required-message="请读取或填写客户姓名。"
											>
										</div>
									</div>
									<div class="form-group">
										<label for="mobileNo" class="col-sm-2 control-label">手机号码</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="mobileNo"
												check-type="required" placeholder="手机号码"
												required-message="请填写手机号码。"
											>
										</div>
									</div>
									<div class="form-group">
										<label for="identificationNo" class="col-sm-2 control-label">证件号码</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="identificationNo"
												check-type="required" placeholder="证件号码"
												required-message="请读取或填写证件号码。"
											>
										</div>
									</div>
								</form>
							</div>
							<div class="tab-pane fade" id="tab_2">
								<form class="form-horizontal" role="form" id="form1" action="#">
									<div class="form-group">
										<label for="cardType" class="col-sm-2 control-label">卡类别</label>
										<div class="col-sm-6">
										<select class="form-control" id="cardType">
											<option value="0" selected>普通卡</option>
											<option value="1">福利卡</option>
											<option value="2">管理卡</option>
											<option value="3">其他卡</option>
										</select>
										</div>
									</div>
									<div class="form-group">
										<label for="customerSex" class="col-sm-2 control-label">性别</label>
										<div class="col-sm-6">
										<label class="radio-inline">
											<input type="radio" name="customerSex" id="customerSex" value="1" checked>男
										</label>
										<label class="radio-inline">
											<input type="radio" name="customerSex" id="customerSex" value="0">女
										</label>
										</div>
									</div>
									<div class="form-group">
										<label for="cardType" class="col-sm-2 control-label">卡用途</label>
										<div class="col-sm-6">
										<select class="form-control" id="cardType">
											<option value="0" selected>A卡</option>
											<option value="1">B卡</option>
											<option value="2">C卡</option>
										</select>
										</div>
									</div>
									<div class="form-group">
										<label for="nameSimple" class="col-sm-2 control-label">姓名简拼</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="nameSimple" placeholder="姓名简拼">
										</div>
									</div>
									<div class="form-group">
										<label for="address" class="col-sm-2 control-label">联系地址</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="address" placeholder="联系地址">
										</div>
									</div>
									<div class="form-group">
										<label for="nation" class="col-sm-2 control-label">民族</label>
										<div class="col-sm-6">
										<select class="form-control" id="nation">
											<option value="01" selected>汉族</option>
											<option value="02">蒙古族</option>
											<option value="03">满族</option>
											<option value="04">回族</option>
											<option value="05">藏族</option>
										</select>
										</div>
									</div>
									<div class="form-group">
										<label for="email" class="col-sm-2 control-label">电子邮箱</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="email" check-type="mail" placeholder="电子邮箱">
										</div>
									</div>
									<div class="form-group">
										<label for="conuntry" class="col-sm-2 control-label">国家</label>
										<div class="col-sm-6">
										<select class="form-control" id="conuntry">
											<option value="01" selected>中国</option>
											<option value="02">阿富汗</option>
											<option value="03">阿尔巴尼亚</option>
											<option value="04">阿尔及利亚</option>
											<option value="05">安道尔</option>
										</select>
										</div>
									</div>
									<div class="form-group">
										<label for="postCode" class="col-sm-2 control-label">邮政编码</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="postCode" placeholder="邮政编码">
										</div>
									</div>
									<div class="form-group">
										<label for="conuntry" class="col-sm-2 control-label">证件类型</label>
										<div class="col-sm-6">
										<select class="form-control" id="conuntry">
											<option value="01" selected>身份证</option>
											<option value="02">军官证</option>
											<option value="03">警官证</option>
											<option value="04">护照</option>
											<option value="05">驾驶证</option>
										</select>
										</div>
									</div>
									<div class="form-group">
										<label for="birthDate" class="col-sm-2 control-label">出生日期</label>
										<div class="col-sm-6">
										<div class="input-group">
										<input type="text" class="form-control" id="birthDate" placeholder="出生日期" onClick="WdatePicker()">
											<span class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</span>
										</div>
										</div>
									</div>
									<div class="form-group">
										<label for="remark" class="col-sm-2 control-label">备注</label>
										<div class="col-sm-6">
										<textarea class="form-control" rows="2" id="remark"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">&nbsp;</label>
										<div class="col-sm-6">
										<label class="checkbox-inline">
											<input type="checkbox" id="oneCunsumePassword" value="true" checked>统一消费密码
										</label>
										<label class="checkbox-inline">
											<input type="checkbox" id="noName" value="true">不记名
										</label>
										<label class="checkbox-inline">
											<input type="checkbox" id="createOnlineAccount" value="true" onClick="if(this.checked){$('#onlineAccount').show();}else{$('#onlineAccount').hide();};">创建在线账户
											<span class="form-control-static" id="onlineAccount" style="display:none;">ZXX410102201432</span>
										</label>
									</div>
									</div>
								</form>
							</div>
						</div>
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab_1" data-toggle="tab">基本信息</a>
							</li>
							<li><a href="#tab_2" data-toggle="tab">更多详情</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<!-- 收费信息 -->
			<div class="col-md-12 column sortable">
				<div class="portlet box green">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-exchange"></i>收费信息
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"></a> <a
								href="javascript:;" class="reload"
							></a> <a href="javascript:;" class="remove"></a>
						</div>
					</div>
					<div class="portlet-body">
								<form class="form-horizontal" role="form" id="form2" action="#">
									<div class="form-group">
										<label for="costMoney" class="col-sm-2 control-label">成本费</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="costMoney" disabled value="10.00">
										</div>
									</div>
									<div class="form-group">
										<label for="manageMoney" class="col-sm-2 control-label">管理费</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="manageMoney" disabled value="10.00">
										</div>
									</div>
									<div class="form-group">
										<label for="cardCoat" class="col-sm-2 control-label">卡套费用</label>
										<div class="col-sm-6">
											<label class="checkbox-inline">
											<input type="checkbox" id="useCardCoat" value="true" checked onClick="if(this.checked){$('#cardCoat').show();}else{$('#cardCoat').hide();};">使用卡套
											</label>
											<label class="checkbox-inline" id="cardCoat">
											<input type="text" class="form-control" id="cardCoatTxt" disabled value="10.00"></span>
											</label>
										</div>
									</div>
									<div class="form-group">
										<label for="chargeMoney" class="col-sm-2 control-label">充值金额</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="chargeMoney">
										</div>
									</div>
									<div class="form-group">
										<label for="recMoney" class="col-sm-2 control-label">实收款</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="recMoney">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">&nbsp;</label>
										<div class="col-sm-6">
											<label class="inline">应收金额：<span class="red">100.00</span></label>
											<label class="inline">找零金额：<span class="red">20.00</span></label>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
		</div>
		<!-- 提交 -->
		<div class="row">
			<div class="col-md-9 col-md-offset-3">
				<button type="submit" class="btn btn-success" role="button">
					<i class="fa fa-check"></i>&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;
				</button>
				&nbsp;&nbsp;&nbsp;
				<button type="reset" class="btn btn-default" role="button">
					<i class="fa fa-reply"></i>&nbsp;&nbsp;&nbsp;重置&nbsp;&nbsp;&nbsp;
				</button>
			</div>
		</div>
		
	</div>
</body>
</html>