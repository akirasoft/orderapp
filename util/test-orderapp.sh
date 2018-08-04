#!/bin/bash
curl \
   --header "Content-type: application/json" \
   --request POST \
   --data '{"productId": "123456789"}' \
   http://${1}/orders?createaccount=true&name=xyz&type=PLAT
