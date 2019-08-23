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
		content +='		</span> · <span>评论 '+article.commentCount+' &nbsp; · ';
		content +='		<span>'+ getdays_(article.createTime)+'小时前</span> ';
		content +='	</div> ';
		content +='</div> ';
		showBox.append(content);
	}
	
	function getInervalHour( date) {
		var startDate = new Date();
		var endDate = new Date(date.replace("-","/"));
        var ms = startDate.getTime() - endDate.getTime();
        if (ms < 0) return 0;
        return Math.floor(ms/1000/60/60);
    }
	
	function getdays_(date){
		var time ='';
		var day = Math.floor(getInervalHour( date)/24);
		if(day > 1){
			time += day + '天';
		}
		return time + (getInervalHour( date)%24);
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
	
	
	
	
	
function showHead( showBox){
	var content = '';
	content +='<div class="panel-heading" >';
	if(showBox.attr("title") == 'art'){
		content +='	<i class="fa fa-book  fa-1x font-sty" aria-hidden="true">&nbsp;文章</i>';
	}else{
		content +='	<i class="fa fa-book  fa-1x font-sty" aria-hidden="true">&nbsp;问答</i>';
	}
	content +='</div>';
	showBox.append(content);
}	
function meShowArts(article , showBox){
	var content = '';

	content +='<div class="panel-body border-bootom">';
	content +='	 <div class="pull-right"> ';
	content +='	 <button type="button" class="btn btn-info" onclick=editArt('+article.id+')> 编辑 </button>';
	content +='	 <button type="button" class="btn btn-danger" onclick=deleteArt('+article.id+ ',this)> 删除 </button>';
	content +='	 </div> ';
	content +='	 <a href="/article/'+article.id+'" target="_blank" class="font-weight-bold-15 "> ';
	content +='		&nbsp;' + article.title;
	content +='	</a>';
	content +='	<div class="card-text text-dark magin-top">&nbsp;';
	content +='		<a href="#" class="text-white label label-info"> '+article.catalog.name +' </a> ';
	content +='		<span class="font-weight-light text-secondary ">&nbsp;&nbsp;&nbsp;阅读  ' + article.clickNum;
	content +='		</span> · <span>评论 '+ article.commentCount;
	content +='		· <span>'+ getInervalHour(article.createTime)+'小时前</span> ';
	content +='	 </div> ';
	content +='	</div> ';

	showBox.append(content);
}
	
function appleMsgList(message){
	var content = '';
	content +='<div class="panel-body">';
	content +='	<a href="/user/'+message.sender+'" target="_self"> ';
	content +='		<img src="'+message.senderImageUrl+'" class="img-thumbnail img-size-50"/>';
	content +='	</a>';
	content += message.detail;
	content +='</div> ';
	return content;
}	
	
	
	
	
	
	
	
	
	
	
	