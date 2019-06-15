<#import "./layout/inc.ftl" as inc>
<#import "./layout/nav.ftl" as nav>
<#import "./layout/message-js.ftl" as message>

<!DOCTYPE html>
<html lang="en">
<@inc.head "${Session['loginUser'].username}">
</@inc.head>
<body>
	<@nav.topbar active='default'>
	</@nav.topbar>
 
 <div class="container">

		<div class="row clearfix" style="margin-top: 25px">
			<div class="col-md-2 column">
				<!-- 选项卡菜单-->
				<ul id="myTab" class="nav nav-pills nav-stacked" role="tablist">
				    <li class="active">
				    	<a href="#bulletin" role="tab" data-toggle="pill"> 个人信息    </a>
				     </li>
				    <li><a id="me-arts" href="#art-list" role="tab" data-toggle="pill">我的文章</a></li>
				    <li><a id="me-question" href="#question-list" role="tab" data-toggle="pill">我的提问</a></li>
				    <li><a id="me-message" href="#welfare" role="tab" data-toggle="pill">消息通知</a></li>
				</ul>
			</div>

			<div class="col-md-10 column">
					
				<!-- 选项卡面板 -->
				<div id="myTabContent" class="tab-content">
				    <div class="tab-pane fade in active" id="bulletin"  style="border:none !important;">
				    	<!-- 作者信息 -->
						<div class="panel  panel-primary" style="border:none !important;">
							<div class="panel-heading">
								<h4 class="magin-top-40" >${Session['loginUser'].username}</h4>
								<a href="user/${Session['loginUser'].id}"> <img class="img-circle" src="${Session['loginUser'].imageUrl}"
									style="position: absolute; width: 70px; height: 70px; right: 20px; top: 30px;margin-right: 20px" />
								</a>
							</div>
							<div class="panel-body magin-top-30">
								 <div class="col-md-6">
								 	<ul class="list-group">
									  <li class="list-group-item font-weight-bold-18"  style="border: none;">
									  	<i class="fa fa-envelope" aria-hidden="true">&nbsp; 邮箱</i>
									  	<span id="email-span" class="color-hui-2 font-size-13 magin-left-20" >${Session['loginUser'].email}</span>
									  </li>
									  <li class="list-group-item font-weight-bold-18"  style="border: none;">
									  	<i class="fa fa-pencil" aria-hidden="true">&nbsp; 签名</i>
									  	<span  id="signature-span" class="color-hui-2 font-size-13 magin-left-20" ">${Session['loginUser'].signature}</span>
									  </li>
									  <li class="list-group-item font-weight-bold-18"  style="border: none;">
									  	<i class="fa fa-paw" aria-hidden="true">&nbsp; 来源</i>
									  	<span class="color-hui-2 font-size-13 magin-left-20">${Session['loginUser'].source}</span>
									  </li>
									  <li class="list-group-item font-weight-bold-18"  style="border: none;">
									  	<i class="fa fa-exclamation-circle" aria-hidden="true">&nbsp; 主页</i>
									  	<span class="color-hui-2 font-size-13 magin-left-20" ><a href='${Session['loginUser'].profileUrl}'>${Session['loginUser'].profileUrl}</a></span>
									  </li>
									</ul>
								 </div>
								 <div class="col-md-6">
								 	
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
												<strong>回复</strong>
											</p>
											<p class="text-center" >${commentCount}</p>
										</div>
									</div>
								 	
								 	
								 </div>
								 
							</div>
							
							<#include "/layout/social.ftl">
							<div class="row magin-top-10 padding-bottom-20">
								 <div class="col-md-6">
								 	<button class="btn btn-info btn-sm pull-right"  data-toggle="modal" data-target="#myModal">编辑资料</button>
								 </div>
								 <div class="col-md-6">
								 <div>
								  	<button class="btn btn-danger btn-sm" onclick="javascript:window.location.href='/logout'">退出登陆</button>
								  </div>
								 </div>
							</div>
							
						</div>
				    	
				    </div>
				    <div class="tab-pane fade" id="art-list">
				    	<div class="panel panel-default"  title="art">
						  <div class="panel-heading" >
						    <i class="fa fa-book  fa-1x font-sty" aria-hidden="true">&nbsp;文章</i>
						  </div>
						 
						</div>
				    </div>
				    <div class="tab-pane fade" id="question-list">
				    	<div class="panel panel-default"  title="question">
						  <div class="panel-heading" >
						    <i class="fa fa-book  fa-1x font-sty" aria-hidden="true">&nbsp;问答</i>
						  </div>
						</div>
				    </div>
				    
				    
				    <div class="tab-pane fade" id="welfare">
				    	<div id="messageBox" class="panel panel-default"  title="question">
						</div>
				    </div>
				</div>
				 
			</div>



		</div>
	</div>
	
	<!--modal  -->	
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">编辑资料</h4>
      </div>
      <div class="modal-body">
        
        	  <div class="form-group">
			    <label for="exampleInputEmail1">邮箱</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email"/>
			  </div>
        	  <div class="form-group">
			    <label for="exampleInputEmail1">个性签名</label>
			    <textarea class="form-control" id="signature" rows="3" placeholder="这个家伙很懒，什么都没留下..."></textarea>
			  </div>
        
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="update()">确认</button>
      </div>
    </div>
  </div>
