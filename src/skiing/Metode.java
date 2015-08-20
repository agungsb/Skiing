/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiing;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Agung Surya Bangsa
 */
public class Metode {

    ArrayList<ArrayList<Integer>> posts = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    private int gridX;
    private int gridY;
    private int[][] grid;
    private int x;
    private int y;

    public Metode() {

    }

    public Metode(int[][] grid, int x, int y, int gridX, int gridY) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.gridX = gridX;
        this.gridY = gridY;
//        compare(path, x, y);
        createRoot(x, y);
    }

    private void createRoot(int x, int y) {
        ArrayList<Integer> node = new ArrayList<>();
        node.add(grid[x][y]);
        System.out.println(node.toString());
        createNodeRight(node, x, y);
        int first = node.get(0);
        node.clear();
        node.add(first);
        createNodeBottom(node, x, y);
        node.clear();
        node.add(first);
        createNodeLeft(node, x, y);
    }

    private void recursiveNode(ArrayList<Integer> node, int x, int y) {
        for (Iterator<ArrayList<Integer>> it = posts.iterator(); it.hasNext();) {
            ArrayList<Integer> a = it.next();
            for (Iterator<Integer> its = a.iterator(); its.hasNext();) {
                int aa = its.next();
            }
//            System.out.println(a.toString());
//            createNodeRight(node, x, y);
        }
    }

    private void createNodeRight(ArrayList<Integer> node, int x, int y) {
//        System.out.println(y);
        ArrayList<Integer> mad = new ArrayList<>();
        if (y <= gridY) {
            node.add(grid[x][y + 1]);
            y += 1;
            mad.add(x);
            mad.add(y);
            posts.add(mad);
            System.out.println(posts.toString());
            recursiveNode(node, x, y);
        }
    }

    private void createNodeLeft(ArrayList<Integer> node, int x, int y) {
//        System.out.println(y);
        ArrayList<Integer> mad = new ArrayList<>();
        if (y <= gridY) {
            node.add(grid[x][y - 1]);
            y -= 1;
            mad.add(x);
            mad.add(y);
            posts.add(mad);
            System.out.println(posts.toString());
            recursiveNode(node, x, y);
        }
    }

    private void createNodeBottom(ArrayList<Integer> node, int x, int y) {
//        System.out.println(y);
        ArrayList<Integer> mad = new ArrayList<>();
        if (x <= gridX) {
            node.add(grid[x + 1][y]);
            x += 1;
            mad.add(x);
            mad.add(y);
            posts.add(mad);
            System.out.println(posts.toString());
            recursiveNode(node, x, y);
        }
    }

    private int goLeft(int x, int y) {
        System.out.println("[goLeft] Mulai pencarian, dimulai dari: " + x + " - " + y);
        int result = 0;
        if (y != 0) {
            if (grid[x][y] > grid[x][y - 1]) {
                System.out.println(grid[x][y - 1]);
                y -= 1;
                result = 1;
//            compare(path, x, (y - 1)); // ke kiri
            } else {
                System.out.println("Can't go to the left. Find another way");
            }
        } else {
            System.out.println("Edge of left");
        }
        if ((x == 0) && (y == 0)) {
//            System.out.println("Top left: " + grid[x][y]);
            int B = goBottom(x, y);
            if (B == 1) {
                goBottom(x + 1, y);
            }
        } else if ((x == 0) && (y == (this.gridY - 1))) {
            System.out.println("Top right: " + grid[x][y]);
        } else if ((x == (this.gridX - 1)) && (y == 0)) {
            System.out.println("Bottom left: " + grid[x][y]);
        } else if ((x == (this.gridX - 1)) && (y == (this.gridY - 1))) {
            System.out.println("Bottom right: " + grid[x][y]);
        } else if (y == 0) {
            System.out.println("Left: " + grid[x][y]);
        } else if (y == (this.gridY - 1)) {
            System.out.println("Right: " + grid[x][y]);
        } else if (x == (this.gridX - 1)) {
            System.out.println("Bottom: " + grid[x][y]);
        } else {
            System.out.println("Middle: " + grid[x][y]);
        }
        return result;
    }

    private int goRight(int x, int y) {
        System.out.println("Mulai pencarian, dimulai dari: " + x + " - " + y);
        int result = 0;
        if (y <= gridY) {
            if (grid[x][y] > grid[x][y + 1]) {
                System.out.println(grid[x][y + 1]);
                result = 1;
//            compare(path, x, (y - 1)); // ke kiri
            } else {
                System.out.println("Can't go to the left. Find another way");
            }
        } else {
            System.out.println("Edge of right");
        }
        return result;
    }

    private int goBottom(int x, int y) {
        int result = 0;
        if (x <= gridX) {
            if (grid[x][y] > grid[x + 1][y]) {
                System.out.println(grid[x + 1][y]);
                x += 1;
                result = 1;
//            compare(path, x, (y - 1)); // ke kiri
            } else {
                System.out.println("Can't go to the left. Find another way");
            }
        } else {
//            System.out.println("Edge of bottom");
        }
        return result;
    }

    private void compare(ArrayList<Integer> path, int x, int y) {
        path.add(grid[x][y]);
        if ((x == 0) && (y == 0)) {
            System.out.println("Top left: " + grid[x][y]);
        } else if ((x == 0) && (y == (this.gridY - 1))) {
            System.out.println("Top right: " + grid[x][y]);
        } else if ((x == (this.gridX - 1)) && (y == 0)) {
            System.out.println("Bottom left: " + grid[x][y]);
        } else if ((x == (this.gridX - 1)) && (y == (this.gridY - 1))) {
            System.out.println("Bottom right: " + grid[x][y]);
        } else if (y == 0) {
            System.out.println("Left: " + grid[x][y]);
            compare(path, x, y + 1);
        } else if (y == (this.gridY - 1)) {
            System.out.println("Right: " + grid[x][y]);
        } else if (x == (this.gridX - 1)) {
            System.out.println("Bottom: " + grid[x][y]);
        } else {
            System.out.println("Middle: " + grid[x][y]);
            if (grid[x][y] > grid[x][y - 1]) {
                toLeft(path, grid, x, y); // ke kiri
//                compare(path, x, (y - 1)); // ke kiri
            } else {
                System.out.println("Can't go to the left. Find another way");
            }
        }
        System.out.println(path.toString());
    }

    public void toRight(ArrayList<Integer> path, int[][] grid, int x, int y) {
        if (grid[x][y] > grid[x][y + 1]) {
            compare(path, x, (y + 1)); // ke kanan
        } else {
            System.out.println("Can't go to the right. Find another way");
        }
    }

    public void toLeft(ArrayList<Integer> path, int[][] grid, int x, int y) {
        if (y != 0) {
            if (grid[x][y] > grid[x][y - 1]) {
                path.add(grid[x][y - 1]);
                y -= 1;
                toLeft(path, grid, x, y);
//            compare(path, x, (y - 1)); // ke kiri
            } else {
                System.out.println("Can't go to the left. Find another way");
            }
        }
    }

    public void toBottom(ArrayList<Integer> path, int[][] grid, int x, int y) {
        ArrayList<Integer> paths = new ArrayList<>();
        if (grid[x][y] > grid[x + 1][y]) {
            compare(paths, (x + 1), y); // ke kanan
        } else {
            System.out.println("Can't go to the bottom. Find another way");
        }
    }

    public void bottomFirst() {
        if (grid[x][y] > grid[x + 1][y]) { // Jika cell tujuan lebih kecil dari cell yang sekarang
            compare(path, (x + 1), y); // ke bawah
        } else {
            System.out.println("Can't go to bottom. Find another way");
            if (grid[x][y] > grid[x][y - 1]) {
                compare(path, x, (y - 1)); // ke kiri
            } else {
                System.out.println("Can't go to the left. Find another way");
                if (grid[x][y] > grid[x][y + 1]) {
                    compare(path, x, (y + 1)); // ke kanan
                } else {
                    System.out.println("Can't go to the right. Find another way");
                }
            }
        }
    }
}
