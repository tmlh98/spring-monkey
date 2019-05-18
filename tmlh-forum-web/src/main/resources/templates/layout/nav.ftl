<#-- 导航 -->
<#macro topbar active>
 <nav class="row clearfix">
	<div class="col-md-12 column" >
		<nav class="navbar navbar-default navbar-inverse navbar-static-top"
			role="navigation">
			<div class="container" style="padding-top: 5px;padding-bottom: 5px">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/"><span class="glyphicon glyphicon-home"></span>&nbsp;Spring Monkey</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#">标签云</a></li>
						<li><a href="https://github.com/tmlh98" target="_blank">Github</a></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div>
						<!-- <button type="submit" class="btn btn-default">Submit</button> -->
					</form>
					
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/article/1">关于</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">发布<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="/user/article/publish">文章</a></li>
								<li><a href="/user/question/publish">问答</a></li>
							</ul></li>
						<#if Session["loginUser"]??>
							<li>
								 <img src="${Session["loginUser"].imageUrl}"  class="img-circle pointer" style="vertical-align:middle;width: 40px; height: 40px"
								 onclick="javascript:window.location.href='/user'" id="user-avatar" />
							</li>
							<#else>
							<li>
								<a href="/user/login" style="color: white;">登陆</a>
							</li>
						</#if>	
						
					</ul>
				</div>
			</div>

		</nav>
	</div>
</nav>
<#nested>

</#macro>




