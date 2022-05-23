package thread;


import 케릭터.주인공;
import java.util.Scanner;

public class 휴식 extends 주인공 implements Runnable{

		public int 회복값 = 5; // 회복 수치
		public 주인공 p;

		public 휴식(주인공 p) {
			this.p = p;
		}

		public void 휴식실행() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("마을에 도착해 휴식을 취합니다...");
			System.out.println();

			Thread 마을휴식 = new Thread(new 휴식(p));
			마을휴식.start();   // 일정 간격마다 회복을 하는 쓰레드가 실행됨.
			scanner.nextLine(); // 유저로 부터 입력을 받음.
			마을휴식.interrupt(); // 유저가 입력을 하면, 쓰레드를 중단시킴.
			사운드 효과음 = new 사운드("메인선택버튼.mp3",false);
			효과음.start();
		}

		@Override
		public void run() {
			while (true) {

				if (Thread.interrupted()) {
					System.out.println("휴식을 중단했습니다.");
					return;
				}

				p.체력회복(회복값);    // hero에 회복하는 코드


				System.out.println();
				System.out.println();
				System.out.println("============================================================================");
				System.out.println();
				System.out.println("                           [휴    식 ] 중입니다. ");
				System.out.println();
				System.out.println("                휴식을 취하는동안 hp 가 서서히 증가합니다.");
				System.out.println("                자리에서 일어나 간단한 운동을 권장합니다 !");
				System.out.println("                장기간 게임플레이는 건강에 악영향을 미칠수 있습니다.");
				System.out.println();
				System.out.println("                         현재 체력 : "+p.hp+" / "+p.hpm);
				System.out.println("                         현재 행동력 : "+p.mp+" / "+p.mpm);
				System.out.println("                         현재 공복도 : "+p.en+" / "+p.enm);
				System.out.println("                         (아무키나눌러 휴식을중단)");
				System.out.println("============================================================================");
				System.out.println();

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					return;
				}
			}

		}
	}








