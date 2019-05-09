<#import "/layout/admin/inc.ftl" as inc>
<#import "/layout/admin/nav.ftl" as nav>


<!DOCTYPE html>
<html lang="en">
<@inc.head '后台管理首页'></@inc.head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<@nav.topbar></@nav.topbar>
		<@nav.menu active='dashboard'></@nav.menu>

		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					统计 
				</h1>
			</section>

			<section class="content">
				<!-- Small boxes (Stat box) -->
				<div class="row">
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-aqua">
							<div class="inner">
								<h3>${loginUserCount}</h3>

								<p>当前在线人数</p>
							</div>
							<div class="icon">
								<i class="ion ion-bag"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-green">
							<div class="inner">
								<h3 >${userCount}</h3>

								<p>网站用户数量</p>
							</div>
							<div class="icon">
								<i class="ion ion-stats-bars"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-yellow">
							<div class="inner">
								<h3 >${homeFlux}</h3>

								<p>网站首页访问量</p>
							</div>
							<div class="icon">
								<i class="ion ion-person-add"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-red">
							<div class="inner">
								<h3>65</h3>

								<p>Unique Visitors</p>
							</div>
							<div class="icon">
								<i class="ion ion-pie-graph"></i>
							</div>
							<a href="#" class="small-box-footer">More info <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
				</div>
				 
										 
										 
 



		</div>

		<!-- /.content-wrapper -->
		<#include "/layout/admin/footer.ftl">
		<!-- Control Sidebar -->

		<@nav.controlBar></@nav.controlBar>
		<div class="control-sidebar-bg"></div>
	</div>
</body>
	<@inc.script></@inc.script>
</html>
