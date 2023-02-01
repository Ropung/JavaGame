package 케릭터;

import thread.사운드;

import java.util.Random;
import java.util.Scanner;

public class 몬스터 extends 생물 {

Scanner sc = new Scanner(System.in);
	사운드 효과음 = new 사운드("메인선택버튼.mp3",false);




	//랜덤 달팽이 몬스터 생성
	public void  달팽이생성(int 탐색) {
		Random 랜덤 = new Random();
		랜덤.setSeed(System.currentTimeMillis());
		if (탐색 <= 60) {
			종족 = "달팽족";
			this.이름 = "달팽이";
			this.lv = 1 + 랜덤.nextInt(5);
			this.hp = 10 + (this.lv * 5);
			this.at = 3 + 랜덤.nextInt(2);
			this.dp = 2;

			this.ex = 50;
			this.gd = 500 + (랜덤.nextInt(500) + 1);
			this.시련의조각 = 10;
		} else if (탐색 <= 90) {
			종족 = "바다달팽이";
			this.이름 = "민숭달팽이";
			this.lv = 1 + 랜덤.nextInt(10);
			this.hp = 50 + (this.lv * 5);
			this.at = 4 + 랜덤.nextInt(2);
			this.dp = 3 + (this.lv / 2);

			this.ex = 60;
			this.gd = 1000 + (랜덤.nextInt(500) + 1);
			this.시련의조각 = 20;
		} //엘리트 몹
		else {
			this.종족 = "보스";
			this.이름 = "암모나이트";    //엘리트 보스몬스터
			this.lv = 10;
			this.hp = 150;
			this.at = 10;
			this.dp = 8;

			this.ex = 100;
			this.gd = 10000 + 랜덤.nextInt(10000);
			this.시련의조각 = 100;
			this.지금 = 1;

			System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
			System.out.println("[ 첫번째 시련의 보스 ]" + this.이름 + "(이)가 출현하였습니다. ");
			System.out.println(this.이름 + ": 지금을 노리는 자들은 나에게 다 죽임을 당했지!! 너의 실력을 볼까?");
			System.out.println("만약 나를 이긴다면 지금을 넘겨주도록하지!!");
			System.out.println("⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");
		}


	}

	//랜덤 메뚜기 몬스터 생성
	public void 메뚜기생성(int 탐색) {
		Random 랜덤 = new Random();
		랜덤.setSeed(System.currentTimeMillis());
		if (탐색 <= 60) {
			this.종족 = "메뚜기";
			this.이름 = "방아깨비";
			this.lv = 10 + 랜덤.nextInt(15);
			this.hp = 200 + (this.lv * 5);
			this.at = 3 + 랜덤.nextInt(2);
			this.dp = 4;
			this.시련의조각 = 50;
			this.ex = 50;
			this.gd = 500 + (랜덤.nextInt(500) + 1);
		}                    //일반 몹
		else if (탐색 <= 90) {
			this.종족 = "메뚜기";
			this.이름 = "여치";
			this.lv = 20 + 랜덤.nextInt(10);
			this.hp = 300 + (this.lv * 5);
			this.at = 4 + 랜덤.nextInt(2);
			this.dp = 6 + (this.lv / 2);

			this.ex = 60;
			this.gd = 1000 + (랜덤.nextInt(500) + 1);
			this.시련의조각 = 50;
		} //엘리트 몹
		else {
			this.종족 = "보스";
			this.이름 = "유재석";    //엘리트 보스몬스터
			this.lv = 30;
			this.hp = 500;
			this.at = 10;
			this.dp = 10;

			this.ex = 100;
			this.gd = 10000 + 랜덤.nextInt(10000);
			this.시련의조각 = 100;
			this.열매 = 1;

			System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
			System.out.println("[ 두번째 시련의 보스 ]" + this.이름 + "(이)가 출현하였습니다. ");
			System.out.println(this.이름 + ": 무명의 개그맨에서 국민 Mc까지.. 인내는 쓰지만 열매는 달거든요오");
			System.out.println("아 ! 저를 이기신다면 열매를 넘겨드리도록 하죠 하하하");
			System.out.println("⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");

		}


	}

