import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPioche2 extends JPanel 
{
	private Pioche pioche;
	private JPanel panelPioche;
	private JPanel pnlBorder1;
	private JPanel pnlBorder2;
	private JPanel pnlGrid;
	private JPanel pnlErreur;

	private ArrayList<JLabel> ensPioche;
	private JLabel lblDosCaret1;
	private JLabel lblDosCaret2;
	private JLabel lblPointRouge;
	private JLabel lblPointBleu;
	private JLabel lblPointBleu1;
	private JLabel lblPointRouge1;

	private JLabel lblErreur;

	private Controleur ctrl;

	public PanelPioche2(Controleur ctrl)
	{
		this.setLayout(new BorderLayout());
		this.pioche       = new Pioche();
		this.ensPioche    = new ArrayList<JLabel>();

		/*------------------------*/
		/*Creation des composants */
		/*------------------------*/
		this.pnlBorder1   = new JPanel(new GridLayout(1, 3));
		this.pnlBorder2   = new JPanel(new GridLayout(1, 3));
		this.pnlGrid      = new JPanel(new GridLayout(1, 3));
		this.pnlErreur    = new JPanel();
		this.ctrl         = ctrl;


		this.panelPioche     = new JPanel(new GridLayout(1, 10, 15, 2));

		this.lblDosCaret1    = new JLabel( this.ctrl.getCouleurCarte(0));
		this.lblDosCaret2    = new JLabel( this.ctrl.getCouleurCarte(1));

		this.lblPointBleu  = new JLabel("00");
		this.lblPointRouge = new JLabel("01");
		
		this.lblPointBleu1  = new JLabel("00");
		this.lblPointRouge1 = new JLabel("01");

		//creation du label erreur
		this.lblErreur = new JLabel(" -- ");


		//creation label pour afficher les cartes presentent dans la pioche.
		for(int i = 0;i<pioche.getPioche().size();i++)
		{
			JLabel lblTmp = new JLabel(new ImageIcon(this.pioche.getPiochePasSchuffle().get(i).getLienImg()));
			// set le nom de la carte
			lblTmp.setName(this.pioche.getPiochePasSchuffle().get(i).getLienImg());

			this.ensPioche.add(lblTmp);  //ajoute les labels au tableau ensPioche 
		}
		
		/*------------------------------*/
		/*positionnement des composants */
		/*------------------------------*/
		pnlBorder1.add(this.lblDosCaret1);
		pnlBorder1.add(this.lblPointBleu);
		pnlBorder1.add(this.lblPointRouge);
		
		
		pnlBorder2.add(this.lblPointBleu1);
		pnlBorder2.add(this.lblPointRouge1);
		pnlBorder2.add(this.lblDosCaret2);

		for(int i=0;i<ensPioche.size();i++)
		{
			this.panelPioche.add(this.ensPioche.get(i));
		}

		pnlGrid.add(pnlBorder1);
		pnlGrid.add(panelPioche);
		pnlGrid.add(pnlBorder2);

		this.pnlErreur.add(this.lblErreur);

		pnlGrid.setPreferredSize(new Dimension(50, 50));
		this.add(pnlGrid, BorderLayout.CENTER);
		this.add(pnlErreur, BorderLayout.SOUTH);
	}

	public void miseAjour()
	{
		this.panelPioche.removeAll();

		ArrayList<JLabel> ensPiocheTmp = new ArrayList<JLabel>();
		for(int i=0;i<ensPioche.size();i++)
		{
			if (ensPioche.get(i).getName().equals(this.ctrl.getPioche(1).getLienImg()))
			{	
				this.ensPioche.remove(i);
				
			}
		}
		ensPiocheTmp .addAll( this.ensPioche);
		this.ensPioche = new ArrayList<JLabel>();
		//this.panelPioche.remove(0);
		
		for(int i = 0;i<ensPiocheTmp.size();i++)
		{
			JLabel lblTmp = new JLabel(ensPiocheTmp.get(i).getIcon());
			// set le nom de la carte
			lblTmp.setName(ensPiocheTmp.get(i).getName());

			this.ensPioche.add(lblTmp);			
		}
		this.panelPioche.revalidate();
		this.panelPioche.repaint();

		for(int i=0;i<ensPiocheTmp.size();i++)
		{
			this.panelPioche.add(ensPiocheTmp.get(i));
		}

		this.replacement();
		this.panelPioche.setLayout(new GridLayout(1, this.ensPioche.size(), 15, 2));
		this.repaint();
	}

	public void miseAjour(Boolean boo)
	{
		this.panelPioche.removeAll();

		this.pioche      = new Pioche();
		this.ensPioche   = new ArrayList<JLabel>();
		this.panelPioche = new JPanel();
		this.panelPioche.setLayout(new GridLayout(1, this.ensPioche.size(), 15, 2));

		//creation des boutons symbolisant la pioche
		for(int i = 0;i<pioche.getPioche().size();i++)
		{
			JLabel lblTmp = new JLabel(new ImageIcon(this.pioche.getPiochePasSchuffle().get(i).getLienImg()));
			// set le nom de la carte
			lblTmp.setName(this.pioche.getPiochePasSchuffle().get(i).getLienImg());

			this.ensPioche.add(lblTmp);
		}
			
		// enlever la premiere carte piochier de la pioche
		for(int i=0;i<ensPioche.size();i++)
		{
			if (ensPioche.get(i).getName().equals(this.ctrl.getPioche(1).getLienImg()))
				this.ensPioche.remove(i);
		}
		
		for(int i=0;i<ensPioche.size();i++)
		{
			this.panelPioche.add(this.ensPioche.get(i));
		}

		this.replacement();
		miseAjour();
	}

	public void setLabelBleu  (){this.lblPointBleu  .setText(String.format("%03d",this.ctrl.getJ1().getPointBleu ()));}
	public void setLabelRouge (){this.lblPointRouge .setText(String.format("%03d",this.ctrl.getJ1().getPointRouge()));}
	public void setLabelBleu1 (){this.lblPointBleu1 .setText(String.format("%03d",this.ctrl.getJ2().getPointBleu ()));}
	public void setLabelRouge1(){this.lblPointRouge1.setText(String.format("%03d",this.ctrl.getJ2().getPointRouge()));}

	public void miseAjourScore()
	{
		this.setLabelBleu  ();
		this.setLabelBleu1 ();
		this.setLabelRouge ();
		this.setLabelRouge1();
	}

	public void replacement()
	{
		this.pnlBorder1.removeAll();

		pnlBorder1.add(this.lblDosCaret1);
		pnlBorder1.add(this.lblPointBleu);
		pnlBorder1.add(this.lblPointRouge);

		
		pnlBorder2.add(this.lblPointBleu1);
		pnlBorder2.add(this.lblPointRouge1);
		pnlBorder2.add(this.lblDosCaret2);
		
		this.pnlGrid.add(this.pnlBorder1);
		this.pnlGrid.add(this.panelPioche);
		this.pnlGrid.add(this.pnlBorder2);
	}

	public void setLabelErreur(String text) 
	{
		String txt = "";
		switch (text) 
		{
			case "6":
				txt = "Vous n'etes pas sur la bonne ile de depart, vous devez commencer sur l'ile " + this.ctrl.getNomIleDep();
				break;
			case "4":
				txt = "Vous allez former un cycle, vous en pouvez pas relier les arretes entre elles";
				break;
			case "5":
				txt = "Vous ne pouvez colorier une arrete deja coloriée";
				break;
			case "7":
				txt = "Vous devez colorier à partir d'une extremité";
				break;
			case "8":
				txt = "Vous devez colorier l'ile de la couleur de la carte";
				break;
			case "9":
				txt = "Vous ne pouvez pas croiser une arrete deja coloriée";
				break;
			default:
				txt = "";
		}
		this.lblErreur.setText(txt);
	}
}
