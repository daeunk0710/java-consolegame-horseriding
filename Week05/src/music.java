/*
스레드 사용하여 배경음악을 재생하고 종료하는 클래스

 */
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class music extends Thread {

    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public music(String category, String songName, boolean isLoop){
        try {
            this.isLoop = isLoop;
            file = new File("C:\\Users\\lg\\IdeaProjects\\TeamnovaBasic\\Week05\\src\\music\\"+category+"\\"+songName+".mp3");
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // 현재 재생 위치를 알려줌 (10초 부분이 재생되고 있다면 10000 반환)
    public int getTime(){
        if (player == null)
            return 0;
        return player.getPosition();
    }

    // 음악 종료 메소드
    public void close(){
        isLoop = false;
        player.close();
        this.interrupt();
    }

    // 음악 실행 메소드
    public void run() {

        // isLoop 가 true 일 때 곡을 실행
        try {
            do {
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } while (isLoop);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
