package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Rook extends ChessPiece{

    public Rook(Board board, Color color) {
        super(board, color);
    }
    


    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);
        //above
        p = getPosition();
        p.setValues(p.getRow()-1, p.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1, p.getColumn());
        }
        if(isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below
        System.out.println("Below:");
        p.setValues(position.getRow(), position.getColumn());
        p.setValues(p.getRow()+1, p.getColumn());
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            System.out.println(p);
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()+1, p.getColumn());
        }
        if(isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        System.out.println("left:");
        p.setValues(position.getRow(), position.getColumn());
        p.setValues(p.getRow(), p.getColumn()-1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            System.out.println(p);
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow(), p.getColumn()-1);
        }
        if(isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColumn());
        p.setValues(p.getRow(), p.getColumn()+1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow(), p.getColumn()+1);
        }
        if(isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
