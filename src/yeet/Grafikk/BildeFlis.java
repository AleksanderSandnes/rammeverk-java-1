package yeet.Grafikk;

public class BildeFlis extends Bilde {
    private int tileW, tileH;

    public BildeFlis(String path, int tileW, int tileH) {
        super(path);
        this.tileW = tileW;
        this.tileH = tileH;
    }

    public Bilde getBildeFlis(int tileX, int tileY) {
        int[] pixels = new int[tileW * tileH];

        for(int y = 0; y < tileW; y++) {
            for(int x = 0; x < tileH; x++) {
                pixels[x + y * tileW] = this.getPixels()[(x + tileX * tileW) + (y + tileY + tileW) * this.getWidth()];
            }
        }

        return new Bilde(pixels, tileW, tileH);
    }

    public int getTileW() {
        return tileW;
    }

    public void setTileW(int tileW) {
        this.tileW = tileW;
    }

    public int getTileH() {
        return tileH;
    }

    public void setTileH(int tileH) {
        this.tileH = tileH;
    }
}

