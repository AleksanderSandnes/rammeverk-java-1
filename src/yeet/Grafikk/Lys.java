package yeet.Grafikk;

public class Lys {
    public static final int NONE = 0;
    public static final int FULL = 1;

    private int radius, diameter, farge;
    private int[] lysKart;

    public Lys(int radius, int farge) {
        this.radius = radius;
        this.diameter = radius * 2;
        this.farge = farge;
        lysKart = new int[diameter * diameter];

        for(int y = 0; y < diameter; y++) {
            for(int x = 0; x < diameter; x++) {
                double distanse = Math.sqrt((x - radius) * (x - radius) + (y - radius) * (y - radius));

                if(distanse < radius) {
                    double kraft = 1 - (distanse / radius);
                    lysKart[x + y * diameter] = (int)(((farge >> 16) & 0xff) * kraft) << 16 | (int)(((farge >> 8) & 0xff) * kraft) << 8 | (int)((farge& 0xff) * kraft);
                }
                else {
                    lysKart[x + y * diameter] = 0;
                }
            }
        }
    }

    public int getLysVerdi(int x, int y) {
        if(x < 0 || x >= diameter || y < 0 || y >= diameter) {
            return 0;
        }
        return lysKart[x + y * diameter];
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getFarge() {
        return farge;
    }

    public void setFarge(int farge) {
        this.farge = farge;
    }

    public int[] getLysKart() {
        return lysKart;
    }

    public void setLysKart(int[] lysKart) {
        this.lysKart = lysKart;
    }
}

