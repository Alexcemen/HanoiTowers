package my;

import com.javarush.engine.cell.Color;

import java.util.ArrayList;
import java.util.List;

public class Ring {
    private int mainX;
    private int mainY;
    private final int value;
    private List<RingCoordinate> ringCoordinates = new ArrayList<>();
    private Color color;

    public Ring(int mainX, int mainY, int value) {
        this.mainX = mainX;
        this.mainY = mainY;
        this.value = value;
        this.ringCoordinates = createRingCoordinates();
        this.color = setColor(value);
    }

    public void setMainX(int mainX) {
        this.mainX = mainX;
        this.ringCoordinates = createRingCoordinates();
    }

    public void setMainY(int mainY) {
        this.mainY = mainY;
        this.ringCoordinates = createRingCoordinates();
    }

    public int getMainX() {
        return mainX;
    }

    public int getMainY() {
        return mainY;
    }

    public Color getColor() {
        return color;
    }

    private Color setColor(int value) {
        return switch (value) {
            case 1 -> Color.BLUE;
            case 2 -> Color.GREEN;
            case 3 -> Color.YELLOW;
            case 4 -> Color.ORANGE;
            case 5 -> Color.RED;
            default -> Color.PINK;
        };
    }

    public List<RingCoordinate> getRingCoordinates() {
        return ringCoordinates;
    }

    private List<RingCoordinate> createRingCoordinates() {
        List<RingCoordinate> coordinates = new ArrayList<>();
        for (int i = mainX - value; i <= mainX + value; i++) {
            coordinates.add(new RingCoordinate(i, mainY));
            coordinates.add(new RingCoordinate(i, mainY-1));
        }
        return coordinates;
    }
}
