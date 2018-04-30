for port in `ps -ef|grep redis|grep cluster |awk '{print $2}'`;
do
    echo "killing process port: $port";
    kill -9 $port
done

cd /usr/local/redis/redis_cluster/7000
rm node*
echo "node 7000 has been stoped."

cd ../7001
rm node*
echo "node 7001 has been stoped."

cd ../7002
rm node*
echo "node 7002 has been stoped."

cd ../7003
rm node*
echo "node 7003 has been stoped."

cd ../7004
rm node*
echo "node 7004 has been stoped."

cd ../7005
rm node*
echo "node 7005 has been stoped."
