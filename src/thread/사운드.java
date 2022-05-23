package thread;

//import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class 사운드 extends Thread {


//	Player player;
	boolean isloop;
	public String name;
	FileInputStream fis;
	BufferedInputStream bis;


	public 사운드(String filename, boolean isloop) {
		try {
			this.isloop = isloop;
			name = filename;
			fis = new FileInputStream("src/Musicfile/" + name);
			bis = new BufferedInputStream(fis);
//			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}




	public void 음악교체(String filename, boolean isloop) {
//		player.close();
		this.interrupt();
		name = filename;
		this.isloop = isloop;
	}



	public void 음악중지() {
		isloop = false;
//		player.close();
		this.interrupt();
	}

	@Override
	public void run() {
		try {
			do {
//				player.play();
				fis = new FileInputStream("src/Musicfile/" + name);
				bis = new BufferedInputStream(fis);
//				player = new Player(bis);
			} while (isloop);
		} catch (Exception e) {

		}
	}


}




