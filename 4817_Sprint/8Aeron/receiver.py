import socket
import sys

host = "localhost"
#host = "172.20.0.1"

port = 50030
#s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM | socket.SO_REUSEADDR)
s = socket.socket(
    socket.AF_INET, socket.SOCK_STREAM)
s.bind((host, port))
s.listen(2)
print "waiting on port:", port
while 1:
    #data, addr = s.recvfrom(1024)
    data, addr = s.accept()
    print data
