#!/bin/bash
i="0"

while [ $i -lt 10000 ]
do
    curl --fail --silent --show-error \
        --header "Content-type: application/json" \
        --request POST \
        --data '{"productId": "123456789"}' \
        http://${1}/orders?createaccount=true&name=xyz&type=PLAT 
    sleep 1
    i=$[$i+1]
done
