package System;

import java.util.Calendar;

public class 날짜 {


	public static void 날짜말하기() {
		Calendar 현재 = Calendar.getInstance();
		int 년 = 현재.get(Calendar.YEAR); //Calendar 인스턴스에 있는 저장된 필드 값을 가져옴
		int 월 = 현재.get(Calendar.MONTH);
		int 일 = 현재.get(Calendar.DATE);
		int 요일 = 현재.get(Calendar.DAY_OF_WEEK);
		int 마지막일 = 현재.getActualMaximum(Calendar.DATE); //해당 월의 마지막 일(date)를 반환

		System.out.println();
		System.out.print("현재 날짜는  :  " + 년 + "년  " + (월 + 1) + "월  " + 일 + "일  ");
		if (요일 == 1) {  // 일요일은 1, 월요일 2......토요일 7
			System.out.println("일요일 입니다.");
		}
		else if(요일 == 2){
			System.out.println("월요일 입니다.");
		}
		else if(요일 == 3){
			System.out.println("화요일 입니다.");
		}
		else if(요일 == 4){
			System.out.println("수요일 입니다.");
		}
		else if(요일 == 5){
			System.out.println("목요일 입니다.");
		}
		else if(요일 == 6){
			System.out.println("금요일 입니다.");
		}
		else if(요일 == 7){
			System.out.println("토요일 입니다.");
		}



	}






}
