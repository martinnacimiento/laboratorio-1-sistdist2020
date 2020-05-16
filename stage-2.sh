#!/bin/bash

set - e
echo "Bienvenid@ al stage 2"
echo 
echo "8 nodos, 5 Hz cada uno"
echo
existNetwork=$(docker network ls --format {{.Name}} | grep red_tcp_g10)
if [ "$existNetwork" != "red_tcp_g10" ]; then
    #crear red
    echo "creando red...⌛"
    docker network create red_tcp_g10
    echo "red creada!👌"
fi

# ejecutar servidor
docker run --rm --network red_tcp_g10 --name server_tcp_g10 -v $PWD/logs:/logs/ servidor_tcp_g10 8000 &

# Esperar 3 seg para asegurar que el servidor arranque
sleep 3

# ejecutar nodos
docker run --rm --network red_tcp_g10 cliente_tcp_g10 node1 5 server_tcp_g10 8000 &
pid_node1=$!
docker run --rm --network red_tcp_g10 cliente_tcp_g10 node2 5 server_tcp_g10 8000 &
pid_node2=$!
docker run --rm --network red_tcp_g10 cliente_tcp_g10 node3 5 server_tcp_g10 8000 &
pid_node3=$!
docker run --rm --network red_tcp_g10 cliente_tcp_g10 node4 5 server_tcp_g10 8000 &
pid_node4=$!
docker run --rm --network red_tcp_g10 cliente_tcp_g10 node5 5 server_tcp_g10 8000 &
pid_node5=$!
docker run --rm --network red_tcp_g10 cliente_tcp_g10 node6 5 server_tcp_g10 8000 &
pid_node6=$!
docker run --rm --network red_tcp_g10 cliente_tcp_g10 node7 5 server_tcp_g10 8000 &
pid_node7=$!
docker run --rm --network red_tcp_g10 cliente_tcp_g10 node8 5 server_tcp_g10 8000 &
pid_node8=$!

wait $pid_node1
wait $pid_node2
wait $pid_node3
wait $pid_node4
wait $pid_node5
wait $pid_node6
wait $pid_node7
wait $pid_node8
echo "Apagando servidor...⌛"
docker stop server_tcp_g10
echo "Servidor apagado!👌"
# borrar red
echo "Borrando red...⌛"
docker network rm red_tcp_g10
echo "Red eliminada!👌"