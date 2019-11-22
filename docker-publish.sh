CONTAINER_NAME=forum

docker build -t $CONTAINER_NAME:latest .

is_exist=`docker ps | grep $CONTAINER_NAME` 
if [ ! -z "$is_exist" ] ;then	         
	docker stop $CONTAINER_NAME
fi

is_exist=`docker ps -a | grep $CONTAINER_NAME`  

if [ ! -z "$is_exist" ] ;then	         
	docker rm $CONTAINER_NAME
fi 



docker run -d -p 80:80 --name=$CONTAINER_NAME --network=bridge-user -t $CONTAINER_NAME:latest
