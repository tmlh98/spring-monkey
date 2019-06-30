<#import "/layout/inc.ftl" as inc>
<#import "/layout/nav.ftl" as nav>
<#import "./layout/message-js.ftl" as message>

<!DOCTYPE html>
<html lang="en">
<@inc.head '${article.title}'>
<link rel="stylesheet" href="/asserts/css/article-content.css" />
</@inc.head>
<body>
	<@nav.topbar active='default'></@nav.topbar>
 	<div class="container">
		<div class="row clearfix">

			<div class="col-md-9 column">

				<div class="list-group">
					<div class="list-group-item active">
						<p>
							<span >${article.title}</span>
						</p>
					</div>
					<div class="list-group-item">

						<div class="card-body  padding-top  padding-bottom">
							<b class="d-inline-block pull-left">
								<span class="glyphicon glyphicon-time color-bff" aria-hidden="true"></span>
								&nbsp;<span>
									${article.createTime?number_to_datetime}
								</span></b> 
								
							<b class="d-inline-block   magin-left-20">
								<span class="glyphicon glyphicon-user color-bff" aria-hidden="true"></span>&nbsp;
								<span >${article.clickNum}</span>
							</b>
								
							<!-- <b class="d-inline-block ml-3 magin-left-20">
								<span class="glyphicon glyphicon-envelope color-bff" aria-hidden="true"></span>
								&nbsp;<span >${article.clickNum}</span></b> 
							<b class="d-inline-block ml-3 magin-left-20">
								<span class="glyphicon glyphicon-heart color-bff" aria-hidden="true"></span>
								&nbsp;<span >${article.clickNum}</span></b>
							<button class="btn  btn-danger btn-sm pull-right">添加至喜欢</button> -->
						</div>


					</div>

					<div class="list-group-item  hover py-4 pad">
						<div id="article-content" >
							${article.content}
						</div>
					</div>

				</div>

				<div class="list-group" id= "comBox">
					<div class="list-group-item">
					<!-- 	<span class="glyphicon glyphicon-comment color-bff" aria-hidden="true"></span> -->
						<i class="fa fa-comments-o  color-bff" aria-hidden="true">&nbsp; 评论</i> 
					</div>
					
					<#list commentList as comment>
					<div class="list-group-item">
						<div class="row">
							<div class="magin-left-20  pull-left" style="min-width: 50px;min-height: 50px">
								<a href="/user/${comment.userId}"><img  class="img-circle img-size-50 "  alt="" src="${comment.userImageUrl}"/></a>
							</div>
							<div class=" pull-left magin-left-10">
								<p><a href="/user/${comment.userId}"  class="color-black"><strong >${comment.username}</strong></a></p>
								<p>${comment.content}</p>
							</div>
						</div>
						<div class="row">
							<p class="pull-right" >
								<span  class=" color-hui magin-right-25 pointer hover-red" style="font-size: 13px" onclick="removeComment(${comment.id} , this.parentNode)">
									<i class="fa fa-trash-o" aria-hidden="true"> 删除</i>
								</span>
								<span  class=" color-hui magin-right-25 pointer hover-blue" style="font-size: 13px" onclick="addCommentChild(${article.id},${comment.id} , this)">
									<i class="fa fa-comment-o" aria-hidden="true"> 回复</i>
								</span>
							</p>
						</div>
						<!-- 子回复-->
						<#list comment.commentChildList as  child>
						<div class="row" >
							<div class="magin-left-50 border-top">
								<div class="magin-left-20  pull-left  magin-top-20" style="min-width: 40px;min-height: 40px">
									<a href="/user/${child.userId}"><img  class="img-circle img-size-50 "  alt="" src="${child.userImageUrl}"/></a>
								</div>
								<div class=" pull-left magin-left-10 magin-top-20">
									<p><a href="/user/${child.userId}"  class="color-black"><strong >${child.username}</strong></a></p>
									<p >${child.content}</p>
								</div>
							</div>
						</div>
						</#list>
					</div>
					
					</#list>
				</div>
				
				<div  id="editorBox" class="list-group-item">
					<div>
						<div id="comment-toolbar" class="toolbar pull-left" style="width: 90%">
						</div>
				    </div>
				    <p ><button id="comment-save" class="btn btn-default btn-sm"  onclick="saveComment(${article.id},'-1')">提交评论</button> </p>
				    <div id="comment-text" class="text"> <!--可使用 min-height 实现编辑区域自动增加高度-->
				    </div>
				</div>

			</div>

			<div class="col-md-3 column">
				<!-- 作者信息 -->
				<div class="panel  panel-primary">
					<div class="panel-heading">
						<h4 class="magin-top-40" >${article.username}</h4>
						<a href="/user/${article.userId}"> <img class="img-circle" src="${article.imageUrl}"
							style="position: absolute; width: 70px; height: 70px; right: 20px; top: 30px" />
						</a>
					</div>
					<div class="row magin-top-40">
						<div class="col-md-10 column col-md-offset-1">
							<div class="col-md-4">
								<div class="card-body">
									<p class="text-center">
										<strong>文章</strong>
									</p>
									<p class="text-center" >${articleCount}</p>
								</div>
							</div>
							<div class="col-md-4 column">
								<div class="card-body">
									<p class="text-center">
										<strong>问答</strong>
									</p>
									<p class="text-center" >${questionCount}</p>
								</div>
							</div>
							<div class="col-md-4 column">
								<div class="card-body">
									<p class="text-center">
										<strong>粉丝</strong>
									</p>
									<p class="text-center">0</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row magin-top padding-bottom">
						<div class="col-md-10 column col-md-offset-1">
							<div class="col-md-12 column" id="relation">
							<#if isFollow >
								<button id="unfolwer" class="btn btn-success btn-block" >取消关注</button>	
								<#else>
								<button id="folwer" class="btn btn-success btn-block" >+关注</button>
							</#if>		
							</div>
						</div>
					</div>


				</div>
				<!-- 作者文章 -->
				<div class="panel panel-default">
				  <div class="panel-heading">
				    <i class="fa fa-address-book" aria-hidden="true" style="color: #218838;">&nbsp;作者文章 </i>
				  </div>
				  <div class="panel-body">
				  <#list articleList as art>
				  	<p  style="margin-top: 2px">
				  		<a href="${art.id}" style="color: black;">${art.title}</a>
				  	</p>
				  	</#list>
				  </div>
				</div>
				

			</div>





		</div>
	</div>
 
 
	<#include "/layout/footer.ftl">
