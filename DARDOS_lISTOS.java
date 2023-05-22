import java.util.Random;
import java.util.Scanner;

public class DARDOS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Configuración inicial del juego
        System.out.println("¡Bienvenido al juego de dardos!");
        System.out.print("Ingrese el número de jugadores (2 a 4): ");
        int numJugadores = input.nextInt();
        if (numJugadores < 2 || numJugadores > 4) {
            System.out.println("Número de jugadores inválido.");
            return;
        }
        System.out.print("Ingrese el número de rondas por partida (3 a 5): ");
        int numRondas = input.nextInt();
        if (numRondas < 3 || numRondas > 5) {
            System.out.println("Número de rondas inválido.");
            return;
        }

        // Inicialización de variables
        int[] puntuaciones = new int[numJugadores];
        int jugadorActual = random.nextInt(numJugadores); // Se elige aleatoriamente quién comienza
        int rondaActual = 1;

        // Comienza el juego
        System.out.println("Comienza la partida!");
        while (rondaActual <= numRondas) {
            System.out.println("Ronda " + rondaActual);
            for (int i = 0; i < numJugadores; i++) {
                if (i == jugadorActual) {
                    System.out.println("Turno del jugador " + (i + 1));
                    int puntuacion = jugarDardos();
                    puntuaciones[i] += puntuacion;
                    System.out
                            .println("El jugador " + (i + 1) + " ha obtenido " + puntuacion + " puntos en esta ronda.");
                    System.out.println("Puntuación total del jugador " + (i + 1) + ": " + puntuaciones[i]);
                } else {
                    System.out.println("Esperando el turno del jugador " + (i + 1) + "...");
                }
            }
            rondaActual++;
            jugadorActual = (jugadorActual + 1) % numJugadores; // Siguiente jugador // en este el jugador se puede
                                                                // repetir mas veces, en el caso de que sea random.
        }

        // Fin del juego
        int maxPuntuacion = 0;
        int ganador = -1;
        for (int i = 0; i < numJugadores; i++) {
            System.out.println("Puntuación total del jugador " + (i + 1) + ": " + puntuaciones[i]);
            if (puntuaciones[i] > maxPuntuacion) {
                maxPuntuacion = puntuaciones[i];
                ganador = i;
            } else if (puntuaciones[i] == maxPuntuacion) {
                // Empate
                ganador = -1;
            }
        }
        if (ganador == -1) {
            System.out.println("¡Ha habido un empate!");
        } else {
            System.out.println("El ganador es el jugador " + (ganador + 1) + " con una puntuación total de "
                    + maxPuntuacion + " puntos.");
        }
    }

    public static int jugarDardos() {
        Random random = new Random();
        int puntuacion = random.nextInt(21);
        return puntuacion;
    }
}