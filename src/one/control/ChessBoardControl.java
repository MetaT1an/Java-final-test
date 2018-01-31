package one.control;

import javafx.scene.image.Image;
import one.model.EightQueenModel;
import one.model.Queen;
import one.model.QueenList;
import one.view.ChessBoard;

public class ChessBoardControl {
    private static ChessBoard chessBoard = ChessBoard.getInstance();
    private static EightQueenModel eightQueenModel = EightQueenModel.getInstance();
    private static QueenList qlist = QueenList.getInstance();
    private static int numOfQueen = 0;

    private ChessBoardControl(){}

    public static void addChessBoardEvents(){
        addQueenEvent();
    }

    public static void addQueenEvent(){

        chessBoard.getCanvas().setOnMouseClicked(event -> {
            if(numOfQueen < EightQueenModel.N){
                double tempX = event.getX();
                double tempY = event.getY();

                int x = (int)(tempX/ ChessBoard.SIZE);
                int y = (int)(tempY/ ChessBoard.SIZE);

                //position is valid
                if(eightQueenModel.addQueen(x,y)){
                    Queen queen = new Queen(x,y);
                    qlist.add(queen);
                    drawQueen(queen);
                    numOfQueen++;//make sure only 8 queens are available
                }
            }
        });
    }

    public static void cancelAddQueenEvent(){
        chessBoard.getCanvas().setOnMouseClicked(event -> {});
    }

    public static void clearBoard(){
        chessBoard.updateChessBoard();
        chessBoard.drawBoard();
        numOfQueen = 0;
    }

    private static void drawQueen(Queen queen){
        double startX = queen.getX()* ChessBoard.SIZE + (ChessBoard.SIZE - ChessBoard.PSIZE) / 2;
        double startY = queen.getY()* ChessBoard.SIZE + (ChessBoard.SIZE - ChessBoard.PSIZE) / 2;
        chessBoard.getGc().drawImage(queen.getImage(),startX,startY, ChessBoard.PSIZE, ChessBoard.PSIZE);
    }

    public static void drawSolution(){
        clearBoard();
        byte[] pos = eightQueenModel.getSolutionList().get(eightQueenModel.getPointer());
        for(int i = 0; i<EightQueenModel.N; ++i){
            double startX = i* ChessBoard.SIZE + (ChessBoard.SIZE - ChessBoard.PSIZE) / 2;
            double startY = pos[i]* ChessBoard.SIZE + (ChessBoard.SIZE - ChessBoard.PSIZE) / 2;
            chessBoard.getGc().drawImage(new Image("one/picture/blackQueen.png"), startX, startY, ChessBoard.PSIZE, ChessBoard.PSIZE );
        }
    }
}