</body>
<@inc.script>
<script src="/webjars/wangEditor/3.1.1/release/wangEditor.min.js"></script>
<script src="/webjars/sweetalert/2.1.0/sweetalert.min.js"></script>
<script src="https://cdn.bootcss.com/mustache.js/3.0.1/mustache.js"></script>

<script type="text/x-mustache-template" id="commentTemplate">
		<div class="list-group-item">  
			<div class="row">  
				<div class="magin-left-20  pull-left" style="min-width: 50px;min-height: 50px">  
					<a href="/user/{{userId}}"><img  class="img-circle img-size-50 "  alt="" src="{{comment.userImageUrl}}" /></a>  
				</div>  
				<div class=" pull-left magin-left-10">  
					<p><a href="#"  class="color-black"><strong>{{username}}</strong></a></p>  
					<p><span>{{content}}</span></p>  
				</div>  
			</div>  
			<div class="row">  
				<p class="pull-right" > 
					<span  class=" color-hui magin-right-25 pointer hover-red" style="font-size: 13px" onclick="removeComment({{id}} , this.parentNode)"> 
								<i class="fa fa-trash-o" aria-hidden="true"> 删除</i>';
					</span> 
					<span class=" color-hui magin-right-25  pointer hover-blue" style="font-size: 13px" onclick="addCommentChild(${article.id},{{id}})">  
						<i class="fa fa-comment-o" aria-hidden="true"> 回复</i>  
					</span>  
				</p> 
			</div>  
		</div> 
</script>

<script type="text/x-mustache-template" id="commentChildTemplate">
		<div class="row"> 
    	<div class="magin-left-50 border-top">  
    		<div class="magin-left-20  pull-left  magin-top-20" style="min-width: 40px;min-height: 40px"> 
	    			<a href="/user/{{userId}}"><img  class="img-circle img-size-50 "  alt="" src=" {{userImageUrl}} "/></a> 
	    		</div> 
	    		<div class=" pull-left magin-left-10 magin-top-20"> 
	    			<p><a href="/user/{{userId}}"  class="color-black"><strong">{{username}}</strong></a></p> 
	    			<p> {{content}} </p> 
	    		</div> 
	    	</div> 
	    </div> 
	    </div> 
