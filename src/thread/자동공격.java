package thread;

import 케릭터.몬스터;
import 케릭터.생물;
import 케릭터.주인공;

import java.util.Random;

public class 자동공격 extends 생물 implements Runnable {

	public 몬스터 몬스터;
	public 주인공 주인공;


	public 자동공격(주인공 주인공,몬스터 몬스터) {
		this.주인공 = 주인공;
		this.몬스터 = 몬스터;
	}


	public void run() {
		try {

			while (true) {

				if (주인공.hp <= 0) {
					System.out.println(주인공.종족 + "이(가) 사망했습니다.");
					Thread 경고 = new 사운드("5. 삐.mp3", false);
					경고.start();
					break;
				}

				주인공.피격(몬스터.공격());

				if (주인공.hp <= 0) {
					System.out.println(주인공.종족 + "이(가) 사망했습니다.");
					Thread 경고 = new 사운드("5. 삐.mp3", false);
					경고.start();
					break;
				}

				주인공.mp += 1;
				if (mp >= mpm){
					mp = mpx;
				}

				Thread.sleep(3000);
			}
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

	}


}
