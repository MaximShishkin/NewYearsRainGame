package game9_12;

//����������
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;

public class Pole extends JPanel{

	private Image shapka; // �������� �����
	private Image fon; // �������� ����
	private Image end_game; // �������� ����� ����
	int x = 400; // �������� �����
	// ������ � ��������� �������� (����������)
	private int schet=0; // ������� ��� ��������� ��������� �����
	private int hp=3; // ���������� ������� � ����
	private Podarok [] game_Podarok = new  Podarok [9]; // � ��� ����� ��������� 7 �������� � � ��������� (�� 0 �� 6)
	Timer TimerUpdate, TimerDraw; // �������
	private int slognost; // �������� ���������
	
	// ����������� ������ Pole, � ������� ������� ���������� slognost (���������)
	Pole(int slognost)
	{
		this.slognost=slognost;
		
		try {
			game_Podarok[0]=new Podarok(ImageIO.read(this.getClass().getResource("p0.png")),slognost);
			game_Podarok[1]=new Podarok(ImageIO.read(this.getClass().getResource("p1.png")),slognost);
			game_Podarok[2]=new Podarok(ImageIO.read(this.getClass().getResource("p2.png")),slognost);
			game_Podarok[3]=new Podarok(ImageIO.read(this.getClass().getResource("p3.png")),slognost);
			game_Podarok[4]=new Podarok(ImageIO.read(this.getClass().getResource("p4.png")),slognost);
			game_Podarok[5]=new Podarok(ImageIO.read(this.getClass().getResource("p5.png")),slognost);
			game_Podarok[6]=new Podarok(ImageIO.read(this.getClass().getResource("p6.png")),slognost);
			game_Podarok[7]=new Podarok(ImageIO.read(this.getClass().getResource("p2.png")),slognost);
			game_Podarok[8]=new Podarok(ImageIO.read(this.getClass().getResource("p3.png")),slognost);
			
			shapka=ImageIO.read(this.getClass().getResource("shapka.png"));
			fon = ImageIO.read(this.getClass().getResource("fon.png"));
			end_game = ImageIO.read(this.getClass().getResource("end_game.png"));
			
			System.out.println("� ���������� �� ��");
		} catch (IOException e) {
			System.out.println("������ � ����������");
		}	
		
		TimerUpdate = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateStart();
				repaint();
			}
		});
		TimerUpdate.start();
		
		TimerDraw = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repaint();
			}
		});
		TimerDraw.start();	
	}
	
	// ������� ���-�� �������� �� ���� �  ���� �� �������� ������ �������� ���������, �� ��������� �������� �� �����
	private void UpdateStart() 
	{
		int koll=0; // ����������, ������� ���������� ���������� �������� �� ���� � ������ ������
		
		for (int i=0;i<9;i++) // ���� �� ���� ���������
		{
			if(game_Podarok[i].active_img==false) // ���� �������� �� ��������� �� �����, �� 
			{
				if (koll<slognost) // ���� ���������� �������� �� ���� ������ ��������� ��������� ����, ��
				{
					game_Podarok[i].start(); // ����������� �������� �� �����
					break; // ������� �� �����
				}
			}
			else koll++; // ���������, ��� �������� ��� ���� �� ������
		}
	}
	
	// ������������ ������� � ����
	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr); // 
		// ��������� ����
		gr.drawImage(fon, 0, 0, null);
		
		// ���� ��������� ��������
		for (int i=0;i<9;i++)
		{
			// ����� ������ ��� ���������, ������� ��������� � ������ Podarok
			game_Podarok[i].draw(gr);
			// ������� ���������, ���� �������� ���� �� ����, ��
			if (game_Podarok[i].active_img==true)
			{
				if((game_Podarok[i].y+game_Podarok[i].img.getHeight(null))>=470)
				{
					if (Math.abs(game_Podarok[i].x-x)>75)
					{
						if (hp==0) { // ���� ������� �� ��������, �� ����������� ����!
							gr.drawImage(end_game, 300, 300, null);
							TimerUpdate.stop();
							TimerDraw.stop();
							break;
						}
						
						hp=hp-1; // ��������� ���-�� ������� �� 1
						game_Podarok[i].active_img=false; // ������� ������� � ����
					}
					else
					{
						game_Podarok[i].active_img=false; // ������� ������� � ����
						schet=schet+1; // �������� �������
						if (schet % 10 == 0) // ������� � ��������, ���� ������� 0, ��
						{
							for (int j=0;j<9;j++) // ��������� ��������� �������� �� ���� ��������
							{
								game_Podarok[j].updatespeed=game_Podarok[j].updatespeed+10;
							}
						}
					}
				}	
			}	
		}
		gr.setColor(Color.white);
		gr.drawString("���� ����: "+ schet, 700, 10);
		gr.drawString("�������� �������: "+ hp, 652, 30);
		gr.drawImage(shapka, x, 465,null);
	}
}
