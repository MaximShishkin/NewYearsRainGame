package game9_12;
// ����������
import javax.swing.JOptionPane;

// �����, ����������� ����
public class Start {
	// �����, ����� ����� � ����
	public static void main(String[] args) {
		// ������ �������� � ���������� �� ����
		String rez = JOptionPane.showInputDialog(null,"������� ��������� ���� �� 1 �� 9:","��������� ����",3);
		// ������ �������� ��������� � ����������
		int slognost = rez.charAt(0)-'0';
		// �������, ��� ��������� ��������� ����
		if ((slognost>=1) && (slognost<=9))
		{
			// �������� ������� ������ Okno � � ���� ��������� �������� (����������) slognost
			Okno wind = new Okno(slognost); 
		}
		else
		{
			// ������������� �����, ���� ��������� ������� ����������!
			JOptionPane.showMessageDialog(null, "����� ���������� ���������, ����������))", "������", 0);
		}		
	}
}
