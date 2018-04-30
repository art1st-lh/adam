cd /usr/local/redis/redis_cluster/7000/
redis-server redis.conf
echo "7000 has been started."


cd ../7001/
redis-server redis.conf
echo "7001 has been started."

cd ../7002/
redis-server redis.conf
echo "7002 has been started."

cd ../7003/
redis-server redis.conf
echo "7003 has been started."

cd ../7004/
redis-server redis.conf
echo "7004 has been started."

cd ../7005/
redis-server redis.conf
echo "7005 has been started."

cd /usr/local/redis/src/
./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005

echo "execute redis-trib.rb finished."