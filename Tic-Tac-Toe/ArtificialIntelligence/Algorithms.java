package ArtificialIntelligence;

import TicTacToe.Board;


public class Algorithms {

    private Algorithms() {}


    public static void random (Board board) {
        Random.run(board);
    }


    public static void miniMax (Board board) {
        MiniMax.run(board.getTurn(), board, Double.POSITIVE_INFINITY);
    }


    public static void miniMax (Board board, int ply) {
        MiniMax.run(board.getTurn(), board, ply);
    }


    public static void alphaBetaPruning (Board board) {
        AlphaBetaPruning.run(board.getTurn(), board, Double.POSITIVE_INFINITY);
    }


    public static void alphaBetaPruning (Board board, int ply) {
        AlphaBetaPruning.run(board.getTurn(), board, ply);
    }


    public static void alphaBetaAdvanced (Board board) {
        AlphaBetaAdvanced.run(board.getTurn(), board, Double.POSITIVE_INFINITY);
    }


    public static void alphaBetaAdvanced (Board board, int ply) {
        AlphaBetaAdvanced.run(board.getTurn(), board, ply);
    }

}
