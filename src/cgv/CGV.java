package cgv;

import javax.swing.JOptionPane;

public class CGV {

	public static void main(String[] args) {
		
		String helloMsg = "★★★  C G V ★★★\n\n";
		String menuMsg = "1. 예매하기\n2. 구매하기\n3. 포인트 조회 \n4. 현재 잔액\n5. 나가기\n\n";
		String films = "1.라이온킹(08:00)\n2.스파이더맨(12:00)\n3.사일런스(23:00)[청소년 관람 불가]\n4.뒤로가기\n\n"; 
		String ageMsg = "[청소년 구매 불가 상풍]\n나이를 입력하세요\n";		
		String product = "1.팝콘 L\n2.콜라\n3.맥주\n4.뒤로 가기\n\n";
		String balance = "현재 잔액";
		
		int age;                // 나이 제한 사용
		int choice = 0;         // 목록
		int money = 10_000;     // 잔액 
		int point = 0;          //
		int t_price = 10_000;   // 영화표 값
		boolean t_check;        //검사
		int pd = 5_000;         //상품

		
		while(true) {
			t_check = true;
			choice = Integer.parseInt(JOptionPane.showInputDialog(helloMsg + menuMsg));
			if(choice == 5) break;
			
			//잘못입력했을때 continue
			if(!(choice >= 1 && choice <= 4))continue;			
			switch(choice) {						
//예매하기 영역
			case 1:
				// 잔액 - 티켓금액
				if((point + money) - t_price < 0) {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
					continue;
				}
				//choice = 변수의 재사용
				choice = Integer.parseInt(JOptionPane.showInputDialog(helloMsg + films));
				if(choice == 1) {
					JOptionPane.showMessageDialog(null, "라이온킹 예매 완료(08:00)");
				}
				else if(choice ==2) {
					JOptionPane.showMessageDialog(null, "스파이더맨(12:00)");
				}
				else if(choice == 3) {
					age = Integer.parseInt(JOptionPane.showInputDialog(ageMsg));
					if(age > 19) {
						JOptionPane.showMessageDialog(null, "사일런스(23:00)");
					}
					else {
						t_check = false;
						JOptionPane.showMessageDialog(null, "다시 시도해 주세요");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
					continue;
				}
				
				if(t_check) {   
					if(point > 0) {                           //포인트 보다 크니?
						if(point - t_price >= 0) {
						point -= t_price;             
					}
						else {
							money -= (t_price - point);     //포인트, 잔액 동시 결제 
							point = 0;                      //포인트 전체 사용
						}
					}
					else {
						money -= t_price;                 // 잔액으로만 티켓 구매
						point +=(int)(t_price * 1);        //포인트 누적
					}
					JOptionPane.showMessageDialog(null, "현재 잔액 : " + money + "원");				
				}
				break;
								
//구매하기 영역	
			case 2:
				choice = Integer.parseInt(JOptionPane.showInputDialog(helloMsg + product));
				if(choice == 5) break;
				
				//잘못입력했을때 continue
				if(!(choice >= 1 && choice <= 4))continue;
				if((point + money) - pd < 0) {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
					continue;
				}
				//choice = 변수의 재사용
				if(choice == 1) {
					JOptionPane.showMessageDialog(null, "팝콘L");
				}
				else if(choice ==2) {
					JOptionPane.showMessageDialog(null, "콜라");
				}
			
				else if(choice == 3) {
					age = Integer.parseInt(JOptionPane.showInputDialog(ageMsg));
					if(age > 19) {
						JOptionPane.showMessageDialog(null, "맥주");
					}
					else {
						t_check = false;
						JOptionPane.showMessageDialog(null, "다시 시도해 주세요");
						break;
						}							
				}
				else  {    
					
					JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
					continue;					
				}					
				if (t_check) {
				}
					if(point > 0) {    //포인트 보다 크니?
						if((point - pd) >= 0) {
						point -= pd;             
					}
						else {
							money -= (pd - point);    //포인트, 잔액 동시 결제 
							point = 0;                      //포인트 전체 사용						
						}
					}else {
						money -= pd;
						point +=(int)(pd * 0.1);   //포인트 누적
					}				
				JOptionPane.showMessageDialog(null, "현재 잔액 : " + money + "원");
				break;	
				
// 포인트 조회 영역
			case 3:
				JOptionPane.showMessageDialog(null, "잔여 포인트 :" + point + "점");
				break;	
				
// 현재 잔액 영역				
			case 4:
				JOptionPane.showMessageDialog(null, "현재 잔액 :" + money + "원");
				break;
			}
		}
	}
}


