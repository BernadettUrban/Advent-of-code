package java_2021;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

class Submarine{
    private int horizontal;
    private int depth;

    private int aim;

    public Submarine(int horizontal, int depth, int aim) {
        this.horizontal = horizontal;
        this.depth = depth;
        this.aim = aim;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
public class Day02 {
    public static void main(String[] args) {
        FileReaderClass fileReaderClass = new FileReaderClass();
        String filename="02.txt";
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile.toAbsolutePath());
        List<String> lines = fileReaderClass.readFileWithScanner("C:\\Users\\Lenovo Ideapad\\Desktop\\Huli\\Advent-of-code\\AdventOfCode\\src\\02.txt");
                //readFileInList("C:\\Users\\Lenovo Ideapad\\Desktop\\Huli\\Advent-of-code\\AdventOfCode\\src\\02.txt");

        Submarine submarine = new Submarine(0,0,0);
        for (String s: lines){
            String [] split = s.split(" ");
            String command = split[0];
            int number = Integer.valueOf(split[1]);
            if(command.equals("down")){
                submarine.setAim(submarine.getAim()+number);
            }else if(command.equals("up")){
                submarine.setAim(submarine.getAim()-number);
            }else if(command.equals("forward")){
                submarine.setHorizontal(submarine.getHorizontal()+number);
                //It increases your depth by your aim multiplied by X.
                submarine.setDepth(submarine.getDepth()+submarine.getAim()*number);
            }
        }
        System.out.println(submarine.getHorizontal()* submarine.getDepth());

        /*part 1
        Submarine submarine = new Submarine(0,0);

        for (String s: lines){
            String [] split = s.split(" ");
            String command = split[0];
            int number = Integer.valueOf(split[1]);
            if(command.equals("forward")){
                submarine.setHorizontal(submarine.getHorizontal()+number);
            }else if(command.equals("down")){
                submarine.setDepth(submarine.getDepth()+number);
            }else {
                submarine.setDepth(submarine.getDepth()-number);
            }
        }
        System.out.println(submarine.getHorizontal()* submarine.getDepth());

         */

    }

    public static List<String> readFileInList(String fileName) {

        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(
                    Paths.get(fileName),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {

            // do something
            e.printStackTrace();
        }
        return lines;

    }

}
