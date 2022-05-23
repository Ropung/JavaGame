package thread;


import 케릭터.몬스터;
import 케릭터.주인공;


public class 전투시간 extends 몬스터 implements Runnable {

	private int n = 0;

	int 증가값 = 30;
	public 몬스터 m;
	public 주인공 p;

	public 전투시간(몬스터 m,주인공 p) {
		this.m = m;
		this.p = p;

	}


	@Override
	public void run() {

		try {



			while (true) {

				if(m.hp <= 0){
					break;
				}
				else if(p.hp <= 0){
					break;
				}

				n += 10;
				System.out.println("                                                - " + n + "초 경과 -");
				if (n == 120) {
					System.out.println("");
					System.out.println(" 120초가 지났습니다.\n");
					System.out.println("몬스터가 동료를 불러 대폭강해집니다.");
					System.out.println("[경고] 도망가세요! ");
					m.대폭강화(증가값);

				} else if (n == 60) {
					System.out.println(" 60초가 지났습니다.\n");
					System.out.println("주인공에 패턴에 익숙해져 몬스터가 더욱강해집니다.");
					m.소폭강화(증가값);

				} else if (n >= 120) {
					break;
				}
				if(n == 30){
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println("                       2분안에 몬스터를 잡지않으면 몬스터들에 의해 공격을 받아 마을로 보내지게됩니다.");
					System.out.println();
					System.out.println();
					System.out.println();
				}



				Thread.sleep(10000);
			}

		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}


	}

}














