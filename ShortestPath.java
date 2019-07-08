package pathFinder;

import map.Coordinate;

import java.util.ArrayList;
import java.util.List;


 //A separate class to stores the original list of coordinates representing the shortest path
 
class ShortestPath {
    private List<Coordinate> cordList;
    private int pathWeight;
    private boolean validPath;

    // Constructor 
    public ShortestPath(List<Coordinate> coordList, int pathWeight) {
        this.cordList = coordList;
        this.pathWeight = pathWeight;
        this.validPath = true;
    }

    
   //Creating a dummy path with the weight is Integer.MAX_VALUE and the coordList is empty.
    
    public ShortestPath() {
        this.cordList = new ArrayList<>();
        this.pathWeight = Integer.MAX_VALUE;
        this.validPath = false;
    }
 
    //Returning the shortest path
    public ShortestPath(ShortestPath start, ShortestPath end) {
        int i = start.cordList.size() - 1;
        Coordinate lastStart = start.cordList.get(i);
        Coordinate firstEnd = end.cordList.get(0);
        if (!lastStart.equals(firstEnd)) {
            // Path is not valid
            cordList = new ArrayList<>();
            validPath = false;
            pathWeight = Integer.MAX_VALUE;
        } else {
            this.cordList = new ArrayList<>(start.cordList);
            // Do not add point connecting the paths twice:
            Coordinate connection = start.cordList.get(i);
            this.cordList.remove(i);
            this.cordList.addAll(end.cordList);
            this.pathWeight = start.pathWeight + end.pathWeight - connection.getTerrainCost();
            this.validPath = true;
        }
    }


    public boolean isValidPath() {
        return validPath;
    }

    public int getWeight() {
        return pathWeight;
    }

    public List<Coordinate> getCoordList() {
        return cordList;
    }
}