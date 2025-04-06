package my;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

import java.util.List;

public class Solution extends Game {
    private static final int SIDE = 37;
    private int[][] gameField = new int[SIDE][SIDE];
    private Rack rackA;
    private Rack rackB;
    private Rack rackC;
    private Rack[] racks;
    static int numRings;

    @Override
    public void initialize() {
        numRings = 6;
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.ENTER) {
            new Thread(() -> move(rackA, rackB, rackC, numRings)).start();
        }
    }

    public void move(Rack A, Rack B, Rack C, int numRings) {
        if (numRings > 1) {
            move(A, C, B, numRings - 1);
            swap(A, B);
            move(C, B, A, numRings - 1);
        } else {
            swap(A, B);
        }
    }

    private void swap(Rack A, Rack B) {
        Ring tmp = A.getRingList().getLast();
        A.getRingList().removeLast();
        List<Ring> ringListB = B.getRingList();
        ringListB.add(tmp);
        B.setRingList(ringListB);
        updateRingsCoordinates();
        updateScene();
    }


    private void createGame() {
        gameField = new int[SIDE][SIDE];
        rackA = new Rack(35, 6);
        rackB = new Rack(35, 18);
        rackC = new Rack(35, 30);
        racks = new Rack[]{rackA, rackB, rackC};
        fillRackA(numRings);
    }


    private void drawScene() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                setCellColor(i, j, Color.AQUA);
            }
        }

        for (Rack rack : racks) {
            for (RackCoordinate rackCoordinate : rack.getRackCoordinates()) {
                setCellColor(rackCoordinate.getY(), rackCoordinate.getX(), Color.BROWN);
            }

            for (Ring ring : rack.getRingList()) {
                for (RingCoordinate ringCoordinate : ring.getRingCoordinates()) {
                    setCellColor(ringCoordinate.getX(), ringCoordinate.getY(), ring.getColor());
                }
            }
        }

//        System.out.println("A: " + rackA.getRingList().toString());
//        System.out.println("B: " + rackB.getRingList().toString());
//        System.out.println("C: " + rackC.getRingList().toString());
//        System.out.println();
    }

    private void updateRingsCoordinates() {
        for (Rack rack : racks) {
            List<Ring> ringList = rack.getRingList();
            for (int index = 0, l = 2; index < ringList.size(); index++, l += 2) {
                ringList.get(index).setMainX(rack.getMainY());
                ringList.get(index).setMainY(rack.getMainX() - l);
            }
        }
    }

    private void fillRackA(int numRings) {
        List<Ring> tmp = rackA.getRingList();
        for (int i = numRings, l = 2; i > 0; i--, l += 2, numRings--) {
            Ring ring = new Ring(rackA.getMainY(), rackA.getMainX() - l, numRings);
            tmp.add(ring);
        }
        rackA.setRingList(tmp);
    }

    private void updateScene() {
        drawScene();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
