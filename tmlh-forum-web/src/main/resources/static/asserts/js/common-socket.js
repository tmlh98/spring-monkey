var  socket = new WebSocket("ws://www.tmlh.xyz/websocket");

socket.onerror= err => {           
	console.log(err);
	alert("onerror");
};

socket.onopen = event => {            
	console.log(event);
	alert("onopen");
};

socket.onmessage = mess => {           
	console.log(mess);
	alert("收到数据");
};

socket.onclose = () => {            
	console.log("连接关闭");
};        
        
function sendMessage() {            
	if (socket.readyState === 1)
        socket.send("这是一个测试数据");
	else
        alert("尚未建立websocket连接");
}   
        