</script>


<script type="text/javascript">
	var id = ${article.userId};
	$("#relation").on("click"," #folwer",function(){
		folwer();
	}); 
	$("#relation").on("click"," #unfolwer",function(){
		unfolwer();
	}); 
    var E = window.wangEditor
    var editor1 = new E('#comment-toolbar', '#comment-text')  // 两个参数也可以传入 elem 对象，class 选择器
 	// 自定义菜单配置
    editor1.customConfig.menus = [
        'head',
        'bold',
        'italic',
        'underline',
        'emoticon',  // 表情
        'image',
        'code'
    ]
    editor1.create();
    
    function saveComment(articleId , comId , text , obj) {
    	var content = editor1.txt.text();
    	var commentId ;
    	if(comId > 0){
    		commentId = comId;
    	}
    	if(!isEmpty(text)){
    		content = text;
    	}
    	
    	if(content.length == 0 || content.trim() == ''){
    		dangerNotify('请输入内容!');
    		return;
    	}
    	if(content.length > 500 ){
    		dangerNotify('评论过长');
    		return;
    	}
    	$.ajax({
    		  method: "POST",
    		  url: '/user/comment/publish',
    		  data: {
    			  articleId : articleId,
    			  content : content , 
    			  commentId : commentId
    		  },
    		  success: function(data){
    			  if(data.code == 0){
   				  	successNotify("评论成功!");
	   				 if(comId > 0){
	   					$(obj.parentNode.parentNode.parentNode).append(Mustache.render($('#commentChildTemplate').html(),data.result.comment))
	   				 }else{
	   					$('#comBox').append(Mustache.render($('#commentTemplate').html(),data.result.comment));
	   				 }
   				 	
   				 	editor1.txt.clear()
    			  }else{
    			  	dangerNotify('<strong>上传失败:</strong> ' + data.message);
    			  }
    		  },
    		  error :function(data){
    			  warningNotify(data.responseJSON.message , '/login');
    		  }
    		});
    }
    
    
	function folwer(){
		$.ajax({
  		  method: "POST",
  		  url: '/user/social/' + id,
  		  success: function(data){
  			  if(data.code == '0'){
  				infoNotify(data.message);
  				$('#relation').html('<button id="unfolwer" class="btn  btn-success btn-block">取消关注</button>');
  			  }else{
  				dangerNotify(data.message);
  			  }
  		  },error:function(data){
  			dangerNotify(data.responseJSON.message );
  		  }
  		});
	}
	function unfolwer(){
		$.ajax({
  		  method: "DELETE",
  		  url: '/user/social/' + id,
  		  success: function(data){
  			  if(data.code == '0'){
  				infoNotify(data.message);
  				$('#relation').html('<button id="folwer" class="btn  btn-success btn-block">+关注</button>');
  			  }else{
  				dangerNotify(data.message);
  			  }
  		  }
  		});
	}
	
	
	
	function addCommentChild(artId ,commentId ,obj){
		swal({ 
			  title: "回复", 
			  buttons: [true, "OK"],
			  content: {
				    element: "input",
				    attributes: {
				      placeholder: "请输入你的回复:",
				      type: "text",
				    },
				  },
			}).then((will ) => {
				  if (will ) {saveComment(artId ,commentId , will , obj);}  
			});
	}
	
	function removeComment(cid , obj){
		swal({
			  title: "是否删除",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				  $.ajax({
					  method: "DELETE",
					  url: '/user/comment/'+cid,
					  success: function(data){
						  if(data.code == 0){
							  infoNotify(data.message);
							  obj.parentNode.parentNode.remove();
						  }else{
							  dangerNotify('<strong>删除失败:</strong> ' + data.message);
						  }
					  },
					  error :function(data){
						  dangerNotify(data.responseJSON.message);
					  }
					});
			  } 
			});
		
	}
</script>
</@inc.script>
<@message.messageNotify></@message.messageNotify>

</html>
