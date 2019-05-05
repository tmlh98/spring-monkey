<#-- 导航 -->
<#macro topbar active>
<header class="main-header">
	<!-- Logo -->
	<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>管理</b></span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>Spring</b>Monkey</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">

				<!-- Notifications: style can be found in dropdown.less -->
				<li class="dropdown notifications-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 10 notifications</li>
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu">
								<li><a href="#"> <i class="fa fa-users text-aqua"></i>
										5 new members joined today
								</a></li>
								<li><a href="#"> <i class="fa fa-warning text-yellow"></i>
										Very long description here that may not fit into the page and
										may cause design problems
								</a></li>
								<li><a href="#"> <i class="fa fa-users text-red"></i> 5
										new members joined
								</a></li>
								<li><a href="#"> <i
										class="fa fa-shopping-cart text-green"></i> 25 sales made
								</a></li>
								<li><a href="#"> <i class="fa fa-user text-red"></i>
										You changed your username
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">View all</a></li>
					</ul></li>


				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
						<img src="/webjars/AdminLTE/2.3.8/dist/img/user2-160x160.jpg"
						class="user-image" alt="User Image "> <span
						class="hidden-xs">管理员</span>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img
							src="/webjars/AdminLTE/2.3.8/dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image">

							<p>
								Alexander Pierce - Web Developer <small>Member since
									Nov. 2012</small>
							</p></li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<a href="/logout" class="btn btn-default btn-flat">Sign out</a>
							</div>
						</li>
					</ul></li>

				<!-- Control Sidebar Toggle Button -->
				<li><a href="#" data-toggle="control-sidebar"><i
						class="fa fa-gears"></i></a></li>
			</ul>
		</div>
	</nav>
</header>  
  
  
  
<#nested>
</#macro>




<#macro menu active>
<aside class="main-sidebar" >
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
      
      	<li class="
      	<#if active == 'dashboard'>active treeview
      		<#else>treeview
      	</#if>
      	">
          <a href="/admin/main">
            <i class="fa fa-dashboard"></i> <span>仪表盘</span>
          </a>
        </li>
      	
      	
        <li class="
      	<#if active == 'user'> active treeview 
      		<#else> treeview 
      	</#if> ">
          <a href="/admin/user">
            <i class="fa  fa-user-o"></i> <span>用户管理</span>
          </a>
        </li>
        <li
        class=" <#if active == 'article'> active treeview 
      		<#else> treeview 
      	</#if>
      	">
          <a href="/admin/article">
            <i class="fa fa-book"></i> <span>文章管理</span>
          </a>
        </li>
        <li class="
      	<#if active == 'comment'> active treeview 
      		<#else> treeview 
      	</#if>
      	">  
          <a href="/admin/comment">
            <i class="fa fa-commenting-o"></i> <span>评论管理</span>
          </a>
        </li>
        <li class="
      	<#if active == 'log'> active treeview 
      		<#else> treeview 
      	</#if>
      	">  
          <a href="/admin/syslog">
            <i class="fa fa-eye"></i> <span>日志管理</span>
          </a>
        </li>
        <li 
        class="
      	<#if active == 'system'> active treeview 
      		<#else> treeview 
      	</#if>
      	">  
          <a href="#">
            <i class="fa fa-cog"></i> <span>系统管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu" style="display: block;">
            <li><a href="/admin/druid"><i class="fa fa-database"></i> 数据源监控</a></li>
            <li><a href="/admin/swagger"><i class="fa fa-circle-o"></i> 接口测试</a></li>
          </ul>
          
        </li>
        
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
</#macro>

<#macro controlBar>
<aside class="control-sidebar control-sidebar-dark" >
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
         
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
           
           
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Back End Framework
                <span class="label label-primary pull-right">68%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">

          <h3 class="control-sidebar-heading">Chat Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Show me as online
              <input type="checkbox" class="pull-right" checked>
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Turn off notifications
              <input type="checkbox" class="pull-right">
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Delete chat history
              <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
            </label>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
</#macro>

