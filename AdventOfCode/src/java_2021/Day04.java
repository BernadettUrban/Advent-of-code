package java_2021;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Day04 {
    public static void main(String[] args) throws IOException {

        File file = new File("AdventOfCode\\src\\txt_2021\\04ex.txt");
        List<Integer> numbers = getDrawingNumbers(file);
        List<int[][]>grids = getGrids(file);
        System.out.println(numbers);
        for (int i = 0; i < grids.size(); i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.println(grids.get(i)[j][k]);
                }
            }
        }
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < grids.size(); i++) {
            //System.out.println(checkWinningCondition(grids.get(i), numbers,integerSet));
        }
        for(int[][] grid : grids) {
            Set<Integer> cmpList = new HashSet<>();
            boolean hasWon = checkWinningCondition(grid, numbers, cmpList);
            System.out.println(hasWon);
        }
            //

        /*System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);
            String[] split = current.split(" ");
            for (int j = 0; j < split.length; j++) {
                //System.out.println(split[j]);
            }

        }*/
    }
    public static List<Integer> getDrawingNumbers(File file) throws IOException {
        List<Integer> nums = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                if(line.isBlank()) {
                    break;
                }
                nums.addAll(Arrays.stream(line.split(","))
                        .map(n -> Integer.parseInt(n)).collect(Collectors.toList()));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nums;
    }
    public static List<int[][]> getGrids(File file) {
            List<int[][]> grids = new ArrayList<>();

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";
                int skipRows = 1;
                //skip drawing numbers
                while ((line = br.readLine()) != null && skipRows > 0) {
                    skipRows--;
                }

                int[][] grid = new int[5][5];
                int row = 0;
                int col = 0;
                while((line = br.readLine()) != null) {
                    if(line.isBlank()) {
                        grids.add(grid);
                        grid = new int[5][5];
                        row = 0;
                        continue;
                    }

                    Integer[] nums = Arrays.stream(line.split(" "))
                            .filter(n -> !n.isBlank())
                            .map(n -> Integer.parseInt(n)).toArray(Integer[]::new);
                    for(int num : nums) {
                        grid[row][col++] = num;
                    }
                    col = 0;
                    row++;
                }
                grids.add(grid);
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return grids;
        }

        public static boolean checkWinningCondition(int[][] grid,
                                                    List<Integer> drawingNumbers,
                                                    Set<Integer> setOfNumbers){
            for (int i = 0; i < grid.length; i++) {
                int[] row = grid[i];
                Arrays.stream(row).forEach(num -> {
                    setOfNumbers.add(num);
                });
                if(drawingNumbers.containsAll(setOfNumbers)){
                    return true;
                }
                setOfNumbers.clear();
            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    setOfNumbers.add(grid[j][i]);
                }
                if(drawingNumbers.containsAll(setOfNumbers)){
                    return true;
                }
                setOfNumbers.clear();
            }



            return false;
        }
}
