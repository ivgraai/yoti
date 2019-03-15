package hu.ivgraai.yoti.logic;

import java.util.stream.IntStream;

/**
 * @author Gergo Ivan
 */
public class Model {

    private boolean[][] grid;
    private final int xLength;
    private final int yLength;
    private int xCoordinate;
    private int yCoordinate;
    private int count;

    public Model(int xLength, int yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
        grid = new boolean[xLength][];
        IntStream.range(0, xLength).forEach(i -> grid[i] = new boolean[yLength]);
    }

    public void initialize(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        count = 0;
    }

    public void setPatch(int xCoordinate, int yCoordinate) {
        grid[xCoordinate][yCoordinate] = true;
    }

    public void moveNorth() {
        if (0 < xCoordinate) {
            --xCoordinate;
        }
        afterMovement();
    }

    public void moveSouth() {
        if (xCoordinate < xLength - 1) {
            ++xCoordinate;
        }
        afterMovement();
    }

    public void moveWest() {
        if (0 < yCoordinate) {
            --yCoordinate;
        }
        afterMovement();
    }

    public void moveEast() {
        if (yCoordinate < yLength - 1) {
            ++yCoordinate;
        }
        afterMovement();
    }

    private void afterMovement() {
        if (grid[xCoordinate][yCoordinate]) {
            ++count;
            grid[xCoordinate][yCoordinate] = false;
        }
    }

    public int getCurrentX() {
        return xCoordinate;
    }

    public int getCurrentY() {
        return yCoordinate;
    }

    public int cleanedPatches() {
        return count;
    }

}
