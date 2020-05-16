set - e

# compilar proyecto y genera los JARS con sus depencias
docker run -it --rm --name laboratorio-1-G10 -v "$(pwd)":/workspaces/laboratorio-1 \
    -w /workspaces/laboratorio-1 maven:3.6.3-openjdk-15 sh build.sh

# crear imagen de nodo
docker build -t cliente_tcp_g10 -f cliente.dockerfile .

# crear imagen de servidor
docker build -t servidor_tcp_g10 -f servidor.dockerfile .