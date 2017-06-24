#!/bin/bash

# the hostname of your VM
hostName=$1

# WARNING: if you try to create a VM using the existing one, it will be destroyed
#sudo virsh destroy $hostName
#sudo virsh undefine $hostName

# the RAM size of your VM
ramSize=$2
# the virtual CPU number of your VM
cpuNumber=$3
# the DISK size of your VM
diskSize=$4
# the bridge attached to the vm
vmEthernet=$5
# create your VM using the above arguments
virt-install --network bridge:$vmEthernet \
--name $hostName \
--ram=$ramSize \
--vcpus=$cpuNumber \
--disk path=/home/ptcadm/vmDisks/$hostName.img,size=$diskSize \
--graphics none \
--location=/var/lib/libvirt/images/CentOS-7-x86_64-Minimal-1611.iso \
--extra-args="console=tty0 console=ttyS0,115200"
