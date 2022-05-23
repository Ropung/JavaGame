package 케릭터;

import thread.사운드;

import java.util.Random;
import java.util.Scanner;


public class 주인공 extends 생물 {


	Random 랜덤 = new Random();
	Scanner sc = new Scanner(System.in);


	//주인공 회복매서드
	public void 체력회복(int 회복값){
		this.hp += 회복값;
		this.hp = Math.min(hp,hpm);
		this.mp += 회복값;
		this.mp = Math.min(mp,mpm);
		this.en = Math.min(en,enm);
	}


	//주인공 독매서드
	public void 디버프(String name){
		System.out.println("몬스터에 디버프에 걸렸습니다.");
		if(name == "독") {
			hp -= 3;
			System.out.println("3초마다 -3의 피가 감소합니다.");
			System.out.println("현재 체력 : "+this.hp );
		}
		else if(name == "화상") {
			hp -= 5;
			System.out.println("3초마다 -5의 피가 감소합니다.");
			System.out.println("현재 체력 : "+this.hp );
		}



	}



    //주인공의 공복도
	public int  en,enm;
	public int 구역1 = 1;
	public int 구역2 = 1;
	public int 구역3 = 1;
	public int 구역4 = 1;



	public String 인벤토리1 ="없음";
	public String 인벤토리2 ="없음";
	public String 인벤토리3 ="없음";
	public String 인벤토리4 ="없음";


	//시련템
	public int 후회의돌,인내의돌,긍정의돌,배려의돌,시련의돌 ;



	//게임진행에 필요한템


	public int 경험치부적 = 1;

	//--------------------------------------------------------------------------

	//주인공의 상태창 확인
	public void 상태(String 닉네임) {
		System.out.println("     ⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐⥐");
		System.out.println();
		System.out.println("     [닉네임] : " + 닉네임);
		System.out.println("     [종 족]" + this.종족);
		System.out.println("     [레 벨]" + this.lv);
		System.out.println("     [체 력]" + this.hp + "/" + this.hpm);
		System.out.println("     [행동력]" + this.mp + "/" + this.mpm);
		System.out.println();
		System.out.println("     공격력 :" + this.at);
		System.out.println("     방어력 :" + this.dp);
		System.out.println();
		System.out.println("     [경험치] " + this.ex + "/" + this.exm);
		System.out.println("     [ 돈 ]  " + this.gd + "원");
		System.out.println("     [악세사리] " + this.악세사리);
		System.out.println();
		System.out.println("     [시련의조각] " + this.시련의조각 + "개");
		System.out.println("     [시련의 돌] " + this.시련의돌 + "개 ");
		System.out.println("     [시련아이템] "+this.지금+"/"+this.열매+"/"+this.웃음꽃+"/"+this.호잇+"/"+this.고길동의부탁);
		System.out.println("     [진행아이템] "+this.후회의돌+"/"+this.인내의돌 +"/"+this.긍정의돌 +"/"+this.배려의돌 +"/"+this.고길동의소원);
		System.out.println("");
		System.out.println("     [공복도] " + this.en+"/"+this.enm);
		System.out.println("");
		System.out.println("     ⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎⥎");
		System.out.println();
	}


	//첫번째 시련 [후회의돌] (퀘스트내용)
	public void 시련진행1() {
		System.out.println("[첫번째 시련에 도전합니다..]");
		System.out.println();
		System.out.println("인생에는 3가지후회가 있지");
		System.out.println("참을(걸) , 즐길(걸) , 베풀(걸)");
		System.out.println("자네가 토끼라면 잠을 참지못해 후회가 남을것이고");
		System.out.println("거북이라면 베풀지못한 후회가 있듯");
		System.out.println("사람마다 누구나 후회를 하며 살아간다네");
		System.out.println("하지만 지난날을 후회한다고 결과는 바뀌지않아");
		System.out.println("앞으로도 살면서 후회를 하게될걸세..");
		System.out.println("중요한건 앞으로 지나간 시간에 후회하지않는것!");
		System.out.println("[지금]에 충실하며 살아가는게 중요한거야");
		System.out.println("");
		System.out.println("");
		System.out.println("전설에 따르면 달팽이숲에 서식중인 몬스터에게 [지금]을 얻을수있다고하네");
		System.out.println("달팽이 숲에있는 [boss]암모나이트를 찾아서 [지금]을 얻어오면 후회의 돌을주겠네 !!");

	}

