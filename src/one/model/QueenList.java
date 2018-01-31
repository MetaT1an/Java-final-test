package one.model;

import java.util.ArrayList;

public class QueenList {
    private ArrayList<Queen> list;

    private static QueenList queenList = null;

    public static QueenList getInstance(){
        if(queenList == null)
            queenList = new QueenList();
        return queenList;
    }

    private QueenList(){
        list = new ArrayList<>();
    }

    public void add(Queen q){
        list.add(q);
    }

    public void clear(){
        list.clear();
    }

    public int size(){
        return list.size();
    }

    public Queen get(int i){
        return list.get(i);
    }
}
