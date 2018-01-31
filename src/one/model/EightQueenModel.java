package one.model;

import java.util.ArrayList;

public class EightQueenModel {
    public static int N = 8;

    private boolean[][] arr;
    private ArrayList<byte[]> solutionList;
    private int pointer;

    private static EightQueenModel eightQueenModel = null;

    public static EightQueenModel getInstance(){
        if(eightQueenModel == null)
            eightQueenModel = new EightQueenModel();
        return eightQueenModel;
    }

    public static void setN(int n){
        N = n;
    }

    private EightQueenModel(){
        arr = new boolean[N][N];
        solutionList = new ArrayList<>();
        pointer = 0;
    }

    public ArrayList<byte[]> getSolutionList() {
        return solutionList;
    }

    public int getPointer(){
        return pointer;
    }

    public void addPointer(){
        pointer = (pointer + 1) % solutionList.size();
    }

    public void subPointer(){
        pointer = (pointer - 1 + solutionList.size()) % solutionList.size();
    }

    public boolean addQueen(int i, int j){
        if(i<N && j<N && !arr[i][j]){
            arr[i][j] = true;
            return true;
        }
        else
            return false;
    }

    public boolean isValid(int k,int j){
        for(int i =0;i<N;++i){
            if(arr[i][j])   //conflict with row
                return false;
        }
        for(int i=k-1,m=j-1;i>=0&&m>=0;i--,m--){
            if(arr[i][m])   //left-up
                return false;
        }
        for(int i=k-1,m=j+1;i>=0&&m<=N-1;i--,m++){
            if(arr[i][m])  //right-up
                return false;
        }
        return true;
    }

    public void findSolution(int i){
        if(i==N){
            byte[] solution = new byte[N];
            for(byte q = 0; q<N; ++q){
                for(byte t = 0; t<N; ++t){
                    if(arr[q][t]){
                        solution[q] = t;
                        break;
                    }
                }
            }
            solutionList.add(solution);
            return;
        }
        for(int m=0;m<N;m++){       //recursion
            if(isValid(i,m)){
                arr[i][m]=true;
                findSolution(i+1);
                arr[i][m]=false;   //value of last level
            }
        }
    }

    public void clear(){
        arr = new boolean[N][N];
        pointer = 0;
    }
}
