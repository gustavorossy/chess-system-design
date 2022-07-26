package chess;

import boardgame.Board;

import boardgame.Piece;
import boardgame.Position;
import chess.enums.Color;

public abstract class ChessPiece extends Piece{
    private Color color;
    private int moveCount;
    
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
    public int getMoveCount(){
        return moveCount;
    }
    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
    
    protected void increaseMoveCount(){
        moveCount++;
    }

    protected void decreaseMoveCount(){
        moveCount--;
    }
    protected boolean isThereOpponentPiece(Position position){
        
        if(!getBoard().positionExists(position.getRow(), position.getColumn())){
            return false;
        }

        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p!=null && p.getColor() != this.color;
        
        
    }
    protected boolean isThereFriendlyPiece(Position position){
        
        if(!getBoard().positionExists(position.getRow(), position.getColumn())){
            return false;
        }

        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p!=null && p.getColor() == this.color;
        
        
    }
}
