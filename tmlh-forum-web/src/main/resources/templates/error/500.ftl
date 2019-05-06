<#import "./layout/inc.ftl" as inc>
<#import "./layout/nav.ftl" as nav>
<!DOCTYPE html>
<html lang="en">
<@inc.head '500'>
<style type="text/css">
.display-1 {
	font-weight: 300;
	line-height: 1.2;
	color: red;
	font-size: 6rem;
}
.d-block {
	display: block !important;
	margin-top: 50px;
}
</style>
</@inc.head>
<body>
	<@nav.topbar active='default'>	</@nav.topbar>
 	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-12 text-center">
				<span class="display-2 d-block">500</span>
				<div class="mb-4">服务器错误</div>
			</div>
		</div>
	</div>
 
 
</body>
</html>
