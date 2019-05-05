<#macro head title>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head th:fragment="head(title ,links , styles)">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="icon" href="/favicon.ico" />

<title >${title}</title>

<link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" />
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="/webjars/font-awesome/4.7.0/css/font-awesome.min.css" />

<link rel="stylesheet" href="/webjars/AdminLTE/2.3.8/dist/css/AdminLTE.min.css" />
<link rel="stylesheet" href="/webjars/AdminLTE/2.3.8/dist/css/skins/_all-skins.min.css"/>
	
<link rel="stylesheet" href="/webjars/bootstrap-table/1.14.2/dist/bootstrap-table.min.css"/>
	
<link rel="stylesheet" href="/asserts/css/animate.css" />
<link rel="stylesheet" href="/asserts/css/common.css" />
<link rel="stylesheet" href="/asserts/admin/css/docs.css"/> 
	<#nested>
</head>
</#macro>





<#macro script>
<script src="/webjars/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="/webjars/bootstrap-notify/3.1.3-1/bootstrap-notify.min.js"></script>


<script src="/webjars/bootstrap-table/1.14.2/dist/bootstrap-table.min.js"></script>
<script src="/webjars/bootstrap-table/1.14.2/dist/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="/asserts/js/common.js"></script>

<!-- FastClick -->
<script src="/webjars/AdminLTE/2.3.8/plugins/fastclick/fastclick.js"></script>
<!-- SlimScroll 1.3.0 -->
<script
	src="/webjars/AdminLTE/2.3.8/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script>
  var AdminLTEOptions = {
  };
</script>
<!-- AdminLTE App -->
<script src="/webjars/AdminLTE/2.3.8/dist/js/app.min.js"></script>
<script src="/webjars/sweetalert/2.1.0/sweetalert.min.js"></script>

<script src="/asserts/admin/js/swal-common.js"></script>
<script src="/asserts/admin/js/method-common.js"></script>
<#nested>
</#macro>









