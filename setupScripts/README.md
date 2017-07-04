Guide for KVM environment prerequisites on Ubuntu/CentOS server.
 
 INSTALLING KVM (minimal : without graphical interface)
 
To install kvm, run the script istallKvmOnLinux.sh located in poc-team-cloud/setupScripts.
If you are installing on ubuntu server, run the script with the argument "ubuntu".
If you are installing on Centos / RedHat server, run the script without argument
 
CREATE A VIRTUAL NETWORK
 
You need to attach your VMs or virtual network interface or virtual bridge. We are using virtual bridge in this tuto. You can easily create a bridge with the bridge management command "brctl" 
	a) create the bridge bridge_name
 
	$ brctl addbr bridge_name
 
	b) set up the bridge bridge_name with:
		-	network_id: xxx.yyy.zzz.abc (this @ip is the gateway of this virtual network)
		-	subnet_mask: XXX.YYY.ZZZ.ABC
 
	$ ifconfig bridge_name network_id/subnet_mask up
 
CONFIGURE ETHERNET TO FORWARD TRAFFIC
 
- make sure the content of the file /proc/sys/net/ipv4/ip_forward is 1
 
	 $ echo "1" > /proc/sys/net/ipv4/ip_forward
 
 
- make sure the main ethernet interface can provide NAT service:
 
	$  iptables -t nat -A POSTROUTING -o eth0 -j MASQUERADE
 
CREATION OF A VIRTUAL MACHINE
 
To create a vm, run the script createKvmHost.sh located in poc-team-cloud/setupScripts, with the following arguments:
 
the hostname of the vm
the size of RAM
vCPU number
virtual hard disk size
the name of virtual bridge
 
Ex: poc-team-cloud/setupScripts$ ./createKvmHost.sh.sh ptc0 1024 2 20 virbr1
this shows how to create a vm with the following features:
hostname: ptc0
1 GB of RAM
2 vCPUs
20 GB of virtual hard disk 
attached to virtual bridge virbr1
 
TRAFFIC REDIRECTION
This section describes how to redirect inbound traffic from a main server to its hosted virtual machines.
next
