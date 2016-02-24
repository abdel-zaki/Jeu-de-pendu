import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//	Class principale de l'application  ***********************************************
class Application
{
	String CharTapes = "";
	String TabLettre ="abcdefghijklmnopqrstuvwxyz";
	char TabEtoiles [];
	String MotSaisie="";
	int NbErreur=0;
	JLabel LblMot = new JLabel("",0);
	JPasswordField TxtMot = new JPasswordField();
	JButton CmdValider = new JButton("Valider");
	JMenuItem MenuValider = new JMenuItem("Valider",'V');
	JLabel LblMessage = new JLabel("",0);
	Application()
	{
		TxtMot.setFont(new Font("",1,15));
		TxtMot.setBounds(175,130,115,20);
		//	/////////////////////////////////////////////////
		CmdValider.setBounds(175,180,115,30);
		CmdValider.setFont(new Font("Times New Roman",1,17));
		//	//////////////////////////////////////////////
		LblMot.setBackground(Color.getHSBColor(0,0,0.6f));
		LblMot.setForeground(Color.getHSBColor(0,0,0.2f));
		LblMot.setFont(new Font("Arial",3,25));
		LblMot.setOpaque(true);
		LblMot.setBounds(20,400,315,50);
		//	//////////////////////////////////////////
		LblMessage.setBackground(Color.getHSBColor(0,1,0.6f));
		LblMessage.setForeground(Color.white);
		LblMessage.setFont(new Font("",3,15));
		LblMessage.setOpaque(true);
		LblMessage.setBounds(140,260,189,30);
		//	////////////////////////////////
	}
	public static void main(String[]wa33)
	{
		Application app = new Application();
		JFrame f = new JFrame("[Jeu de pondu] vérsion 1.0 ©");
		f.setContentPane(new Interface(app));
		//	Récuperer les dimensions de l'écran
		Dimension SizeEcran = Toolkit.getDefaultToolkit().getScreenSize();
		f.setBounds((SizeEcran.width - 620) / 2, (SizeEcran.height - 500) / 2,620,500);
		f.setResizable(false);
		f.setDefaultCloseOperation(3);
		f.show();
	}
	boolean VerifierSaisie() // Fonction pour vérifier si on a bien saisie juste les caractères [a-z]
	{
		boolean MotValide = true;
		MotSaisie = TxtMot.getText().toLowerCase();
		for(int i=0 ; i<MotSaisie.length() ; i++)
		{
			if(TabLettre.indexOf(MotSaisie.charAt(i))==-1) MotValide = false;
		}
		return MotValide;
	}
	void Valider() // Procedure du bouton CmdValider
	{
		if(TxtMot.getText().length()<2 || TxtMot.getText().length()>14)
		{
			JOptionPane.showMessageDialog(null,"La langueure du mot doit être comprise entre 2 et 14 !","Erreur de saisie",JOptionPane.ERROR_MESSAGE);
			TxtMot.setText("");
		}
		else
		{
			if(VerifierSaisie())
			{
				JOptionPane.showMessageDialog(null,"Votre mot est admis, vous pouvez commencer le jeu !","Information",JOptionPane.INFORMATION_MESSAGE);
				TxtMot.setText("");
				TxtMot.setEnabled(false);
				CmdValider.setEnabled(false);
				MenuValider.setEnabled((false));
				TabEtoiles = new char [MotSaisie.length()];
				String MotTrouve="";
				for(int i=0 ; i<MotSaisie.length() ; i++)
				{
					TabEtoiles[i]='*';
					MotTrouve+='*';
				}
				LblMot.setText(MotTrouve);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Votre mot contient des caractères non valides !","Erreur de saisie",JOptionPane.ERROR_MESSAGE);
				TxtMot.setText("");
			}
		}
	}
	void Recherche(char c) // Procedure qui cherche les caractères choisies dans le mot saisie au début
	{
		if(MotSaisie.indexOf(c)==-1) NbErreur+=1;
		for(int i=0 ; i<MotSaisie.length() ; i++)
		{
			if(MotSaisie.charAt(i)==c)
			{
				TabEtoiles[i]=c;
			}
		}
		String MotTrouve = "";
		for(int i=0 ; i<TabEtoiles.length ; i++)
		{
			MotTrouve+=TabEtoiles[i];
		}
		LblMot.setText(MotTrouve);
	}
	boolean TesterReussite() // Fonction qui teste si on a trouver le mot
	{
		boolean ToutTrouve = true;
		for(int i=0 ; i<TabEtoiles.length ; i++)
		{
			if(TabEtoiles[i]=='*') ToutTrouve = false;
		}
		return ToutTrouve;
	}
	void Recomencer() // Procedure du bouton CmdRecomencer
	{
		MotSaisie="";
		NbErreur = 0;
		LblMot.setText("");
		LblMessage.setText("");
		TxtMot.setEnabled(true);
		CmdValider.setEnabled(true);
		MenuValider.setEnabled((true));
	}
	void Quitter() // Operation à effectuer pour le bouton CmdQuitter
	{
		if(JOptionPane.showConfirmDialog(null,"Etes vous sûr de bien vouloir quitter ?","Question",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			System.exit(0);
	}
}

