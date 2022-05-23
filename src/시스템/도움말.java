package 시스템;
import thread.사운드;
import 케릭터.주인공;

import java.util.Scanner;


public class 도움말 extends 주인공 {



	//게임진행에 필요한 도움말
	public static void 도움말하기() throws InterruptedException {
		Scanner 도움말 = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		사운드 메인2 =  new 사운드("메인2.mp3",true);
		사운드 효과음 =  new 사운드("메인선택버튼.mp3",false);
		메인2.start();

		System.out.println("=========================================================================================================================================================");
		System.out.println();
		System.out.println();
		System.out.println("당신은 지금부터 토끼와 거북이의 인생을 살게됩니다.");
		System.out.println("거북이와 토끼가 각자의 멋진 인생을 살도록 도와주세요!");
		System.out.println();
		System.out.println("                                                    ↵   ");
		도움말.nextLine();
		효과음.start();

		System.out.println("[ 1.게임의 목표 ]");
		System.out.println("시련목록에 시련을 완수하면 게임이 클리어됩니다.");
		System.out.println("각 시련을 이겨내고 깨달음을 얻어 주인공이 만족할수있게 도와주세요!");
		System.out.println();
		System.out.println("                                                    ↵   ");
		도움말.nextLine();
		효과음 = new 사운드("메인선택버튼.mp3",false);
		효과음.start();
		System.out.println("[ 2.주의 사항 ]");
		System.out.println("주인공의 각종 상태를 잘보고 관리를 해주세요!");
		System.out.println("                                                    ↵   ");
		도움말.nextLine();
		효과음 = new 사운드("메인선택버튼.mp3",false);
		효과음.start();
		System.out.println("[공복]이 [0]이 될시 사냥을할수없으니 상점에서 음식을 섭취하거나 마을에서 쉬어주세요");
		System.out.println("                                                    ↵   ");
		도움말.nextLine();
		효과음 = new 사운드("메인선택버튼.mp3",false);
		효과음.start();
		System.out.println("마을에있으면 자동적으로 체력과 공복도가 찹니다.");
		System.out.println("                                                    ↵   ");
		도움말.nextLine();
		효과음 = new 사운드("메인선택버튼.mp3",false);
		효과음.start();
		System.out.println("[사냥터]를 통해 레벨업과 돈을 얻을수있수있어요.");
		System.out.println("                                                    ↵   ");
		도움말.nextLine();
		효과음 = new 사운드("메인선택버튼.mp3",false);
		효과음.start();
		System.out.println("시련의 조각을모아 시련의돌을만들어 시련퀘스트를 진행해주세요!");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(" 마지막 보스의 눈물을 얻어 시련을 진행해 게임을 클리어해주세요!");
		System.out.println("=========================================================================================================================================================");
		System.out.println("                                                    ↵   ");
		도움말.nextLine();
		효과음 = new 사운드("메인선택버튼.mp3",false);
		효과음.start();
		메인2.음악중지();
		System.out.println();

		System.out.println();
		System.out.println();







	}


	public static void 공지사항(){

	}





}
