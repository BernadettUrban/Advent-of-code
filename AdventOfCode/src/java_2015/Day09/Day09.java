package java_2015.Day09;

import java_2015.FileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day09 {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();

        FileReader fileReader = new FileReader();
        List<String> lines = fileReader.readFileInList("C:\\Users\\Lenovo Ideapad\\Desktop\\Huli\\Advent-of-code\\AdventOfCode\\src\\java_2015\\Day09\\day09.txt");
        // https://www.baeldung.com/java-dijkstra

        List<Node> cities = new ArrayList<>();
        Graph graph = new Graph();
        for (int i = 0; i < lines.size(); i++) {
            // String input = lines.get(i);
            String[] split = lines.get(i).split(" to ");
            String firstCity = split[0];
            Node city = new Node(firstCity);
            cities.add(city);
            System.out.println(split[0]);

            String[] splitDistance = split[1].split(" = ");
            //
            String secondCity = splitDistance[0];
            Node anotherCity = new Node(secondCity);

            Integer distance = Integer.valueOf(splitDistance[1]);
            //nodeA.addDestination(nodeB, 10);
            city.addDestination(anotherCity, distance);
            graph.addNode(city);
            // System.out.println(splitDistance[0]);
            // System.out.println(splitDistance[1]);
            //System.out.println(secondCity);
           // System.out.println(distance);
            //graph = dijkstra.calculateShortestPathFromSource(graph, city);
        }

        //System.out.println(cities.size());
        //System.out.println(graph.getNodes());
        System.out.println(dijkstra.calculateShortestPathFromSource(graph, cities.get(0)));

    }

}
