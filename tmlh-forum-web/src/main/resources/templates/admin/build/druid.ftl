<#import "/layout/admin/inc.ftl" as inc>
<#import "/layout/admin/nav.ftl" as nav>


<!DOCTYPE html>
<html lang="en">
<@inc.head '接口管理'>
<style type="text/css">
#mainFrame{
	width: 100%; 
	min-height:600px;
	height: 100%; 
	background-color: #ecf0f5;
	overflow: hidden;
}
</style>
</@inc.head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<@nav.topbar></@nav.topbar>
		<@nav.menu active='system'></@nav.menu>
 
 	<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<iframe id="mainFrame" name="mainFrame" scrolling="yes"   frameborder="0" 
			src ="/druid/index.html"></iframe>
			
		</div>
 		
 

		<!-- /.content-wrapper -->
		<#include "/layout/admin/footer.ftl">
		<!-- Control Sidebar -->

		<@nav.controlBar></@nav.controlBar>
		<div class="control-sidebar-bg"></div>
	</div>
</body>
<@inc.script> </@inc.script>
</html>
