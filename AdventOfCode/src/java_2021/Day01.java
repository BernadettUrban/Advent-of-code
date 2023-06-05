package java_2021;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {
    public static void main(String[] args) {
        List<String> lines = readFileInList("AdventOfCode\\src\\txt_2021\\01.txt");
        List<Integer> depths = new ArrayList<>();
        for (String s : lines) {
            depths.add(Integer.valueOf(s));
        }
    /**part 1
        int counter = 0;
        for (int i = 0; i < depths.size() - 1; i++) {
            if (depths.get(i) < depths.get(i + 1)) {
                counter++;
            }
        }
        System.out.println(counter);
    **/
        int windowSum = 0;
        int count = 0;
        int k = 3;

        for(int i=0;i<k;i++){
            windowSum+= depths.get(i);
        }

        for(int i=k;i< depths.size();i++){
            var sum = windowSum + depths.get(i)- depths.get(i-k);
            if (sum > windowSum) {
                count++;
            }
            windowSum = sum;
        }
        System.out.println(count);

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
