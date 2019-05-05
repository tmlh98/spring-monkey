<#macro head title>
<head >
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
	<meta name="description" content="" />
	<meta name="author" content="" />
<link rel="icon" href="/favicon.ico" />
<title>${title}</title>
<link rel="stylesheet" href="/asserts/css/common.css" />
<link rel="stylesheet"
	href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/webjars/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="/asserts/css/animate.css" />
	<#nested>
</head>
</#macro>

<#macro script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/webjars/jquery/2.1.1/jquery.min.js"></script> 

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="/webjars/bootstrap-notify/3.1.3-1/bootstrap-notify.min.js"></script>
<script src="/asserts/js/common.js"></script>
<#nested>
</#macro>




