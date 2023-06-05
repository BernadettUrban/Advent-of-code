package java_2021;

import java.util.Arrays;
import java.util.List;

public class Day03 {
    public static void main(String[] args) {
        FileReaderClass fileReaderClass = new FileReaderClass();
        List<String> list =  fileReaderClass.readFileInList("AdventOfCode\\src\\txt_2021\\03.txt");
        System.out.println(list);
        int length = list.size();
        int lengthOfWord = list.get(0).length();
        char[][]  array = new char[length][lengthOfWord];
        for (int i = 0;i< list.size();i++) {
            String current = list.get(i);
            for (int j = 0; j < current.length(); j++) {
                array[i][j]= current.charAt(j);
            }
        }
        char[][]  transposedArray = new char[lengthOfWord][length];
        for (int i = 0;i< lengthOfWord;i++) {
            for (int j = 0; j < length; j++) {
                transposedArray[i][j]= array[j][i];
            }
        }

        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        for (int i = 0; i < transposedArray.length; i++) {
            int countZero = 0;
            int countOne = 0;
            for (int j = 0; j < transposedArray[i].length; j++) {
                if(transposedArray[i][j]=='0'){
                    countZero++;
                }else{
                    countOne++;
                }
            }
            if(countZero>countOne){
                gamma.append(0);
                epsilon.append(1);
            }else if(countOne>countZero){
                gamma.append(1);
                epsilon.append(0);
            }
            System.out.println();

        }
        System.out.println(gamma);
        System.out.println(epsilon);

        int decimalGamma=Integer.parseInt(gamma.toString(),2);
        int decimalEpsilon=Integer.parseInt(epsilon.toString(),2);
        System.out.println(decimalGamma*decimalEpsilon);
    }
}
