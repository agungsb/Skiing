package skiing;

import java.io.BufferedReader;
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

    public Skiing() {
    }

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
}