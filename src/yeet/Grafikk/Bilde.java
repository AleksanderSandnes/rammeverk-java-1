package yeet.Grafikk;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bilde {
    private int width, height;
    private int[] pixels;
    private boolean alpha = true; //?
    private int lysBlokk = Lys.NONE;

    public Bilde(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(Bilde.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();
        pixels = image.getRGB(0, 0, width, height, null, 0, width);

        image.flush();
    }

    public Bilde(int[] pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    public boolean isAlpha() {
        return alpha;
    }

    public void setAlpha(boolean alpha) {
        this.alpha = alpha;
    }

    public int getLysBlokk() {
        return lysBlokk;
    }

    public void setLysBlokk(int lysBlokk) {
        this.lysBlokk = lysBlokk;
    }
}

