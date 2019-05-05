<#import "/layout/admin/inc.ftl" as inc>
<#import "/layout/admin/nav.ftl" as nav>


<!DOCTYPE html>
<html lang="en">
<@inc.head '文章管理'></@inc.head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<@nav.topbar></@nav.topbar>
		<@nav.menu active='article'></@nav.menu>
 <div class="content-wrapper">
			<section class="content-header">
				<h1>
					文章管理
				</h1>
			</section>
			
			<section class="content">
				<div class="panel panel-default">
				    <div class="panel-heading">
				        查询条件
				    </div>
				    <div class="panel-body form-group" style="margin-bottom:0px;">
				        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">标题：</label>
				        <div class="col-sm-2">
				            <input type="text" class="form-control" name="title" id="search_name"/>
				        </div>
				        <label class="col-sm-2 control-label" style="text-align: right; margin-top:5px">作者：</label>
				        <div class="col-sm-2">
				            <input type="text" class="form-control" name="author" id="search_tel"/>
				        </div>
				        <div class="col-sm-1 col-sm-offset-4">
				            <button class="btn btn-primary" onclick="search_btn()" >查询</button>
				        </div>
				     </div>
				</div>
				<div class="panel panel-default">
					<!-- <div id="toolbar" class="btn-group">
			            <button id="btn_add" type="button" class="btn btn-default">
			                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
			            </button>
			            <button id="btn_edit" type="button" class="btn btn-default">
			                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
			            </button>
			            <button id="btn_delete" type="button" class="btn btn-default">
			                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
			            </button>
			        </div> -->
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
	url : "/admin/article/page",//请求路径
	striped: true,     
	 /* toolbar: '#toolbar',  */               //工具按钮用哪个容器//是否显示行间隔色
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
 
			title : $('input[name="title"]').val(),
			username : $('input[name="author"]').val()
		};
		return temp;
	},
	responseHandler: function(res) {
        return {
            "total": res.result.articlePage.total,//总页数
            "rows": res.result.articlePage.records   //数据
         };
    },
	columns : [ 
		{checkbox: true},
	{
		title : '内容',
		field : 'title',
	}, {
		title : '描述',
		field : 'description',
	}, {
		title : '作者',
		field : 'user.username',
	}, {
		title : '来源',
		field : 'user.source',
	}, {
		title : '发表时间',
		field : 'createTime',
	}, {
		title : '操作',
		field : 'id',
		align: 'center',
		formatter : operation,//对资源进行操作
	} ]
});
 
//删除、编辑操作
function operation(value, row, index) {
	 var htm =  "<button class='btn btn-danger' onclick='deleteArt(" + row.id + ")'>删除</button>";
	return htm;
}


function deleteArt(artId){
	var url = '/admin/article/'+artId;
	deleteModel(artId , url);
}
//查询按钮事件
function search_btn(){
	$('#table').bootstrapTable('refresh', {
		url : '/admin/article/page',
	});
}
</script>
</@inc.script>
</html>
