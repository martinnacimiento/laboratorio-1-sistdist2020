set - e

# crear red
#docker network create red_tcp

# ejecutar servidor
docker run --rm --network red_tcp --name serverEvent -v $PWD/logs:/logs/ servidor_tcp 8000 &

# ejecutar nodos
docker run --rm --network red_tcp cliente_tcp node1 5 serverEvent 8000 &
docker run --rm --network red_tcp cliente_tcp node2 5 serverEvent 8000

# borrar
#docker network rm red_tcp