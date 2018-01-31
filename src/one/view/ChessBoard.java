package one.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import one.model.EightQueenModel;

public class ChessBoard {
    public static final int SIZE = 66;
    public static final int PSIZE = 52;

    private Canvas canvas;
    private GraphicsContext gc;

    private static ChessBoard chessBoard = null;

    public static ChessBoard getInstance(){
        if(chessBoard == null)
            chessBoard = new ChessBoard();
        return chessBoard;
    }

    private ChessBoard(){
        canvas = new Canvas(SIZE* EightQueenModel.N, SIZE* EightQueenModel.N);
        gc = canvas.getGraphicsContext2D();
        drawBoard();
    }

    public void updateChessBoard(){
        gc.clearRect(0,0,SIZE* EightQueenModel.N,SIZE* EightQueenModel.N);
        canvas.setHeight(SIZE* EightQueenModel.N);
        canvas.setWidth(SIZE* EightQueenModel.N);
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public  void drawBoard(){
        for(int i = 0;i<EightQueenModel.N;i++){
            for(int j = 0;j<EightQueenModel.N;j++){
                String color = (i+j)%2 == 0 ? "white" : "dimgray";
                gc.setFill(Paint.valueOf(color));
                gc.fillRect(i*SIZE,j*SIZE,SIZE,SIZE);
            }
        }
    }

}
