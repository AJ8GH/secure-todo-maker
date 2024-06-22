#!/bin/zsh

BASE_URL='localhost:8080/todo'
TOKEN_ENDPOINT='/v1/token'
TOKEN_URL="$BASE_URL$TOKEN_ENDPOINT"

endpoint="$1"
url="$BASE_URL$endpoint"
token=$(curl "$TOKEN_URL")

curl --oauth2-bearer "$token" "$url"
