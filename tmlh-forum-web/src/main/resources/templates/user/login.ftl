<#import "./layout/inc.ftl" as inc>
<#import "./layout/nav.ftl" as nav>

<!DOCTYPE html>
<html lang="en">

<@inc.head '授权登陆'></@inc.head>


<body>

	<@nav.topbar active='default'></@nav.topbar>
	
 <div class="container">
		<div class="row clearfix" style="margin-top: 25px">
			<div class="text-center">

				<h3 class="row">授权登录</h3>
				<div class="ui horizontal"
					style="font-size: 14px; color: #7d7d7d; border-bottom: 1px solid #7d7d7d; margin-bottom: 20px; padding-bottom: 20px">
					一步之遥，成为社区里的你</div>

				<div class="mt-4  border-secondary pt-4 px-4">
					<a href="http://www.tmlh.xyz/auth/qq" style="text-decoration-line: none"> <img
						src="http://springforall.ufile.ucloud.com.cn/images/icon/qq.svg"
						alt="" style="max-width: 64px; max-height: 64px"/>
					</a> 
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="http://www.tmlh.xyz/auth/github" class="ml-4"> <img
						src="http://springforall.ufile.ucloud.com.cn/images/icon/github.svg"
						alt="" style="max-width: 64px; max-height: 64px"/>
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="http://www.tmlh.xyz/auth/gitee" class="ml-4">
					 	<img src="/images/gitee.png"
						alt="" style="max-width: 64px; max-height: 64px;"/>
					</a>
				</div>

				<h4 class="row" style="font-size: 16px; color: #7d7d7d; padding-top: 30px">
					扫描加站长QQ</h4>
				<div class="mt-4 border-secondary pt-4 px-4"
					style="text-align: center">
					<a href="tencent://AddContact/?fromId=45&fromSubId=1&subcmd=all&uin=1720213210&website=www.oicqzone.com" style="text-decoration-line: none"> <img
						src="https://tmlh98.gitee.io/image-repository/img/spring_monkey/qrcode_1.jpg"
						alt="" style="max-width: 200px; max-height: 200px"/>
					</a>

				</div>

			</div>
		</div>
	</div>
 
 
</body>
<@inc.script>
 
</@inc.script>
</html>
