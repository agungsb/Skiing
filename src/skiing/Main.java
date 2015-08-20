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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Skiing skiing = new Skiing();
//        skiing.readFile("skiing_map.txt");
        skiing.readFile("skiing_map.txt");
//        System.out.println(skiing.getText());
        String[] exp;
        int[][] grid;
        exp = skiing.getText().split("\\s+");
        int gridX = Integer.parseInt(exp[0]);
        int gridY = Integer.parseInt(exp[1]);
        grid = new int[gridX][gridY];
        int[] points = new int[exp.length - 2];
        for (int i = 2; i < exp.length; i++) {
            points[i - 2] = Integer.parseInt(exp[i]);
        }
        int flag = 1;
        int gridXFlag = 0;
        int gridYFlag = 0;
        for (int i = flag - 1; i < points.length; i++) {
//            System.out.println(points[i]);
            grid[gridXFlag][gridYFlag] = points[i];
//            System.out.println("[" + gridXFlag + "]" + "[" + gridYFlag + "] -> " + points[i]);
            gridYFlag++;
            if ((flag % gridX) == 0) {
//                System.out.println("newline");
                gridXFlag++;
                gridYFlag = 0;
            }
            flag++;
        }

        ArrayList<Integer> steepest = new ArrayList<>(); // Hasil akhir
        steepest.add(0);

        for (int x = 0; x < gridX; x++) {
            for (int y = 0; y < gridY; y++) {
//                skiing.compare(grid, grid[x][y], x, y, gridX, gridY);
                Prediction prediction = new Prediction(grid, x, y, gridX, gridY);
                System.out.println("Prediction: " + prediction.getSteepest());
                if (steepest.size() < prediction.getSteepest().size()) {
                    steepest = prediction.getSteepest();
                } else if (steepest.size() == prediction.getSteepest().size()) {
                    int iiSize = prediction.getSteepest().get(0) - prediction.getSteepest().get(prediction.getSteepest().size() - 1);
                    int steepestSize = steepest.get(0) - steepest.get(steepest.size() - 1);
                    if (steepestSize < iiSize) {
                        steepest = prediction.getSteepest();
                    }
                }
            }
//            System.out.println();
        }
        System.out.println(steepest);
        System.out.println("Length: " + steepest.size());
        System.out.println("Distance: " + (steepest.get(0) - steepest.get(steepest.size() - 1)));
        int x = 0;
        int y = 3;
//        int x = 2;
//        int y = 3;
//        int x = 2;
//        int y = 0;
//        Metode metode = new Metode(grid, x, y, gridX, gridY);
//        Predict predict = new Predict(grid, x, y, gridX, gridY);
//        Prediction prediction = new Prediction(grid, x, y, gridX, gridY);
//        System.out.println("Prediction: " + prediction.getSteepest());
//        Methods method = new Methods(grid, grid[x][y], x, y, gridX, gridY);
//        method.recursive();
//        System.out.println("Start: " + grid[x][y]);
//        skiing.compare(grid, grid[x][y], x, y, gridX, gridY);
//        skiing.compare(grid, grid[1][1], 1, 1, gridX, gridY);
//        skiing.compare(grid, grid[2][1], 2, 1, gridX, gridY);
//        skiing.compare(grid, grid[2][2], 2, 2, gridX, gridY);
//        skiing.compare(grid, grid[3][1], 3, 1, gridX, gridY);
    }

}
