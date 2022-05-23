package 시스템;
import thread.사운드;

import java.util.Scanner;

public class 게임실행 {

	//초기 게임실행 창(반복)
	public static void 실행() {
		int 시작;
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("[ 게임을 시작 하시겠습니까 ?}");
		System.out.println("1.네.    2.아니요.");
		System.out.print("입력 : ");
		시작 = sc.nextInt();
		sc.nextLine();
		사운드 효과음 = new 사운드("메인선택버튼.mp3",false);
		효과음.start();

		while (true) {
			if (시작 == 1) {
				System.out.println();
				System.out.println("[게임을 시작합니다.]");
				System.out.println();
				break;
			} else if (시작 == 2) {
				System.out.println();
				System.out.println("[게임을 종료합니다..]");
				System.exit(0);
				break;
			} else {
				System.out.println();
				System.out.println("다시 선택해주세요!");
				System.out.println();
				System.out.print("[1]시작한다.    [2]종료한다.");
				System.out.println();
				System.out.print("입력 : ");
				System.out.println();
				시작 = sc.nextInt();
				sc.nextLine();
				효과음 = new 사운드("메인선택버튼.mp3",false);
				효과음.start();
			}
		}


	}


	//이름 설정 창
	public static void 설정(){
		System.out.println();
		System.out.println("================================================================================================================");
		System.out.println("                                        당신의 이름을 설정해 주세요.");
		System.out.println("================================================================================================================");
		System.out.println();



	}


	//주인공 선택창
	public static void 주인공선택(){

		System.out.println("                               =============================================");
		System.out.println();
		System.out.println("                                           주인공을 선택해주세요!");
		System.out.println("                               [1]토끼    [2]거북이    [3]랜덤   [0] 게임종료");
		System.out.println();
		System.out.println("                               =============================================");


	}



}
