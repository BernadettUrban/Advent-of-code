package java_2015.Day02;

import java_2015.FileReader;

import java.util.List;

public class Day02 {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readFileInList("");
        int area = 0;

        for (int i = 0; i < lines.size(); i++) {
            int currentArea = 0;
            String[] dimensions = lines.get(i).split("x");

            int l = Integer.valueOf(dimensions[0]);
            int w = Integer.valueOf(dimensions[1]);
            int h = Integer.valueOf(dimensions[2]);

            int sideOne = l * w;
            int sideTwo = w * h;
            int sideThree = h * l;
            int min = Math.min(Math.min(sideOne, sideTwo), sideThree);

            currentArea = 2 * sideOne + 2 * sideTwo + 2 * sideThree + min;

            area += currentArea;

        }
        System.out.println(area);
    }
}
