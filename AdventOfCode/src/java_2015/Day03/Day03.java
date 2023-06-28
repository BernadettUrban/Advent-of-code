package java_2015.Day03;

import java_2015.FileReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class House {
    private final int x;
    private final int y;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "House{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof House that)) {
            return false;
        }
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Object.class.hashCode();
    }
}

public class Day03 {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readFileInList("");
        String input = lines.get(0);
        char[] directions = input.toCharArray();
        House house = new House(0, 0);

        Set<House> uniqueHomes = new HashSet<>();

        uniqueHomes.add(house);
        for (char ch : directions) {
            house = getHouse(ch, house);
            uniqueHomes.add(house);

        }

        System.out.println(uniqueHomes.size());

    }


    public static House getHouse(char character, House house) {

        if (character == '^') {
            house = new House(house.getX() + 1, house.getY());

        } else if (character == 'v') {

            house = new House(house.getX() - 1, house.getY());
        } else if (character == '>') {
            house = new House(house.getX(), house.getY() + 1);

        } else if (character == '<') {
            house = new House(house.getX(), house.getY() - 1);

        }

        return house;
    }

}
