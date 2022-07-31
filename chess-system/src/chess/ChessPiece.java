package chess;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
import boardgame.Position;
import chess.enums.Color;

public abstract class ChessPiece extends Piece{
    private Color color;
    
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
    
    protected boolean isThereOpponentPiece(Position position){
        
        if(!getBoard().positionExists(position)){
            return false;
        }

        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p!=null && p.getColor() != this.color;
        
        
    }
}
