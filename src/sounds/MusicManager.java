package sounds;

import example.ImageEnemy;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

//the video that helped me do this is here
//https://www.youtube.com/watch?v=TErboGLHZGA
public class MusicManager {

File musicFile;

public void paySound(String file, boolean loop) {
    try {
        this.musicFile = new File(file);
            if (musicFile.exists()) {
                System.out.println("file found");
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File(musicFile.getAbsolutePath()));
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                    //if loop is true than the music will loop continuously
                    // e.g title screen music vs death sound, you wouldn't want the death sound to play on repeat
                    if(loop){
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                        clip.start();
                        int l = clip.getFrameLength();
                        Thread.sleep(l);
                    }else {
                        clip.start();
                        int l = clip.getFrameLength();
                        Thread.sleep(l);
                    }
            } else
                System.err.println("file not found");
    } catch (Exception ex) {
                System.err.println("Error with playing sound.");
                ex.printStackTrace();
            }
    }
}
