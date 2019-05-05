<#import "/layout/admin/inc.ftl" as inc>
<#import "/layout/admin/nav.ftl" as nav>


<!DOCTYPE html>
<html lang="en">
<@inc.head '用户评论管理'></@inc.head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<@nav.topbar></@nav.topbar>
		<@nav.menu active='comment'></@nav.menu>
 		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					用户评论管理
				</h1>
			</section>
			
			<section class="content">
				<div class="panel panel-default">
				    <div class="panel-heading">
				        查询条件
				    </div>
				    <div class="panel-body form-group" style="margin-bottom:0px;">
				        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">内容：</label>
				        <div class="col-sm-2">
				              <input type="text" class="form-control" name="content" />
				        </div>
				        <label class="col-sm-2 control-label" style="text-align: right; margin-top:5px">作者：</label>
				        <div class="col-sm-2">
				            <input type="text" class="form-control" name="username" />
				        </div>
				        <div class="col-sm-1 col-sm-offset-4">
				            <button class="btn btn-primary" id="search_btn">查询</button>
				        </div>
				     </div>
				</div>
				<div class="panel panel-default">
					<table id="table"></table>
				</div>
			
			</section>
		</div>
 
 		
 

		<!-- /.content-wrapper -->
		<#include "/layout/admin/footer.ftl">
		<!-- Control Sidebar -->

		<@nav.controlBar></@nav.controlBar>
		<div class="control-sidebar-bg"></div>
	</div>
</body>
<@inc.script>
 <script type="text/javascript">
$('#table').bootstrapTable({
	method : 'get',
	url : "/admin/comment/page",//请求路径
	striped: true,     
	 clickToSelect: true,                //是否启用点击选中行
	pageNumber : 1, //初始化加载第一页
	showColumns: true,                  //是否显示所有的列
	pagination: true,                   //是否显示分页（*）
	sidePagination : 'server',//server:服务器端分页|client：前端分页
	pageSize : 5,//单页记录数
	pageList : [ 5, 10, 20, 30 ],//可选择单页记录数
	showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
	showRefresh : true,//刷新按钮
	queryParams : function(params) {//上传服务器的参数
		console.log(params);
		var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
			currPage : (params.offset / params.limit) + 1, // 每页显示数量
			pageSize : params.limit, // SQL语句起始索引
			//page : (params.offset / params.limit) + 1, //当前页码 
 
			username : $('input[name="username"]').val(),
			content : $('input[name="content"').val()
		};
		return temp;
	},
	responseHandler: function(res) {
        return {
            "total": res.result.commentPage.total,//总页数
            "rows": res.result.commentPage.records   //数据
         };
    },
	columns : [ 
		{checkbox: true},
	{
			title : '序号',
		formatter: function (value, row, index) {
					return index+1;
		}

	},
	{
		title : '作者',
		field : 'username',
	}, {
		title : '内容',
		field : 'content',
		formatter : contentOper
	}, {
		title : '文章地址',
		field : 'articleId',
		formatter : artUrl, 
	}, {
		title : '注册时间',
		field : 'createTime',
	}, {
		title : '操作',
		field : 'id',
		formatter : operation,//对资源进行操作
	} ]
});
 
function artUrl(value, row, index) {
	var url = "<a href='/article/"+row.articleId +"'>spring monkey<a/>";
	return url;
}
//删除、编辑操作
function operation(value, row, index) {
	 var htm =  "<button class='btn btn-danger' onclick='deleteCom(" + row.id + ")'>删除</button>";
	return htm;
}
 
//查询按钮事件
$('#search_btn').click(function() {
	$('#table').bootstrapTable('refresh', {
		url : '/admin/comment/page'
	});
});
function contentOper(value, row, index) {
	var st='';
	if(value.length >= 20){
		st = value.substring(0 , 10);
	}
	localStorage.setItem("content" + index,value);
	st = '<span class="hover-blue pointer"  onclick="show('+index+')"> '+ st +' </span>';
	return st;
}
function show(index){
	swal({
		  text: localStorage.getItem("content"+ index)
		});
}
function deleteCom(artId){
	var url = '/admin/comment/'+artId;
	deleteModel(artId , url);
}

</script>
</@inc.script>
</html>
