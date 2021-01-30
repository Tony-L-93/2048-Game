<h1 align="center"> 2048-Game</h1>
--
<p align="center"><img src="https://github.com/Tony-L-93/2048-Game/blob/master/pics/welcome-2048.png"/></p>
<p> Proyecto final del desarrollo de una aplicacion para jugar al 2048, donde se puede elegir 3 tipos de tableros: 4x4, 6x6, 8x8.</p>

### Estructura del proyecto
Se crean tres clases necesarias que contienen el código responsable para el funcionamiento de la aplicación:
-	**Tablero** es la clase principal donde se crea la matriz según el tamaño que se elija, busca las posiciones libres, verifica las colisiones y permite los movimientos de los números enteros.
-	**Celda** crea cada celda individual y es la que genera los valores aleatorios 2 u, ocasionalmente, 4.
-	**JuegoMain** es el encargado de iniciar el juego.

Mientras que por otro lado se tiene las interfaces que se crean usando WindowBuilder: 
-	**InterfaceInicio** que contiene la ventana inicial del juego donde se puede optar por comenzar a jugar, que se vincula con la interfaz Opciones, o por salir del juego.
-	**Opciones** donde se puede elegir el tamaño del tablero puede ser 4x4 que es el tamaño original pero se logro agregar dos tamaños más de tableros 6x6 y 8x8. Al presionar cualquiera de estos tamaños se puede comenzar a jugar. También, hay otra opción que es “volver” a la InterfaceInicio.
-	**Interface2048** es la interfaz principal ya que contiene la grafica del juego. Es responsable de mostrar los tableros, así como los botones y los movimientos de los mismos. Permite mostrar las colisiones de los números y muestra los puntajes en la pantalla.
<p align="center"><img src="https://github.com/Tony-L-93/2048-Game/blob/master/pics/game-2048.png"/></p>
-	**Perdedor y Ganador** estas dos interfaces aparecen cuando se pierde o se gana el juego.

### Contenido y características
Lo básico del juego se logra implementar, tal como los movimientos, las sumas de las colisiones y la suma final es 2048 y finaliza el juego.
Se logra implementar la opción de elegir varios tamaños de tableros: 4x4 (16 celdas), 6x6 (36 celdas) y 8x8 (64 celdas). 
<p align="center"><img src="https://github.com/Tony-L-93/2048-Game/blob/master/pics/options-2048.png"/></p>

### Ejecución de 2048-Game.
Se puede bajar el ejectuable que se encuentra en la carpeta * [Ejecutable](https://github.com/Tony-L-93/2048-Game/tree/master/ejecutable)
y luego ejecutar el archivo **2048-Demo.exe**

### Tecnologías usadas
La aplicación está estructurada utilizando el lenguaje `Java` y se diseño la interfaz con `WindowBuilder`.

---
 📢 por [Tony Liendro](https://github.com/Tony-L-93)