	public void 시련보상1(){
		System.out.println("오호.. 벌써 보스와 마주해서 얻어냈구만.. 끌끌끌");
		System.out.println("조건을 달성했으니 이 [돌]을 주겠네..");
		System.out.println();
		System.out.println("자네가 이 지금을 구하는 과정에 좀더 효율적인 방법을 쓰지못한것을 후회하고 아쉬워할수있어");
		System.out.println("혹은 자네가 모르는사이에 이미 필요한것을 얻었을수도있네 !");
		System.out.println("자네가 이것을 가져오는 과정들의 순간 순간들이 바로 지금이였네");
		System.out.println("이미 자네는 항상 지금을 가지고있었던거야 !");
		System.out.println("이 순간순간의 지금으로 자네가 있는것이 아닐까 생각하네 하하하..");
		System.out.println("자네 내면은 분명 알게모르게 좀더 성숙해졌을 걸세");
		System.out.println("다음시련에서 좀더 성장한 모습으로 보세나!!");

	}


	//두번째 시련 [인내의돌] (퀘스트내용)
	public void 시련진행2() {
		System.out.println("[두번째 시련에 도전합니다..]");
		System.out.println();
		System.out.println("우리가 살다보면 많은 일들을 그르치는 상황이오네");
		System.out.println("대부분 조바심을 부려서 생긴일이 대부분이지..");
		System.out.println("조금만 기다렸다면 원하는것을 얻었을지도모르지");
		System.out.println("스스로 얻고싶은 욕망을 이기못한다면 얻지못할걸세 ");
		System.out.println("항상 자신을 돌아볼수있어야 비로소 성장했다고 말할수있을걸세");
		System.out.println("");
		System.out.println("");
		System.out.println("유튜브에 따르면 알수없는 알고리즘에의해 메뚜기마을에 유재석에게 [열매]을(를) 얻을수있다고하네");
		System.out.println("메뚜기 숲에있는 [boss]를 찾아서 [열매]을 얻어오면 인내의돌 을주겠네 !!");

	}

	public void 시련보상2(){
		System.out.println("오호 그것이 바로 달다는 [열매]인가 ??");
		System.out.println("조건을 달성했으니 이 [돌]을 주겠네..");
		System.out.println();
		System.out.println("우리 사는 인생은 항상 조바심만 가지고 선택을하기나름이지");
		System.out.println("그 선택이 피눈물을 흘리는 경우도있고 그떄마다 우리는 많은것들을 깨닫게되네");
		System.out.println("나 또한 굳이 하지않았어도 될 선택을 하면서 그 시간들은 지금의 나를 만들어줬지");
		System.out.println("자네가 달려온 노력이라는 인내는 조금 쓰겠지만 그 결과는 달달할것이네");
		System.out.println("아직까지 쓰다는건 아직 열매가 익지않아서 일지도 모르지");
		System.out.println("그러니 그열매가 잘익을떄까지 인내를 멈추지 않길 바라겠네 !!");
		System.out.println("다음시련에서 좀더 성장한 모습으로 보세나!!");
	}


	//세번째 시련 [긍정의돌] (퀘스트내용)

	public void 시련진행3() {
		System.out.println("[세번째 시련에 도전합니다..]");
		System.out.println();
		System.out.println("삶에는 빛과 어둠이있지 ...");
		System.out.println("우리는 우리를 기쁘게 하는것을 골라야하네 ");
		System.out.println("긍정적으로 된다는것은,자신의 삶이 장밋빛이거나,풍요로운게 아닐세");
		System.out.println("긍정적인 사람이 부정정인 면을 전혀 모르는 것도 아닐세");
		System.out.println("");
		System.out.println("버섯산에 스폰지밥이 여행을왔다고하네");
		System.out.println("버섯산에 있는 [boss]를 찾아서 [웃음꽃]을(를) 얻어오면 긍정의돌을 주겠네 !!");

	}

	public void 시련보상3(String 닉네임){
		System.out.println("오호.. 스펀지밥을 상대하고왔군..");
		System.out.println("조건을 달성했으니 이 [돌]을 주겠네..");
		System.out.println();
		System.out.println("스폰지밥을 봤을때 진정 그의 삶은 장밋빛이거나 풍요로웠던가?");
		System.out.println(닉네임 + ": 전혀 달랐다...");
		System.out.println("맞는말일세.. 하지만 그는 항상 웃음을 머금고 긍정적인 삶을살았지");
		System.out.println("앞서말했던 오히려 긍정적인 사람이 부정적인 면을 더잘알고있네");
		System.out.println("하지만 그런 사람들은 부정과 긍정의 사이에서 긍정을 선택했을뿐이지! ");
		System.out.println("자네가 바로 긍정맨이 되길 바라는게아닌 긍정안을 가졌으면 좋겠네");
		System.out.println("분명 그눈은 자네가 좀더 현명하게 살수있도록 도와줄걸세");
	}


	//마지막 시련 [배려의돌] (퀘스트내용)

