package com.tiles;

import com.main.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class TileMap {
    GamePanel gpl;
    Tile[] tiles;
    int[][] tilemap;

    public TileMap(GamePanel gpl) {
        this.gpl = gpl;

        tiles = new Tile[2]; // The total number of differnt possible tiles
        loadTileResources();

        tilemap = new int[this.gpl.maxScreenRow][this.gpl.maxScreenCol];
        loadTileMap();
    }

    // Loads all the tile images at the start of the program
    private void loadTileResources() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    // Load the tile map from a file into the tiles array
    public void loadTileMap() {
        try {
            InputStream in = getClass().getResourceAsStream("/maps/map_00.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            // Read the data line by line
            int row = 0;
            while (br.ready()) {
                String line = br.readLine();
                String[] numbersStr = line.split(" ");

                for (int col = 0; col < numbersStr.length; col++) {
                    tilemap[row][col] = Integer.parseInt(numbersStr[col]);
                }

                row++; // Increment the row
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    // Draw the tile map
    public void draw(Graphics2D g2d) {
        for (int row = 0; row < tilemap.length; row++)
        {
            for (int col = 0; col < tilemap[row].length; col++)
            {
                int mapValue = tilemap[row][col];
                g2d.drawImage(
                    tiles[mapValue].image, col * gpl.tileSize, row * gpl.tileSize, gpl.tileSize, gpl.tileSize, null
                );
            }
        }
    }


}
