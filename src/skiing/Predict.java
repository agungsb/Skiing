/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiing;

import java.util.ArrayList;

/**
 *
 * @author Agung Surya Bangsa
 */
public class Predict {

    private int gridX;
    private int gridY;
    private int[][] grid;
    private int x;
    private int y;
    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> bp = new ArrayList<>();

    public Predict() {

    }

    public Predict(int[][] grid, int x, int y, int gridX, int gridY) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.gridX = gridX;
        this.gridY = gridY;
        path.add(grid[x][y]);
        compare(path, x, y);
    }

    private void compare(ArrayList<Integer> length, int x, int y) {
        System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y]);
        boolean hasLeft = false, hasRight = false, hasBottom = false;
        if (left(x, y) == 1) {
            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " has left. Now let's do the recursive on this: " + x + " - " + (y - 1));
//            compare(length, x, y - 1);
            hasLeft = true;
        } else {
            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " doesn't have left");
        }
        if (right(x, y) == 1) {
            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " has right. Now let's do the recursive on this: " + x + " - " + (y + 1));
//            compare(length, x, (y + 1));
            hasRight = true;
        } else {
            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " doesn't have right");
        }
        if (bottom(x, y) == 1) {
            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " has bottom. Now let's do the recursive on this: " + (x + 1) + " - " + y);
//            compare(length, x + 1, y);
            hasBottom = true;
        } else {
            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " doesn't have bottom");
        }
        ArrayList<ArrayList<Integer>> c = new ArrayList<>();
        ArrayList<ArrayList<Integer>> e = new ArrayList<>();
        ArrayList<Integer> branchPoint = new ArrayList<>();
        ArrayList<Integer> endPoint = new ArrayList<>();
        ArrayList<Integer> toLeft = new ArrayList<>();
        ArrayList<Integer> toRight = new ArrayList<>();
        ArrayList<Integer> toBottom = new ArrayList<>();
        ArrayList<ArrayList<Integer>> Left = new ArrayList<>();
        ArrayList<ArrayList<Integer>> Right = new ArrayList<>();
        ArrayList<ArrayList<Integer>> Bottom = new ArrayList<>();
        if (hasLeft && hasRight && hasBottom) {
            System.out.println("Branches everywhere");
            branchPoint.add(x);
            branchPoint.add(y);
            c.add(branchPoint);
            System.out.println("Branch point: " + c.toString());
            toLeft.add(grid[x][y-1]);
            System.out.println("toLeft: " + toLeft.toString());
            compare(length, x, y - 1);
            compare(length, x, (y + 1));
            compare(length, x + 1, y);
        } else if (hasLeft && hasRight && !hasBottom) {
            System.out.println("Branches on Left and Right");
            branchPoint.add(x);
            branchPoint.add(y);
            c.add(branchPoint);
            System.out.println("Branch point: " + c.toString());
            compare(length, x, y - 1);
            compare(length, x, (y + 1));
        } else if (hasLeft && !hasRight && hasBottom) {
            System.out.println("Branches on Left and Bottom");
            branchPoint.add(x);
            branchPoint.add(y);
            c.add(branchPoint);
            System.out.println("Branch point: " + c.toString());
            compare(length, x, y - 1);
            compare(length, x + 1, y);
        } else if (!hasLeft && hasRight && hasBottom) {
            System.out.println("Branches on Right and Bottom");
            branchPoint.add(x);
            branchPoint.add(y);
            c.add(branchPoint);
            System.out.println("Branch point: " + c.toString());
            compare(length, x, (y + 1));
            compare(length, x + 1, y);
        } else if (hasLeft && !hasRight && !hasBottom) {
            System.out.println("Branch on Left");
            compare(length, x, y - 1);
        } else if (!hasLeft && hasRight && !hasBottom) {
            System.out.println("Branch on Right");
            compare(length, x, (y + 1));
        } else if (!hasLeft && !hasRight && hasBottom) {
            System.out.println("Branch on Bottom");
            toBottom.add(grid[x+1][y]);
            System.out.println("toBottom: " + toBottom.toString());
            compare(length, x + 1, y);
        } else {
            System.out.println("End of the story");
            endPoint.add(x);
            endPoint.add(y);
            e.add(endPoint);
            System.out.println("End point: " + e.toString());
        }
    }

    public int left(int x, int y) {
        int result = 0;
        if (y > 0) {
            if (grid[x][y] > grid[x][y - 1]) {
                result = 1;
            }
        }
        return result;
    }

    public int right(int x, int y) {
        int result = 0;
        if (y < (gridY - 1)) {
            if (grid[x][y] > grid[x][y + 1]) {
                result = 1;
            }
        }
        return result;
    }

    public int bottom(int x, int y) {
        int result = 0;
        if (x < (gridX - 1)) {
            if (grid[x][y] > grid[x + 1][y]) {
                result = 1;
            }
        }
        return result;
    }
}
