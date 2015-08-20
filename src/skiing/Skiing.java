/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agung Surya Bangsa
 */
public class Skiing {

    String text;
    private int gridX;
    private int gridY;

    ArrayList<Integer> path = new ArrayList<>();

    public Skiing() {}

    public void readFile(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            String text = sb.toString();
            setText(text);
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Skiing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setGrid(int gridX, int gridY) {
        this.gridX = gridX;
        this.gridY = gridY;
    }

    public void compare(int[][] grid, int point, int x, int y, int gridX, int gridY) {
        setGrid(gridX, gridY);
        if ((x == 0) && (y == 0)) {
//            System.out.println("Top left: " + grid[x][y]);
//            compareTopLeft(grid, grid[x][y], x, y);
        } else if ((x == 0) && (y == (this.gridY - 1))) {
//            System.out.println("Top right: " + grid[x][y]);
//            compareTopRight(grid, grid[x][y], x, y);
        } else if ((x == (this.gridX - 1)) && (y == 0)) {
//            System.out.println("Bottom left: " + grid[x][y]);
//            compareBottomLeft(grid, grid[x][y], x, y);
        } else if ((x == (this.gridX - 1)) && (y == (this.gridY - 1))) {
//            System.out.println("Bottom right: " + grid[x][y]);
//            compareBottomRight(grid, grid[x][y], x, y);
        } else if (y == 0) {
//            System.out.println("Left: " + grid[x][y]);
//            compareLeft(grid, grid[x][y], x, y);
        } else if (y == (this.gridY - 1)) {
//            System.out.println("Right: " + grid[x][y]);
//            compareRight(grid, grid[x][y], x, y);
        } else if (x == (this.gridX - 1)) {
//            System.out.println("Bottom: " + grid[x][y]);
//            compareBottom(grid, grid[x][y], x, y);
        } else {
//            System.out.println("Middle: " + grid[x][y]);
//            compareMiddle(grid, grid[x][y], x, y);
        }
        int vb = 0, vr = 0, vl = 0;
        int nextx = 0, nexty = 0, next = 0;
        if (x == (this.gridX - 1)) {
            System.out.println("we are in bottom");
        } else {
            if (grid[x][y] > grid[compareToBottom(grid, point, x, y)][y]) {
                vb = grid[compareToBottom(grid, point, x, y)][y];
                if (vb > next) {
//                    System.out.println("Nilainya lebih besar nih daripada " + next);
                    next = vb;
                    nextx = compareToBottom(grid, point, x, y);
                    nexty = y;
                }
//                System.out.println("Gridx[" + x + "][" + y + "]: " + grid[x][y]);
//                System.out.println("Gridx[" + compareToBottom(grid, point, x, y) + "][" + y + "]: " + vb + " (ToBottom)");
            }
            if (grid[x][y] > grid[x][compareToLeft(grid, point, x, y)]) {
                vl = grid[x][compareToLeft(grid, point, x, y)];
                if (vl > next) {
//                    System.out.println("Nilainya lebih besar nih daripada " + next);
                    next = vl;
                    nextx = x;
                    nexty = compareToLeft(grid, point, x, y);
                }
//                System.out.println("Gridyl[" + x + "][" + y + "]: " + grid[x][y]);
//                System.out.println("Gridyl[" + x + "][" + compareToLeft(grid, point, x, y) + "]: " + vl + " (ToLeft)");
            }
            if (grid[x][y] > grid[x][compareToRight(grid, point, x, y)]) {
                vr = grid[x][compareToRight(grid, point, x, y)];
                if (vr > next) {
//                    System.out.println("Nilainya lebih besar nih daripada " + next);
                    next = vr;
                    nextx = x;
                    nexty = compareToRight(grid, point, x, y);
                } 
//                System.out.println("Gridyr[" + x + "][" + y + "]: " + grid[x][y]);
//                System.out.println("Gridyr[" + x + "][" + compareToRight(grid, point, x, y) + "]: " + vr + " (ToRight)");
            }
//            System.out.println("Finish: " + next);
//            System.out.println("x: " + nextx);
//            System.out.println("y: " + nexty);
            path.add(next);
            System.out.println(path.toString());
        }
//        compare(grid, grid[nextx][nexty], nextx, nexty, gridX, gridY);
    }

    public void compareTopLeft(int[][] grid, int point, int x, int y) {
        compareToBottom(grid, point, x, y);
        compareToRight(grid, point, x, y);
    }

    public void compareTopRight(int[][] grid, int point, int x, int y) {
        compareToLeft(grid, point, x, y);
        compareToRight(grid, point, x, y);
    }

    public void compareBottomLeft(int[][] grid, int point, int x, int y) {
        compareToLeft(grid, point, x, y);
        compareToRight(grid, point, x, y);
    }

    public void compareBottomRight(int[][] grid, int point, int x, int y) {
        compareToLeft(grid, point, x, y);
        compareToRight(grid, point, x, y);
    }

    public void compareLeft(int[][] grid, int point, int x, int y) {
        compareToLeft(grid, point, x, y);
        compareToRight(grid, point, x, y);
    }

    public void compareRight(int[][] grid, int point, int x, int y) {
        compareToLeft(grid, point, x, y);
        compareToRight(grid, point, x, y);
    }

    public void compareBottom(int[][] grid, int point, int x, int y) {
        compareToLeft(grid, point, x, y);
        compareToRight(grid, point, x, y);
    }

    public void compareMiddle(int[][] grid, int point, int x, int y) {
//        System.out.println("Point: " + point);
        if (x < compareToBottom(grid, point, x, y)) {
            x = compareToBottom(grid, point, x, y);
//            System.out.println("Grid[" + x + "][" + y + "]: " + grid[x][y]);
            compare(grid, grid[x][y], x, y, this.gridX, this.gridY);
        }
//        if (y < compareToLeft(grid, point, x, y)) {
//            y = compareToLeft(grid, point, x, y);
////            System.out.println("Grid[" + x + "][" + y + "]: " + grid[x][y]);
//            compare(grid, grid[x][y], x, y, this.gridX, this.gridY);
//        } 
//        if (y < compareToRight(grid, point, x, y)) {
//            y = compareToRight(grid, point, x, y);
////            System.out.println("Grid[" + x + "][" + y + "]: " + grid[x][y]);
//            compare(grid, grid[x][y], x, y, this.gridX, this.gridY);
//        }
    }

    public int compareToLeft(int[][] grid, int point, int x, int y) {
//        int res = 0;
        if (grid[x][y - 1] < point) {
//            System.out.println(grid[x][y - 1]);
//            res = grid[x][y - 1];
            y -= 1;
        }
        return y;
    }

    public int compareToRight(int[][] grid, int point, int x, int y) {
//        int res = 0;
        if (grid[x][y + 1] < point) {
//            System.out.println(point + " lebih kecil dari: " + grid[x][y]);
//            System.out.println(grid[x][y + 1]);
//            res = grid[x][y + 1];
            y += 1;
        }
        return y;
    }

    public int compareToBottom(int[][] grid, int point, int x, int y) {
//        System.out.println("compare to bottom");
//        int res = 0;
        if (grid[x + 1][y] < point) {
//            System.out.println(grid[x + 1][y]);
//            System.out.println(x+1);
//            System.out.println(y);
//            res = grid[x + 1][y];
            x += 1;
        }
        return x;
    }
}
