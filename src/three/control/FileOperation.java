package three.control;

import three.model.Client;
import three.model.Transaction;

import java.io.*;
import java.util.ArrayList;

public class FileOperation {
    private static File clientFile = new File("src/three/files/clientRecords.txt");
    private static File transactionFile = new File("src/three/files/transactionRecords.txt");

    public static void AddClient(Client c){
        if(!clientFile.exists()){
            try {
                clientFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Fail to create new files");
                e.printStackTrace();
            }
        }

        try(FileOutputStream fos = new FileOutputStream(clientFile,true);
            ObjectOutputStream oos = new ObjectOutputStream(fos)
        ){

            oos.writeObject(c);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Client> getAllClients(){
        if(!clientFile.exists()){
            System.out.println("No records yet");
            return null;
        } else {

            ArrayList<Client> cList = new ArrayList<>();
            Client temp = null;

            try(FileInputStream fis = new FileInputStream(clientFile)
            ){
                ObjectInputStream ois = null;
                while (fis.available() > 0){
                    try{
                        ois = new ObjectInputStream(fis);
                        temp = (Client)ois.readObject();
                        cList.add(temp);

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return cList;
        }
    }

    public static void writeBack(ArrayList<Client> clientList){
        if(!clientFile.exists()){
            try {
                clientFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Fail to create new files");
                e.printStackTrace();
            }
        } else {
            try(FileOutputStream fos = new FileOutputStream(clientFile)
            ){
                ObjectOutputStream oos = null;
                for(Client c : clientList){
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(c);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void addTscRecord(Transaction transaction){
        if(!transactionFile.exists()){
            try {
                transactionFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Fail to create new files");
                e.printStackTrace();
            }
        }

        try(FileOutputStream fos = new FileOutputStream(transactionFile,true);
            ObjectOutputStream oos = new ObjectOutputStream(fos)
        ){

            oos.writeObject(transaction);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Transaction> getAllTscRecords(){
        if(!transactionFile.exists()){
            System.out.println("No records yet");
            return null;
        } else {

            ArrayList<Transaction> tList = new ArrayList<>();
            Transaction temp = null;

            try(FileInputStream fis = new FileInputStream(transactionFile)
            ){
                ObjectInputStream ois = null;
                while (fis.available() > 0){
                    try{
                        ois = new ObjectInputStream(fis);
                        temp = (Transaction)ois.readObject();
                        tList.add(temp);

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return tList;
        }
    }
}
