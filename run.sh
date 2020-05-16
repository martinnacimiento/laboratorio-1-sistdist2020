set - e

# crear red
docker network create red_tcp

# ejecutar servidor
docker run --rm --network red_tcp --name server_tcp_g10 -v $PWD/logs:/logs/ servidor_tcp_g10 8000 &

# Esperar 3 seg para asegurar que el servidor arranque
sleep 3

# ejecutar nodos
docker run --rm --network red_tcp cliente_tcp_g10 node1 0.5 server_tcp_g10 8000 &
pid_node1=$!
docker run --rm --network red_tcp cliente_tcp_g10 node2 5 server_tcp_g10 8000
pid_node2=$!

wait $pid_node1
wait $pid_node2
echo Apagando servidor...
docker stop server_tcp_g10
echo Servidor apagado!
# borrar
#docker network rm red_tcp