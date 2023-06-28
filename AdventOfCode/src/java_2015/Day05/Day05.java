package java_2015.Day05;

import java_2015.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Day05 {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readFileInList("");
        String vowels = "aeiou";
        List<String> forbidden = new ArrayList();
        forbidden.add("ab");
        forbidden.add("cd");
        forbidden.add("pq");
        forbidden.add("xy");

        List<String> niceList = new ArrayList();
        for (int i = 0; i < lines.size(); i++) {
            String current = lines.get(i);
            if(isNice(current, vowels, forbidden) == true){
                niceList.add(current);
            }
        }
        System.out.println(niceList.size());
    }
    public static boolean isNice(String input, String vowels, List<String> forbidden ){
        boolean answer= false;
        boolean flagForbidden = false;
        int countVowel = 0;
        int doubleLetterCount = 0;

        for (int i = 0; i < forbidden.size(); i++) {
            if (input.contains(forbidden.get(i))) {
                flagForbidden = true;
                break;
            }

        }
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (vowels.contains(c+"")) {
                countVowel++;
            }
        }

        for (int j = 0; j < input.length() - 1; j++) {
            if (input.charAt(j) == input.charAt(j + 1)) {
                doubleLetterCount++;
            }
        }

        if (countVowel >= 3 && doubleLetterCount >= 1 && flagForbidden == false) {
            answer = true;
        }

        return answer;
    }
}
