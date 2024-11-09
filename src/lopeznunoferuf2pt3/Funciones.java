package lopeznunoferuf2pt3;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author flopeznun.daw1r23 Clase dedicada a almacenar todos los métodos del
 * juego
 */
public class Funciones {

    /**
     * Este método imprime el tablero de juego que verá el jugador. Lo llena con
     * " # " en todas las casillas.
     *
     * @param tablero imprime un tablero de muestra lleno de #'s
     */
    public void inicializarTableroJuego(String tablero[][]) {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = "#";

            }
        }
    }

    /**
     * Método para establecer la dificultad del juego. Dependiendo de la misma,
     * devolverá un int (1,2,3) que se usará para crear el tablero con el tamaño
     * adecuado y establecer el num de minas correspondiente.
     *
     * @return dificultad devuelve un int que representa la dificultad
     * seleccionada (1,2 o 3); en base a este num se creará el tablero y el num.
     * de minas
     */
    public int seleccionarDificultad() {

        System.out.println("Bienvenido al juego del buscaminas. Introduce dificultad deseada: 1-facil 2-medio 3-dificil: ");

        int dificultad;

        Scanner teclat = new Scanner(System.in);
        dificultad = teclat.nextInt();

        while (dificultad != 1 && dificultad != 2 && dificultad != 3) {
            System.out.println("Introduce 1, 2 o 3 (nivel facil, medio o dificil): ");
            dificultad = teclat.nextInt();
        }

        if (dificultad == 1) {
            System.out.println("");
            System.out.println("Dificultad establecida en FACIL, empieza el juego");
            System.out.println("");
        } else if (dificultad == 2) {
            System.out.println("");
            System.out.println("Dificultad establecida en NIVEL MEDIO, empieza el juego");
            System.out.println("");
        } else if (dificultad == 3) {
            System.out.println("");
            System.out.println("Dificultad establecida en NIVEL DIFICIL, empieza el juego");
            System.out.println("");
        }

        return dificultad;
    }

    /**
     * Este método devuelve una matriz con el tamaño adecuado, dependiendo de la
     * dificultad introducida por el usuario.
     *
     * @param dificultad aquí entra el int dificultad (1,2 o 3) y en base al
     * mismo se establece el tamaño de la matriz-tablero de juego
     * @return el return devuelve una matriz con el tamaño correspondiente a la
     * dificultad seleccionada
     */
    public int[][] tamañoTabla(int dificultad) {

        int tabla[][] = null;

        if (dificultad == 1) {
            tabla = new int[10][10];
        } else if (dificultad == 2) {
            tabla = new int[15][15];
        } else if (dificultad == 3) {
            tabla = new int[16][30];
        }
        return tabla;
    }

    /**
     * Este método hace dos cosas: define el número de minas, dependiendo del
     * tamaño del tablero (el cual, a su vez, depende de la dificultad
     * seleccionada) e imprime las cabeceras para cada tipo de tablero (fácil,
     * medio y difícil).
     *
     * @param tamañoTabla en este método entra la tabla anterior, creada en base
     * a la dificultad escogida
     * @return devuelve un int que representa el número de minas, establecido
     * según las dimensiones de la tabla (que, a su vez, depende de la
     * dificultad). Además, este método imprime la cabecera de la tabla.
     */
    public int imprimirTabla(int tamañoTabla[][]) {

        int numMinas = 0;

        if (tamañoTabla.length == 10 && tamañoTabla[0].length == 10) {

            numMinas = 15;

            System.out.println("");
            System.out.println("    | 1 | 2 | 3 | 4  | 5  | 6 | 7 | 8 | 9 | 10 |");
            System.out.println("------------------------------------------");

            for (int i = 0; i < tamañoTabla.length; i++) {

                int num = i + 1;

                if (num < 10) {
                    System.out.print(i + 1 + "  | ");
                } else {
                    System.out.print(i + 1 + " | ");
                }

                for (int j = 0; j < tamañoTabla[i].length; j++) {
                    System.out.print("# | ");
                }
                System.out.println("");
            }

        } else if (tamañoTabla.length == 15 && tamañoTabla[0].length == 15) {

            numMinas = 35;

            System.out.println("");
            System.out.println("    | 1 | 2 | 3 | 4 |  5  | 6 | 7 | 8 | 9 | 10 | 11| 12| 13| 14| 15|");
            System.out.println("--------------------------------------------------------------");

            for (int i = 0; i < tamañoTabla.length; i++) {

                int num = i + 1;

                if (num < 10) {
                    System.out.print(i + 1 + "  | ");
                } else {
                    System.out.print(i + 1 + " | ");
                }

                for (int j = 0; j < tamañoTabla[i].length; j++) {
                    System.out.print("# | ");
                }
                System.out.println("");
            }

        } else if (tamañoTabla.length == 16 && tamañoTabla[0].length == 30) {

            numMinas = 99;

            System.out.println("");
            System.out.println("    | 1 | 2 | 3 | 4 |  5  | 6 | 7 | 8 | 9 | 10 | 11| 12| 13| 14| 15|16| 17| 18|19| 20 |21| 22| 23| 24|25 |26| 27| 28| 29| 30|");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < tamañoTabla.length; i++) {

                int num = i + 1;

                if (num < 10) {
                    System.out.print(i + 1 + "  | ");
                } else {
                    System.out.print(i + 1 + " | ");
                }

                for (int j = 0; j < tamañoTabla[i].length; j++) {
                    System.out.print("# | ");
                }
                System.out.println("");
            }
        }
        return numMinas;
    }

    /**
     * Este método coloca las minas aleatoriamente e imprime una única vez un
     * tablero "revelado" donde podemos ver todas las minas (son nums. 8).
     * También indica cuántas minas hay alrededor de las casillas, ya que el
     * segundo bucle recorre el "exterior" de todas las casillas con un 8 dentro
     * (es decir, con mina) y suma 1 en cada una.
     *
     * @param tabla esto introduce la tabla con el tamaño ya definido.
     * @param minas esto es el numero de minas, que serán colocadas
     * aleatoriamente en la tabla con un sistema boleano.
     *
     */
    public void colocarMinas(int tabla[][], int minas) {

        Random rand = new Random();
        Posicion p = new Posicion();
        int contador = 0;

        //bucle para colocar minas (MALO, las coloca todas arriba)
//        for (int i = 0; i < tabla.length; i++) {
//
//            for (int j = 0; j < tabla[i].length; j++) {
//
//                if (rand.nextBoolean() == false && contador < minas) {
//                    tabla[i][j] = 8;
//                    contador++;
//                }
//            }
//        }

        //colocar minas:
        
        while (minas>0){
            
            p.fila = rand.nextInt(tabla.length);
            p.columna = rand.nextInt(tabla[0].length);
            
            if (tabla[p.fila][p.columna] != 8){
                tabla[p.fila][p.columna] = 8;
                minas--;
            }
            
        }

        //bucle para colocar nums alrededor de las minas
        for (int i = 0; i < tabla.length; i++) {

            for (int j = 0; j < tabla[i].length; j++) {

                if (tabla[i][j] == 8) {

                    for (int k = i - 1; k <= i + 1; k++) {

                        for (int l = j - 1; l <= j + 1; l++) {

                            if (k >= 0 && l >= 0 && k < tabla.length && l < tabla[0].length && tabla[k][l] != 8) {

                                tabla[k][l]++;

                            }

                        }

                    }

                }

            }
        }

        System.out.println("");
        System.out.println("");

        //este for imprime la tabla "revelada" en el inicio para ver dónde están las minas
        for (int i = 0; i < tabla.length; i++) {
            System.out.print(i + 1 + " | ");

            for (int j = 0; j < tabla[i].length; j++) {

                System.out.print(tabla[i][j] + " | ");
            }
            System.out.println("");
        }
    }

    /**
     * Este método devolverá un char que indica al programa la acción que el
     * jugador quiere llevar a cabo: marcar (m), desmarcar (x), descubrir (d),
     * ayuda (h), reiniciar la partida (r) o finalizarla (f).
     *
     * @return este return devuelve un char que indca al programa la acción que
     * el jugador quiere llevar a cabo: marcar (m), desmarcar (x), descubrir
     * (d), ayuda (h), reiniciar la partida (r) o finalizarla (f).
     */
    public char marcarODescubrir() {

        char eleccion = 'x';

        System.out.println("");
        System.out.println("Introduce 'd' para descubrir, 'm' para marcar o 'x' para desmarcar. Otras opciones: ayuda 'h', reiniciar partida 'r', finalizar juego 'f'. ");

        Scanner teclat = new Scanner(System.in);
        eleccion = teclat.next().charAt(0);

        while (eleccion != 'm' && eleccion != 'd' && eleccion != 'x' && eleccion != 'h' && eleccion != 'r' && eleccion != 'f') {
            System.out.println("CARACTER INCORRECTO: introduce letra valida: ");
            eleccion = teclat.next().charAt(0);
        }
        return eleccion;
    }

    /**
     * Este método ocurre cuando el jugador selecciona "descubrir" casilla. El
     * mismo devuelve una Posición ("coordenada") donde, en el main, se
     * imprimirá un espacio en lugar de un # (si no hay mina en dicha casilla).
     *
     * @param tabla entra el parámetro tabla de nuevo.
     * @param decision este parámetro es un char que indica la acción elegida
     * por el jugador.
     * @return devuelve una posición "coordenada", conforme a la clase
     * Posicion.java (compuesta por los ints. fila y columna). Esta posición
     * será "descubierta" imprimiendo un " " en lugar del "#" existente.
     */
    public Posicion descubrir(int tabla[][], char decision) {

        Posicion p = new Posicion();

        Scanner teclat = new Scanner(System.in);

        System.out.println("Introduce fila: ");
        p.fila = teclat.nextInt() - 1;

        System.out.println("Introduce columna: ");
        p.columna = teclat.nextInt() - 1;

        while (p.fila < 0 || p.fila >= tabla.length || p.columna < 0 || p.columna >= tabla[0].length) {
            System.out.println("Posicion invalida. Introduce una posicion valida:");
            System.out.println("Introduce fila: ");
            p.fila = teclat.nextInt() - 1;
            System.out.println("Introduce columna: ");
            p.columna = teclat.nextInt() - 1;
        }
        return p;
    }

    /**
     * Método para que, una vez descubierto un cuadrado sin minas, se destapen también todos los cuadrados sin minas colindantes de forma recursiva llamando a este mismo método hasta que no encuentre más cuadrados en blanco
     * @param tabla entra la tabla numérica oculta...
     * @param tablaJugador ... y la del jugador
     * @param fila también entra la fila (del tablero del jugador)
     * @param columna y la columna del mismo tablero
     */
    public void descubrirRecursivo(int tabla[][], String tablaJugador[][], int fila, int columna) {
               
        if (tabla[fila][columna] > 0 && tabla[fila][columna]!=8) {
            
           //se da a la posición de la tabla jugador la correspondiente de la tabla numérica para q salga el mismo num en la tabla jugador.
           tablaJugador[fila][columna]=String.valueOf(tabla[fila][columna]); 
        } 
        
        else {
            if (!" ".equals(tablaJugador[fila][columna])) { 
                tablaJugador[fila][columna] = " ";

                for (int k = fila - 1; k <= fila + 1; k++) {

                    for (int l = columna - 1; l <= columna + 1; l++) {

                        if (k >= 0 && l >= 0 && k < tabla.length && l < tabla[0].length && tabla[k][l] != 8) {
                            descubrirRecursivo(tabla, tablaJugador, k, l);

                        }
                    }
                }
            }
        }
    }

    /**
     * Este método coloca una "X" en lugar de "#" en el tablero del jugador.
     *
     * @param tabla de nuevo, entra la matriz "tablero".
     * @param decision carácter que especifica la decisión del jugador
     * @return como en el método descubrir, esto devuelve Posición (ints fila y
     * columna de clase Posicion.java, una "coordenada").
     */
    public Posicion marcar(String tabla[][], char decision) {
        Posicion p = new Posicion();

        Scanner teclat = new Scanner(System.in);

        System.out.println("Introduce fila: ");
        p.fila = teclat.nextInt() - 1;

        System.out.println("Introduce columna: ");
        p.columna = teclat.nextInt() - 1;

        while (p.fila < 0 || p.fila >= tabla.length || p.columna < 0 || p.columna >= tabla[0].length) {
            System.out.println("Posicion invalida. Introduce una posicion valida:");
            System.out.println("Introduce fila: ");
            p.fila = teclat.nextInt() - 1;
            System.out.println("Introduce columna: ");
            p.columna = teclat.nextInt() - 1;
        }

        return p;
    }

    /**
     * Esta opción vuelve a cambiar una "X" previamente colocada e imprime de
     * nuevo un "#".
     *
     * @param tabla de nuevo, entra la matriz "tablero".
     * @param decision carácter que especifica la decisión del jugador
     * @return como en los métodos anteriores, "p" devuelve Posición (ints fila
     * y columna de clase Posicion.java, una "coordenada").
     */
    public Posicion desmarcar(String tabla[][], char decision) {
        Posicion p = new Posicion();

        Scanner teclat = new Scanner(System.in);

        System.out.println("Introduce fila: ");
        p.fila = teclat.nextInt() - 1;

        System.out.println("Introduce columna: ");
        p.columna = teclat.nextInt() - 1;

        while (p.fila < 0 || p.fila >= tabla.length || p.columna < 0 || p.columna >= tabla[0].length) {
            System.out.println("Posicion invalida. Introduce una posicion valida:");
            System.out.println("Introduce fila: ");
            p.fila = teclat.nextInt() - 1;
            System.out.println("Introduce columna: ");
            p.columna = teclat.nextInt() - 1;
        }

        return p;
    }

    /**
     * Este método salta cuando el usuario presiona "h". es una pantalla de
     * ayuda para saber cómo jugar al buscaminas
     */
    public void ayuda() {
        System.out.println("--------------------------------------------------------- AYUDA ------------------------------------------------------------");
        System.out.println("");
        System.out.println("1.- En primer lugar selecciona el nivel de dificulad. Cuanto mayor sea, mas minas habra y mayor sera el terreno de juego.");
        System.out.println("2.- Decide si quieres destapar una casilla oculta, marcarla o desmarcarla; destaparla significa revelar si hay o no una mina ");
        System.out.println("     debajo: si la hay, se acaba el juego. Si no, se revelan todas las casillas adyacentes sin mina y se indica si en alguna hay");
        System.out.println("      minas proximas (y cuantas). Marcarla significa indicar que en esa casilla crees que hay 1 mina. Desmarcarla sirve para");
        System.out.println("      quitar dicha marca.");
        System.out.println("3.-  El juego termina cuando el jugador destapa una casilla con mina, o cuando destapa todas las casillas vacias o marca las");
        System.out.println("      que contienen minas.");
    }

    /**
     * Este método controla el while del método main: cuando se invoca, lo
     * coloca en "false", y por tanto el while se rompe y el juego acaba.
     *
     * @return devuelve un boleano en "false" que rompe el while del método main
     * para que acabe el juego.
     */
    public boolean finalizarPartida() {
        boolean boleano = false;
        System.out.println("");
        System.out.println("Juego finalizado");
        return boleano;
    }

    /**
     * Este método "resetea" el tablero de juego volviendo a imprimir todos los
     * #s. Además, coloca de nuevo todas las minas aleatoriamente.
     *
     * @param dificultad parámetro correspondiente a la dificultad originalmente
     * seleccionada por el jugador
     * @param tablero tablero de juego "revelado"
     * @param tableroJuego tablero de juego "público", el del jugador
     * @param numMinas número de minas determinado según el tamaño del tablero.
     * Este método sirve para resetear la partida. Para ello, entran en él todos
     * los parámetros que van siendo modificados a lo largo de la partida y se
     * resetean (excepto el de dificultad): por ejemplo, en el tablero de juego
     * (el del jugador) se vuelven a imprimir #s en todas las casillas, y se
     * vuelven a colocar las minas aleatoriamente.
     */
    public void resetearPartida(int dificultad, int[][] tablero, String[][] tableroJuego, int numMinas) {
        tablero = tamañoTabla(dificultad);

        for (int i = 0; i < tableroJuego.length; i++) {
            for (int j = 0; j < tableroJuego[0].length; j++) {
                tableroJuego[i][j] = "#";
            }
        }

        colocarMinas(tablero, numMinas);
        System.out.println("");
        System.out.println("Juego reiniciado.");
    }

    /**
     * Método usado para imprimir la matriz-tablero en su estado actual en cada
     * turno de juego. También imprime la cabecera.
     *
     * @param matriz este método imprime la matriz en su estado actual en cada
     * turno de juego. Es el tablero "público".
     */
    public void Matriz(String matriz[][]) {

        if (matriz.length == 10 && matriz[0].length == 10) {

            System.out.println("");
            System.out.println("    | 1 | 2 | 3 | 4  | 5  | 6 | 7 | 8 | 9 | 10 |");
            System.out.println("------------------------------------------");
        } 
        else if (matriz.length == 15 && matriz[0].length == 15) {

            System.out.println("");
            System.out.println("    | 1 | 2 | 3 | 4 |  5  | 6 | 7 | 8 | 9 | 10 | 11| 12| 13| 14| 15|");
            System.out.println("--------------------------------------------------------------");

        } 
        else if (matriz.length == 16 && matriz[0].length == 30) {

            System.out.println("");
            System.out.println("    | 1 | 2 | 3 | 4 |  5  | 6 | 7 | 8 | 9 | 10 | 11| 12| 13| 14| 15|16| 17| 18|19| 20 |21| 22| 23| 24|25 |26| 27| 28| 29| 30|");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
        }
        
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(i + 1 + " | ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println("");
        }
    }

    /**
     * Método usado para definir si el jugador ha perdido. Si el parámetro "p"
     * (coordenada) es igual a 8, devuelve "true", lo cual hará que, en el main,
     * juegoContinua se coloque en "false" y por tanto que el juego acabe.
     *
     * @param tabla entra la tabla...
     * @param p ... y la posición
     * @return el return devuelve un booleano
     */
    public boolean verificarDerrotaJugador(int tabla[][], Posicion p) {

        if (tabla[p.fila][p.columna] == 8) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Método para verificar si el jugador ha marcado correctamente todas las minas; para ello, recorre toda la matriz del jugador (la de strings) y compara cada posición con la correspondiente de la matriz "descubierta": si en la del jugador hay una X y en la descubierta un 8, la mina ha sido marcada correctamente y el contador suma 1 - cuando el contador llega al mismo número de minas, devuelve un boleano "false" que, en el main", coloca juegoContinua en "false" y por tanto se sale del while de juego y el mismo termina.
     * @param tablaJugador se introduce en el método la tabla del jugador (de strings)
     * @param tabla también la tabla "oculta" con las minas (8s)
     * @param minas y el número de minas
     * @return el return devuelve un boleano: en true mientras el int "contador" no sea igual al num de minas, y en false cuando sí lo sea
     */
    public boolean verificarVictoriaMarcar(String tablaJugador[][], int tabla[][], int minas) {

        int contador = 0;
        boolean boleano = false;

        for (int i = 0; i < tablaJugador.length; i++) {
            for (int j = 0; j < tablaJugador[0].length; j++) {

                if ("X".equals(tablaJugador[i][j]) && tabla[i][j] == 8 && contador < minas) {
                    contador++;
                    boleano = false;
                }

                if (contador >= minas) {
                    boleano = true;
                }
            }
        }
        return boleano;
    }
    
    /**
     * Método para verificar si el jugador ha destapado todas las casillas sin minas del tablero - se recorre toda la tabla y se devuelve un booleano en false mientras alguna de las casillas NO tenga un espacio o una X; en caso contrario (es decir, todo el tablero destapado y/o marcado), se devuelve true y el juego acaba con victoria.
     * @param tableroJuego se mete como parámetro el tableroJuego (el de strings) 
     * @return 
     */
    public boolean verificarVictoriaDestapar(String tableroJuego[][]) {

        for (int i = 0; i < tableroJuego.length; i++) {
            for (int j = 0; j < tableroJuego[0].length; j++) {
                
                if (!" ".equals(tableroJuego[i][j]) && !"X".equals(tableroJuego[i][j])) {
                    return false;
                }
              
            }
        }
        return true;
    }
}

