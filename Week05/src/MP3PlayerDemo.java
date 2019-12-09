/*
jLayer 라이브러리 사용 연습
 */

import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class MP3PlayerDemo {
    public static void main(String[] args){
        try {
            File file = new File("C:\\Users\\lg\\IdeaProjects\\TeamnovaBasic\\Week05\\src\\music\\INTRO.mp3");
            FileInputStream fis = new FileInputStream(file);
            Player playMP3 = new Player(fis);
            playMP3.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
