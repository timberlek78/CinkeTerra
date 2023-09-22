import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	private Controleur  ctrl;
	private Archipel    archp;
	private JPanel      pnlBas;
	private PanelTour   pnlCentre;
	private PanelPoint  pnlScore;
	private PanelPioche pnlPioche;
	
	public Frame ( Controleur ctrl)
	{
		JPanel pnlArchi = new JPanel(new GridLayout(1, 2));
		this.ctrl = ctrl;
		this.setLayout(new BorderLayout());
		this.setTitle   ( "Cinke Tera");
		this.setSize    ( 820,640 );
		this.setLocation(  50, 50 );
		this.setIconImage(new ImageIcon(getClass().getResource("./images/btnMenu/icone.png")).getImage());

		this.archp = this.ctrl.getArchi();

		
		this.pnlBas    = new JPanel(new GridLayout(2, 1));
		this.pnlScore  = new PanelPoint(ctrl);
		this.pnlPioche = new PanelPioche ( this.ctrl );

		this.pnlCentre = new PanelTour   ( this.ctrl , this.archp );
		


		pnlArchi.add   (ctrl.getArchi());
		this.pnlBas.add(this.pnlPioche );
		this.pnlBas.add(this.pnlScore  );

		this.add(      pnlArchi  ,BorderLayout.CENTER);
		this.add( this.pnlBas    ,BorderLayout.SOUTH );
		this.add( this.pnlCentre ,BorderLayout.EAST  );


		// Gestion de la fermeture de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setBonusArrete();
		ctrl.getArchi().repaint();
		this.setVisible(true);

	}

	//Permet l'affihage des arêtes bonus en vert, leurs nombres et leurs position d'affichage (aléatoires)
    public void setBonusArrete()
    {
       String [][] tabArreteBonus = new String[][]{
									{"Tokha","Laçao"},
									{"Ticó","Laçao"},
									{"Laçao","Milaù"},
									{"Khont-Rolah","Mutaa"},
									{"Khont-Rolah","Fuego"},
									{"Mokah","Fissah"}};

		for(int i = 0;i<tabArreteBonus.length;i++)	
		{
			for(Arete a : this.archp.getEnsEdge())
			{
				if(a.getIleDep().getNom().equals(tabArreteBonus[i][0]) && a.getIleArr().getNom().equals(tabArreteBonus[i][1]))
				{
					a.setBonus();
					a.setColoEdge(new Color(0,255,0));
				}
			}
		}
    }

	public ArrayList<Ile> getEnsIle(){return this.archp.getEnsIle();}
	public Archipel getArchi(){return this.archp;}

	public boolean getPasseTour()  { return true; }

	public void majCouleur() { this.pnlCentre.majTirage(); }

	public void miseAjour(boolean b) { this.pnlPioche.miseAjour(b); }
	public void miseAjour()          { this.pnlPioche.miseAjour();  }

	public void setLabelBleu (int point)      {this.pnlScore.setLabelBleu (point);   }
	public void setLabelRouge(int point)      {this.pnlScore.setLabelRouge(point);   }
	public void setLabel1(int point)      {this.pnlScore.setLabel1(point);   }
	public void setLabel2(int point)      {this.pnlScore.setLabel2(point);   }
	public void setLabelErreur(String txt){this.pnlScore.setLabelErreur(txt);}
	
}