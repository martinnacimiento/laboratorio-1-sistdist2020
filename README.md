# Laboratorio 1 😎

## Avances 🌱

Todos los avances y cambios del proyecto pueden ser vistos en el [changelog](./CHANGELOG.md).

## Integrantes 👦 👧

- Nacimiento, Martin
- Senghaas, Evelin

## Requisitos ✋

- Docker

## Comenzar 🚀

Para utilizar el proyecto usted debe:

1. Clonar el repositorio.
2. Una vez clonado el repo ejecuta en tu consola (bash) `sh init.sh`. Podes ir a prepararte tu bebida favorita, comida y mirarte un capitulo de tu serie hasta que el comando termine de preparar el proyecto.
3. Una vez listo el proyecto ejecuta `sh stage-1.sh` para probarlo.

## Escenarios 🤔

### Escenario 1 🕐

El escenario uno consta de 3 nodos, 0.5 Hz cada uno. Para probarlo ejecutar `sh stage-1.sh`.

### Escenario 2 🕓

El escenario dos consta de 8 nodos, 5 Hz cada uno. Para probarlo ejecutar `sh stage-2.sh`.

## Logs 🕵

Todos los logs se guardan en archivos JSON con su marca de tiempo en la carpeta `/logs`.

En los logs se guarda cada evento que recibe el servidor. Ejemplo: un archivo se llamaría `logs - 1589607693051.json` y se vería:

```JSON
[
  {
    "time": 1589607700341,
    "nameNode": "node5",
    "hash": "e994b5179f233d6cc7bf69a011bd26102c8d7a07941713e8fbf32c117073e89a",
    "timeDelay": 905,
    "bandwidth": 115
  },
  {
    "time": 1589607700955,
    "nameNode": "node1",
    "hash": "c9309b5cdced7d2fe17fb83e7cb9bff7da10baf6a2b7819778cda0cc6b73d7fc",
    "timeDelay": 508,
    "bandwidth": 115
  }
]
```

en donde:

- **time**: es el tiempo en el cual el evento fue generado en el cliente.
- **nameNode**: es el nombre del nodo el cual generó el evento.
- **hash**: es un hash propio y único de cada evento.
- **timeDelay**: es el retraso de tiempo desde que se generó el evento en el cliente y llegó al servidor.
- **bandwidth**: es la longitud del evento transmitido por la red desde el cliente al servidor.

## Cálculos ✍

- Para calcular el **tiempo de retraso** de cada evento se realiza la diferencia entre la marca de tiempo del evento en la cual se generó dicho evento con la marca de tiempo en la cual se obtiene al momento de llegar en el servidor.
- Para calcular el **ancho de banda** de cada evento se tomo la longitud de cada evento serializado en gson.

## Paquetes utilizados 📦

- commons-math3
- gson

## Gráficos 📈

Los gráficos fueron especialmente programados para estos archivos JSON mostrarlos de un forma entendible e intuitiva. Los mismos fueron construidos con:

- Vue.js
- Moments.js
- VueChart.js

![Chart 1](/img/chart-1.png)
![Chart 1](/img/chart-1-hover.jpg)
![Chart 1](/img/chart-2.png)
