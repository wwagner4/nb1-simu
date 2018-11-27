package simu.gen;

import java.util.Random;

public class StreetGenerator {

    private Random ran = new Random();

    private final int minDist = 2;
    private final int maxDist = 5;

    public String[][] generate(int width, int height) {
        String[][] grid = new String[height][];
        for (int i = 0; i < height; i++) {
            grid[i] = new String[width];
            for (int j = 0; j < width; j++) {
                grid[i][j] = ".";
            }
        }
        int x = minDist + 1 + ran.nextInt(maxDist);
        while (x <= width - minDist) {
            for (int i = 0; i < height; i++) {
                grid[i][x] = "X";
            }
            x += minDist + 1 + ran.nextInt(maxDist);
        }
        int y = minDist + 1 + ran.nextInt(maxDist);
        while (y <= height - minDist) {
            for (int i = 0; i < width; i++) {
                grid[y][i] = "X";
            }
            y += minDist + 1 + ran.nextInt(maxDist);
        }
        return grid;
    }

    public static void main(String[] args) {
        int w = 50;
        int h = 40;
        String[][] grid = new StreetGenerator().generate(w, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

}
