#!/bin/bash

echo "Enter the default password:"
read -s pass

while IFS=':' read ip name; do
        echo "Creating $name account"
        ssh root@$ip useradd $name -m -p `openssl passwd $pass` -s /bin/bash
        echo "User $name created"
done < users.txt
