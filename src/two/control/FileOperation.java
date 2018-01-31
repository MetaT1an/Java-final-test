package two.control;

import two.model.StuInfo;

import java.io.*;
import java.util.ArrayList;

public class FileOperation {
    private static File file = new File("src/two/files/records.txt");

    public static void AddRecords(StuInfo stuInfo){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Fail to create new files");
                e.printStackTrace();
            }
        }

        try(FileOutputStream fos = new FileOutputStream(file,true);
            ObjectOutputStream oos = new ObjectOutputStream(fos)
        ){

            oos.writeObject(stuInfo);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<StuInfo> getRecords(){
        if(!file.exists()){
            System.out.println("No records yet");
            return null;
        }
        else{
            ArrayList<StuInfo> list = new ArrayList<>();
            StuInfo temp = null;

            try(FileInputStream fis = new FileInputStream(file)
            ){
                ObjectInputStream ois = null;
                while (fis.available() > 0){
                    try {
                        ois = new ObjectInputStream(fis);
                        temp = (StuInfo) ois.readObject();
                        list.add(temp);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return list;
        }
    }

}
