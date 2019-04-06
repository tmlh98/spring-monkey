	function showArts(article , showBox){
		var content = '';
		content +='<div class="list-group-item">';
		content +='	<a href="/user/'+article.user.id+'" target="_self"> ';
		content +='		<img src="'+article.user.imageUrl+'" class="img-thumbnail img-size-50"/>';
		content +='	</a>';
		content +='	 <a href="/article/'+article.id+'" target="_blank" class="font-weight-bold "> ';
		content +='		&nbsp;' + article.title;
		content +='	</a>';
		content +='	<div class="card-text text-dark magin-top">&nbsp;';
		content +='		<a href="/category/2" class="text-white label label-info"> '+article.catalog.name +' </a> ';
		content +='		<span class="font-weight-light text-secondary ">&nbsp;&nbsp;&nbsp;阅读  ' + article.clickNum;
		content +='		</span> · <span>评论 0 ';
		content +='		</span> · <span>喜欢 0 </span> · ';
		content +='		<span>'+ timeJoin(article.updateTime)+'小时前</span> ';
		content +='	</div> ';
		content +='</div> ';
		showBox.append(content);
	}
	function timeJoin(time){
		if(time == null | time == ''){
			return '';
		}
		var year = time.year;
		var monthValue = time.monthValue;
		var dayOfMonth = time.dayOfMonth;
		var hour = time.hour;
		var minute = time.minute;
		var second = time.second;
		return diffTime(year + '/'+monthValue+'/'+dayOfMonth +' ' + hour+':'+''+minute+':'+second);
	}