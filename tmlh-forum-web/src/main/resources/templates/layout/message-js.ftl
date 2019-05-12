<#macro messageNotify>
  
<script type="text/javascript">
window.onload=function msgNotify(){
	<#if Session["loginUser"]??>
		$.get("/user/message/count",function(result){
			if(result.result.length > 0){
				$.notify( {message:result.message}, 
					{type: 'info',offset: {
						x :  0 ,
						y : 70
					},delay: 1000 * 60 * 10}
				);
			}
		});
	</#if>	
}
</script>

</#macro>




