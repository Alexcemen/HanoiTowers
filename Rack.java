package my;

import java.util.ArrayList;
import java.util.List;

public class Rack {
    private int mainX;
    private int mainY;
    private List<RackCoordinate> rackCoordinates = new ArrayList<>();
    private List<Ring> ringList = new ArrayList<>();

    public Rack(int mainX, int mainY) {
        this.mainX = mainX;
        this.mainY = mainY;

        rackCoordinates.add(new RackCoordinate(mainX, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-1, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-2, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-3, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-4, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-5, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-6, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-7, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-8, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-9, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-10, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-11, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-12, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-13, mainY));
        rackCoordinates.add(new RackCoordinate(mainX-1, mainY-1));
        rackCoordinates.add(new RackCoordinate(mainX-1, mainY+1));
    }

    public int getMainX() {
        return mainX;
    }

    public int getMainY() {
        return mainY;
    }

    public List<RackCoordinate> getRackCoordinates() {
        return rackCoordinates;
    }

    public List<Ring> getRingList() {
        return ringList;
    }

    public void setRingList(List<Ring> ringList) {
        this.ringList = ringList;
    }
}
