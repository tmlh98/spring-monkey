<#import "/layout/inc.ftl" as inc>
<#import "/layout/nav.ftl" as nav>
<#import "./layout/message-js.ftl" as message>


<#macro artAdd>
<!DOCTYPE html>
<html lang="en">
<@inc.head '发布'>
<style type="text/css">
     .w-e-text-container{
   	 	min-height: 300px !important;
   	 	height:auto !important;
	}
	#editor{
		min-height: 300px;
		height:auto !important;
	}
	.w-e-toolbar{
		background-color: #ffffff !important;
	}
</style>
</@inc.head>
<body>
	<@nav.topbar active='default'>
	</@nav.topbar>
 	<div class="container">

		<div class="row clearfix" style="margin-top: 25px">
			<div class="input-group">
				<span class="input-group-btn"> 
				<select id="catalog-selected" class="selectpicker show-tick form-control" style=" width: 180px">
			
					<#list catalogList as catalog>
						<#if catalog.id==Request.article.catalog.id>
							<option value="${catalog.id}" selected="selected" >${catalog.name}</option>
							<#else>
							<option value="${catalog.id}">${catalog.name}</option>
						</#if>
					</#list>
				</select>
				</span> <input id="title" type="text" class="form-control" placeholder="标题" value="${Request.article.title}"/> <span
					class="input-group-btn">
					<button class="btn btn-default " type="button" onclick="save()">发布</button>
				</span>
			</div>
			    <!-- 文章编辑器组件 -->
		    <div>
		        <p class="text-success">友情提示：编辑器支持图片拖动上传或者复制粘贴上传~</p>
		        <div id="editor" >
		        	<#nested>
		        </div>
		    </div>
		</div>
	</div>
 
 
	<#include "/layout/footer.ftl">
</body>
<@inc.script>
 <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
 <script src="/webjars/wangEditor/3.1.1/release/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor;
        var editor = new E('#editor');
        editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
        editor.create();
        
        
        function save() {
        	var icontent = editor.txt.text();
        	if(icontent.length == 0 || icontent.trim() == ''){
        		dangerNotify('请输入内容!');
        		return;
        	}
        	
        	var catalogId = $('#catalog-selected').val();
        	var title = $('#title').val();
        	var content = editor.txt.html();
        	var publishType = '${Request.publishType}';
        	var data = { 
      			  "catalog": {
    				  "id" : catalogId
    			  },
    			  "title": title,
    			  "publishType": publishType,
    			  "content": content
    			  };
        	$.ajax({
        		  method: "POST",
        		  url: '/user/article/publish',
        		  data: {
        			  articleStr : JSON.stringify(data)
        		  },
        		  success: function(data){
        			  if(data.code == 0){
       				  	 $.notify({
       				  		 message:'提交成功,点击查看',
       				  			url: "/article/" + data.result.articleId,
       				  			target :'_self'
       				  	 	},
       		        		{type: 'success'});
        			  }else{
       				  	 $.notify({message:'<strong>上传失败:</strong> ' + data.message},
       		        		{type: 'danger'});

        			  }
        		  },
        		  error :function(){
        			  dangerNotify('服务器异常!');
        		  }
        		});
        }
        
    </script>
</@inc.script>
<@message.messageNotify></@message.messageNotify>

</html>
</#macro>