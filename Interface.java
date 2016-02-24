import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//	Class Interface *****************************************************************
class Interface extends JPanel
{
	JLabel LblTitre = new JLabel("Jeu de pondu",0);
	JPanel PanelButton = new JPanel(null);
	Dessin dessin = new Dessin();
	JLabel LblCommentaire = new JLabel("Saisissez votre mot ici .");
	JButton CmdRecomencer = new JButton("Recomencer");
	JButton CmdQuitter = new JButton("Quitter");
	JMenuBar MenuBarre = new JMenuBar();
	JMenu MenuAction = new JMenu("Action");
	JMenuItem MenuRecomencer = new JMenuItem("Recomencer",'R');
	JMenuItem MenuQuitter = new JMenuItem("Quitter",'Q');
	Application app;
	
	Interface(Application app)
	{
		setLayout(null);
		this.app=app;
		LblTitre.setBounds(132,30,356,65);
		LblTitre.setFont(new Font("Arial",3,40));
		LblTitre.setForeground(Color.orange);
		LblTitre.setOpaque(true);
		LblTitre.setBackground(Color.getHSBColor(0,0,0.2f));
		//	//////////////////////////////////////////////////////////////////////////
		LblCommentaire.setFont(new Font("Monotype Corsiva",1,10));
		LblCommentaire.setForeground(Color.white);
		LblCommentaire.setBounds(155,105,160,20);
		//	///////////////////////////////////////////////////
		PanelButton.setBounds(20,100,105,285);
		PanelButton.setBackground(Color.getHSBColor(0,0,0.4f));
		//	//////////////////////////////////////////
		dessin.setBounds(345,100,260,305);
		dessin.setBackground(Color.getHSBColor(0,0,0.4f));
		dessin.repaint();
		//	Sans commentaire !!
		Label l = new Label();
		l.setBounds(95,355,30,30);
		l.setBackground(Color.getHSBColor(0,0,0.3f));
		//	////////////////////////
		CmdRecomencer.setBounds(169,345,127,30);
		CmdQuitter.setBounds(437,420,90,30);
		CmdRecomencer.setFont(new Font("Times New Roman",1,12));
		CmdQuitter.setFont(new Font("Times New Roman",1,13));
		add(LblTitre);
		add(LblCommentaire);
		add(app.TxtMot);
		BoutonsAZ();
		add(PanelButton);
		add(l);
		add(app.CmdValider);
		add(app.LblMessage);
		add(app.LblMot);
		add(CmdRecomencer);
		add(dessin);
		add(CmdQuitter);
		//	//////////////////////////////////////
		MenuAction.add(app.MenuValider);
		MenuAction.add(MenuRecomencer);
		MenuAction.add(MenuQuitter);
		MenuBarre.add(MenuAction);
		MenuBarre.setBounds(2,2,610,20);
		add(MenuBarre);
		//	//////////////////////////////////////
		LblTitre.addMouseListener(new Adaptateur(this,app));
		app.CmdValider.addMouseListener(new Adaptateur(this,app));
		CmdRecomencer.addMouseListener(new Adaptateur(this,app));
		CmdQuitter.addMouseListener(new Adaptateur(this,app));
		//	//////////////////////////////////////
		app.CmdValider.addActionListener(new Adaptateur(this,app));
		app.MenuValider.addActionListener(new Adaptateur(this,app));
		CmdRecomencer.addActionListener(new Adaptateur(this,app));
		MenuRecomencer.addActionListener(new Adaptateur(this,app));
		CmdQuitter.addActionListener(new Adaptateur(this,app));
		MenuQuitter.addActionListener(new Adaptateur(this,app));
		setBackground(Color.getHSBColor(0,0,0.3f));
	}
	//	Création, Ajout et attribution de l'écouteur d'événement aux boutons [A-Z]
	void BoutonsAZ()
	{
		int XBut=10, YBut=-20;
		for(int i=0 ; i<=25 ; i++)
		{
			int j=i+65;
			Button b = new Button(""+(char)j);
			if(j>73)
			{
				if(j==74 || j==83) YBut=-20;
				if(j<=82) XBut=40;
				else XBut=70;
			}
			YBut+=30;
			b.setBounds(XBut,YBut,25,25);
			b.setFont(new Font("Arial",3,14));
			b.setBackground(Color.getHSBColor(0,0,0.3f));
			b.setForeground(Color.white);
			PanelButton.add(b);
			b.addActionListener(new Adaptateur(this,app));
		}
	}
}

