package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Pawn extends ChessPiece{
    
    public Pawn(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "P";
    }
    
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        
        if(getColor() == Color.WHITE){
            
            p.setValues(getPosition().getRow()-1, getPosition().getColumn());
            if(getBoard().positionExists(p) && !isThereFriendlyPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(getPosition().getRow()-2, getPosition().getColumn());
            if(getMoveCount()== 0 && getBoard().positionExists(p) && !isThereFriendlyPiece(p) && !getBoard().thereIsAPiece(new Position(p.getRow()+1, p.getColumn()))){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(getPosition().getRow()-1, getPosition().getColumn()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(getPosition().getRow()-1, getPosition().getColumn()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        if(getColor() == Color.BLACK){
            
            p.setValues(getPosition().getRow()+1, getPosition().getColumn());
            if(getBoard().positionExists(p) && !isThereFriendlyPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(getPosition().getRow()+2, getPosition().getColumn());
            if(getMoveCount()== 0 && getBoard().positionExists(p) && !isThereFriendlyPiece(p) && !getBoard().thereIsAPiece(new Position(p.getRow()-1, p.getColumn()))){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(getPosition().getRow()+1, getPosition().getColumn()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(getPosition().getRow()+1, getPosition().getColumn()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        return mat;
    }
}