	//랜덤 버섯 몬스터 생성
	public void 버섯생성(int 탐색) {
		Random 랜덤 = new Random();
		랜덤.setSeed(System.currentTimeMillis());
		if (탐색 <= 60) {
			this.종족 = "버섯";
			this.이름 = "좀비버섯";
			this.lv = 30 + 랜덤.nextInt(15);
			this.hp = 200 + (this.lv * 5);
			this.at = 3 + 랜덤.nextInt(2);
			this.dp = 4;

			this.ex = 50;
			this.gd = 500 + (랜덤.nextInt(500) + 1);
		}                    //일반 몹
		else if (탐색 <= 90) {
			this.종족 = "시체꽃";
			this.이름 = "라플레시아";
			this.lv = 50 + 랜덤.nextInt(10);
			this.hp = 300 + (this.lv * 5);
			this.at = 4 + 랜덤.nextInt(2);
			this.dp = 6 + (this.lv / 2);

			this.ex = 60;
			this.gd = 1000 + (랜덤.nextInt(500) + 1);
			this.시련의조각 = 50;
		} //엘리트 몹
		else {
			this.종족 = "보스";
			this.이름 = "스폰지밥";    //엘리트 보스몬스터
			this.lv = 60;
			this.hp = 500;
			this.at = 10;
			this.dp = 10;

			this.ex = 100;
			this.gd = 10000 + 랜덤.nextInt(10000);
			this.시련의조각 = 100;
			this.열매 = 1;

			System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
			System.out.println("[ 세번째 시련의 보스 ]" + this.이름 + "(이)가 출현하였습니다. ");
			System.out.println(this.이름 + ": 아이고 깜짝이야 ! 아! 월요일! 월요일 좋아~~  최고로좋아!~ ");
			System.out.println("난 일할때 제일 멋지지 !!");
			System.out.println("오늘부터 열심히 할거야  ~~ 월요일 좋아 ~~~~~~~~~~~~~~~~~~");
			System.out.println("나를 이긴다면 ");

			System.out.println("⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");

		}


	}

	//랜덤 풀벌레 몬스터 생성   6.1 생성
	public void 풀벌레생성(int 탐색) {
		Random 랜덤 = new Random();
		랜덤.setSeed(System.currentTimeMillis());
		if (탐색 <= 30) {
			this.종족 = "풀벌레";
			this.이름 = "강철사마귀";
			this.lv = 60 + 랜덤.nextInt(20);
			this.hp = 400 + (this.lv * 5);
			this.at = 3 + 랜덤.nextInt(2);
			this.dp = 4;
			this.시련의조각 = 100;
			this.ex = 60;
			this.gd = 500 + (랜덤.nextInt(500) + 1);
		}                    //일반 몹
		else if (탐색 <= 50) {
			this.종족 = "풀벌레";
			this.이름 = "전투지네";
			this.lv = 90 + 랜덤.nextInt(10);
			this.hp = 500 + (this.lv * 5);
			this.at = 4 + 랜덤.nextInt(2);
			this.dp = 6 + (this.lv / 2);

			this.ex = 80;
			this.gd = 1000 + (랜덤.nextInt(500) + 1);
			this.시련의조각 = 100;
		}

		//엘리트 몹
		else {

			this.종족 = "보스";
			this.이름 = "둘리";    //엘리트 보스몬스터
			this.lv = 100;
			this.hp = 800;
			this.at = 20;
			this.dp = 10;

			this.ex = 100;
			this.gd = 10000 + 랜덤.nextInt(10000);
			this.시련의조각 = 100;
			this.호잇 = 1;

			System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
			System.out.println("[ 마지막 시련의 보스 ]" + this.이름 + "(이)가 출현하였습니다. ");
			System.out.println(this.이름 + ": 아이 싯8...! ");
			System.out.println("너 뭐냐 초능력 맛좀볼래 ??");
			System.out.println("⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");

		}


	}


