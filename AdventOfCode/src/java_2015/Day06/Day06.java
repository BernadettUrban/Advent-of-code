package java_2015.Day06;

import java_2015.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Instruction{
    private String action;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Instruction(String action, int startX, int startY, int endX, int endY) {
        this.action = action;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public Instruction() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "action='" + action + '\'' +
                ", startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
    }
}
class Light {
    private int x;
    private int y;
    private boolean state;

    public Light(int x, int y, boolean state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public Light() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getState() {
        return state;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Light{" +
                "x=" + x +
                ", y=" + y +
                ", state=" + state +
                '}';
    }
}

public class Day06 {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readFileInList("C:\\Users\\Lenovo Ideapad\\Desktop\\Huli\\Advent-of-code\\AdventOfCode\\src\\java_2015\\Day06\\day06.txt");


        int countLightsOn = 0;
        List<Instruction>instructions = new ArrayList<>();
        Light[][] lights = new Light[1000][1000];

        for (int m = 0; m < lights.length; m++) {
            for (int j = 0; j < lights.length; j++) {
                lights[m][j] = new Light(m, j, false);
            }
        }


        for(int i = 0; i < lines.size(); i++) {


            String current =
                    //"turn on 0,0 through 2,2";
                    lines.get(i);
                    //"turn off 499,499 through 500,500";
                    //
            //System.out.println(current);
            String[] split = current.split(" ");
            Instruction instruction = new Instruction();

            if(split[0].equals("turn") && split[1].equals("on")){
                instruction.setAction("turn on");
            }else if(split[0].equals("turn") && split[1].equals("off")){
                instruction.setAction("turn off");
            }else if(split[0].equals("toggle")){
                instruction.setAction("toggle");
            }
            String[] startIndexes = new String[2];
            String[] endIndexes = new String[2];
            startIndexes = startIndexes(split);
            endIndexes = endIndexes(split);

            int startX = Integer.valueOf(startIndexes[0]);
            int startY = Integer.valueOf(startIndexes[1]);
            int endX = Integer.valueOf(endIndexes[0]);
            int endY = Integer.valueOf(endIndexes[1]);

            instruction.setStartX(startX);
            instruction.setEndX(endX);
            instruction.setStartY(startY);
            instruction.setEndY(endY);


            instructions.add(instruction);
            
        }


        for (int i = 0; i < instructions.size(); i++) {
            System.out.println(instructions.get(i));
            int startY = instructions.get(i).getStartY();
            int endY= instructions.get(i).getEndY();
            int startX = instructions.get(i).getStartX();
            int endX = instructions.get(i).getEndX();
            for (int j = startX; j <= endX; j++) {
                for (int k = startY; k <= endY; k++) {
                    if(instructions.get(i).getAction().equals("turn on")){
                            //split[0].equals("turn") && split[1].equals("on")){
                        lights[j][k].setState(true);
                        //countLightsOn++;
                    }else if(instructions.get(i).getAction().equals("turn off")){
                        lights[j][k].setState(false);
                        //countLightsOn--;
                    }else if(instructions.get(i).getAction().equals("toggle")){
                        if(lights[j][j].getState()==true){
                            lights[j][k].setState(false);
                            // countLightsOn--;
                        }else if(lights[j][j].getState()==false){
                            lights[j][k].setState(true);
                            //countLightsOn++;
                        }
                    }
                }
            }


        }



        for (int m = 0; m < lights.length; m++) {
            for (int j = 0; j < lights.length; j++) {
                if(lights[m][j].getState()==true){
                    countLightsOn++;
                }
                //System.out.println(lights[m][j]);

            }
            //System.out.println();
        }

        System.out.println(countLightsOn);
        // 4805659 too high
        //13822818 too high :(
        //13822818
        //17808995
        //13693344
        //534742 //is too low 534742 //531297 //435509 //435509 504118 513409
    }


    public static String [] startIndexes(String[] split){
        String[] startIndexes = new String[2];

        if(split[0].equals("toggle")){
            startIndexes = split[1].split(",");


        }else {
            startIndexes = split[2].split(",");

        }
        return startIndexes;
    }
    public static String [] endIndexes(String[] split){
        String[] endIndexes = new String[2];

        if(split[0].equals("toggle")){

            endIndexes = split[3].split(",");

        }else {

            endIndexes = split[4].split(",");
        }
        return endIndexes;
    }

}
