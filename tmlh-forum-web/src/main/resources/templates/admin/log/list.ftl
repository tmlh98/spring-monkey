<#import "/layout/admin/inc.ftl" as inc>
<#import "/layout/admin/nav.ftl" as nav>


<!DOCTYPE html>
<html lang="en">
<@inc.head '日志管理'></@inc.head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<@nav.topbar></@nav.topbar>
		<@nav.menu active='comment'></@nav.menu>
 
 	<div class="content-wrapper">
			<section class="content-header">
				<h1>
					日志管理
				</h1>
			</section>
			
			<section class="content">
				<div class="panel panel-default">
				    <div class="panel-heading">
				        查询条件
				    </div>
				    <div class="panel-body form-group" style="margin-bottom:0px;">
				        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">接口：</label>
				        <div class="col-sm-2">
				              <input type="text" class="form-control" name="url" />
				        </div>
				        <label class="col-sm-2 control-label" style="text-align: right; margin-top:5px">用户：</label>
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
	url : "/sys/log/page",//请求路径
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
			url : $('input[name="url"').val()
		};
		return temp;
	},
	responseHandler: function(res) {
        return {
            "total": res.result.sysLogPage.total,//总页数
            "rows": res.result.sysLogPage.records   //数据
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
		title : '用户',
		field : 'username',
	}, {
		title : '接口',
		field : 'url',
	}, {
		title : '描述',
		field : 'operation',
	}, {
		title : '方法',
		field : 'method',
		formatter : methodOper,
	}, {
		title : '参数',
		field : 'params',
		formatter : paramsOper,
	}, {
		title : 'ip',
		field : 'ip',
	}, {
		title : '执行时间',
		field : 'time',
	}, {
		title : '访问时间',
		field : 'createTime',
	} ]
});
 
//查询按钮事件
$('#search_btn').click(function() {
	$('#table').bootstrapTable('refresh', {
		url : '/sys/log/page'
	});
})
 
function paramsOper(value, row, index) {
	var st='';
	if(value.length >= 10){
		st = value.substring(0 , 10);
	}
	localStorage.setItem("params" + index,value);
	st = '<span class="hover-blue pointer"  onclick="show('+index+')"> '+ st +' </span>';
	return st;
}
function methodOper(value, row, index) {
	var st='';
	if(value.length >= 10){
		st = value.substring(0 , 10);
	}
	localStorage.setItem("method" + index,value);
	st = '<span class="hover-blue pointer"  onclick="showMethod('+index+')"> '+ st +' </span>';
	return st;
}
function show(index){
	swal({
		  text: localStorage.getItem("params"+ index)
		});
}
function showMethod(index){
	swal({
		  text: localStorage.getItem("method"+ index)
		});
}
</script>
</@inc.script>
</html>
