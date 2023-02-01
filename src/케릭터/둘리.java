package 케릭터;

import thread.사운드;

import java.util.Random;

public class 둘리 extends 몬스터{
	Random 랜덤 = new Random();






public void 각성(){
	
	this.종족 = "공룡족";
	this.이름 = "[각성]둘리";    //엘리트 보스몬스터
	this.lv = 100;
	this.hp = 1000;
	this.at = 30;
	this.dp = 15;

	this.ex = 100;
	this.gd = 10000 + 랜덤.nextInt(10000);
	this.시련의조각 = 50;
	this.둘리의눈물 = 1;

	System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
	System.out.println("[ 마지막 시련의 보스 ]" + this.이름 + "(이)가 각성 하였습니다. ");
	System.out.println(this.이름 + ": 봐주지 않겠다! ");
	System.out.println("귀여운 둘리의 초능력 내친구의 맛을 보여주지!");
	System.out.println("⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");
}


	//몬스터의 공격 스킬
	public int 공격() {
		Random 랜덤 = new Random();
		랜덤.setSeed(System.currentTimeMillis());
		int 스킬 = 랜덤.nextInt(100) + 1;
		int sum = 0;

		if (스킬 <= 50) {
			System.out.println("                                          " + this.이름 + "의 호잇!");
			System.out.println("                                          ⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");
			return at;
		}

		//앞니찍기 함수 (레벨비례)
		else if (스킬 <= 80) {
			sum += super.lv * 2;
			sum += super.at * 2;
			System.out.println("                                           " + this.이름 + "꼬리치기!!");
			System.out.println("                                          ⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");
			return sum;
		}

		//뒷발차기 함수 (공격력비례)
		else if (스킬 <= 90) {
			sum += at * 10000;
			System.out.println("                                          " + this.이름 + "가 파이널 스킬을(를) 사용했다.");
			System.out.println("                                             " + this.이름 + "의 호잇 공격!!");
			System.out.println("                                             ⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");
			return sum;
		}
		return at;
	}   // 공격시

	//몬스터의 피격
	public void 피격(int sum) {
		if (dp >= sum) {
			hp = hp - 0;
			System.out.println("");
			System.out.println("                                          ⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
			사운드 방어 =new 사운드("방어.mp3",false);
			방어.start();
			System.out.println("                                            적의 방어력이 높아 데미지가 들어가질않습니다.]");
			System.out.println("                                             적의 [ Hp ] : " + this.hp);
		} else {

			hp = hp + dp - sum;
			System.out.println("[ " + (dp - sum) + " ] 의 데미지를 주었습니다.");
			System.out.println("⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");
			if (this.hp <= 0) {
				System.out.println();
				System.out.println();
				System.out.println("[전투종료]");
				사운드 타격음 = new 사운드("타격음.mp3",false);
				타격음.start();
				System.out.println(this.이름 + "을(를) 잡았습니다.");
				System.out.println();
				return;
			}

			System.out.println("                                             ⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
			System.out.println("                                             적의 남은 [ Hp ] : " + this.hp);
			System.out.println("");
		}

	}




}
