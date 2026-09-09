import java.net.Socket;

abstract class Device {

    String brand = "Samsung";

    abstract void turnon();

    void showBrand(){
        System.out.println("Brand: " + brand);
    }
}

interface Camera {
    int Max_Zoom = 10;

    void takePhoto();

    default void camerInfo(){
        System.out.println("Camera is ready");
    }
}

interface MusicPlayer{

    String Type = "Digital";

    void playMusic();

    default void musicInfo() {
        System.out.println("Music player is ready");
    }
}


class Smartphone  extends  Device implements  Camera, MusicPlayer{

    void turnon(){
        System.out.println("Smartphone is turned ON");
    }
    
    public void takePhoto(){
        System.out.println("Taking Photo...");
    }

    public void playMusic(){
        System.out.println("Playing Music...");
    }
}

public class Abstract_Interface {
    public static void main(String[] args) {
        Smartphone s = new Smartphone();
        s.turnon();
        s.showBrand();
        s.takePhoto();
        s.playMusic(); 
        s.camerInfo();
        s.musicInfo();
        System.out.println("Maximum Zoom: " + Camera.Max_Zoom);
        System.out.println("Music Type: " + MusicPlayer.Type);
    }
}