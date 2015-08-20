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
public class Methods {

    ArrayList<Integer> path = new ArrayList<>();

    private int gridX;
    private int gridY;
    private int[][] grid;
    private int x;
    private int y;
    private int current;

    public Methods(int[][] grid, int current, int x, int y, int gridX, int gridY) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.gridX = gridX;
        this.gridY = gridY;
        this.current = current;
    }

    public void recursive() {
        compare(x, y);
    }

    public void compare(int x, int y) {
        System.out.println("Root: " + grid[x][y]);
        System.out.println();
        if ((x == 0) && (y == 0)) {
//            System.out.println("Top left: " + grid[x][y]);
            compareToRight(path, x, y);
            compareToBottom(path, x, y);
        } else if ((x == 0) && (y == (gridY - 1))) {
//            System.out.println("Top right: " + grid[x][y]);
            compareToLeft(path, x, y);
            compareToBottom(path, x, y);
        } else if ((x == (gridX - 1)) && (y == 0)) {
//            System.out.println("Bottom left: " + grid[x][y]);
            compareToRight(path, x, y);
        } else if ((x == (gridX - 1)) && (y == (gridY - 1))) {
//            System.out.println("Bottom right: " + grid[x][y]);
            compareToLeft(path, x, y);
        } else if (y == 0) {
//            System.out.println("Left: " + grid[x][y]);
            compareToRight(path, x, y);
            compareToBottom(path, x, y);
        } else if (y == (gridY - 1)) {
//            System.out.println("Right: " + grid[x][y]);
            compareToLeft(path, x, y);
            compareToBottom(path, x, y);
        } else if (x == (gridX - 1)) {
//            System.out.println("Bottom: " + grid[x][y]);
            compareToLeft(path, x, y);
            compareToRight(path, x, y);
        } else {
//            System.out.println("Middle: " + grid[x][y]);
            compareToLeft(path, x, y);
            compareToRight(path, x, y);
            compareToBottom(path, x, y);
        }
    }

    public void compareToLeft(ArrayList<Integer> path, int xx, int yy) {
//        y -= 1;
//        System.out.println(grid[this.x][this.y] + " is bigger than " + grid[xx][yy-1]);
        if (grid[xx][yy] > grid[xx][yy - 1]) {
            int y = yy - 1;
            int x = xx;
//            System.out.println(grid[x][y]);
            if ((x == 0) && (y == 0)) {
                System.out.println("Top left: " + grid[x][y]);
                compareToRight(path, x, y);
                compareToBottom(path, x, y);
            } else if ((x == 0) && (y == (gridY - 1))) {
                System.out.println("Top right: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToBottom(path, x, y);
            } else if ((x == (gridX - 1)) && (y == 0)) {
                System.out.println("Bottom left: " + grid[x][y]);
                compareToRight(path, x, y);
            } else if ((x == (gridX - 1)) && (y == (gridY - 1))) {
                System.out.println("Bottom right: " + grid[x][y]);
                compareToLeft(path, x, y);
            } else if (y == 0) {
                System.out.println("Left: " + grid[x][y]);
                compareToRight(path, x, y);
                compareToBottom(path, x, y);
            } else if (y == (gridY - 1)) {
                System.out.println("Right: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToBottom(path, x, y);
            } else if (x == (gridX - 1)) {
                System.out.println("Bottom: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToRight(path, x, y);
            } else {
                System.out.println("Middle: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToRight(path, x, y);
                compareToBottom(path, x, y);
            }
        } else{
//            System.out.println("End of node");
            System.out.println("Cannot compareToLeft: " + grid[xx][yy] + " with " + grid[xx][yy - 1]);
        }
    }

    public void compareToRight(ArrayList<Integer> path, int xx, int yy) {
//        y += 1;
//        System.out.println(grid[xx][yy] + " vsd " + grid[xx][yy + 1]);
        if (grid[xx][yy] > grid[xx][yy + 1]) {
            int y = yy + 1;
            int x = xx;
//            System.out.println(grid[x][y]);
            if ((x == 0) && (y == 0)) {
                System.out.println("Top left: " + grid[x][y]);
                compareToRight(path, x, y);
                compareToBottom(path, x, y);
            } else if ((x == 0) && (y == (gridY - 1))) {
                System.out.println("Top right: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToBottom(path, x, y);
            } else if ((x == (gridX - 1)) && (y == 0)) {
                System.out.println("Bottom left: " + grid[x][y]);
                compareToRight(path, x, y);
            } else if ((x == (gridX - 1)) && (y == (gridY - 1))) {
                System.out.println("Bottom right: " + grid[x][y]);
                compareToLeft(path, x, y);
            } else if (y == 0) {
                System.out.println("Left: " + grid[x][y]);
                compareToRight(path, x, y);
                compareToBottom(path, x, y);
            } else if (y == (gridY - 1)) {
                System.out.println("Right: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToBottom(path, x, y);
            } else if (x == (gridX - 1)) {
                System.out.println("Bottom: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToRight(path, x, y);
            } else {
                System.out.println("Middle: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToRight(path, x, y);
                compareToBottom(path, x, y);
            }
        }else{
//            System.out.println("End of node");
            System.out.println("Cannot compareToRight: " + grid[xx][yy] + " with " + grid[xx][yy + 1]);
        }
    }

    public void compareToBottom(ArrayList<Integer> path, int xx, int yy) {
//        x += 1;
        if (grid[xx][yy] > grid[xx + 1][yy]) {
            int x = xx + 1;
            int y = yy;
//            System.out.println(grid[x][y]);
            if ((x == 0) && (y == 0)) {
                System.out.println("Top left: " + grid[x][y]);
                compareToRight(path, x, y);
                compareToBottom(path, x, y);
            } else if ((x == 0) && (y == (gridY - 1))) {
                System.out.println("Top right: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToBottom(path, x, y);
            } else if ((x == (gridX - 1)) && (y == 0)) {
                System.out.println("Bottom left: " + grid[x][y]);
                compareToRight(path, x, y);
            } else if ((x == (gridX - 1)) && (y == (gridY - 1))) {
                System.out.println("Bottom right: " + grid[x][y]);
                compareToLeft(path, x, y);
            } else if (y == 0) {
                System.out.println("Left: " + grid[x][y]);
                compareToRight(path, x, y);
                compareToBottom(path, x, y);
            } else if (y == (gridY - 1)) {
                System.out.println("Right: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToBottom(path, x, y);
            } else if (x == (gridX - 1)) {
                System.out.println("Bottom: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToRight(path, x, y);
            } else {
                System.out.println("Middle: " + grid[x][y]);
                compareToLeft(path, x, y);
                compareToRight(path, x, y);
                compareToBottom(path, x, y);
            }
        }else{
//            System.out.println("End of node");
            System.out.println("Cannot compareToBottom: " + grid[xx][yy] + " with " + grid[xx + 1][yy]);
        }
    }
}
