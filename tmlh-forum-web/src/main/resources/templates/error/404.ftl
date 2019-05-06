<#import "./layout/inc.ftl" as inc>
<#import "./layout/nav.ftl" as nav>
<!DOCTYPE html>
<html lang="en">
<@inc.head '404'>
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

		<div class="row ">
			<div class="col-md-12 text-center">
				<span class="display-1 d-block">404</span>
				<div>找不到这个页面</div>
			</div>
		</div>
	</div>
 
 
</body>
</html>
