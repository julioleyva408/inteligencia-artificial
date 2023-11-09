package TicTacToe;

import ArtificialIntelligence.Algorithms;

import java.util.Scanner;


public class Console {

    private Board board;
    private Scanner sc = new Scanner(System.in);


    private Console() {
        board = new Board();
    }


    private void play () {

        System.out.println("Comenzando un nuevo juego.");

        while (true) {
            printGameStatus();
            playMove();

            if (board.isGameOver()) {
                printWinner();

                if (!tryAgain()) {
                    break;
                }
            }
        }
    }


    private void playMove () {
        if (board.getTurn() == Board.State.X) {
            getPlayerMove();
        } else {
            Algorithms.alphaBetaAdvanced(board);
        }
    }


    private void printGameStatus () {
        System.out.println("\n" + board + "\n");
        System.out.println(board.getTurn().name() + "Es tu turno");
    }


    private void getPlayerMove () {
        System.out.print("Índice de movimiento: ");

        int move = sc.nextInt();

        if (move < 0 || move >= Board.BOARD_WIDTH* Board.BOARD_WIDTH) {
            System.out.println("\nMovimiento invalido");
            System.out.println("\nEl índice del movimiento debe estar entre 0 y "
                    + (Board.BOARD_WIDTH * Board.BOARD_WIDTH - 1) + ", inclusivo.");
        } else if (!board.move(move)) {
            System.out.println("\nMovimiento invalido.");
            System.out.println("\nEl índice seleccionado debe estar en blanco..");
        }
    }


    private void printWinner () {
        Board.State winner = board.getWinner();

        System.out.println("\n" + board + "\n");

        if (winner == Board.State.Blank) {
            System.out.println("El TicTacToe es un empate..");
        } else {
            System.out.println("Jugador " + winner.toString() + "es el ganador!");
        }
    }


    private boolean tryAgain () {
        if (promptTryAgain()) {
            board.reset();
            System.out.println("Comenzando nuevo juego.");
            System.out.println("X es tu turno.");
            return true;
        }

        return false;
    }


    private boolean promptTryAgain () {
        while (true) {
            System.out.print("¿Quieres empezar un nuevo juego? (S/N): ");
            String response = sc.next();
            if (response.equalsIgnoreCase("s")) {
                return true;
            } else if (response.equalsIgnoreCase("n")) {
                return false;
            }
            System.out.println("Entrada invalida.");
        }
    }

    public static void main(String[] args) {
        Console ticTacToe = new Console();
        ticTacToe.play();
    }

}
