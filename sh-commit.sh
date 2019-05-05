#!/bin/bash

msg=$1

if [ ! -n "$msg" ]; then
	msg="."
fi

git add -A
echo "------------(git add)------------"

git commit -m "$msg"
echo "-------------(git commit)--------"

git push 
echo "-------------(git push)----------"

echo "complete."
