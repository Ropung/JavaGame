package 케릭터;

import thread.사운드;

import java.util.Scanner;


public class 거북이 extends 주인공 {


	//공격을 하는 함수
	@Override
	public int 공격() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.[몸통 박치기]");
		System.out.println("2.[등딱지 후리기]");
		System.out.println("3.[넥슬라이스]");
		System.out.println();
		System.out.println("스킬을 선택해주세요.");
		System.out.print("입력 : ");
		int 스킬 = sc.nextInt();
		sc.nextLine();
		int sum = 0;


		//등딱지 공격
		if (스킬 == 1) {
			System.out.println("거북의 몸통박치기!!");
			return at;
		}
		if (스킬 == 2) {
			sum += lv * 3;
			sum += dp * 5;
			System.out.println("등딱지를 벗어서 공격합니다.");
			System.out.println("행성 스윙!!");
			System.out.println();
			return sum;
			//등딱지 강화
		} else if (스킬 == 3) {
			sum += at * 4;
			System.out.println("목을 길게 뻗어 공격합니다.");
			System.out.println("고무고무 !~ 넥슬라이스!!");
			System.out.println();
			return sum;
		}
		System.out.println("");
		return sum;
	}  //거북이의 스킬



	//피격되는 함수
	@Override
	public void 피격(int sum) {
		System.out.println("");
		if (dp >= sum) {
			hp = hp - 0;
			System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
			사운드 방어 =new 사운드("방어.mp3",false);
			방어.start();
			System.out.println("[방어력이 높아 데미지를 받지 않았습니다.] ");
		} else {
			hp = hp + dp - sum;
			System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
			System.out.println("[적]에게 " + (dp - sum) + "의 데미지를 받았습니다.");

			if (hp <= 0) {
				return;
			}


		}
		System.out.println("현재 : " + this.종족 + "의 [  Hp ] : " + this.hp);
		System.out.println();


	} //피격시
}
