package yeet.Grafikk;

public class Font {
    public static final Font STANDARD = new Font("/Fonter/font2.png");
    //public static final Font STANDARD = new Font("/Fonter/font.png");

    private Bilde fontBilde;
    private int[] offsets;
    private int[] widths;

    public Font(String path) {
        fontBilde = new Bilde(path);

        offsets = new int[256];
        widths = new int[256];

        int unicode = 0;

        for(int i = 0; i < fontBilde.getWidth(); i++) {
            if(fontBilde.getPixels()[i] == 0xff0000ff) {
                offsets[unicode] = i;
            }

            if(fontBilde.getPixels()[i] == 0xffffff00) {
                widths[unicode] = i - offsets[unicode];
                unicode++;
            }
        }
    }

    public Bilde getFontBilde() {
        return fontBilde;
    }

    public void setFontBilde(Bilde fontBilde) {
        this.fontBilde = fontBilde;
    }

    public int[] getOffsets() {
        return offsets;
    }

    public void setOffsets(int[] offsets) {
        this.offsets = offsets;
    }

    public int[] getWidths() {
        return widths;
    }

    public void setWidths(int[] widths) {
        this.widths = widths;
    }
}

