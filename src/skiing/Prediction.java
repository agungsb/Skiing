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
public class Prediction {

    private int gridX;
    private int gridY;
    private int[][] grid;
    private int x;
    private int y;
    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> bp = new ArrayList<>();

    ArrayList<Integer> steepest = new ArrayList<>(); // Hasil akhir

    public Prediction() {

    }

    public Prediction(int[][] grid, int x, int y, int gridX, int gridY) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.gridX = gridX;
        this.gridY = gridY;
        path.add(grid[x][y]);
        bp.add(path);
        compare(bp, x, y);
//        System.out.println("Finished: " + bp.toString());
        steepest = bp.get(0);
        for (ArrayList<Integer> ii : bp) {
            if (steepest.size() < ii.size()) {
                steepest = ii;
            } else if (steepest.size() == ii.size()) {
                int iiSize = ii.get(0) - ii.get(ii.size() - 1);
                int steepestSize = steepest.get(0) - steepest.get(steepest.size() - 1);
                if (steepestSize < iiSize) {
                    steepest = ii;
                }
            }
//            System.out.println(ii + " -> Length: " + ii.size() + ", Distance: " + (ii.get(0) - ii.get(ii.size() - 1)));
        }
//        System.out.println(steepest);
    }

    public ArrayList<Integer> getSteepest() {
        return this.steepest;
    }

    private void compare(ArrayList<ArrayList<Integer>> length, int x, int y) {
        ArrayList<ArrayList<Integer>> localLength = new ArrayList<>();
        localLength = (ArrayList<ArrayList<Integer>>) length.clone();
        ArrayList<Integer> localPath = new ArrayList<>();
        int initLength = length.size();
//        System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y]);
        boolean hasLeft = false, hasRight = false, hasBottom = false;
        if (left(x, y) == 1) {
            localPath.clear();
//            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " has left. Now let's do the recursive on this: " + x + " - " + (y - 1));
            for (Integer ii : localLength.get(localLength.size() - 1)) {
//                System.out.println(ii);
                localPath.add(ii);
            }
            localPath.add(grid[x][y - 1]);
//            System.out.println(localPath.toString());
            length.add(localPath);
//            System.out.println(length.toString());
            compare(length, x, y - 1);
            hasLeft = true;
        } else {
//            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " doesn't have left");
        }
        if (right(x, y) == 1) {
            localPath.clear();
//            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " has right. Now let's do the recursive on this: " + x + " - " + (y + 1));
            for (Integer ii : localLength.get(localLength.size() - 1)) {
//                System.out.println(ii);
                localPath.add(ii);
            }
            localPath.add(grid[x][y + 1]);
//            System.out.println(localPath.toString());
            length.add(localPath);
//            System.out.println(length.toString());
            compare(length, x, (y + 1));
            hasRight = true;
        } else {
//            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " doesn't have right");
        }
        if (bottom(x, y) == 1) {
            localPath.clear();
//            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " has bottom. Now let's do the recursive on this: " + (x + 1) + " - " + y);
            for (Integer ii : localLength.get(localLength.size() - 1)) {
//                System.out.println(ii);
                localPath.add(ii);
            }
            localPath.add(grid[x + 1][y]);
//            System.out.println(localPath.toString());
            length.add(localPath);
//            System.out.println(length.toString());
            compare(length, x + 1, y);
            hasBottom = true;
        } else {
//            System.out.println("grid[" + x + "][" + y + "]: " + grid[x][y] + " doesn't have bottom");
        }
//        System.out.println(length.toString());
        bp = (ArrayList<ArrayList<Integer>>) length.clone();
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
