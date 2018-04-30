# 1.Install redis.

#2.update ruby(2.2.2)
    brew install ruby
    curl -sSL https://get.rvm.io | bash -s stable
    rvm -v

#3.set redis cluster
    cd /usr/local/redis/
    mkdir redis_cluster/7000 redis_cluster/7001 redis_cluster/7002 redis_cluster/7003 redis_cluster/7004 redis_cluster/7005
    (3 master 3 slave)
    cd /usr/local/redis/src/
    ./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005

#4.meet node
    redis-cli -c -h 127.0.0.1 -p 7000
        cluster meet 127.0.0.1 7001
        cluster meet 127.0.0.1 7002
        cluster meet 127.0.0.1 7003
        cluster meet 127.0.0.1 7004
        cluster meet 127.0.0.1 7005

#5.test
    redis-cli -c -h 127.0.0.1 -p 7000
    set key abc
    get key

