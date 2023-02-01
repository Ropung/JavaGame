package 케릭터;

import thread.사운드;

import java.util.Scanner;

public class 토끼 extends 주인공 {


	public void 토끼(int hp) {
		this.hp = hp;

	}


	//공격을 하는 함수
	@Override
	public int 공격() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("1.[몸통 박치기]");
		System.out.println("2.[앞니 찍기]");
		System.out.println("3.[뒷발 차기]");
		System.out.println();
		System.out.println("스킬을 선택해주세요.");
		System.out.print("입력 : ");
		int 스킬 = sc.nextInt();
		sc.nextLine();
		사운드 효과음 = new 사운드("메인선택버튼.mp3", false);
		효과음.start();

		int sum = 0;



		if (hp >= 1) {
			System.out.println("적을 공격합니다.");

			//일반공격
			if (스킬 == 1) {
				System.out.println("토끼의 [몸통박치기]!!");
				sum += at;
				mp += 5;
				if (mp > mpm){
					mp = mpx;
				}
				return sum;
			}

			//앞니찍기 함수 (레벨비례)
			else if (스킬 == 2) {

				if(mp < 40){
					System.out.println("행동력이 부족합니다.");
					System.out.println("다른 스킬을 선택해주세요!");
					스킬 = sc.nextInt();
					sc.nextLine();
				}
				mp -= 40;
				if (mp > mpm){
					mp = mpx;
				}


				sum += lv * 2;
				sum += at * 2;

				System.out.println("길다란 앞니로 찍어 공격합니다.");
				System.out.println("[앞니찍기!!]");
				return sum;
			}

			//뒷발차기 함수 (공격력비례)
			else if (스킬 == 3) {
				if(mp < 80){
					System.out.println("행동력이 부족합니다.");
					System.out.println("다른 스킬을 선택해주세요!");
					스킬 = sc.nextInt();
					sc.nextLine();
					mp -= 80;
				}
				if (mp > mpm){
					mp = mpx;
				}
				sum += at * 3;
				mp = Math.max(mp,mpx);
				System.out.println("회심의 뒷발차기를 사용합니다!.");
				System.out.println("[뒷발차기!!]");
				return sum;
			}
			else if (스킬 == 4) {
				sum += at * 1523415;
				System.out.println("개발자의 [코드공격]!!");
				return sum;

			}
			return sum;
		}
		else {
		System.out.println("내적공격을 사용했지만 이미 싸늘한 주검이되었다....");
		System.out.println();
			System.out.println("                                            ↵   ");
			sc.nextLine();
//			효과음.음악중지();
//			효과음 = new 사운드("메인선택버튼.mp3",false);
//			효과음.start();
		return sum;
		}
	}

		//피격되는 함수
		@Override
		public void 피격 (int sum){
			System.out.println("");
			if(sum <= 0){
				return;
			}

			if (dp >= sum) {
				hp = hp - 0;
				mp += 5;
				if (mp > mpm){
					mp = mpx;
				}
				System.out.println();
				System.out.println("[토끼의 방어력이 높아 데미지를 받지 않았습니다.] ");
				사운드 방어 = new 사운드("방어.mp3", false);
				방어.start();
			} else {
				mp += 5;
				if (mp > mpm){
					mp = mpx;
				}
				hp = hp + dp - sum;
				System.out.println();
				System.out.println("토끼(이)가 [적]에게 " + (dp - sum) + "의 데미지를 받았습니다.");

				if (hp <= 0) {
					System.out.println();
					System.out.println("눈앞이 흐려진다 ...");
					return;
				}


			}
			System.out.println("현재 : " + 종족 + "의 [ H p ] : " + hp);
			System.out.println("현재 : " + 종족 + "의 [행동력] : " + mp);
			System.out.println();
			System.out.println();


		} //피격시
	}