package java_2015.Day09;

import java.util.*;

public class Node {

    private String name;

    private List<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) && Objects.equals(shortestPath, node.shortestPath) && Objects.equals(distance, node.distance) && Objects.equals(adjacentNodes, node.adjacentNodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shortestPath, distance, adjacentNodes);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", shortestPath=" + shortestPath +
                ", distance=" + distance +
                ", adjacentNodes=" + adjacentNodes +
                '}';
    }
}

