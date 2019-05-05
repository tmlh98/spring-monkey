<#import "/layout/admin/inc.ftl" as inc>
<#import "/layout/admin/nav.ftl" as nav>


<!DOCTYPE html>
<html lang="en">
<@inc.head '用户管理'></@inc.head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<@nav.topbar></@nav.topbar>
		<@nav.menu active='user'></@nav.menu>
 
 
 		
 

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
	url : "/admin/user/page",//请求路径
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
			source : $('select[name="source"').val()
		};
		return temp;
	},
	responseHandler: function(res) {
        return {
            "total": res.result.userPage.total,//总页数
            "rows": res.result.userPage.records   //数据
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
		title : '来源',
		field : 'source',
	}, {
		title : '邮箱',
		field : 'email',
	}, {
		title : '粉丝数',
		field : 'fansCount',
	}, {
		title : '文章数',
		field : 'articleCount',
	}, {
		title : '状态',
		field : 'state',
		formatter : formatstatus
	}, {
		title : '最后登陆时间',
		field : 'lastLogin',
	}, {
		title : '注册时间',
		field : 'createTime',
	}, {
		title : '操作',
		field : 'id',
		formatter : operation,//对资源进行操作
	} ]
});
 
//value代表该列的值，row代表当前对象formatter : formatSex,//对返回的数据进行处理再显示
function formatstatus(value, row, index) {
	return value == 'NORMAL' ? "正常" : "冻结";
	//或者 return row.sex == 1 ? "男" : "女";
}
 
//删除、编辑操作
function operation(value, row, index) {
	var htm ;
	var normal = 'NORMAL';
	var freeze = 'FREEZE';
	var name = row.username;
	if(row.state == 'NORMAL'){
	 	htm =  "<button class='btn btn-danger' onclick=\" freezeUser('"+row.id+"','"+name+"','"+freeze+"')\">冻结</button>";
	}else{
	 	htm =  "<button class='btn btn-success' onclick=\" freezeUser('"+row.id+"','"+name+"','"+normal+"')\">解冻</button>";
	}
	return htm;
}
 
//查询按钮事件
$('#search_btn').click(function() {
	$('#table').bootstrapTable('refresh', {
		url : '/admin/user/page'
	});
})

function freezeUser(id,username , status){
	var st = status == 'NORMAL' ? "解冻" : "冻结";
	swal({
		  title: "是否"+st+"用户" + username,
		  icon: "error",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  $.ajax({
				  method: "PUT",
				  url: '/admin/user/freeze/'+id,
				  data : {
					  'statusEnum' : status
				  },
				  success: function(data){
					  if(data.code == 0){
						  operSuccess(data.message);
						  $("#table").bootstrapTable("refresh", { silent: true  });
					  }else{
						  operFail('<strong>冻结失败:</strong> ' + data.message);
					  }
				  },
				  error :function(data){
					  operFail(data.responseJSON.message);
				  }
				});
		  } 
		});
	
}

</script>
</@inc.script>
</html>
