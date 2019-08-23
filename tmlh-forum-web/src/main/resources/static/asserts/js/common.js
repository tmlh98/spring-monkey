function toDateTime(time){
	// 比如需要这样的格式 yyyy-MM-dd hh:mm:ss
	var date = new Date(time);
	Y = date.getFullYear() + '-';
	M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	D = date.getDate() + ' ';
	h = date.getHours() + ':';
	m = date.getMinutes() + ':';
	s = date.getSeconds(); 
	return Y+M+D+h+m+s;
}

function diffTime(startDate) { 
    startDate= new Date(startDate);
    var endDate= new Date();
    var diff=endDate.getTime() + (3600*1000 * 20) - startDate.getTime();//时间差的毫秒数 
        
    //计算出小时数 
    var leave1=diff%(24*3600*1000);    //计算天数后剩余的毫秒数 
    var hours=Math.floor(leave1/(3600*1000)); 
    return hours; 
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



/*===========================================*/
function successNotify(msg){
	$.notify(
		{message:msg},
   		{type: 'success', offset: {
			x :  0 ,
			y : 70
		}}
	);
}
function warningNotify(msg){
	$.notify(
			{message:msg},
				{type: 'warning',offset: {
					x :  0 ,
					y : 70
				}}
	);
}
function warningNotify(msg ,url){
	$.notify({
	 message:msg,
		url: url,
 	},
{type: 'warning',offset: {
	x :  0 ,
	y : 70
}});
}
			
function infoNotify(msg){
	$.notify(
		{message:msg},
		{
			type: 'info' ,
			offset: {
				x : 0 ,
				y : 70
			}
		}
	);
}
			
function dangerNotify(msg){
	$.notify(
		{message:msg},
		{type: 'danger',offset: {
			x :  0 ,
			y : 70
		}}
	);
}
function errorHandler(message){
	dangerNotify(message);
}

//判断字符是否为空的方法
function isEmpty(obj){
    if(typeof obj == "undefined" || obj == null || obj == ""){
        return true;
    }else{
        return false;
    }
}