package game9_12;

//����������
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

// ����� Okno, � ������� �������� ���� ����
public class Okno extends JFrame{
	
    // ������ ������ Pole c ������ game_Pole
	private Pole game_Pole;
	
	// ����� ��� ��������� ������� ������ �� ���������� 
	private class MyKey implements KeyListener
	{
		// ����������� ��� ������� �� �������
		public void keyPressed(KeyEvent arg0) {
			// ������ ���� ������� � ����������
			int key_code = arg0.getKeyCode();
			// ����� �������� � ������� 
			System.out.println(key_code);
			if (key_code==37) // �������� ����� ����� 
			{
				game_Pole.x= game_Pole.x - 30;
			}
			if (key_code==39) // �������� ����� ������
			{
				game_Pole.x= game_Pole.x + 30;
			}
			if (game_Pole.x>751) 
			{
				game_Pole.x=0;
			}
			if (game_Pole.x<0) 
			{
				game_Pole.x=750;
			}
		}
		public void keyReleased(KeyEvent arg0) {}
		public void keyTyped(KeyEvent arg0) {}	
	}
	
	// ����������� ������ Okno, � ������� ������� ���������� slognost
	Okno(int slognost)
	{
		// ����������� ���������� ������ ����������� � ����
		addKeyListener(new MyKey());
		setFocusable(true);
		
		// ������ ������� ���� � ����� ������� � ����� ����
		setBounds(10,10,800,600);
		setTitle("���� - ���������� �����. ��������� " + slognost);
		
		// ������ ������ ������ Pole � ����������� � ����
		game_Pole = new Pole(slognost);
		add(game_Pole);
		
		// ������� ������ ���������� ��� �������� ���� � ������ ���� �������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
