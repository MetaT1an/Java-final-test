package two.control;

import two.model.StuInfo;
import two.view.InfoCenter;

public class InfoControl {
    private static InfoCenter infoCenter = InfoCenter.getInfoCenter();

    public static void addInfoEvents(){
        summit();
        next();
        quit();
    }

    private static void addRecords(){
        String name = infoCenter.getTextField(0).getText();
        String id = infoCenter.getTextField(1).getText();
        String score = infoCenter.getTextField(2).getText();

        StuInfo stuInfo;
        if("".equals(score))
            stuInfo = new StuInfo(name, id);
        else
            stuInfo = new StuInfo(name, id, Double.parseDouble(score));

        FileOperation.addRecords(stuInfo);
    }

    private static void summit(){
        infoCenter.getButton(0).setOnAction(event -> {
            addRecords();

            for(int i = 0; i<3; ++i){
                infoCenter.getTextField(i).setDisable(true);
            }
        });
    }

    private static void next(){
        infoCenter.getButton(1).setOnAction(event -> {
            for(int i = 0; i<3; ++i){
                infoCenter.getTextField(i).setDisable(false);
                infoCenter.getTextField(i).clear();
            }
        });
    }

    private static void quit(){
        infoCenter.getButton(2).setOnAction(event -> {
            ConsoleControl.changeSceneToCanvas();
        });
    }
}
