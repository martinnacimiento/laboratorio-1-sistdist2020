# Laboratorio-1
## Avances
- Servidor concurrente creado.
- Comunicación entre servidor y cliente mediante sockets TCP.
- Clientes envían eventos al servidor y los muestra en el formato establecido.
## Problemas encontrados
- Hicimos un intento de ejecutar con docker-compose empaquetando los proyectos de app y server en archivos .jar, pero la dependencia de ExponentialDistribution no se empaqueta junto, y al cambio de contenedor de desarrollo al de "producción" falla al faltar esa librería.
## Integrantes
- Nacimiento, Martin
- Senghaas, Evelin