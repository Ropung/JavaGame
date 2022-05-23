package 케릭터;


import thread.사운드;

import java.util.Random;

public class 생물{


	//캐릭터 고유의 이름과 스텟표시 몬스터,주인공 등등


	public String 이름, 종족, 악세사리;



	public int lv,lvm, hp, hpm ,mp,mpm,mpx, at, dp, ex, exm, gd;

	public int 패널티 = 0;

	//시련필요템(퀘스트)
	public int 지금,열매,웃음꽃,호잇,둘리의눈물,시련의조각,고길동의부탁,고길동의소원,둘리의분노=0;;







	//생물의 공격 스킬
	public int 공격() {
		Random 랜덤 = new Random();
		랜덤.setSeed(System.currentTimeMillis());
		int 스킬 = 랜덤.nextInt(100) + 1;

		int sum = 0;

		if(hp <= 0){
			System.out.println("                                                                  "+ 이름 + "(이)가 [사망] 하였습니다.");
			return sum;
		}

		if (스킬 <= 40) {
			sum += at;
			System.out.println();
			System.out.println();
			System.out.println("                                                                  "+ 이름 + "의 [ hp ] : "+ hp);
			System.out.println("                                                                  "+ 이름 + "이(가) 공격합니다!!");
			System.out.println("                                                                  "+ 이름 + "의 일반공격!");
			System.out.println();
			System.out.println();
			return sum;
		}

		else if (스킬 <= 99) {
			sum += lv * 2;
			sum += at* 2;
			System.out.println();
			System.out.println();
			System.out.println("                                                                  "+ 이름 + "의 [ hp ] : "+ hp);
			System.out.println("                                                                  "+ 이름 + "이(가) 공격합니다!!");
			System.out.println("                                                                  " + 이름 +"의 회심의 일격!!");
			System.out.println();
			System.out.println();

			return sum;
		}

		else if (스킬 <= 99) {
			sum += at * 10;
			System.out.println();
			System.out.println();
			System.out.println("                                                                  "+ 이름 +  "의 [ hp ] : "+ hp);
			System.out.println("                                                                  " + 이름 + "이 액티브 스킬을(를) 사용했다.");
			System.out.println("                                                                  " + 이름 + "의 최후의 공격!!");
			System.out.println();
			System.out.println();
			return sum;
		}

		return sum;
	}


	//생물의 피격
	public void 피격(int sum) {


		if (sum >= 1) {
			if (dp >= sum) {
				hp = hp - 0;
				System.out.println("");
				사운드 방어 = new 사운드("방어.mp3", false);
				방어.start();
				System.out.println("                                                                         적의 방어력이 높아 데미지가 들어가질않습니다.]");
				System.out.println("                                                                         적의 [ Hp ] : " + this.hp);
			}
			else {

				hp = hp + dp - sum;
				System.out.println("");
				System.out.println("");
				System.out.println("[ " + (dp - sum) + " ] 의 데미지를 주었습니다.");

				if (hp <= 0) {
					System.out.println();
					System.out.println();
					사운드 타격음 = new 사운드("타격음.mp3", false);
					타격음.start();
					System.out.println("");
					System.out.println(this.이름 + "가 사망하였습니다.");
					System.out.println("");
					System.out.println("                                                    [전투종료]");
					System.out.println();
					return;
				}


			}
		}

		else {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("몬스터는 집으로 돌아갔다!");
			System.out.println();
			System.out.println();
		}

	}










	}


