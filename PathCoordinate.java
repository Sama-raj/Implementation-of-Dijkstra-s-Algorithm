package pathFinder;

import map.Coordinate;

// Class of a coordinate used for the Dijkstra algorithm.This class stores it's previous coordinate and the total distance from
// the source coordinate.
 
public class PathCoordinate implements Comparable<PathCoordinate>{
    private map.Coordinate pre;
    private map.Coordinate coord;
    private int d;

    // Creating a new path coordinate
    public PathCoordinate(map.Coordinate coordinate) {
        this.coord = coordinate;
        this.pre = null;
        this.d = Integer.MAX_VALUE;
    }

// Creating a path coordinate with know coordinate distance
    public PathCoordinate(map.Coordinate previous, map.Coordinate coordinate, int distance) {
        this.pre = previous;
        this.coord = coordinate;
        this.d = distance;
    }

    @Override
    public int compareTo(PathCoordinate other) {
        return this.d - other.getDistance();
    }


    public void setPrevious(Coordinate previous) {
        this.pre = previous;
    }

    public void setDistance(int distance) {
        this.d = distance;
    }

    public Coordinate getCoordinate() {
        return coord;
    }

    public Coordinate getPrevious() {
        return pre;
    }

    public int getDistance() {
        return d;
    }

    public int getTerrainCost() {
        return coord.getTerrainCost();
    }

    public boolean isImpassable() {
        return coord.getImpassable();
    }
}
