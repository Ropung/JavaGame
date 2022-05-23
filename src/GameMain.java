
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import thread.메인화면;
import thread.이용시간;
import 케릭터.*;
import 시스템.*;
import 맵.*;
import thread.*;


public class GameMain {
	public static void main(String[] args) throws InterruptedException {
		Random 랜덤 = new Random();
		랜덤.setSeed(System.currentTimeMillis());
		Scanner sc = new Scanner(System.in);



		//메인 음악
		사운드 메인음악 = new 사운드("메인.mp3", true);
		메인음악.start();

		//메인 제목
		메인화면 메인창 = new 메인화면("토끼와거북");
		메인창.메인그림();

		// 정적 변수 설정
		String 닉네임;

		// if문 선택지
		int 주인공선택;
		int 메인선택;
		int 사냥터탐색;
		int 시련선택;
		int 상점선택;
		int 음식점;


		//[생성자]
		몬스터 m = new 몬스터();   //몬스터m
		주인공 p = new 주인공(); //주인공p


		휴식 휴식 = new 휴식(p);


		//쓰레드
		Thread f = new Thread(new 전투시간(m, p));
		f.interrupt();
		Thread auto = new Thread(new 자동공격(p, m));
		auto.interrupt();


		//  음악 쓰레드[선언/생성]
		이용시간 이용시간 = new 이용시간();
		사운드 효과음 = new 사운드("메인선택버튼.mp3", false);
		사운드 메인3 = new 사운드("메인3.mp3", true);
		사운드 경고 = new 사운드("5. 삐.mp3", false);
		사운드 쩝쩝 = new 사운드("쩝쩝.mp3", false);
		사운드 돈 = new 사운드("돈.mp3", false);
		사운드 레벨업 = new 사운드("레벨업.mp3", false);
		사운드 방어 = new 사운드("방어.mp3", false);
		사운드 배틀 = new 사운드("배틀.mp3", true);
		사운드 당황 = new 사운드("뜨헉.mp3", false);
		사운드 뿅 = new 사운드("도망.mp3", false);


		//유저 닉네임 설정
		게임실행.설정();
		공백.입력();
		닉네임 = sc.nextLine();
		효과음.start();


		//로딩 화면 구현 [1]
		공백.공백s();
		게임실행.실행();


		//이용시간 쓰레드 (날짜말하기) 스토리진행
		이용시간.start();
		메인음악.음악중지();

		// 초반 줄거리 및 설정
		int 스토리생략;
		공백.공백s();
		공백.공백s();
		System.out.println("스토리와 도움말을 보시겠습니까?");
		System.out.println("1. 네             2.아니요     ");
		공백.입력();
		스토리생략 = sc.nextInt();
		sc.nextLine();
		공백.공백s();

		// 생략 선택
		if (스토리생략 == 1) {
			공백.공백s();
			스토리.줄거리();

			도움말.도움말하기();
		} else {
			공백.공백s();
			System.out.println("스토리를 생략합니다.");
		}


		//메인 노래
		메인3.start();


		//주인공 선택
		공백.공백s();
		게임실행.주인공선택();
		공백.입력();
		주인공선택 = sc.nextInt();
		sc.nextLine();
		효과음 = new 사운드("메인선택버튼.mp3", false);
		효과음.start();

		//주인공 초기값 설정
		공백.공백s();
		if (주인공선택 == 1) {
			p = new 토끼();
			p.종족 = "토끼";
			p.lv = 1;
			p.hp = 100;
			p.hpm = 100 * p.lv;
			p.mp = 100;
			p.mpm = 100;
			p.mpx = 1;
			p.en = 50;
			p.enm = 150;
			p.at = 10;
			p.dp = 8;
			p.ex = 0;
			p.exm = 100;
			p.gd = 10000;
			p.악세사리 = "없음";

		}
		else if (주인공선택 == 2) {
			p = new 거북이();
			p.종족 = "거북";
			p.lv = 1;
			p.hp = 50;
			p.hpm = 100;
			p.mp = 100;
			p.mpm = 100;
			p.en = 20;
			p.enm = 100;
			p.at = 3 * p.lv;
			p.dp = 5 * p.lv;
			p.ex = 0;
			p.exm = 100;
			p.gd = 1000000;
			p.악세사리 = "없음";

		} //거북
		else if (주인공선택 == 0) {
			경고.start();
			System.out.println("게임을 종료합니다.");
			System.exit(0);
		} //게임종료
		else {
			랜덤.setSeed(System.currentTimeMillis());
			int 랜덤선택;
			랜덤선택 = 랜덤.nextInt(9);
			p = new 랜덤();
			p.종족 = "랜덤";
			p.lv = 1;
			p.hp = 100;
			p.hpm = 100;
			p.at = 5 * p.lv;
			p.dp = 1 * p.lv;
			p.ex = 0;
			p.exm = 100;
			p.gd = 10000;
			p.악세사리 = "없음";
		}  //랜덤


		//생성로딩 표현
		System.out.println("     [ " + p.종족 + " ]의 기본상태를 생성 합니다.");
		System.out.println("");
		if (주인공선택 <= 10) {

			공백.공백s();
			System.out.println("     ...생성중...");
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
			System.out.println("     ...준비중...");
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
			System.out.println("     ...완료.....");
			공백.공백s();
			System.out.println("                                                    ↵   ");
			sc.nextLine();
			효과음 = new 사운드("메인선택버튼.mp3", false);
			효과음.start();
		}


		// 게임 시작  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		while (true) {
			auto.interrupt();
			f.interrupt();
			메인3.음악중지();
			배틀.음악중지();

			//주인공 사망시 경험치 하락 패널티
			if (p.hp <= 0) {
				System.out.println("사망하여 경험치를 잃었습니다.");
				System.out.println(닉네임 + "의 전체 경험치가 30% 줄어듭니다.");
				System.out.println("몬스터에게 돈을 털렸습니다 !!");
				p.gd -= 랜덤.nextInt(2000 + 2000);
				p.hp = 1;
				p.ex -= 30;
				System.out.println();
				System.out.println();
				System.out.println("                                                    ↵   ");
				sc.nextLine();
				효과음.음악중지();
				효과음 = new 사운드("메인선택버튼.mp3", false);
				효과음.start();

				//경험치가 -일때 0으로초기화
				if (p.ex <= 0) {
					p.ex = 0;
				}
			}


			//메인 배경음악
			메인3 = new 사운드("메인3.mp3", true);
			메인3.start();

			System.out.println("휴식을 취합니다.");
			TimeUnit.SECONDS.sleep(1);


			//휴식실행 (주인공회복)
			휴식 = new 휴식(p);
			휴식.휴식실행();


			//주인공의 상태
			p.상태(닉네임);
			System.out.println();
			System.out.println("                                                    ↵   ");
			sc.nextLine();

			//시스템 경고 공복도부족
			if (p.en <= 20) {
				System.out.println("공복도가 부족합니다.");
				System.out.println("원할한 사냥을위해 마을 탐방에서 음식점에서 공복도를 보충해주세요!");
				경고 = new 사운드("5. 삐.mp3", false);
				경고.start();
				System.out.println();
				System.out.println("                                                    ↵   ");
				sc.nextLine();

			}

			//시스템 경고 hp부족
			if (p.hp <= 20) {
				System.out.println("Hp가 부족합니다.");
				System.out.println("원할한 사냥을위해 마을 탐방에서 음식점에서 공복도를 보충해주세요!");
				경고 = new 사운드("5. 삐.mp3", false);
				경고.start();
				System.out.println();
				System.out.println("                                                    ↵   ");
				sc.nextLine();
			}

			//메인 화면
			메뉴창.메인창();
			공백.입력();
			메인선택 = sc.nextInt();
			sc.nextLine();
			효과음 = new 사운드("메인선택버튼.mp3", false);
			효과음.start();
			System.out.println();


			//사냥터 입장  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			while (true) {

				//쓰레드 종료
				배틀.음악중지();
				메인3.음악중지();
				f.interrupt();
				auto.interrupt();

				//공복도 공복시 귀환
				if (p.en <= 0) {
					System.out.println("배가고파 탐색을 하기 힘듭니다.");
					System.out.println("현재공복도 : " + p.en);
					System.out.println("마을로 귀환합니다.");
					System.out.println();
					System.out.println("                                                    ↵   ");
					sc.nextLine();
					break;
				}

				//주인공 사망시 귀환
				if (p.hp <= 0) {
					break;
				}


				//메뉴창.사냥터선택
				if (메인선택 == 1) {

					System.out.println("레벨에 맞지않는 사냥터를 선택하게되면 경험치 패널티를 받습니다.");
					System.out.println("");
					System.out.println("                                                        ↵   ");
					sc.nextLine();
					효과음.음악중지();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();


					//1.달팽이숲 2.메뚜기 3.버섯 4.풀벌레 0.돌아가기
					메뉴창.사냥터선택();
					공백.입력();
					사냥터탐색 = sc.nextInt();
					sc.nextLine();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();


					//달팽이(1)  - 시간 =================================================
					if (사냥터탐색 == 1) {
						달팽이숲.입장();

						//레벨 패널티 (수정)
						if (p.lv >= 10) {
							경고 = new 사운드("5. 삐.mp3", false);
							경고.start();
							p.구역1 = 0;
						} else {
							p.구역1 = 1;
						}

						//공복도 경고
						if (p.en <= 10) {
							System.out.println("배가고파 오랫동안 탐색을 하기 힘들것같다.");
							System.out.println("현재공복도 : " + p.en);
							if (p.en <= 0) {
								p.en = 0;
								System.out.println("공복도가 0이되어 더이상 사냥을할수없습니다.");
								System.out.println();
								System.out.println("                                     ↵   ");
								sc.nextLine();
								효과음.음악중지();
								효과음 = new 사운드("메인선택버튼.mp3", false);
								효과음.start();
								break;
							}
						}

						//탐색중 에너지 소모
						p.en -= 5;

						//전투시 몬스터 생성 및 적등장 및 선택
						int 탐색 = 랜덤.nextInt(100 + 1);
						m.달팽이생성(탐색);
						m.적등장();


						//전투 혹은 도망
						int 전투;
						전투 = sc.nextInt();
						sc.nextLine();
						효과음 = new 사운드("메인선택버튼.mp3", false);
						효과음.start();


						//전투 시작 , 도망치기
						if (전투 == 1) {
							f.interrupt();
							auto.interrupt();

							공백.공백s();
							System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐ 전투 로그 ⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
							공백.공백s();
							System.out.println("전투를 시작합니다.");

							//전투시간 쓰레드
							f = new Thread(new 전투시간(m, p));
							f.start();

							//전투 시작
							while (true) {


								//플레이어의 공격
								m.피격(p.공격());

								//유저 hp가 0이면 사망 및 패널티
								if (p.hp <= 0) {
									f.interrupt();
									auto.interrupt();
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									break;
								}

								//몬스터 잡을시 보상
								if (m.hp <= 0) {

									f.interrupt();
									auto.interrupt();

									TimeUnit.SECONDS.sleep(1);

									System.out.println();
									System.out.println("성공적으로 " + m.이름 + "을(를) 잡았습니다.");
									p.ex += (m.ex) * (p.경험치부적) * (p.구역1);
									System.out.println("+ " + m.ex + "  경험치 획득");
									p.gd += m.gd;
									System.out.println("+ " + (m.gd) + " 원 획득");
									p.시련의조각 += m.시련의조각;
									System.out.println("시련의조각 + :" + p.시련의조각 + " 획득!");

									//레벨업
									if (p.ex >= p.exm) {
										p.lv += 1;
										p.ex -= 100;

										if ("토끼".equals(p.종족)) {
											p.at += 2;
											p.dp += 1;
										} else if ("거북".equals(p.종족)) {
											p.at += 1;
											p.dp += 2;
										} else if ("랜덤".equals(p.종족)) {
											p.at += 랜덤.nextInt(3);
											p.dp += 랜덤.nextInt(3);

										}
										TimeUnit.SECONDS.sleep(1);
										System.out.println(p.종족 + "의 레벨이 올랐습니다!!");
										레벨업.음악중지();
										레벨업 = new 사운드("레벨업.mp3", false);
										레벨업.start();

										p.hp = p.hpm;
										p.mp = p.mpm;
									}

									//시련의 조각 >> 돌로 변환
									if (p.시련의조각 >= 100) {
										p.시련의조각 -= 100;
										p.시련의돌 += 1;
										System.out.println("시련의 조각이 시련의 돌로 바뀌었습니다.");
									}

									//시련 퀘스트 아이템
									if (m.지금 == 1) {
										System.out.println("보스를 잡으면 일정확률로 퀘스트아이템을 받습니다.");
										p.지금 += 랜덤.nextInt(1);
										if (p.지금 >= 1) {
											System.out.println("첫번쨰 퀘스트 아이템을 획득하였습니다.");
										}
										System.out.println();
										System.out.println("조건을 달성하고 시련에 도전해주세요!");
										if (p.lv >= 10 && p.지금 >= 1) {
											System.out.println("첫번쨰 퀘스트 조건을 충족하였습니다.");
										}
									}
									System.out.println("                                                    ↵   ");
									sc.nextLine();
									효과음.음악중지();
									효과음 = new 사운드("메인선택버튼.mp3", false);
									효과음.start();
									break;
								}


								//몬스터의 공격
								System.out.println();
								auto.interrupt();
								auto = new Thread(new 자동공격(p, m));
								auto.start();


								//유저 hp가 0이면 사망 및 패널티
								if (p.hp <= 0) {
									f.interrupt();
									auto.interrupt();
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									System.out.println("");
									break;
								}

							}

						}

						//도망 실패시 적이 먼저공격
						else if (전투 == 2) {
							f.interrupt();
							auto.interrupt();

							공백.공백s();

							int 도망 = 랜덤.nextInt(99 + 1);

							//도망성공
							if (도망 <= 80) {
								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("도망치기가 성공하였습니다.");
								뿅.음악중지();
								뿅 = new 사운드("도망.mp3", false);
								뿅.start();
							}

							//[도망시 80퍼 성공  &&  10퍼 전투]
							else {

								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("도망에 실패하였습니다!");
								당황.음악중지();
								당황 = new 사운드("뜨헉.mp3", false);
								당황.start();
								System.out.println();
								System.out.println();
								System.out.println();

								f = new Thread(new 전투시간(m, p));
								f.start();

								//전투
								while (true) {

									//몬스터의 공격,전투시간 쓰레드
									System.out.println();
									auto.interrupt();
									auto = new Thread(new 자동공격(p, m));
									auto.start();

									//유저 hp가 0이면 사망 및 패널티
									if (p.hp <= 0) {
										f.interrupt();
										auto.interrupt();
										경고 = new 사운드("5. 삐.mp3", false);
										경고.start();
										System.out.println("");
										break;
									}

									//플레이어의 공격
									m.피격(p.공격());

									//유저 hp가 0이면 사망 및 패널티
									if (p.hp <= 0) {
										f.interrupt();
										auto.interrupt();
										경고 = new 사운드("5. 삐.mp3", false);
										경고.start();
										break;
									}

									//몬스터 잡을시 보상
									if (m.hp <= 0) {

										f.interrupt();
										auto.interrupt();

										TimeUnit.SECONDS.sleep(1);

										System.out.println();
										System.out.println("성공적으로 " + m.이름 + "을(를) 잡았습니다.");
										p.ex += (m.ex) * (p.경험치부적) * (p.구역1);
										System.out.println("+ " + m.ex + "  경험치 획득");
										p.gd += m.gd;
										System.out.println("+ " + (m.gd) + " 원 획득");
										p.시련의조각 += m.시련의조각;
										System.out.println("시련의조각 + :" + p.시련의조각 + " 획득!");

										//레벨업
										if (p.ex >= p.exm) {
											p.lv += 1;
											p.ex -= 100;

											if ("토끼".equals(p.종족)) {
												p.at += 2;
												p.dp += 1;
											} else if ("거북".equals(p.종족)) {
												p.at += 1;
												p.dp += 2;
											} else if ("랜덤".equals(p.종족)) {
												p.at += 랜덤.nextInt(3);
												p.dp += 랜덤.nextInt(3);

											}
											TimeUnit.SECONDS.sleep(1);
											System.out.println(p.종족 + "의 레벨이 올랐습니다!!");
											레벨업.음악중지();
											레벨업 = new 사운드("레벨업.mp3", false);
											레벨업.start();

											p.hp = p.hpm;
											p.mp = p.mpm;
										}

										//시련의 조각 >> 돌로 변환
										if (p.시련의조각 >= 100) {
											p.시련의조각 -= 100;
											p.시련의돌 += 1;
											System.out.println("시련의 조각이 시련의 돌로 바뀌었습니다.");
										}

										//시련 퀘스트 아이템
										if (m.지금 == 1) {
											System.out.println("보스를 잡으면 일정확률로 퀘스트아이템을 받습니다.");
											p.지금 += 랜덤.nextInt(1);
											if (p.지금 >= 1) {
												System.out.println("첫번쨰 퀘스트 아이템을 획득하였습니다.");
											}
											System.out.println();
											System.out.println("조건을 달성하고 시련에 도전해주세요!");
											if (p.lv >= 10 && p.지금 >= 1) {
												System.out.println("첫번쨰 퀘스트 조건을 충족하였습니다.");
											}
										}
										System.out.println("                                                    ↵   ");
										sc.nextLine();
										효과음.음악중지();
										효과음 = new 사운드("메인선택버튼.mp3", false);
										효과음.start();
										break;
									}

								}


							}
						}

						//다시입력
						else {
							System.out.println("다시입력해주세요 !");
							공백.입력();
							전투 = sc.nextInt();
							sc.nextLine();
						}
					}

					//메뚜기(2) -  인내
					else if (사냥터탐색 == 2) {
						메뚜기마을.입장();

						//레벨 패널티 (수정)
						if (p.lv >= 30) {
							경고 = new 사운드("5. 삐.mp3", false);
							경고.start();
							p.구역2 = 0;
						} else {
							p.구역2 = 1;
						}

						//공복도 경고
						if (p.en <= 10) {
							System.out.println("배가고파 오랫동안 탐색을 하기 힘들것같다.");
							System.out.println("현재공복도 : " + p.en);
							if (p.en <= 0) {
								p.en = 0;
								System.out.println("공복도가 0이되어 더이상 사냥을할수없습니다.");
								System.out.println();
								System.out.println("                                     ↵   ");
								sc.nextLine();
								효과음.음악중지();
								효과음 = new 사운드("메인선택버튼.mp3", false);
								효과음.start();
								break;
							}
						}

						//탐색중 에너지 소모
						p.en -= 5;

						//전투시 몬스터 생성 및 적등장 및 선택
						int 탐색 = 랜덤.nextInt(100 + 1);
						m.메뚜기생성(탐색);
						m.적등장();


						//전투 혹은 도망
						int 전투;
						전투 = sc.nextInt();
						sc.nextLine();
						효과음 = new 사운드("메인선택버튼.mp3", false);
						효과음.start();


						//전투 시작 , 도망치기
						if (전투 == 1) {
							f.interrupt();
							auto.interrupt();

							공백.공백s();
							System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐ 전투 로그 ⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
							공백.공백s();
							System.out.println("전투를 시작합니다.");

							//전투시간 쓰레드
							f = new Thread(new 전투시간(m, p));
							f.start();

							//전투 시작
							while (true) {


								//플레이어의 공격
								m.피격(p.공격());

								//유저 hp가 0이면 사망 및 패널티
								if (p.hp <= 0) {
									f.interrupt();
									auto.interrupt();
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									break;
								}

								//몬스터 잡을시 보상
								if (m.hp <= 0) {

									f.interrupt();
									auto.interrupt();

									TimeUnit.SECONDS.sleep(1);

									System.out.println();
									System.out.println("성공적으로 " + m.이름 + "을(를) 잡았습니다.");
									p.ex += (m.ex) * (p.경험치부적) * (p.구역2);
									System.out.println("+ " + m.ex + "  경험치 획득");
									p.gd += m.gd;
									System.out.println("+ " + (m.gd) + " 원 획득");
									p.시련의조각 += m.시련의조각;
									System.out.println("시련의조각 + :" + p.시련의조각 + " 획득!");

									//레벨업
									if (p.ex >= p.exm) {
										p.lv += 1;
										p.ex -= 100;

										if ("토끼".equals(p.종족)) {
											p.hpm *= p.lv;
											p.at += 2;
											p.dp += 1;
										} else if ("거북".equals(p.종족)) {
											p.at += 1;
											p.dp += 2;
										} else if ("랜덤".equals(p.종족)) {
											p.at += 랜덤.nextInt(3);
											p.dp += 랜덤.nextInt(3);

										}
										TimeUnit.SECONDS.sleep(1);
										System.out.println(p.종족 + "의 레벨이 올랐습니다!!");
										레벨업.음악중지();
										레벨업 = new 사운드("레벨업.mp3", false);
										레벨업.start();

										p.hp = p.hpm;
										p.mp = p.mpm;
									}

									//시련의 조각 >> 돌로 변환
									if (p.시련의조각 >= 100) {
										p.시련의조각 -= 100;
										p.시련의돌 += 1;
										System.out.println("시련의 조각이 시련의 돌로 바뀌었습니다.");
									}

									//시련 퀘스트 아이템
									if (m.열매 == 1) {
										System.out.println("보스를 잡으면 일정확률로 퀘스트아이템을 받습니다.");
										p.열매 += 1;
										if (p.열매 >= 1) {
											System.out.println("두번쨰 퀘스트 아이템을 획득하였습니다.");
										}
										System.out.println();
										System.out.println("조건을 달성하고 시련에 도전해주세요!");
										if (p.lv >= 30 && p.열매 >= 1) {
											System.out.println("두번쨰 퀘스트 조건을 충족하였습니다.");
										}
									}
									System.out.println("                                                    ↵   ");
									sc.nextLine();
									효과음.음악중지();
									효과음 = new 사운드("메인선택버튼.mp3", false);
									효과음.start();
									break;
								}


								//몬스터의 공격
								System.out.println();
								auto.interrupt();
								auto = new Thread(new 자동공격(p, m));
								auto.start();



								//유저 hp가 0이면 사망 및 패널티
								if (p.hp <= 0) {
									f.interrupt();
									auto.interrupt();
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									System.out.println("");
									break;
								}

							}

						}

						//도망 실패시 적이 먼저공격
						else if (전투 == 2) {
							f.interrupt();
							auto.interrupt();

							공백.공백s();

							int 도망 = 랜덤.nextInt(99 + 1);

							//도망성공
							if (도망 <= 80) {
								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("도망치기가 성공하였습니다.");
								뿅.음악중지();
								뿅 = new 사운드("도망.mp3", false);
								뿅.start();
							}

							//[도망시 80퍼 성공  &&  10퍼 전투]
							else {

								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("도망에 실패하였습니다!");
								당황.음악중지();
								당황 = new 사운드("뜨헉.mp3", false);
								당황.start();
								System.out.println();
								System.out.println();
								System.out.println();

								f = new Thread(new 전투시간(m, p));
								f.start();

								//전투
								while (true) {

									//몬스터의 공격,전투시간 쓰레드
									System.out.println();
									auto.interrupt();
									auto = new Thread(new 자동공격(p, m));
									auto.start();


									//유저 hp가 0이면 사망 및 패널티
									if (p.hp <= 0) {
										f.interrupt();
										auto.interrupt();
										경고 = new 사운드("5. 삐.mp3", false);
										경고.start();
										System.out.println("");
										break;
									}

									//플레이어의 공격
									m.피격(p.공격());

									//유저 hp가 0이면 사망 및 패널티
									if (p.hp <= 0) {
										f.interrupt();
										auto.interrupt();
										경고 = new 사운드("5. 삐.mp3", false);
										경고.start();
										break;
									}

									//몬스터 잡을시 보상
									if (m.hp <= 0) {

										f.interrupt();
										auto.interrupt();

										TimeUnit.SECONDS.sleep(1);

										System.out.println();
										System.out.println("성공적으로 " + m.이름 + "을(를) 잡았습니다.");
										p.ex += (m.ex) * (p.경험치부적) * (p.구역2);
										System.out.println("+ " + m.ex + "  경험치 획득");
										p.gd += m.gd;
										System.out.println("+ " + (m.gd) + " 원 획득");
										p.시련의조각 += m.시련의조각;
										System.out.println("시련의조각 + :" + p.시련의조각 + " 획득!");

										//레벨업
										if (p.ex >= p.exm) {
											p.lv += 1;
											p.ex -= 100;

											if ("토끼".equals(p.종족)) {
												p.hpm *= p.lv;
												p.at += 2;
												p.dp += 1;
											} else if ("거북".equals(p.종족)) {
												p.at += 1;
												p.dp += 2;
											} else if ("랜덤".equals(p.종족)) {
												p.at += 랜덤.nextInt(3);
												p.dp += 랜덤.nextInt(3);

											}
											TimeUnit.SECONDS.sleep(1);
											System.out.println(p.종족 + "의 레벨이 올랐습니다!!");
											레벨업.음악중지();
											레벨업 = new 사운드("레벨업.mp3", false);
											레벨업.start();

											p.hp = p.hpm;
											p.mp = p.mpm;
										}

										//시련의 조각 >> 돌로 변환
										if (p.시련의조각 >= 100) {
											p.시련의조각 -= 100;
											p.시련의돌 += 1;
											System.out.println("시련의 조각이 시련의 돌로 바뀌었습니다.");
										}

										//시련 퀘스트 아이템
										if (m.열매 == 1) {
											System.out.println("보스를 잡으면 일정확률로 퀘스트아이템을 받습니다.");
											p.열매 += 1;
											if (p.열매 >= 1) {
												System.out.println("두번쨰 퀘스트 아이템을 획득하였습니다.");
											}
											System.out.println();
											System.out.println("조건을 달성하고 시련에 도전해주세요!");
											if (p.lv >= 30 && p.열매 >= 1) {
												System.out.println("두번쨰 퀘스트 조건을 충족하였습니다.");
											}
										}
										System.out.println("                                                    ↵   ");
										sc.nextLine();
										효과음.음악중지();
										효과음 = new 사운드("메인선택버튼.mp3", false);
										효과음.start();
										break;
									}

								}


							}
						}

						//다시입력
						else {
							System.out.println("다시입력해주세요 !");
							공백.입력();
							전투 = sc.nextInt();
							sc.nextLine();
						}
					}

					//버섯(3)   -  긍정
					else if (사냥터탐색 == 3) {
						버섯산.입장();

						//레벨 패널티 (수정)
						if (p.lv >= 60) {
							경고 = new 사운드("5. 삐.mp3", false);
							경고.start();
							p.구역3 = 0;
						} else {
							p.구역3 = 1;
						}

						//공복도 경고
						if (p.en <= 10) {
							System.out.println("배가고파 오랫동안 탐색을 하기 힘들것같다.");
							System.out.println("현재공복도 : " + p.en);
							if (p.en <= 0) {
								p.en = 0;
								System.out.println("공복도가 0이되어 더이상 사냥을할수없습니다.");
								System.out.println();
								System.out.println("                                     ↵   ");
								sc.nextLine();
								효과음.음악중지();
								효과음 = new 사운드("메인선택버튼.mp3", false);
								효과음.start();
								break;
							}
						}

						//탐색중 에너지 소모
						p.en -= 5;

						//전투시 몬스터 생성 및 적등장 및 선택
						int 탐색 = 랜덤.nextInt(100 + 1);
						m.버섯생성(탐색);
						m.적등장();


						//전투 혹은 도망
						int 전투;
						전투 = sc.nextInt();
						sc.nextLine();
						효과음 = new 사운드("메인선택버튼.mp3", false);
						효과음.start();


						//전투 시작 , 도망치기
						if (전투 == 1) {
							f.interrupt();
							auto.interrupt();

							공백.공백s();
							System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐ 전투 로그 ⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
							공백.공백s();
							System.out.println("전투를 시작합니다.");

							//전투시간 쓰레드
							f = new Thread(new 전투시간(m, p));
							f.start();

							//전투 시작
							while (true) {


								//플레이어의 공격
								m.피격(p.공격());

								//유저 hp가 0이면 사망 및 패널티
								if (p.hp <= 0) {
									f.interrupt();
									auto.interrupt();
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									break;
								}

								//몬스터 잡을시 보상
								if (m.hp <= 0) {

									f.interrupt();
									auto.interrupt();

									TimeUnit.SECONDS.sleep(1);

									System.out.println();
									System.out.println("성공적으로 " + m.이름 + "을(를) 잡았습니다.");
									p.ex += (m.ex) * (p.경험치부적) * (p.구역3);
									System.out.println("+ " + m.ex + "  경험치 획득");
									p.gd += m.gd;
									System.out.println("+ " + (m.gd) + " 원 획득");
									p.시련의조각 += m.시련의조각;
									System.out.println("시련의조각 + :" + p.시련의조각 + " 획득!");

									//레벨업
									if (p.ex >= p.exm) {
										p.lv += 1;
										p.ex -= 100;

										if ("토끼".equals(p.종족)) {
											p.hpm *= p.lv;
											p.at += 2;
											p.dp += 1;
										} else if ("거북".equals(p.종족)) {
											p.at += 1;
											p.dp += 2;
										} else if ("랜덤".equals(p.종족)) {
											p.at += 랜덤.nextInt(3);
											p.dp += 랜덤.nextInt(3);

										}
										TimeUnit.SECONDS.sleep(1);
										System.out.println(p.종족 + "의 레벨이 올랐습니다!!");
										레벨업.음악중지();
										레벨업 = new 사운드("레벨업.mp3", false);
										레벨업.start();


										p.hp = p.hpm;
										p.mp = p.mpm;
									}

									//시련의 조각 >> 돌로 변환
									if (p.시련의조각 >= 100) {
										p.시련의조각 -= 100;
										p.시련의돌 += 1;
										System.out.println("시련의 조각이 시련의 돌로 바뀌었습니다.");
									}

									//시련 퀘스트 아이템
									if (m.웃음꽃 == 1) {
										System.out.println("보스를 잡으면 일정확률로 퀘스트아이템을 받습니다.");
										p.웃음꽃 += 1;
										if (p.웃음꽃 >= 1) {
											System.out.println("세번쨰 퀘스트 아이템을 획득하였습니다.");
										}
										System.out.println();
										System.out.println("조건을 달성하고 시련에 도전해주세요!");
										if (p.lv >= 60 && p.웃음꽃 >= 1) {
											System.out.println("세번쨰 퀘스트 조건을 충족하였습니다.");
										}
									}
									System.out.println("                                                    ↵   ");
									sc.nextLine();
									효과음.음악중지();
									효과음 = new 사운드("메인선택버튼.mp3", false);
									효과음.start();
									break;
								}


								//몬스터의 공격
								System.out.println();
								auto.interrupt();
								auto = new Thread(new 자동공격(p, m));
								auto.start();



								//유저 hp가 0이면 사망 및 패널티
								if (p.hp <= 0) {
									f.interrupt();
									auto.interrupt();
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									System.out.println("");
									break;
								}

							}

						}

						//도망 실패시 적이 먼저공격
						else if (전투 == 2) {
							f.interrupt();
							auto.interrupt();

							공백.공백s();

							int 도망 = 랜덤.nextInt(99 + 1);

							//도망성공
							if (도망 <= 80) {
								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("도망치기가 성공하였습니다.");
								뿅.음악중지();
								뿅 = new 사운드("도망.mp3", false);
								뿅.start();
							}

							//[도망시 80퍼 성공  &&  10퍼 전투]
							else {

								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("도망에 실패하였습니다!");
								당황.음악중지();
								당황 = new 사운드("뜨헉.mp3", false);
								당황.start();
								System.out.println();
								System.out.println();
								System.out.println();

								f = new Thread(new 전투시간(m, p));
								f.start();

								//전투
								while (true) {

									//몬스터의 공격,전투시간 쓰레드
									System.out.println();
									auto.interrupt();
									auto = new Thread(new 자동공격(p, m));
									auto.start();

									//유저 hp가 0이면 사망 및 패널티
									if (p.hp <= 0) {
										f.interrupt();
										auto.interrupt();
										경고 = new 사운드("5. 삐.mp3", false);
										경고.start();
										System.out.println("");
										break;
									}

									//플레이어의 공격
									m.피격(p.공격());

									//유저 hp가 0이면 사망 및 패널티
									if (p.hp <= 0) {
										f.interrupt();
										auto.interrupt();
										경고 = new 사운드("5. 삐.mp3", false);
										경고.start();
										break;
									}

									//몬스터 잡을시 보상
									if (m.hp <= 0) {

										f.interrupt();
										auto.interrupt();

										TimeUnit.SECONDS.sleep(1);

										System.out.println();
										System.out.println("성공적으로 " + m.이름 + "을(를) 잡았습니다.");
										p.ex += (m.ex) * (p.경험치부적) * (p.구역3);
										System.out.println("+ " + m.ex + "  경험치 획득");
										p.gd += m.gd;
										System.out.println("+ " + (m.gd) + " 원 획득");
										p.시련의조각 += m.시련의조각;
										System.out.println("시련의조각 + :" + p.시련의조각 + " 획득!");

										//레벨업
										if (p.ex >= p.exm) {
											p.lv += 1;
											p.ex -= 100;



											if ("토끼".equals(p.종족)) {
												p.hpm *= p.lv;
												p.at += 2;
												p.dp += 1;
											} else if ("거북".equals(p.종족)) {
												p.at += 1;
												p.dp += 2;
											} else if ("랜덤".equals(p.종족)) {
												p.at += 랜덤.nextInt(3);
												p.dp += 랜덤.nextInt(3);

											}
											TimeUnit.SECONDS.sleep(1);
											System.out.println(p.종족 + "의 레벨이 올랐습니다!!");
											레벨업.음악중지();
											레벨업 = new 사운드("레벨업.mp3", false);
											레벨업.start();
											p.hp = p.hpm;
											p.mp = p.mpm;
										}

										//시련의 조각 >> 돌로 변환
										if (p.시련의조각 >= 100) {
											p.시련의조각 -= 100;
											p.시련의돌 += 1;
											System.out.println("시련의 조각이 시련의 돌로 바뀌었습니다.");
										}

										//시련 퀘스트 아이템
										if (m.웃음꽃 == 1) {
											System.out.println("보스를 잡으면 일정확률로 퀘스트아이템을 받습니다.");
											p.웃음꽃 += 1;
											if (p.웃음꽃 >= 1) {
												System.out.println("세번쨰 퀘스트 아이템을 획득하였습니다.");
											}
											System.out.println();
											System.out.println("조건을 달성하고 시련에 도전해주세요!");
											if (p.lv >= 60 && p.웃음꽃 >= 1) {
												System.out.println("세번쨰 퀘스트 조건을 충족하였습니다.");
											}
										}
										System.out.println("                                                    ↵   ");
										sc.nextLine();
										효과음.음악중지();
										효과음 = new 사운드("메인선택버튼.mp3", false);
										효과음.start();
										break;
									}

								}


							}
						}

						//다시입력
						else {
							System.out.println("다시입력해주세요 !");
							공백.입력();
							전투 = sc.nextInt();
							sc.nextLine();
						}
					}

					//풀벌레(4) -  배려(이타심)
					else if (사냥터탐색 == 4) {
						풀벌레나라.입장();

						//레벨 패널티 (수정)
						if (p.lv >= 100) {
							경고 = new 사운드("5. 삐.mp3", false);
							경고.start();
							p.구역4 = 0;
						} else {
							p.구역4 = 1;
						}

						//공복도 경고
						if (p.en <= 10) {
							System.out.println("배가고파 오랫동안 탐색을 하기 힘들것같다.");
							System.out.println("현재공복도 : " + p.en);
							if (p.en <= 0) {
								p.en = 0;
								System.out.println("공복도가 0이되어 더이상 사냥을할수없습니다.");
								System.out.println();
								System.out.println("                                     ↵   ");
								sc.nextLine();
								효과음.음악중지();
								효과음 = new 사운드("메인선택버튼.mp3", false);
								효과음.start();
								break;
							}
						}

						//탐색중 에너지 소모
						p.en -= 5;

						//전투시 몬스터 생성 및 적등장 및 선택
						int 탐색 = 랜덤.nextInt(100 + 1);
						m.풀벌레생성(탐색);
						m.적등장();

						//둘리의 반성
						if ("둘리".equals(m.이름) &&  p.둘리의눈물 == 1){
							System.out.println("1.핵꿀밤           2.핵토파스칼킥 ");
							System.out.println("                                   ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							System.out.println("필살기 !");
							System.out.println("나의 핵공격을 받아라 !!");
							System.out.println("                      ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							System.out.println("...");
							System.out.println("   ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							System.out.println("둘리 : 폭력 멈춰 !!!!!!!");
							System.out.println("                        ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							System.out.println();
							System.out.println("??? : 멈춰 !!!");
							System.out.println("              ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							System.out.println("길동이 쉑.. 그래.. 내가 미안해 내가잘못했어 ..");
							TimeUnit.SECONDS.sleep(1);
							System.out.println(" 너의 승리야..");
							TimeUnit.SECONDS.sleep(1);
							System.out.println("둘리가 눈물을 흘리며 반성합니다.");
							p.고길동의소원 += 1;
							TimeUnit.SECONDS.sleep(1);
							System.out.println("고길동의 소원을 이뤄주세요 !!");
							System.out.println("마을로 귀환합니다..");
							System.out.println("                                                    ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						//각성둘리 3페이즈
						else if ("둘리".equals(m.이름) && p.호잇 >= 2 && p.둘리의분노 >= 1 ) {
							System.out.println("아니 둘리의 상태가 !!?");
							TimeUnit.SECONDS.sleep(1);
							공백.공백s();
							System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
							System.out.println("[ 마지막 시련의 보스 ]" + m.이름 + "(이)가 각성 하였습니다. ");
							System.out.println(m.이름 + ": 봐주지 않겠다! ");
							System.out.println("귀여운 둘리의 초능력 내친구의 맛을 보여주지!");
							System.out.println("⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥐⥐⥐⥐⥐⥐⥎⥎");
							System.out.println("                                            ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							공백.공백s();
							TimeUnit.SECONDS.sleep(1);
							System.out.println("둘리가 각성하여 [각성한 둘리]가 되었습니다. ");

							m = new 둘리();
							m.종족 = "공룡족";
							m.이름 = "[각성]둘리";
							m.이름 = "둘리";    //엘리트 보스몬스터
							m.lv = 100;
							m.hp = 1000;
							m.at = 30;
							m.dp = 40;

							m.ex = 100;
							m.gd = 10000 + 랜덤.nextInt(10000);
							m.시련의조각 = 50;
							m.호잇 = 1;
							m.둘리의눈물 = 1;
							m.적등장();
						}

						//강화 둘리 2페이즈
						else if ("둘리".equals(m.이름) && p.고길동의부탁 == 1) {

							System.out.println("둘리 : 이냄새는 !!검성의 냄새 !!?!");
							System.out.println("                   ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();

							System.out.println("둘리 : 검성 고길동의 냄새.. 오랜만이야 ");
							System.out.println("                             ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							System.out.println("둘리 : 또 나를 잡으러 왔단말이지??");
							System.out.println("                                 ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							System.out.println("이번엔 쉽게안당할걸 ?? 초능력 맛을 보여주지 !!");
							System.out.println("                                         ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3", false);
							효과음.start();
							m.hp += 500;
							m.at += 10;
							m.둘리의분노 =1;
							m.적등장();
						}






						//전투 혹은 도망
						int 전투;
						전투 = sc.nextInt();
						sc.nextLine();
						효과음 = new 사운드("메인선택버튼.mp3", false);
						효과음.start();


						//전투 시작 , 도망치기
						if (전투 == 1) {
							f.interrupt();
							auto.interrupt();

							공백.공백s();
							System.out.println("⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐ 전투 로그 ⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
							공백.공백s();
							System.out.println("전투를 시작합니다.");

							//전투시간 쓰레드
							f = new Thread(new 전투시간(m, p));
							f.start();

							//전투 시작
							while (true) {

								//플레이어의 공격
								m.피격(p.공격());

								//유저 hp가 0이면 사망 및 패널티
								if (p.hp <= 0) {
									f.interrupt();
									auto.interrupt();
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									break;
								}

								//몬스터 잡을시 보상
								if (m.hp <= 0) {

									f.interrupt();
									auto.interrupt();

									TimeUnit.SECONDS.sleep(1);

									System.out.println();
									System.out.println("성공적으로 " + m.이름 + "을(를) 잡았습니다.");
									p.ex += (m.ex) * (p.경험치부적) * (p.구역4);
									System.out.println("+ " + m.ex + "  경험치 획득");
									p.gd += m.gd;
									System.out.println("+ " + (m.gd) + " 원 획득");
									p.시련의조각 += m.시련의조각;
									System.out.println("시련의조각 + :" + p.시련의조각 + " 획득!");

									//레벨업
									if (p.ex >= p.exm) {
										p.lv += 1;
										p.ex -= 100;



										if ("토끼".equals(p.종족)) {
											p.hpm *= p.lv;
											p.at += 2;
											p.dp += 1;
										} else if ("거북".equals(p.종족)) {
											p.at += 1;
											p.dp += 2;
										} else if ("랜덤".equals(p.종족)) {
											p.at += 랜덤.nextInt(3);
											p.dp += 랜덤.nextInt(3);

										}
										TimeUnit.SECONDS.sleep(1);
										System.out.println(p.종족 + "의 레벨이 올랐습니다!!");
										레벨업.음악중지();
										레벨업 = new 사운드("레벨업.mp3", false);
										레벨업.start();
										if (p.lv >= 90) {
											System.out.println("네번쨰 퀘스트 조건을 충족하였습니다.");
										}
										p.hp = p.hpm;
										p.mp = p.mpm;
									}

									//시련의 조각 >> 돌로 변환
									if (p.시련의조각 >= 100) {
										p.시련의조각 -= 100;
										p.시련의돌 += 1;
										System.out.println("시련의 조각이 시련의 돌로 바뀌었습니다.");
									}



									//시련 퀘스트 아이템
									if (m.호잇 == 1) {
										System.out.println("보스를 잡으면 일정확률로 퀘스트아이템을 받습니다.");
										p.호잇 += 1;
										if (p.호잇 == 1&& p.고길동의부탁 == 1) {
											System.out.println("둘리를 더혼내주세요 !");
										}
										if(m.둘리의분노 == 1){
											p.둘리의분노 += 1;
										}
										if (m.둘리의눈물 == 1){
											System.out.println("둘리의 눈물을 얻었습니다!!");
											System.out.println("마지막으로 한번더 둘리를 혼내주세요 !!");
											p.둘리의눈물 +=1;
										}

									}
									System.out.println("                                                    ↵   ");
									sc.nextLine();
									효과음.음악중지();
									효과음 = new 사운드("메인선택버튼.mp3", false);
									효과음.start();
									break;
								}


								//몬스터의 공격
								System.out.println();
								auto.interrupt();
								auto = new Thread(new 자동공격(p, m));
								auto.start();



								//유저 hp가 0이면 사망 및 패널티
								if (p.hp <= 0) {
									f.interrupt();
									auto.interrupt();
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									System.out.println("");
									break;
								}

							}

						}

						//도망 실패시 적이 먼저공격
						else if (전투 == 2) {
							f.interrupt();
							auto.interrupt();

							공백.공백s();

							int 도망 = 랜덤.nextInt(99 + 1);

							//도망성공
							if (도망 <= 80) {
								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("도망치기가 성공하였습니다.");
								뿅.음악중지();
								뿅 = new 사운드("도망.mp3", false);
								뿅.start();
							}

							//[도망시 80퍼 성공  &&  10퍼 전투]
							else {

								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("도망에 실패하였습니다!");
								당황.음악중지();
								당황 = new 사운드("뜨헉.mp3", false);
								당황.start();
								System.out.println();
								System.out.println();
								System.out.println();

								f = new Thread(new 전투시간(m, p));
								f.start();

								//전투
								while (true) {

									//몬스터의 공격,전투시간 쓰레드
									System.out.println();
									auto.interrupt();
									auto = new Thread(new 자동공격(p, m));
									auto.start();

									//유저 hp가 0이면 사망 및 패널티
									if (p.hp <= 0) {
										f.interrupt();
										auto.interrupt();
										경고 = new 사운드("5. 삐.mp3", false);
										경고.start();
										System.out.println("");
										break;
									}

									//플레이어의 공격
									m.피격(p.공격());

									//유저 hp가 0이면 사망 및 패널티
									if (p.hp <= 0) {
										f.interrupt();
										auto.interrupt();
										경고 = new 사운드("5. 삐.mp3", false);
										경고.start();
										break;
									}

									//몬스터 잡을시 보상
									if (m.hp <= 0) {

										f.interrupt();
										auto.interrupt();

										TimeUnit.SECONDS.sleep(1);

										System.out.println();
										System.out.println("성공적으로 " + m.이름 + "을(를) 잡았습니다.");
										p.ex += (m.ex) * (p.경험치부적) * (p.구역4);
										System.out.println("+ " + m.ex + "  경험치 획득");
										p.gd += m.gd;
										System.out.println("+ " + (m.gd) + " 원 획득");
										p.시련의조각 += m.시련의조각;
										System.out.println("시련의조각 + :" + p.시련의조각 + " 획득!");

										//레벨업
										if (p.ex >= p.exm) {
											p.lv += 1;
											p.ex -= 100;

											if ("토끼".equals(p.종족)) {
												p.hpm *= p.lv;
												p.at += 2;
												p.dp += 1;
											} else if ("거북".equals(p.종족)) {
												p.at += 1;
												p.dp += 2;
											} else if ("랜덤".equals(p.종족)) {
												p.at += 랜덤.nextInt(3);
												p.dp += 랜덤.nextInt(3);

											}
											TimeUnit.SECONDS.sleep(1);
											System.out.println(p.종족 + "의 레벨이 올랐습니다!!");
											레벨업.음악중지();
											레벨업 = new 사운드("레벨업.mp3", false);
											레벨업.start();
											if (p.lv >= 90) {
												System.out.println("네번쨰 퀘스트 조건을 충족하였습니다.");
											}

											p.hp = p.hpm;
											p.mp = p.mpm;
										}

										//시련의 조각 >> 돌로 변환
										if (p.시련의조각 >= 100) {
											p.시련의조각 -= 100;
											p.시련의돌 += 1;
											System.out.println("시련의 조각이 시련의 돌로 바뀌었습니다.");
										}

										//시련 퀘스트 아이템
										if (m.호잇 == 1) {
											System.out.println("보스를 잡으면 일정확률로 퀘스트아이템을 받습니다.");
											p.호잇 += 1;
											if (p.호잇 == 1 && p.고길동의부탁 == 1) {
												System.out.println("네번쨰 퀘스트 아이템을 획득하였습니다.");
												System.out.println("둘리를 더혼내주세요 !");

											}
											if (m.둘리의눈물 == 1){
												System.out.println("둘리의 눈물을 얻었습니다!!");
												System.out.println("마지막으로 한번더 둘리를 혼내주세요 !!");
												p.둘리의눈물 +=1;
											}

										}
										System.out.println("                                                    ↵   ");
										sc.nextLine();
										효과음.음악중지();
										효과음 = new 사운드("메인선택버튼.mp3", false);
										효과음.start();
										break;
									}

								}


							}
						}

						//다시입력
						else {
							System.out.println("다시입력해주세요 !");
							공백.입력();
							전투 = sc.nextInt();
							sc.nextLine();
						}
					}

					//마을귀환(0)
					else {
						System.out.println();
						System.out.println("마을로 돌아갑니다.");
						break;
					}
				}

				//메뉴창.시련선택
				else if (메인선택 == 2) {
					메뉴창.시련선택();
					공백.입력();
					시련선택 = sc.nextInt();
					sc.nextLine();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();

					//첫번쨰 시련 및 퀘스트(후회의돌)
					if (시련선택 == 1) {

						System.out.println("첫번째 시련에 온것을 환영한다.");
						System.out.println("자격이 있는" + p.종족 + "만이 시련을 극복할수 있다네..");
						System.out.println("어디보자 ..");
						System.out.println();
						System.out.println("                                           ↵   ");
						sc.nextLine();
						효과음.음악중지();
						효과음 = new 사운드("메인선택버튼.mp3",false);
						효과음.start();

						//이미 클리어시 끝
						if (p.후회의돌 > 0) {
							System.out.println("자네는 이미 시련을 통과했네..");
							System.out.println("다른 시련에 도전하게 !!");
							System.out.println();
							System.out.println("                            ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}


						//시련의돌 보유여부
						else if (p.시련의돌 < 1) {
							System.out.println("[시련의 돌] 이 부족하군!");
							System.out.println("[시련의 돌]을 1개이상 만들어야 도전이 가능하네");
							System.out.println("[시련의 돌]은 [시련의 조각]*100개를 모으면 하나를 완성할수있네");
							System.out.println("[시련의 조각] : " + p.시련의조각);
							System.out.println("[시련의 돌] : " + p.시련의돌);
							System.out.println();
							System.out.println("                                                          ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						//시련 레벨 미충족
						else if (p.lv < 10) {
							System.out.println("자네의 레벨이 낮군.. 자격을 갖추려면 10레벨까지 올려야하네");
							System.out.println("좀더 성장한 자네의 모습을 기다리겠네");
							System.out.println();
							System.out.println("                                                   ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}


						//자격 됨 (퀘스트부여)
						else {
							System.out.println("자네는 자격이 되는구만!! ");
							System.out.println("이 시험을 통과하면 자네는 [돌] 을 얻게 될걸세");
							System.out.println();
							System.out.println("                                           ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();

							p.시련진행1();

							//이미 퀘스트템을 가지고있는경우
							if (p.지금 >= 1) {
								p.후회의돌 += 1;

								p.시련보상1();
								TimeUnit.SECONDS.sleep(1);
								System.out.println("[후회의 돌을 얻었습니다.]");
								System.out.println();
								System.out.println("                        ↵   ");
								sc.nextLine();
								효과음.음악중지();
								효과음 = new 사운드("메인선택버튼.mp3",false);
								효과음.start();

								break;
							}
						}
					}

					//두번쨰 시련 (인내의돌)
					else if (시련선택 == 2) {
						if (p.후회의돌 == 0) {
							System.out.println("첫번쨰 시련을 클리어해주세요!");
							System.out.println();
							System.out.println("                             ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						System.out.println("두번째 시련에 온것을 환영하네");
						System.out.println("자격이 있는" + p.종족 + "만이 시련을 극복할수 있다네..");
						System.out.println("어디보자 ..");
						System.out.println();
						System.out.println("                                                ↵   ");
						sc.nextLine();
						효과음.음악중지();
						효과음 = new 사운드("메인선택버튼.mp3",false);
						효과음.start();

						//이미 클리어시 끝
						if (p.인내의돌 >= 1) {
							System.out.println("자네는 이미 시련을 통과했네..");
							System.out.println("다른 시련에 도전하게 !!");
							System.out.println();
							System.out.println("                            ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						//시련의돌 보유여부
						else if (p.시련의돌 < 2) {
							System.out.println("[시련의 돌]이 부족하군!");
							System.out.println("[시련의 돌] 을 [2]개이상 만들어야 도전이 가능하네");
							System.out.println("[시련의 돌]은 [시련의 조각] 100개를모으면 하나를 완성할수있네");
							System.out.println("[현재 시련의조각] : " + p.시련의조각);
							System.out.println("[현재 시련의돌] : " + p.시련의돌);
							System.out.println();
							System.out.println("                                                       ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						//시련 레벨 미충족
						else if (p.lv < 30) {
							System.out.println("자네의 레벨이 낮군.. 자격을 갖추려면 30레벨까지 올려야하네");
							System.out.println("좀더 성장한 자네의 모습을 기다리겠네");
							System.out.println();
							System.out.println("                                                  ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}
						//자격 됨 (퀘스트부여)
						else {
							System.out.println("자네는 자격이 되는구만!! ");
							System.out.println("이 시험을 통과하면 자네는 [돌] 을 얻게 될걸세");
							System.out.println();
							System.out.println("                                           ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();

							p.시련진행2();

							//이미 퀘스트템을 가지고있는경우
							if (p.열매 >= 1) {
								p.인내의돌 += 1;

								p.시련보상2();
								System.out.println("[인내의 돌을 얻었습니다.]");
								System.out.println();
								System.out.println("                         ↵   ");
								sc.nextLine();
								효과음.음악중지();
								효과음 = new 사운드("메인선택버튼.mp3",false);
								효과음.start();
								break;
							}
						}
					}

					//세번쨰 시련 (긍정의돌)
					else if (시련선택 == 3) {
						if (p.인내의돌 == 0) {
							System.out.println("두번쨰 시련을 클리어해주세요!");
							System.out.println();
							System.out.println("                             ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}
						System.out.println("세번째 시련에 온것을 환영하네");
						System.out.println("자격이 있는" + p.종족 + "만이 시련을 극복할수 있다네..");
						System.out.println("어디보자 ..");
						System.out.println();
						System.out.println("                                                  ↵   ");
						sc.nextLine();
						효과음.음악중지();
						효과음 = new 사운드("메인선택버튼.mp3",false);
						효과음.start();

						//이미 클리어시 끝
						if (p.긍정의돌 >= 1) {
							System.out.println("자네는 이미 시련을 통과했네..");
							System.out.println("다른 시련에 도전하게 !!");
							System.out.println();
							System.out.println("                              ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						//시련의돌 보유여부
						else if (p.시련의돌 < 3) {
							System.out.println("[시련의 돌]이 부족하군!");
							System.out.println("[시련의 돌]을 [3]개이상 만들어야 도전이 가능하네");
							System.out.println("[시련의 돌]은 [시련의 조각] * 100개를 모으면 하나를 완성할수있네");
							System.out.println("[시련의 조각] : " + p.시련의조각);
							System.out.println("[시련의 돌] : " + p.시련의돌);
							System.out.println();
							System.out.println("                                                         ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						//시련 레벨 미충족
						else if (p.lv < 60) {
							System.out.println("자네의 레벨이 낮군.. 자격을 갖추려면 60레벨까지 올려야하네");
							System.out.println("좀더 성장한 자네의 모습을 기다리겠네");
							System.out.println();
							System.out.println("                                                      ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}
						//자격 됨 (퀘스트부여)
						else {
							System.out.println("자네는 자격이 되는구만!! ");
							System.out.println("이 시험을 통과하면 자네는 [돌] 을 얻게 될걸세");
							System.out.println();
							System.out.println("                                            ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();

							p.시련진행3();

							//이미 퀘스트템을 가지고있는경우
							if (p.웃음꽃 >= 1) {
								p.긍정의돌 += 1;

								p.시련보상3(닉네임);
								System.out.println("[긍정의 돌을 얻었습니다.]");
								System.out.println();
								System.out.println("                                  ↵   ");
								sc.nextLine();
								효과음.음악중지();
								효과음 = new 사운드("메인선택버튼.mp3",false);
								효과음.start();
								break;
							}
						}
					}

					//마지막 시련 (배려의돌)
					else if (시련선택 == 4) {
						if (p.긍정의돌 <= 0) {
							System.out.println("세번쨰 시련을 클리어해주세요!");
							System.out.println();
							System.out.println("                             ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						System.out.println("마지막 시련에 온것을 환영하네");
						System.out.println("자격이 있는" + p.종족 + "만이 시련을 극복할수 있다네..");
						System.out.println("어디보자 ..");
						System.out.println();
						System.out.println("                                           ↵   ");
						sc.nextLine();
						효과음.음악중지();
						효과음 = new 사운드("메인선택버튼.mp3",false);
						효과음.start();

						//이미 클리어시 끝
						if (p.배려의돌 >= 1) {
							System.out.println("마지막으로 내부탁을 들어주게.. ");
							System.out.println();
							System.out.println("                                 ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							System.out.println("(5번째 시련을 진행해주세요 !!)");
							System.out.println();
							System.out.println("                                 ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						//시련의돌 보유여부
						else if (p.시련의돌 < 4) {
							System.out.println("[시련의 돌]이 부족하군!");
							System.out.println("[시련의 돌]을 [4]개이상 만들어야 도전이 가능하네");
							System.out.println("[시련의 돌]은 [시련의조각] * 100개를 모으면 하나를 완성할수있네");
							System.out.println("[시련의 조각] : " + p.시련의조각);
							System.out.println("[시련의 돌] : " + p.시련의돌);
							System.out.println();
							System.out.println("                                               ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}

						//시련 레벨 미충족
						else if (p.lv < 90) {
							System.out.println("자네의 레벨이 낮군.. 자격을 갖추려면 90레벨까지 올려야하네");
							System.out.println("좀더 성장한 자네의 모습을 기다리겠네");
							System.out.println();
							System.out.println("                                                   ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							break;
						}
						//자격 됨 (퀘스트부여)
						else {
							System.out.println("자네는 자격이 되는구만!! ");
							System.out.println("이 시험을 통과하면 마지막 [돌] 을 얻게 될걸세");
							System.out.println();
							System.out.println("                                            ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();

							p.시련진행4();

							//이미 퀘스트템을 가지고있는경우
							if (p.호잇 >= 1) {
								p.배려의돌 += 1;

								p.시련보상4();
								System.out.println("[배려의 돌을 얻었습니다.]");
								System.out.println("마지막 퀘스트 길동의부탁을 들어주세요 !!");
								System.out.println();
								System.out.println("                                  ↵   ");
								p.고길동의부탁 = 1;
								sc.nextLine();
								효과음.음악중지();
								효과음 = new 사운드("메인선택버튼.mp3",false);
								효과음.start();


								break;
							}
						}
					}

					//둘리의 갱생
					else if (시련선택 == 5) {

						System.out.println("내 소원을 들어주었는가 .. ..!!!? ");
						System.out.println("(길동의 실망한 기색이 역력하다)");
						System.out.println("검성고길동 : ....");
						System.out.println("                                 ↵   ");
						sc.nextLine();
						효과음.음악중지();
						효과음 = new 사운드("메인선택버튼.mp3",false);
						효과음.start();

						if (p.배려의돌 == 0) {
							System.out.println("아직 시련에 도전 할 수 없습니다.");
							System.out.println("길동의소원을 들어주세요 !");
							System.out.println();
							System.out.println("검성고길동 : ...");
							System.out.println("                                ↵   ");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
						}


						//게임 클리어
						else if (p.둘리의눈물 >= 1 && p.배려의돌 >= 1 && p.고길동의소원 >=1) {
							System.out.println("아니 !!!!!!!!!!!! 이것은 둘리의 눈물 !!?");
							sc.nextLine();
							효과음.음악중지();
							효과음 = new 사운드("메인선택버튼.mp3",false);
							효과음.start();
							System.out.println("검성 고길동 : 천하의 둘리가 눈물을 흘리다니..  ");
							TimeUnit.SECONDS.sleep(1);
							System.out.println("둘리를 갱생시켜줘서 고맙네 !");
							TimeUnit.SECONDS.sleep(1);
							System.out.println("세상 모든사람들이 자네처럼 배려를 한다면 좀더 따뜻한 세상이 될걸세");
							TimeUnit.SECONDS.sleep(1);
							System.out.println("작은 움직임이 결국 큰움직임을 만들지");
							TimeUnit.SECONDS.sleep(2);
							System.out.println("고맙네 ! " + 닉네임 + "!!");
							System.out.println("                                                    ↵   ");
							sc.nextLine();
							레벨업.음악중지();
							레벨업 = new 사운드("레벨업.mp3",false);
							레벨업.start();

							TimeUnit.SECONDS.sleep(3);
							System.exit(0);
						}


					} else {
						System.out.println("마을로 돌아갑니다.");
						break;
					}
				}


				//메뉴창.상점선택
				else if (메인선택 == 3) {

					//상점종류 선택
					메뉴창.상점창();
					공백.입력();
					상점선택 = sc.nextInt();
					sc.nextLine();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();


					//공복도 식당(상점_
					if (상점선택 == 1) {

						메뉴창.음식점();
						음식점 = sc.nextInt();
						sc.nextLine();
						효과음 = new 사운드("메인선택버튼.mp3", false);
						효과음.start();

						//hp + 공복도 30
						if (음식점 == 1) {
							System.out.println("식사를 시작합니다.");
							쩝쩝.start();
							TimeUnit.SECONDS.sleep(1);
							System.out.println("짭짭짭...");
							System.out.println("쩝쩝...");
							System.out.println("                                                    ↵   ");
							sc.nextLine();
							쩝쩝.음악중지();
							System.out.println("꺼~~~~~억!");
							p.en += 30;
							p.hp += 30;
							if (p.en >= p.enm) {
								p.en = p.enm;
							}
							if (p.hp >= p.hpm) {
								p.hp = p.hpm;
							}
							System.out.println();
							System.out.println();
							System.out.println();
							break;
						}
						//hp + 공복도 60
						else if (음식점 == 2) {
							System.out.println("식사를 시작합니다.");
							쩝쩝 = new 사운드("쩝쩝.mp3", false);
							쩝쩝.start();
							TimeUnit.SECONDS.sleep(1);
							System.out.println("짭짭짭...");
							System.out.println("쩝쩝...");
							System.out.println("                                                    ↵   ");
							sc.nextLine();
							쩝쩝.음악중지();
							System.out.println("꺼~~~~~억!");
							p.en += 60;
							p.hp += 60;
							if (p.en >= p.enm) {
								p.en = p.enm;
							}
							if (p.hp >= p.hpm) {
								p.hp = p.hpm;
							}
							System.out.println();
							System.out.println();
							System.out.println();

							break;
						}
						//hp + 공복도 100
						else if (음식점 == 3) {
							System.out.println("식사를 시작합니다.");
							쩝쩝 = new 사운드("쩝쩝.mp3", false);
							쩝쩝.start();
							TimeUnit.SECONDS.sleep(1);
							System.out.println("짭짭짭...");
							System.out.println("쩝쩝...");
							System.out.println("                                                    ↵   ");
							sc.nextLine();
							쩝쩝.음악중지();
							TimeUnit.SECONDS.sleep(1);
							System.out.println("꺼~~~~~억!");
							p.en += 100;
							p.hp += 100;
							if (p.en >= p.enm) {
								p.en = p.enm;
							}
							if (p.hp >= p.hpm) {
								p.hp = p.hpm;
							}
							System.out.println();
							System.out.println();
							System.out.println();

							break;

						} else {
							System.out.println("마을로 돌아갑니다.");
							break;
						}
					} else if (상점선택 == 2) {
						메뉴창.장비상();
						int 무기상;
						int 구매의사;
						무기상 = sc.nextInt();
						sc.nextLine();
						효과음 = new 사운드("메인선택버튼.mp3", false);
						효과음.start();


						if (무기상 == 1) {
							System.out.println("[강철이빨]을(를) 구매하시겠습니까?");
							System.out.println("[10000] GD");
							System.out.println("[공격력] + 5 ");
							System.out.println("[최대행동력] + 10 ");
							System.out.println();
							System.out.println("1.구입     0. 돌아간다");
							공백.공백s();

							System.out.print("입력 : ");
							구매의사 = sc.nextInt();
							sc.nextLine();
							효과음 = new 사운드("메인선택버튼.mp3", false);
							효과음.start();
							if (구매의사 == 1) {
								if (p.gd >= 10000) {
									System.out.println("[강철 이빨] 을(를) 구매하셨습니다.");
									System.out.println("인벤토리를 확인해주세요!!");
									p.gd -= 10000;
									if (p.인벤토리1.equals("없음")) {
										p.인벤토리1 = "강철이빨";
									} else if (p.인벤토리2.equals("없음")) {
										p.인벤토리2 = "강철이빨";
									} else if (p.인벤토리3.equals("없음")) {
										p.인벤토리3 = "강철이빨";
									} else if (p.인벤토리4.equals("없음")) {
										p.인벤토리4 = "강철이빨";
									}
									break;
								} else {
									System.out.println("골드가 부족합니다.");
									System.out.println("현재 보유골드 : [" + p.gd + "] Gd");
									break;
								}
							} else {
								System.out.println("마을로 돌아갑니다.");
								break;
							}
						} else if (무기상 == 2) {
							System.out.println("[아다만티움 발톱]을(를) 구매하시겠습니까?");
							System.out.println("[20000] GD");
							System.out.println("[공격력] + 10 ");
							System.out.println("[최대행동력] + 30 ");
							System.out.println();
							System.out.println("1.구입     0. 돌아간다");
							공백.공백s();

							System.out.print("입력 : ");
							구매의사 = sc.nextInt();
							sc.nextLine();
							효과음 = new 사운드("메인선택버튼.mp3", false);
							효과음.start();
							if (구매의사 == 1) {
								if (p.gd >= 20000) {
									System.out.println("[아다만티움 발톱] 을 구매하셨습니다.");
									돈.start();
									System.out.println("인벤토리를 확인해주세요!!");
									p.gd -= 20000;
									if (p.인벤토리1.equals("없음")) {
										p.인벤토리1 = "아다만티움발톱";
									} else if (p.인벤토리2.equals("없음")) {
										p.인벤토리2 = "아다만티움발톱";
									} else if (p.인벤토리3.equals("없음")) {
										p.인벤토리3 = "아다만티움발톱";
									} else if (p.인벤토리4.equals("없음")) {
										p.인벤토리4 = "아다만티움발톱";
									}
									break;
								} else {
									System.out.println("골드가 부족합니다.");
									System.out.println("현재 보유골드 : [" + p.gd + "] Gd");
									break;
								}
							} else {
								System.out.println("마을로 돌아갑니다.");
								break;
							}
						} else if (무기상 == 3) {
							System.out.println("아직 준비중입니다!");
							System.out.println("마을로 돌아간다.");
							break;
						} else {
							System.out.println("마을로 돌아간다.");
							break;

						}


					}


				}


				//인벤토리
				else if (메인선택 == 4) {

					공백.공백s();
					System.out.println("    [ 나의 인벤토리 ]");
					System.out.println("    1. " + p.인벤토리1);
					System.out.println("    2. " + p.인벤토리2);
					System.out.println("    3. " + p.인벤토리3);
					System.out.println("    4. " + p.인벤토리4);
					System.out.println("    0. 돌아간다");
					공백.공백s();

					int 인벤선택;
					int 장비착탈;
					인벤선택 = sc.nextInt();
					sc.nextLine();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();


					//인벤1
					if (인벤선택 == 1) {

						//인벤토리 확인
						if (p.인벤토리1.equals("없음")) {
							System.out.println("가지고있는 아이템이 없습니다.");
							break;
						} else {
							System.out.println("1.착용한다.   2.탈착한다.    3.판다.     0.돌아간다");
							System.out.print("입력 : ");
							장비착탈 = sc.nextInt();
							sc.nextLine();
							효과음 = new 사운드("메인선택버튼.mp3", false);
							효과음.start();


							//장비착용
							if (장비착탈 == 1) {
								if (p.악세사리.equals("강철이빨")) {
									System.out.println("이미 착용한 장비입니다!!");
									break;
								}
								if (p.인벤토리1.equals("강철이빨")) {
									p.악세사리 = p.인벤토리1;
									p.at += 5;
									p.mpm += 10;
									System.out.println("강철이빨을 장착하였습니다.");
									p.인벤토리1 = "강철이빨(장착중)";
									공백.공백s();
								} else {
									System.out.println("장비를 확인해주세요!!");
								}
							}
							//장비해제
							else if (장비착탈 == 2) {
								System.out.println("해당 장비를 탈착합니다.");
								if (p.악세사리.equals("강철이빨") && p.인벤토리1.equals("강철이빨(장착중)")) {
									p.악세사리 = "없음";
									p.인벤토리1 = "강철이빨";
									p.at -= 5;
									p.mpm -= 10;
									System.out.println("[강철이빨]을 해제 하였습니다.");
									System.out.println("인벤1로 강철이빨을 보관합니다.");
									공백.공백s();


								}
							} else if (장비착탈 == 3) {

								if (p.악세사리 == "강철이빨" && p.인벤토리1 == "강철이빨(장착중)") {
									공백.공백s();
									System.out.println("     [경고]      장착을먼저 해제해주세요!!!!!!  ");
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									공백.공백s();
									break;
								} else if (p.인벤토리1 == "강철이빨") {
									System.out.println("해당 장비를판매합니다.");
									System.out.println("[경고] 판매금액은 원래가격의 반으로 판매됩니다.");
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									System.out.println();
									p.인벤토리1 = "없음";
									p.gd += 5000;
									System.out.println("성공적으로 판매했습니다.");
									System.out.println("판매금액 : 5000 Gd ");
									돈 = new 사운드("돈.mp3", false);
									돈.start();
									break;
								} else {
									System.out.println("인벤토리로 돌아갑니다.");

								}
								공백.공백s();
							}

						}

					}
					if (인벤선택 == 2) {

						//인벤토리 확인
						if (p.인벤토리2 == "없음") {
							System.out.println("가지고있는 아이템이 없습니다.");
							break;
						} else {
							System.out.println("1.착용한다.   2.탈착한다.    3.판다.     0.돌아간다");
							System.out.print("입력 : ");
							장비착탈 = sc.nextInt();
							sc.nextLine();
							효과음 = new 사운드("메인선택버튼.mp3", false);
							효과음.start();


							//장비착용
							if (장비착탈 == 1) {
								if (p.악세사리 == "강철이빨" || p.악세사리 == "아다만티움발톱") {
									System.out.println("이미 착용한 장비입니다!!");
									break;
								}
								if (p.인벤토리1 == "강철이빨" && p.인벤토리2 == "아다만티움발톱") {
									p.악세사리 = p.인벤토리2;
									p.at += 5;
									p.mpm += 10;
									System.out.println("강철이빨을 장착하였습니다.");
									p.인벤토리2 = "강철이빨(장착중)";
									공백.공백s();
								} else {
									System.out.println("장비를 확인해주세요!!");
								}
							}
							//장비해제
							else if (장비착탈 == 2) {
								System.out.println("해당 장비를 탈착합니다.");
								if (p.악세사리 == "강철이빨" && p.인벤토리2 == "강철이빨(장착중)") {
									p.악세사리 = "없음";
									p.인벤토리2 = "강철이빨";
									p.at -= 5;
									p.mpm -= 10;
									System.out.println("[강철이빨]을 해제 하였습니다.");
									System.out.println("인벤2로 강철이빨을 보관합니다.");
									공백.공백s();


								}
							} else if (장비착탈 == 3) {

								if (p.악세사리 == "강철이빨" && p.인벤토리2 == "강철이빨(장착중)") {
									공백.공백s();
									System.out.println("     [경고]      장착을먼저 해제해주세요!!!!!!  ");
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									공백.공백s();
									break;
								} else if (p.인벤토리2 == "강철이빨") {
									System.out.println("해당 장비를판매합니다.");
									System.out.println("[경고] 판매금액은 원래가격의 반으로 판매됩니다.");
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									System.out.println();
									p.인벤토리2 = "없음";
									p.gd += 5000;
									System.out.println("성공적으로 판매했습니다.");
									돈 = new 사운드("돈.mp3", false);
									돈.start();
									System.out.println("판매금액 : 5000 Gd ");
									break;
								} else {
									System.out.println("인벤토리로 돌아갑니다.");

								}
								공백.공백s();
							}

						}

					}
					if (인벤선택 == 3) {

						//인벤토리 확인
						if (p.인벤토리3 == "없음") {
							System.out.println("가지고있는 아이템이 없습니다.");
							break;
						} else {
							System.out.println("1착용한다.   2.탈착한다.    3.판다.     0.돌아간다");
							System.out.print("입력 : ");
							장비착탈 = sc.nextInt();
							sc.nextLine();
							효과음 = new 사운드("메인선택버튼.mp3", false);
							효과음.start();


							//장비착용
							if (장비착탈 == 1) {
								if (p.악세사리 == "강철이빨") {
									System.out.println("이미 착용한 장비입니다!!");
									break;
								}
								if (p.인벤토리3 == "강철이빨") {
									p.악세사리 = p.인벤토리3;
									p.at += 5;
									p.mpm += 10;
									System.out.println("강철이빨을 장착하였습니다.");
									p.인벤토리3 = "강철이빨(장착중)";
									공백.공백s();
								} else {
									System.out.println("장비를 확인해주세요!!");
								}
							}
							//장비해제
							else if (장비착탈 == 2) {
								System.out.println("해당 장비를 탈착합니다.");
								if (p.악세사리 == "강철이빨" && p.인벤토리3 == "강철이빨(장착중)") {
									p.악세사리 = "없음";
									p.인벤토리3 = "강철이빨";
									p.at -= 5;
									p.mpm -= 10;
									System.out.println("[강철이빨]을 해제 하였습니다.");
									System.out.println("인벤1로 강철이빨을 보관합니다.");
									공백.공백s();


								}
							} else if (장비착탈 == 3) {

								if (p.악세사리 == "강철이빨" && p.인벤토리3 == "강철이빨(장착중)") {
									공백.공백s();
									System.out.println("     [경고]      장착을먼저 해제해주세요!!!!!!  ");
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									공백.공백s();
									break;
								} else if (p.인벤토리3 == "강철이빨") {
									System.out.println("해당 장비를판매합니다.");
									System.out.println("[경고] 판매금액은 원래가격의 반으로 판매됩니다.");
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									System.out.println();
									p.인벤토리3 = "없음";
									p.gd += 5000;
									System.out.println("성공적으로 판매했습니다.");
									돈 = new 사운드("돈.mp3", false);
									돈.start();
									System.out.println("판매금액 : 5000 Gd ");
									break;
								} else {
									System.out.println("인벤토리로 돌아갑니다.");

								}
								공백.공백s();
							}

						}

					}
					if (인벤선택 == 4) {

						//인벤토리 확인
						if (p.인벤토리4 == "없음") {
							System.out.println("가지고있는 아이템이 없습니다.");
							break;
						} else {
							System.out.println("1착용한다.   2.탈착한다.    3.판다.     0.돌아간다");
							System.out.print("입력 : ");
							장비착탈 = sc.nextInt();
							sc.nextLine();
							효과음 = new 사운드("메인선택버튼.mp3", false);
							효과음.start();


							//장비착용
							if (장비착탈 == 1) {
								if (p.악세사리 == "강철이빨") {
									System.out.println("이미 착용한 장비입니다!!");
									break;
								}
								if (p.인벤토리4 == "강철이빨") {
									p.악세사리 = p.인벤토리4;
									p.at += 5;
									p.mpm += 10;
									System.out.println("강철이빨을 장착하였습니다.");
									p.인벤토리4 = "강철이빨(장착중)";
									공백.공백s();
								} else {
									System.out.println("장비를 확인해주세요!!");
								}
							}
							//장비해제
							else if (장비착탈 == 2) {
								System.out.println("해당 장비를 탈착합니다.");
								if (p.악세사리 == "강철이빨" && p.인벤토리4 == "강철이빨(장착중)") {
									p.악세사리 = "없음";
									p.인벤토리4 = "강철이빨";
									p.at -= 5;
									p.mpm -= 10;
									System.out.println("[강철이빨]을 해제 하였습니다.");
									System.out.println("인벤1로 강철이빨을 보관합니다.");
									공백.공백s();


								}
							} else if (장비착탈 == 3) {

								if (p.악세사리 == "강철이빨" && p.인벤토리4 == "강철이빨(장착중)") {
									공백.공백s();
									System.out.println("     [경고]      장착을먼저 해제해주세요!!!!!!  ");
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									공백.공백s();
									break;
								} else if (p.인벤토리4 == "강철이빨") {
									System.out.println("해당 장비를판매합니다.");
									System.out.println("[경고] 판매금액은 원래가격의 반으로 판매됩니다.");
									경고 = new 사운드("5. 삐.mp3", false);
									경고.start();
									System.out.println();
									p.인벤토리4 = "없음";
									p.gd += 5000;
									System.out.println("성공적으로 판매했습니다.");
									돈 = new 사운드("돈.mp3", false);
									돈.start();
									System.out.println("판매금액 : 5000 Gd ");
									break;
								} else {
									System.out.println("인벤토리로 돌아갑니다.");

								}
								공백.공백s();
							}

						}

					} else {
						System.out.println("마을로 돌아갑니다.");
						break;
					}


					//메뉴 4의 웨일문


				}// 전체 진행 마지막 끝


				//음악 on off
				else if (메인선택 == 5) {
					메인3.음악중지();
					System.out.println("메인 Bgm을 끕니다.");
					메인선택 = sc.nextInt();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();
				}

				else if (메인선택 == 6) {
					메인3.음악중지();
					메인3 = new 사운드("메인3.mp3", true);
					메인3.start();
					System.out.println("메인 Bgm을 켭니다.");
					메인선택 = sc.nextInt();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();
				}

				else if (메인선택 == 7){
					공백.공백s();
					스토리.줄거리();
					메뉴창.메인창();
					공백.입력();
					메인선택 = sc.nextInt();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();
				}
				else if (메인선택 == 9 ){
					p = new 토끼();
					p.종족 = "토끼";
					p.lv = 90;
					p.hp = 10000;
					p.hpm = 100 * p.lv;
					p.mp = 100;
					p.mpm = 100;
					p.mpx = 1;
					p.en = 100;
					p.enm = 150;
					p.at = 10;
					p.dp = 8;
					p.ex = 0;
					p.exm = 100;
					p.gd = 1000000000;
					p.악세사리 = "없음";

					p.시련의돌 = 1;
					p.지금 = 1;
					p.열매 = 1;
					p.웃음꽃 = 1;
					p.호잇 = 1;
					p.고길동의부탁 = 1;
					메인선택 = sc.nextInt();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();
				}


				//게임종료
				else if (메인선택 == 0) {
					System.out.println("게임을 종료합니다.");
					System.exit(0);
				} else {
					System.out.println("다시 입력해주세요 !");
					메인선택 = sc.nextInt();
					sc.nextLine();
					효과음 = new 사운드("메인선택버튼.mp3", false);
					효과음.start();
				}
			}
		}
	}
}