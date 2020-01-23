package cgv;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class NEW_CGV {
	String ageMsg = "[청소년 구매 불가 상풍]\n나이를 입력하세요\n";
	int age;                // 나이 제한 사용
	boolean t_check = true;
	
	
	boolean bookTicket() {
		boolean cCheck = false;
		String films = "1.라이온킹(08:00)\n2.스파이더맨(12:00)\n3.사일런스(23:00)[청소년 관람 불가]\n4.뒤로가기\n\n";
		
		int choice = Integer.parseInt(JOptionPane.showInputDialog(films));
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
			cCheck = true;
		}
		return cCheck;
	}

	public static void main(String[] args) {
		
				
		String helloMsg = "★★★  C G V ★★★\n\n";
		String menuMsg = "1. 예매하기\n2. 구매하기\n3. 포인트 조회 \n4. 현금 충전\n5. 나가기\n\n";
		String films = "1.라이온킹(08:00)\n2.스파이더맨(12:00)\n3.사일런스(23:00)[청소년 관람 불가]\n4.뒤로가기\n\n"; 
		String ageMsg = "[청소년 구매 불가 상풍]\n나이를 입력하세요\n";		
		String cha = "충전할 금액을 입력하세요\n";
		String product = "1.팝콘 L\n2.콜라\n3.맥주\n4.뒤로 가기\n\n";
		String balance = "1.현금 조회\n2.현금 충전\n3.뒤로 가기\n\n";
		
		
		int choice = 0;         // 목록
		int money = 10_000;     // 잔액 
		int charge;
		int point = 0;          //
		int t_price = 10_000;   // 영화표 값
		int pd = 5_000;         //상품
		
		int[] tmp = new int[10000];
		
		NEW_CGV c = new NEW_CGV();       // 메서드에 있다
		
		while(true) {
			c.t_check = true;
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
				if(c.bookTicket()) continue;
				
				//choice = 변수의 재사용
				
				
				if(c.t_check) {   
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
					JOptionPane.showMessageDialog(null, "잔여 포인트 : " + point + "점");
				}
				JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
				continue;	
//				break;
								
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
					c.age = Integer.parseInt(JOptionPane.showInputDialog(ageMsg));
					if(c.age > 19) {
						JOptionPane.showMessageDialog(null, "맥주");
					}
					else {
						c.t_check = false;
						JOptionPane.showMessageDialog(null, "다시 시도해 주세요");
						break;
						}							
				}
				else  {    
					
					JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
					continue;					
				}					
				if (c.t_check) {
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
				JOptionPane.showMessageDialog(null, "잔여 포인트 : " + point + "점");
				JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
				continue;	
				
// 포인트 조회 영역
			case 3:
				JOptionPane.showMessageDialog(null, "잔여 포인트 :" + point + "점");
				JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
				continue;
				
				
// 현금 충전 영역				
			case 4:
				choice = Integer.parseInt(JOptionPane.showInputDialog(balance));
				if(choice == 5) break;
				
				if(choice == 1) {
					JOptionPane.showMessageDialog(null, "현재 조회");
					JOptionPane.showMessageDialog(null, "현재 잔액 :" + money + "원");
					JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
					continue;
				}
				else if(choice == 2) {
					charge = Integer.parseInt(JOptionPane.showInputDialog(cha));
									
					
					if (money >= 0) {
					}
						if(charge > 0) {    //포인트 보다 크니?
							if((charge + money) >= 0) {
							money += charge;   
							JOptionPane.showMessageDialog(null, "현금 충전: " + money + "원");
						}
												
						}else {
							JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
							continue;	
						}					
				}
				JOptionPane.showMessageDialog(null, "메인 메뉴로 이동합니다.");
				continue;	
			}									
			break;
		}
	}
}


