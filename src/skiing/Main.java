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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Skiing skiing = new Skiing();
        skiing.readFile("skiing_map_example.txt");
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

        int mostX = 0, mostY = 0;

        for (int x = 0; x < gridX; x++) {
            for (int y = 0; y < gridY; y++) {
                Prediction prediction = new Prediction(grid, x, y, gridX, gridY);
                System.out.println("Longest path on ["+x+"]["+y+"] -> " + prediction.getSteepest());
                if (steepest.size() < prediction.getSteepest().size()) {
                    steepest = prediction.getSteepest();
                    mostX = x;
                    mostY = y;
                } else if (steepest.size() == prediction.getSteepest().size()) {
                    int iiSize = prediction.getSteepest().get(0) - prediction.getSteepest().get(prediction.getSteepest().size() - 1);
                    int steepestSize = steepest.get(0) - steepest.get(steepest.size() - 1);
                    if (steepestSize < iiSize) {
                        steepest = prediction.getSteepest();
                        mostX = x;
                        mostY = y;
                    }
                }
            }
//            System.out.println();
        }
        
        System.out.println("\nMap size: " + gridX + " x " + gridY);
        System.out.println(steepest);
        System.out.println("Starting point: x=" + mostX + ", y=" + mostY);
        System.out.println("Length: " + steepest.size());
        System.out.println("Drop: " + (steepest.get(0) - steepest.get(steepest.size() - 1)));
    }

}
