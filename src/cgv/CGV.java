package cgv;

import javax.swing.JOptionPane;

public class CGV {

	public static void main(String[] args) {
		
		String helloMsg = "�ڡڡ�  C G V �ڡڡ�\n\n";
		String menuMsg = "1. �����ϱ�\n2. �����ϱ�\n3. ����Ʈ ��ȸ \n4. ���� �ܾ�\n5. ������\n\n";
		String films = "1.���̿�ŷ(08:00)\n2.�����̴���(12:00)\n3.���Ϸ���(23:00)[û�ҳ� ���� �Ұ�]\n4.�ڷΰ���\n\n"; 
		String ageMsg = "[û�ҳ� ���� �Ұ� ��ǳ]\n���̸� �Է��ϼ���\n";		
		String product = "1.���� L\n2.�ݶ�\n3.����\n4.�ڷ� ����\n\n";
		String balance = "���� �ܾ�";
		
		int age;                // ���� ���� ���
		int choice = 0;         // ���
		int money = 10_000;     // �ܾ� 
		int point = 0;          //
		int t_price = 10_000;   // ��ȭǥ ��
		boolean t_check;        //�˻�
		int pd = 5_000;         //��ǰ

		
		while(true) {
			t_check = true;
			choice = Integer.parseInt(JOptionPane.showInputDialog(helloMsg + menuMsg));
			if(choice == 5) break;
			
			//�߸��Է������� continue
			if(!(choice >= 1 && choice <= 4))continue;			
			switch(choice) {						
//�����ϱ� ����
			case 1:
				// �ܾ� - Ƽ�ϱݾ�
				if((point + money) - t_price < 0) {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.");
					continue;
				}
				//choice = ������ ����
				choice = Integer.parseInt(JOptionPane.showInputDialog(helloMsg + films));
				if(choice == 1) {
					JOptionPane.showMessageDialog(null, "���̿�ŷ ���� �Ϸ�(08:00)");
				}
				else if(choice ==2) {
					JOptionPane.showMessageDialog(null, "�����̴���(12:00)");
				}
				else if(choice == 3) {
					age = Integer.parseInt(JOptionPane.showInputDialog(ageMsg));
					if(age > 19) {
						JOptionPane.showMessageDialog(null, "���Ϸ���(23:00)");
					}
					else {
						t_check = false;
						JOptionPane.showMessageDialog(null, "�ٽ� �õ��� �ּ���");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "���� �޴��� �̵��մϴ�.");
					continue;
				}
				
				if(t_check) {   
					if(point > 0) {                           //����Ʈ ���� ũ��?
						if(point - t_price >= 0) {
						point -= t_price;             
					}
						else {
							money -= (t_price - point);     //����Ʈ, �ܾ� ���� ���� 
							point = 0;                      //����Ʈ ��ü ���
						}
					}
					else {
						money -= t_price;                 // �ܾ����θ� Ƽ�� ����
						point +=(int)(t_price * 1);        //����Ʈ ����
					}
					JOptionPane.showMessageDialog(null, "���� �ܾ� : " + money + "��");				
				}
				break;
								
//�����ϱ� ����	
			case 2:
				choice = Integer.parseInt(JOptionPane.showInputDialog(helloMsg + product));
				if(choice == 5) break;
				
				//�߸��Է������� continue
				if(!(choice >= 1 && choice <= 4))continue;
				if((point + money) - pd < 0) {
					JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.");
					continue;
				}
				//choice = ������ ����
				if(choice == 1) {
					JOptionPane.showMessageDialog(null, "����L");
				}
				else if(choice ==2) {
					JOptionPane.showMessageDialog(null, "�ݶ�");
				}
			
				else if(choice == 3) {
					age = Integer.parseInt(JOptionPane.showInputDialog(ageMsg));
					if(age > 19) {
						JOptionPane.showMessageDialog(null, "����");
					}
					else {
						t_check = false;
						JOptionPane.showMessageDialog(null, "�ٽ� �õ��� �ּ���");
						break;
						}							
				}
				else  {    
					
					JOptionPane.showMessageDialog(null, "���� �޴��� �̵��մϴ�.");
					continue;					
				}					
				if (t_check) {
				}
					if(point > 0) {    //����Ʈ ���� ũ��?
						if((point - pd) >= 0) {
						point -= pd;             
					}
						else {
							money -= (pd - point);    //����Ʈ, �ܾ� ���� ���� 
							point = 0;                      //����Ʈ ��ü ���						
						}
					}else {
						money -= pd;
						point +=(int)(pd * 0.1);   //����Ʈ ����
					}				
				JOptionPane.showMessageDialog(null, "���� �ܾ� : " + money + "��");
				break;	
				
// ����Ʈ ��ȸ ����
			case 3:
				JOptionPane.showMessageDialog(null, "�ܿ� ����Ʈ :" + point + "��");
				break;	
				
// ���� �ܾ� ����				
			case 4:
				JOptionPane.showMessageDialog(null, "���� �ܾ� :" + money + "��");
				break;
			}
		}
	}
}