	//몬스터 능력치강화 매서드
	public void 소폭강화(int 증가값) {
		this.hp += 증가값;
		this.at += 증가값;
		this.dp += 증가값;
		System.out.println("몬스터의 능력치가 소폭상승했습니다.");
	}

	public void 대폭강화(int 증가값) {
		this.hp += 증가값 * 30;
		this.at += 증가값 * 30;
		this.dp += 증가값 * 30;
		System.out.println("몬스터의 능력치가 대폭상습했습니다.");
	}


	//적의 정보 및 1.전투시작 2.도망치기 메뉴창
	public void 적등장() {
		System.out.println();
		System.out.println("                             ⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐ [적등장] ⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
		System.out.println("                                       야생의 [" + this.이름 + "]가 등장했습니다.       ");
		System.out.println("");
		System.out.println("                                             종족 :" + this.종족);
		System.out.println("                                             이름 :" + this.이름);
		System.out.println("                                             L v   ." + this.lv);
		System.out.println("                                             체력  ." + this.hp);
		System.out.println("                                             공격력." + this.at);
		System.out.println("                                             방어력." + this.dp);
		System.out.println();
		System.out.println("                             ⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");
		System.out.println();
		System.out.println("                            1. 전투시작    2.도망치기 ");
		System.out.println();
		System.out.print("                     입력 : ");

	}



	//생물의 공격 스킬
	@Override
	public int 공격() {
		Random 랜덤 = new Random();
		랜덤.setSeed(System.currentTimeMillis());
		int 스킬 = 랜덤.nextInt(100) + 1;

		int sum = 0;


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
	@Override
	public void 피격(int sum) {


		if (sum >= 1) {
			if (dp >= sum) {
				hp = hp - 0;
				System.out.println("");
//				사운드 방어 = new 사운드("방어.mp3", false);
//				방어.start();
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
//					사운드 타격음 = new 사운드("타격음.mp3", false);
//					타격음.start();
					System.out.println("");
					System.out.println(this.이름 + "가 사망하였습니다.");
					System.out.println("");
					System.out.println("                                                                [전투종료]");
					System.out.println();
					return;
				}


			}
		}

		else {
			Random 랜덤 = new Random();
			랜덤.setSeed(System.currentTimeMillis());
			int 스킬 = 랜덤.nextInt(100) + 1;

			if(스킬 <= 33) {
				System.out.println();
				System.out.println();
				System.out.println(이름 + "은(는) 콧방귀를 뀌며 어딘가로 사라졌다..");
				System.out.println();
				System.out.println("                                                    ↵   ");
				sc.nextLine();
//				효과음.음악중지();
//				효과음 = new 사운드("메인선택버튼.mp3", false);
//				효과음.start();
				System.out.println();
			}else if (스킬 <=66) {
				System.out.println();
				System.out.println();
				System.out.println(이름 + "은(는) 비웃으며 어디론가 사라졌다..");
				System.out.println();
				System.out.println("                                                    ↵   ");
				sc.nextLine();
//				효과음.음악중지();
//				효과음 = new 사운드("메인선택버튼.mp3", false);
//				효과음.start();
				System.out.println();
			}
			else if (스킬 <=99) {
				System.out.println();
				System.out.println();
				System.out.println(이름 + "은(는) 조롱하며 어디론가 사라졌다..");
				System.out.println();
				System.out.println("                                                    ↵   ");
				sc.nextLine();
//				효과음.음악중지();
//				효과음 = new 사운드("메인선택버튼.mp3", false);
//				효과음.start();
				System.out.println();
			}







		}

	}






}
