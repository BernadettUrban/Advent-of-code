package java_2021;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

class Submarine{
    private int horizontal;
    private int depth;

    public Submarine(int horizontal, int depth) {
        this.horizontal = horizontal;
        this.depth = depth;
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
        List<String> lines = readFileInList("AdventOfCode\\src\\txt_2021\\02.txt");
       
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
