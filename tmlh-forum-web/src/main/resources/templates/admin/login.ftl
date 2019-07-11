<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>
	
    <link rel="stylesheet" href="/asserts/admin/css/base.css">
    <link rel="stylesheet" href="/asserts/admin/css/style.css">

  
</head>
<body>

    <div class="bg"></div>
    <div class="container">
        <div class="line bouncein">
            <div class="xs6 xm4 xs3-move xm4-move">
                <div style="height:150px;"></div>
                <div class="media media-y margin-big-bottom">
                </div>
                <form action="index.html" method="post">
                    <div class="panel loginbox">
                        <div class="text-center margin-big padding-big-top">
                            <h1>Spring Monkey后台管理</h1>
                        </div>
                        <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input type="text" class="input input-big" name="name" id="username" placeholder="登录账号" />
                                    <span class="icon icon-user margin-small"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input type="password" class="input input-big" name="password" id="password"  placeholder="登录密码" />
                                    <span class="icon icon-key margin-small"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="field">
                                    <input id="vcode" type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" />
                                    <img src="/code/image" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onClick="this.src=this.src+'?'">
                                </div>
                            </div>
                        </div>
                        <div style="padding:30px;">
                            <input type="button" id="button" class="button button-block bg-main text-big input-big" value="登录" onclick="login()"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>


<script src="https://cdn.jsdelivr.net/npm/jquery@2.1.1/dist/jquery.min.js"></script> 
<script>window.jQuery || document.write(unescape("%3Cscript src='/webjars/jquery/2.1.1/jquery.min.js' type='text/javascript'%3E%3C/script%3E"))</script>

<!-- <script src="/webjars/jquery/2.1.1/jquery.min.js"></script>  -->
<script src="/webjars/sweetalert/2.1.0/sweetalert.min.js"></script> 
<script type="text/javascript">
function login() {
	var username = $("#username").val();
	var password = $("#password").val();
	var vcode = $("#vcode").val();
	$.ajax({
		type : "POST",
		data : {
			"username" : username,
			"password" : password,
			"imageCode" : vcode 
		},
		dataType : "json",
		url : "/security/login",
		success : function(result) {
			if (result.code == '0') {
				swal({
					  icon: "success",
					  title : "登录成功，进入系统！"
				}).then((value) =>{
					window.location.href = "/admin/main";
				});
			} else {
				swal({
					  icon: "error",
					  title : result.message
				});
			}
		}
	});
}

</script>






</html>