</div>

</body>
<@inc.script>
 <script src="/asserts/js/apple-data.js"></script>
<script src="/webjars/sweetalert/2.1.0/sweetalert.min.js"></script>
<script src="/asserts/admin/js/swal-common.js"></script>
<script type="text/javascript">
var id =  ${Session['loginUser'].id} ;
$(function(){
	$('#me-arts').click(function(){
		getArticlePage(1 ,'ARTICLE' , $('#art-list .panel-default'));
	});
	$('#me-question').click(function(){
		getArticlePage(1 ,'QUESTION' , $('#question-list .panel-default'));
	});
	$('#me-message').click(function(){
		getMessage();
		readMessage();
	});
	
});
function readMessage(){
$.ajax({
	  method: "PUT",
	  url: '/user/message/read',
	  success: function(data){
	  
	  }
});
}
function getMessage(){
var st = "";
st += '	<div class="panel-heading" > ';
st += '	<i class="fa fa-lightbulb-o  fa-1x font-sty" aria-hidden="true">&nbsp;消息通知</i>';
st += '  </div>';
$('#messageBox').empty();
$('#messageBox').append(st);

	$.get("/user/message/list",function(data){
		if(data.code == '0'){
			if(data.result.messageList.length > 0){
				
				$.each(data.result.messageList, function(index, message) {
					$('#messageBox').append(appleMsgList(message));
			    });
			}
		}else{
		 dangerNotify(data.message);
	   	}
	});
}
function getArticlePage(currPage , publishType , contentBox){
	$.ajax({
		  method: "GET",
		  url: '/article',
		  data: { 
			  currPage: currPage,
			  pageSize: 100,
			  id : id ,
			  publishType : publishType
			  },
		  success: function(data){
			  if(data.code == '0'){
				var articlePage = data.result.articlePage;
				if(articlePage.records == 0){
					infoNotify('没有更多了!');
				}
				contentBox.empty();
				showHead(contentBox);
				$.each(articlePage.records, function(index, article) {
					meShowArts(article,contentBox);
			    });
				  
			  }else{
				dangerNotify(data.message);
			  }
		  }
		});
}

function update(){
	var email = $('#exampleInputEmail1').val();
	var signature = $('#signature').val();
	$.ajax({
		  method: "PUT",
		  url: '/user/update',
		  data: {
			  signature : signature,
			  email : email
		  },
		  success: function(data){
			  if(data.code == 0){
				  	successNotify("修改成功!!!");
				  	$('#myModal').modal('hide');	
				  	$('#email-span').text(email);
				  	$('#signature-span').text(signature);
			  }else{
			  	dangerNotify('<strong>上传失败:</strong> ' + data.message);
			  }
		  },
		  error :function(data){
			  warningNotify(data.responseJSON.message , '/login');
		  }
		});
}

function deleteArt(artId , obj){
	swal({
		  title: "是否删除",
		  icon: "error",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  $.ajax({
				  method: "DELETE",
				  url: '/user/article/'+artId,
				  success: function(data){
					  if(data.code == 0){
						  operSuccess(data.message);
						  obj.parentNode.parentNode.remove();
					  }else{
						  operFail('<strong>删除失败:</strong> ' + data.message);
					  }
				  },
				  error :function(data){
					  operFail(data.responseJSON.message);
				  }
				});
		  } 
		});
	
}
function editArt(id){
	window.location.href="/user/article/"+id;
}
</script>
</@inc.script>
<@message.messageNotify></@message.messageNotify>

</html>
