package thread;

import static 시스템.날짜.날짜말하기;

public class 이용시간 extends Thread {



	//시간경과 메서드
	public void run() {
		while (true) {
			for (int i = 0; i <= 2400; i++) {
				날짜말하기();
				System.out.println("게임을 이용한지  [ " + i + " 시간 ]지났습니다.");

				if (i == 3) {
					System.out.println("약간의 휴식을 취해주세요!");
				}else if (i > 10 ){
					break;
				} else if (i > 8) {
					System.out.println("무리한 게임 플레이는 건강에 악영향을 끼칠수있습니다.");
				}else if (i == 5) {
					System.out.println("게임을 이용한지 많은시간이 흘렀습니다. \n"+
							"적절한 운동을 권장합니다.");
				}

				try {
					Thread.sleep(1000 * 60);

				} catch (InterruptedException e) {
					e.printStackTrace();

				}
			}
		}


	}


}
