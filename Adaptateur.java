import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//	Class d'aiguillage  ***************************************************************
class Adaptateur implements ActionListener, MouseListener
{
	Interface inter;
	Application app;
	Adaptateur(Interface inter, Application app)
	{
		this.inter=inter;
		this.app=app;
	}
	//	///////// Gestion des evennements click ////////////////
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==app.CmdValider || e.getSource()==app.MenuValider)
		{
			app.Valider();
			app.CharTapes = "";
		}
		if(e.getSource()==inter.CmdRecomencer || e.getSource()==inter.MenuRecomencer)
		{
			app.Recomencer();
			inter.dessin.indexDessin = 0;
			inter.dessin.repaint();
		}
		if(e.getSource()==inter.CmdQuitter || e.getSource()==inter.MenuQuitter)
		{
			app.Quitter();
		}
		for(int l=65 ; l<=90 ; l++)
		{
			if(e.getActionCommand().equals(""+(char)l))
			{
				String c = "" + (char)l;
				//
				if(app.MotSaisie.length()>0)
				{
					if(app.CharTapes.indexOf(c) == -1)
					{
						app.CharTapes+=c.charAt(0);
						app.Recherche(c.toLowerCase().charAt(0));
						inter.dessin.indexDessin = app.NbErreur;
						inter.dessin.repaint();
						app.LblMessage.setText(app.NbErreur + " Erreurs commises");
						if(app.NbErreur == 11)
						{
							JOptionPane.showMessageDialog(null,"Désolé, mais vous êtes déjà pondu, le mot que vous cherchez est : "+app.MotSaisie,"Fin du jeu",JOptionPane.ERROR_MESSAGE);
							app.MotSaisie = ""; app.NbErreur = 0;
						}
						if(app.TesterReussite())
						{
							JOptionPane.showMessageDialog(null,"Bravo! Le mot est bien : "+app.MotSaisie,"Fin du jeu",JOptionPane.INFORMATION_MESSAGE);
							app.MotSaisie = ""; app.NbErreur = 0;
						}
					}
				}
			}
		}
	}
	//	///////// Gestion des evennements sourie ////////////////
	public void mouseReleased(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e)
	{
		if(e.getSource() == inter.LblTitre)
		{
			inter.LblTitre.setFont(new Font("Arial",3,42));
			inter.LblTitre.setBackground(Color.getHSBColor(0,0,0.1f));
		}
		if(e.getSource() == app.CmdValider)
		{
			app.CmdValider.setFont(new Font("Times New Roman",1,18));
			app.CmdValider.setForeground(Color.red);
		}
		if(e.getSource() == inter.CmdRecomencer)
		{
			inter.CmdRecomencer.setFont(new Font("Times New Roman",1,13));
			inter.CmdRecomencer.setForeground(Color.red);
		}
		if(e.getSource() == inter.CmdQuitter)
		{
			inter.CmdQuitter.setFont(new Font("Times New Roman",1,14));
			inter.CmdQuitter.setForeground(Color.red);
		}
	}
	public void mouseExited(MouseEvent e)
	{
		if(e.getSource() == inter.LblTitre)
		{
			inter.LblTitre.setFont(new Font("Arial",3,40));
			inter.LblTitre.setBackground(Color.getHSBColor(0,0,0.2f));
		}
		if(e.getSource() == app.CmdValider)
		{
			app.CmdValider.setFont(new Font("Times New Roman",1,17));
			app.CmdValider.setForeground(Color.black);
		}
		if(e.getSource() == inter.CmdRecomencer)
		{
			inter.CmdRecomencer.setFont(new Font("Times New Roman",1,12));
			inter.CmdRecomencer.setForeground(Color.black);
		}
		if(e.getSource() == inter.CmdQuitter)
		{
			inter.CmdQuitter.setFont(new Font("Times New Roman",1,13));
			inter.CmdQuitter.setForeground(Color.black);
		}
	}
}

