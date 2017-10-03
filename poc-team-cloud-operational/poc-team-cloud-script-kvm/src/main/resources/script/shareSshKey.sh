#!/bin/bash
for ip in `cat listOfHosts`; do
    ssh-copy-id -i ~/.ssh/id_rsa.pub $ip
done
