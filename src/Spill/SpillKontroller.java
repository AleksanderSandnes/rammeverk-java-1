package Spill;

import yeet.AbstraktSpill;
import yeet.Grafikk.Bilde;
import yeet.Grafikk.BildeFlis;
import yeet.Grafikk.Lys;
import yeet.Lyd.Lyd;
import yeet.Renderer;
import yeet.SpillKontainer;

import java.awt.event.KeyEvent;

public class SpillKontroller extends AbstraktSpill {
    private BildeFlis bilde1;
    private Bilde bilde2;
    private BildeFlis bilde3;
    private Lyd clip;
    private Lys lys;

    public SpillKontroller() {
        //bilde1 = new ImageTile("/wood.png", 16, 16);
        bilde2 = new Bilde("/hjerte.png");
        bilde2.setLysBlokk(Lys.FULL);
        bilde2.setAlpha(true);
        bilde3 = new BildeFlis("/test2.png", 16, 16);
        bilde3.setAlpha(true);
        //clip = new Lyd("/audio/minecraft.wav");
        lys = new Lys(100, 0xff00ffff);
    }

    @Override
    public void update(SpillKontainer spillKontainer, float dt) {
        if(spillKontainer.getInput().isKeyDown(KeyEvent.VK_A)) {
            clip.play();
        }

        temp += dt * 20;

        if(temp > 3) {
            temp = 0;
        }
    }

    float temp = 0;

    @Override
    public void render(SpillKontainer spillKontainer, Renderer renderer) {
        renderer.setzDepth(0);
        renderer.tegnBilde(bilde3, 0, 0);
        renderer.tegnBilde(bilde2, 100, 100);

        renderer.drawLight(lys, spillKontainer.getInput().getMouseX(), spillKontainer.getInput().getMouseY());

        //renderer.tegnBilde(animation.getSprite(), x, y, null);

        //renderer.drawImageTile(bilde1, spillKontainer.getInput().getMouseX() -8, spillKontainer.getInput().getMouseY() -16, (int)temp, 0);
        //renderer.drawFillRect(spillKontainer.getInput().getMouseX() - 16, spillKontainer.getInput().getMouseY() - 16, 32, 32, 0xffffccff);

        //For å rendere bilder
        //for(int x = 0; x < bilde2.getWidth(); x++) {
        //    for(int y = 0; y < bilde2.getHeight(); y++) {
        //        renderer.setLysKart(x, y, bilde2.getPixels()[x + y * bilde2.getWidth()]);
        //    }
        //}

        //For å rendere lys versjon 1
        //for(int x = 0; x < lys.getDiameter(); x++) {
        //    for(int y = 0; y < lys.getDiameter(); y++) {
        //        renderer.setLysKart(x, y, lys.getLysKart()[x + y * lys.getDiameter()]);
        //    }
        //}

        //renderer.drawImageTile(bilde3, spillKontainer.getInput().getMouseX(), spillKontainer.getInput().getMouseY(), 1, 1);
        //renderer.tegnBilde(bilde3, spillKontainer.getInput().getMouseX(), spillKontainer.getInput().getMouseY());
        //renderer.setzDepth(0);
        //renderer.tegnBilde(bilde2, 10, 10);
    }

    public static void main(String args[]) {
        SpillKontainer spillKontainer = new SpillKontainer(new SpillKontroller());
        spillKontainer.start();
    }
}

