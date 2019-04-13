function deleteModel(artId , urlStr){
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
				  url: urlStr,
				  success: function(data){
					  if(data.code == 0){
						  operSuccess(data.message);
						  $("#table").bootstrapTable("refresh", { silent: true  });
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