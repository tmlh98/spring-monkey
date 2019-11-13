docker build -t sm:test .
docker rm sm
docker stop sm 
docker run -d -p 8888:8888  --name=sm sm:test