	public void 시련진행4() {
		System.out.println("[마지막 시련에 도전합니다..]");
		System.out.println();
		System.out.println("우리는 사회라는 울타리에서 살고있네");
		System.out.println("넓은 의미론 우리가 사는 세계가 바로 사회라고 볼수있네");
		System.out.println("다양한 생명체가 공존하기 위해선 배려가 필요하지");
		System.out.println("좁게보면 나와 자네 즉 우리의 관계를 전제로 한다네");
		System.out.println("내가 자네를 도와주는 것처럼 우리는 보이지 않는 끈으로 연결되어 있네");
		System.out.println("나보단 다른사람을 생각하는 마음은 몇번을 강조해도 부족함이 없어..");
		System.out.println();
		System.out.println("저기 풀벌레나라 에 있는 [boss]둘리 (을)를 찾아서 [호의]을(를) 얻어오면 마지막 돌을 주겠네 !!");
		System.out.println("정신못차리는 둘리를 5번 혼내주고오게 !");
	}

	public void 시련보상4(){
		System.out.println("검성 고길동 : 드디어 그 버릇없는 자식을 혼내줬구만!!!");
		System.out.println("검성 고길동 : 끌끌끌.. 이제좀 정신을 차렸으면 좋으련만...");
		System.out.println("검성 고길동 : 조건을 달성했으니 이 [돌]을 주겠네..");
		System.out.println();
		System.out.println("맨 처음 둘리는 정말 마음이 순수한 아이였지");
		System.out.println("둘리는 누구보다 배려심 많은 긍정적인 아이였어");
		System.out.println("하지만 부모를 잃고 마음이 삐뚤어지기 시작했네");
		System.out.println("다행이 우리 희동이는 물드려는걸 내가 막았지만 둘리는 그러지못했어..");
		System.out.println("오히려 나는 둘리를 배려하지 못했고 나의 가족만 챙겼지..");
		System.out.println("둘리도 나의 가족이였는데 말이야 ..");
		System.out.println("나와 자네의 보이지않는 끈이 생긴것처럼 이번엔 자네가 둘리에게 보이지않은 끈을 연결해주시켜줄 차례일세");
		System.out.println("내 마지막 부탁일세.. 부디 들어주게나 ..");
		System.out.println("[둘리를 갱생시켜주세요 !]");
	}


	//전투시 주인공의 상태(간략)
	public void 전투상태() {
		System.out.println("          [나의 현재 상태]  ");
		System.out.println();
		System.out.println("          Lv . " + this.lv);
		System.out.println("          체력 : " + this.hp + "/" + this.hpm);
		System.out.println("          공격력 : " + this.at);
		System.out.println("          방어력 : " + this.dp);
		System.out.println("          경험치 : " + this.ex + "/" + this.exm);
		System.out.println("          돈  : " + this.gd + " 원 ");
		System.out.println("");

	}


	//주인공의 공격


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
				System.out.println("토끼의 몸통박치기!!");
				return at;
			}

			//앞니찍기 함수 (레벨비례)
			else if (스킬 == 2) {
				sum += super.lv * 2;
				sum += super.at * 2;
				mp -= 20;
				System.out.println("길다란 앞니로 찍어 공격합니다.");
				System.out.println("앞니찍기!!");
				return sum;
			}

			//뒷발차기 함수 (공격력비례)
			else if (스킬 == 3) {

				sum += at * 3;
				mp -= 40;
				System.out.println("회심의 뒷발차기를 사용합니다!.");
				System.out.println("뒷발차기!!");
				return sum;
			}
			else if (스킬 == 4) {
				sum += at * 1523415;
				System.out.println("개발자의 코드공격!!");
				System.out.println("[효과는 굉장했다]");
				System.out.println("");
				return sum;

			}
			System.out.println("");
			return sum;
		}
		else {
			System.out.println("주인공이 사망하여 공격할수없습니다.");
			return sum;
		}
	}


	//주인공의 피격
	public void 피격(int sum) {
		if (dp >= sum) {
			hp = hp - 0;
			System.out.println("");
			System.out.println("[방어력이 높아 데미지를 받지 않았습니다.] ");
			사운드 방어 =new 사운드("방어.mp3",false);
			방어.start();
			System.out.println();
			System.out.println(this.종족 + "의 [  Hp ] : " + this.hp);
		} else {
			hp = hp + dp - sum;
			System.out.println();
			System.out.println("[적]에게 " + (dp - sum) + "의 데미지를 받았습니다.");
			if (hp <= 0) {
				return;
			}
			System.out.println(this.종족 + "의 남은 [ Hp ] : " + this.hp);
			System.out.println();

		}

	} //피격시
}


