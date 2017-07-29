 #!/bin/bash

    yum update


    RC=$?
    if [ $RC -ne 0 ]
    then
      print "Some error message here"
      exit 1 ## or some other identifying error code
    fi

    yum install -y yum-utils bzip2 bzip2-devel wget curl tar

    RC=$?
    if [ $RC -ne 0 ]
    then
      print "Some other error message here"
      exit 2 ## or some other identifying error code
    fi
