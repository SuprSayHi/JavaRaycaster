package com.tiles;

import com.main.GamePanel;
import java.awt.Graphics2D;
import java.io.IOException;
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
    }

    // Loads all the tile images at the start of the program
    private void loadTileResources() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read((ImageInputStream) getClass().getResourceAsStream("res/tiles/grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    // Load the tile map from a file into the tiles array
    public void loadTileMap() {
        tilemap[0][0] = 0; // technically does nothing but
    }


    // Draw the tile map
    public void draw(Graphics2D g2d) {
        for (int row = 0; row < gpl.maxScreenRow; row++)
        {
            for (int col = 0; col < gpl.maxScreenCol; col++)
            {
                int mapValue = tilemap[row][col];
                g2d.drawImage(
                    tiles[mapValue].image, row * gpl.tileSize, col * gpl.tileSize, gpl.tileSize, gpl.tileSize, null
                );
            }
        }
    }


}
