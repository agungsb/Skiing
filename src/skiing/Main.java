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
        long startTime = System.currentTimeMillis();
        Skiing skiing = new Skiing();
        skiing.readFile("skiing_map.txt");
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

        int startX = 0, startY = 0;

//        System.out.println(grid[x][y]);
        for (int x = 0; x < gridX; x++) {
            for (int y = 0; y < gridY; y++) {
                Prediction prediction = new Prediction(grid, x, y, gridX, gridY);
//                System.out.println("Longest path on ["+x+"]["+y+"] -> " + prediction.getSteepest());
                if (steepest.size() < prediction.getSteepest().size()) {
                    steepest = prediction.getSteepest();
                    startX = x;
                    startY = y;
//                    System.out.println("Longest path on ["+x+"]["+y+"] -> " + steepest + ", Drop: " + (steepest.get(0) - steepest.get(steepest.size() - 1)) + ", Length: " + steepest.size());
                } else if (steepest.size() == prediction.getSteepest().size()) {
                    int iiSize = prediction.getSteepest().get(0) - prediction.getSteepest().get(prediction.getSteepest().size() - 1);
                    int steepestSize = steepest.get(0) - steepest.get(steepest.size() - 1);
                    if (steepestSize < iiSize) {
                        steepest = prediction.getSteepest();
                        startX = x;
                        startY = y;
                    }
//                    System.out.println("Longest path on ["+x+"]["+y+"] -> " + steepest + ", Drop: " + (steepest.get(0) - steepest.get(steepest.size() - 1)) + ", Length: " + steepest.size());
                }
            }
        }

        System.out.println("\nMap size: " + gridX + " x " + gridY);
        System.out.println(steepest);
        System.out.println("Starting point: x=" + startX + ", y=" + startY);
        System.out.println("Length: " + steepest.size());
        System.out.println("Drop: " + (steepest.get(0) - steepest.get(steepest.size() - 1)));
        String email = steepest.size() + "" + (steepest.get(0) - steepest.get(steepest.size() - 1) + "@redmart.com");
        System.out.println("E-mail: " + email);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to compute path: " + ((endTime - startTime) / 1000) + "s");
    }

}
