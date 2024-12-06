package src.main;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound(){
        soundURL[0] = getClass().getResource("/res/sounds/character/goku/punch.wav");
        soundURL[1] = getClass().getResource("/res/sounds/character/goku/kick.wav");
        soundURL[2] = getClass().getResource("/res/sounds/character/goku/getHit.wav");
        soundURL[3] = getClass().getResource("/res/sounds/character/vegeta/punch.wav");
        soundURL[4] = getClass().getResource("/res/sounds/character/vegeta/kick.wav");
        soundURL[5] = getClass().getResource("/res/sounds/character/vegeta/getHit.wav");

        soundURL[6] = getClass().getResource("/res/sounds/backmusic.wav");

        soundURL[7] = getClass().getResource("/res/sounds/kiBlast.wav");

    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }
}
