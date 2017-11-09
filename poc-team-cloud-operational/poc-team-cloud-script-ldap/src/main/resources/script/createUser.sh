#!/bin/bash

echo "Enter the default password:"
read -s default_pass

echo "Enter the root password of the target VM:"
read -s pass_root

while IFS='-' read ip name; do
        nohup sshpass -p $pass_root ssh root@$ip useradd $name -m -p `openssl passwd $pass` & > user_creation.log >> /dev/null
done < users.txt