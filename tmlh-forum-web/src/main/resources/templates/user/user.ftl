<#import "./layout/inc.ftl" as inc>
<#import "./layout/nav.ftl" as nav>
<#import "./layout/message-js.ftl" as message>

<!DOCTYPE html>
<html lang="en">
<@inc.head '${user.username}'>
</@inc.head>
<body>
	<@nav.topbar active='default'>
	</@nav.topbar>
 <div class="container">

		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="tab-pane fade in active" id="bulletin">
					<!-- 作者信息 -->
					<div class="panel  panel-primary">
						<div class="panel-heading">
							<h4 class="magin-top-40" >${user.username}</h4>
							<p class="pull-right" id= "relation">
							<#if isFollow>
								<button id="unfolwer" class="btn  btn-success" >取消关注</button>
								<#else>
								<button id="folwer" class="btn  btn-success"  >+关注</button>
							</#if>
							</p>
							<a href="#"> <img
								class="img-circle img-size-70"
								 src="${user.imageUrl}"
								style="position: absolute; z-index: 1000; right: 50%; left: 47%; top: 50px;" />
							</a>
						</div>
						<div class="panel-body"  style="width: 100%">
							<p class="text-center magin-top-50 color-hui-2" style="font-weight: 700 !important;"> 
								<span >${user.detail}</span> <span>${user.source}</span>
							</p>
							<p class="text-center magin-top-20"  style="font-weight: 700 !important;">
								<span >${user.signature}</span> 
							</p>
						</div>
						
						<div  class="panel-body" >
							<div class="row">
								<div class="col-md-4 col-md-offset-5">
													
									<ul id="myTab" class="nav nav-pills" role="tablist">
									    <li  class="active"><a href="#art-list" role="tab" data-toggle="pill">文章</a></li>
									    <li><a href="#forum" role="tab" data-toggle="pill">问答</a></li>
									    <li><a href="#security" role="tab" data-toggle="pill">社交</a></li>
									</ul>
								
								</div>
							</div>
						</div>
					</div>

				</div>
				
				
				<div>
				
				
					<!-- 选项卡面板 -->
					<div id="myTabContent" class="tab-content">
					    <div class="tab-pane fade in active" id="art-list">
					    	<p id="art-box"></p>
							<button id="add-article" type="button" class="btn btn-default btn-primary btn-block">点击载入</button>
						</div>
					    <div class="tab-pane fade" id="forum">
					    	<p id="question-box"></p>
							<button id="add-question" type="button" class="btn btn-default btn-primary btn-block">点击载入</button>
					    </div>
					    <div class="tab-pane fade" id="security">
					    	<#include "/layout/social.ftl">
					    </div>
					</div>
				</div>


				
			</div>



		</div>
	</div>
 
 
	<#include "./layout/footer.ftl">
</body>
<@inc.script>
 <script src="/asserts/js/apple-data.js"></script>
<script type="text/javascript" >
	var id = ${user.id};
	var current = 1; 
	$(function(){
		getArticlePage(current  ,'ARTICLE');
		$('#add-article').click(function(){
			getArticlePage(current ,'ARTICLE');
		});
		$('#add-question').click(function(){
			getArticlePage(current ,'QUESTION');
		});
		$("#relation").on("click"," #folwer",function(){
			folwer();
		}); 
		$("#relation").on("click"," #unfolwer",function(){
			unfolwer();
		}); 
		
	});
	
	function getArticlePage(currPage , publishType){
		$.ajax({
  		  method: "GET",
  		  url: '/article',
  		  data: { 
  			  currPage: currPage,
  			  pageSize: 10,
  			  id : id ,
  			  publishType : publishType
  			  },
  		  success: function(data){
  			  if(data.code == '0'){
  				var articlePage = data.result.articlePage;
  				if(articlePage.records == 0){
  					infoNotify('没有更多了!');
  				}
  				$.each(articlePage.records, function(index, article) {
  					showArts(article,$('#art-box'));
  					current = articlePage.current + 1;
  			    });
  				  
  			  }else{
  				dangerNotify(data.message);
  			  }
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
  				$('#relation').html('<button id="unfolwer" class="btn  btn-success ">取消关注</button>');
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
  				$('#relation').html('<button id="folwer" class="btn  btn-success">+关注</button>');
  			  }else{
  				dangerNotify(data.message);
  			  }
  		  }
  		});
	}
	

</script>
</@inc.script>
<@message.messageNotify></@message.messageNotify>

</html>
