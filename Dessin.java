import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//	Class pour dessiner		**********************************************************
class Dessin extends JPanel
{
	int indexDessin=0;
	int yo = 52, y1 = 42, y2 = 54;
	Thread Th = new Thread();
	Dessin()
	{
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		switch(indexDessin)
		{
			case 11 : int Tx5[]={178,170,232,240};
					  int Ty5[]={180,192,265,255};
					  g.fillPolygon(Tx5,Ty5,4);
			//	/////////////////////////////
			case 10 :
			case 9 : int Tx4[]={168,178,116,107};
					 int Ty4[]={180,192,265,255};
					 g.fillPolygon(Tx4,Ty4,4);
			//	////////////////////////
			case 8 : int Tx3[]={178,170,236,240};
					 int Ty3[]={120,132,152,140};
					 g.fillPolygon(Tx3,Ty3,4);
			//	////////////////////////
			case 7 : int Tx2[]={168,178,112,107};
					 int Ty2[]={120,132,152,140};
					 g.fillPolygon(Tx2,Ty2,4);
			//	///////////////////
			case 6 : g.fillRect(168,94,10,100);
			//	////////////////////////
			case 5 : g.fillOval(150,35,45,60);		 
			case 4 : g.fillRect(55,15,150,20);		 
			case 3 : g.fillRect(35,15,20,135);
			case 2 : g.fillRect(35,150,20,130);
			case 1 : g.fillRect(15,270,90,20);
		}
		//	////////////////////////
		if(indexDessin==10 || indexDessin==11)
		{
			g.setColor(Color.white);
			g.drawLine(155,77,175,47);
			g.drawLine(155,65,170,42);
			g.drawLine(160,82,175,60);
			if(yo<68)
			{
				try
				{
					Th.sleep(100);
					yo+=2; y1+=2; y2+=2;
					g.fillOval(180,yo,15,15);
					int Tx[]={187,182,192};
					int Ty[]={y1,y2,y2};
					g.fillPolygon(Tx,Ty,3);
					g.setColor(Color.black);
				}
				catch(InterruptedException ex){}
				repaint();
			}
			else
			{
				g.fillOval(180,yo,15,15);
				int Tx[]={187,182,192};
				int Ty[]={y1,y2,y2};
				g.fillPolygon(Tx,Ty,3);
				g.setColor(Color.black);
				yo = 50; y1 = 40; y2 = 52;
			}
		}
	}
}
