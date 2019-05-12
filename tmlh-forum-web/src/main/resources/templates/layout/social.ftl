<div class="row">
	<div class="col-md-6">
		<div class="panel panel-default border-none">
			<div class="panel-heading background-color-none">
				<div class="text-dark">
					<strong> 关注 </strong> <span class="magin-left-20">
						${followList?size} </span>
				</div>
			</div>
			<div class="panel-body  border-none">
				<#list followList as follow>
					<a href="/user/${follow.userId}">
						<img src="${follow.imageUrl}" class="img-size-50 img-thumbnail">
					</a>
				</#list>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="panel panel-default  border-none">
			<div class="panel-heading background-color-none">
				<div class="text-dark">
					<strong> 粉丝 </strong> <span class="magin-left-20">
						${fansList?size} </span>
				</div>
			</div>
			<div class="panel-body  border-none">
				<#list fansList as fans>
					<a href="/user/${fans.userId}">
						<img src="${fans.imageUrl}" class="img-size-50 img-thumbnail">
					</a>
				</#list>
			</div>
		</div>
	</div>
</div>
