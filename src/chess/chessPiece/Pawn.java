package chess.chessPiece;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] met = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //Above
        p.setValue(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            met[p.getRow()][p.getColumn()] = true;
        }
        p.setValue(position.getRow() - 1, position.getColumn());
        Position p2 = new Position(position.getRow() - 2, position.getColumn());
        int moveCount = getMoveCount();
        if(getBoard().positionExists(p)
            && !getBoard().thereIsAPiece(p)
            && getBoard().positionExists(p2)
            && !getBoard().thereIsAPiece(p2)
            && moveCount == 0)  {

            met[p.getRow()][p.getColumn()] = true;
            met[p2.getRow()][p2.getColumn()] = true;
            setMoveCount(getMoveCount() + 1);
        }

        p.setValue(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            met[p.getRow()][p.getColumn()] = true;
        }
        p.setValue(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            met[p.getRow()][p.getColumn()] = true;
        }

        //DEATH BLACK PIECES
            p.setValue(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                met[p.getRow()][p.getColumn()] = true;
            }

            p.setValue(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                met[p.getRow()][p.getColumn()] = true;
            }

            p.setValue(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                met[p.getRow()][p.getColumn()] = true;
            }

            p.setValue(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                met[p.getRow()][p.getColumn()] = true;
            }
            return met;
        }
    }
