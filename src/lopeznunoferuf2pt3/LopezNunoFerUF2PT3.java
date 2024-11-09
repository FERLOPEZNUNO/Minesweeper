package lopeznunoferuf2pt3;

public class LopezNunoFerUF2PT3 {

    public static void main(String[] args) {

        Funciones f = new Funciones();

        int dificultad = 0;
        int numMinas = 0;
        char decision = 't';
        int tablero[][] = new int[0][0];
        String tableroJuego[][] = new String[0][0];

        //pedimos al jugador que seleccione dificultad:
        dificultad = f.seleccionarDificultad();

        //establecemos las dimensiones de la matriz (llamada "tablero") según el metodo tamañotabla, enviando num (que es la dificultad)
        tablero = f.tamañoTabla(dificultad);

        //imprimimos la matriz-tablero en blanco y establecemos el num de minas segun el tamaño
        numMinas = f.imprimirTabla(tablero);

        // iniciamos tablerojuego con mismo tamaño que "tablero"
        tableroJuego = new String[tablero.length][tablero[0].length];

        //colocamos # en todas las casillas de tableroJuego:
        f.inicializarTableroJuego(tableroJuego);

        //colocamos minas:
        f.colocarMinas(tablero, numMinas);

        //
        //EMPIEZA JUEGO:
        //
        boolean juegoContinua = true;

        //iniciamos el contador de tiempo:
        long inici = System.currentTimeMillis();

        while (juegoContinua == true) {

            //jugador indica si quiere marcar o destapar:
            decision = f.marcarODescubrir();

            //jugador introduce casilla deseada donde quiere marcar:
            if (decision == 'm') {
                Posicion pm = f.marcar(tableroJuego, decision);
                tableroJuego[pm.fila][pm.columna] = "X";
                f.Matriz(tableroJuego);

                if (f.verificarVictoriaMarcar(tableroJuego, tablero, numMinas) == true) {
                    System.out.println("VICTORIA: has marcado todas las minas correctamente!!");
                    juegoContinua = false;
                }
            } 

            //jugador introduce casilla deseada donde quiere DESMARCAR una casilla marcada previamente:
            else if (decision == 'x') {
                Posicion px = f.desmarcar(tableroJuego, decision);
                tableroJuego[px.fila][px.columna] = "#";
                f.Matriz(tableroJuego);
            } 

            //jugador introduce casilla deseada donde quiere descubrir:
            else if (decision == 'd') {
                Posicion pd = f.descubrir(tablero, decision);

                if (f.verificarDerrotaJugador(tablero, pd) == true) {
                    System.out.println("");
                    System.out.println("DERROTA, encontraste 1 mina");
                    juegoContinua = false;
                } 
                
                if (f.verificarVictoriaDestapar(tableroJuego)){
                    System.out.println("VICTORIA por descubrir todas las casillas sin minas!!");
                    juegoContinua = false;
                }
                
                else {
                    // tableroJuego[pd.fila][pd.columna] = "  ";
                    f.descubrirRecursivo(tablero, tableroJuego, pd.fila, pd.columna);
                    f.Matriz(tableroJuego);  //<----- esto imprime el tablero con #s y Xs, etc

                }
            } 
            //jugador le da al botón de "ayuda":
            else if (decision == 'h') {
                f.ayuda();
            } 
            //si el jugador le da a "f" para salir del juego:
            else if (decision == 'f') {
                juegoContinua = f.finalizarPartida();
            } 
            //si el jugador le da a "r" para resettear la partida:
            else if (decision == 'r') {
                f.resetearPartida(dificultad, tablero, tableroJuego, numMinas);
                f.Matriz(tableroJuego);
            }

        }

        //paramos el contador de tiempo y mostramos tiempo de juego:
        long fi = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Tiempo de juego: " + ((fi - inici) / 1000) + (" segundos."));
        System.out.println("");

    }
}
