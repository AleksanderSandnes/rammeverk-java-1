package yeet.Lyd;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Lyd {
    private Clip lydklipp = null;
    private FloatControl gainKontroll;

    public Lyd(String path) {
        try {
            InputStream lydKilde = Lyd.class.getResourceAsStream(path);
            InputStream BuffretInn = new BufferedInputStream(lydKilde);
            AudioInputStream lydstromInn = AudioSystem.getAudioInputStream(BuffretInn);
            AudioFormat hovedFormat = lydstromInn.getFormat();
            AudioFormat dekodetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    hovedFormat.getSampleRate(),
                    16,
                    hovedFormat.getChannels(),
                    hovedFormat.getChannels() * 2,
                    hovedFormat.getSampleRate(),
                    false);
            AudioInputStream LydStromInn = AudioSystem.getAudioInputStream(dekodetFormat, lydstromInn);

            lydklipp = AudioSystem.getClip();
            lydklipp.open(LydStromInn);

            gainKontroll = (FloatControl) lydklipp.getControl(FloatControl.Type.MASTER_GAIN);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //Starter lydklippet
    public void play() {
        if(lydklipp == null) {
            return;
        }

        stop();
        lydklipp.setFramePosition(0);
        while (!lydklipp.isRunning()) {
            lydklipp.start();
        }
    }

    //Stopper lydklippet
    public void stop() {
        if(lydklipp.isRunning()) {
            lydklipp.stop();
        }
    }

    //Lukker inputstrømmen
    public void close() {
        stop();
        lydklipp.drain();
        lydklipp.close();
    }

    //Looper lyden
    public void loop() {
        lydklipp.loop(Clip.LOOP_CONTINUOUSLY);
        play();
    }

    public void setVolume(float value) {
        gainKontroll.setValue(value);
    }

    public boolean isRunning() {
        return lydklipp.isRunning();
    }
}

