import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FrameDuo extends JFrame
{
	private Controleur ctrl;
	private Lecteur lct1;
	private Lecteur lct2;

	private Archipel archi1;
	private Archipel archi2;

	private PanelTour2 pnlCentre;
	private PanelPioche2 pnlBas;
	private PanelPoint  pnlScore;


	public FrameDuo(Controleur controleur)
	{
		this.ctrl = controleur;
		this.setLayout(new BorderLayout());
		this.setSize(1400, 610);


		this.pnlScore  = new PanelPoint(ctrl);
		this.archi1    = this.ctrl.getArchiJoueur1();
		this.pnlCentre = new PanelTour2(this.ctrl, this.archi2);
		this.archi2    = this.ctrl.getArchiJoueur2();
		this.pnlBas    = new PanelPioche2(this.ctrl);

		this.archi1.setPreferredSize(new Dimension(600, 100));
		this.archi2.setPreferredSize(new Dimension(600, 100));
		this.pnlBas.setPreferredSize(new Dimension(100, 110));

		this.add(this.archi1   , BorderLayout.WEST);
		this.add(this.pnlCentre, BorderLayout.CENTER);
		this.add(this.archi2   , BorderLayout.EAST);
		this.add(this.pnlBas   , BorderLayout.SOUTH);

		this.setBonusArrete();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.repaint();
		this.setVisible(true);
	}

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
			for(Arete a : this.archi1.getEnsEdge())
			{
				if(a.getIleDep().getNom().equals(tabArreteBonus[i][0]) && a.getIleArr().getNom().equals(tabArreteBonus[i][1]))
				{
					a.setBonus();
					a.setColoEdge(new Color(0,255,0));
				}
			}
			for(Arete a : this.archi2.getEnsEdge())
			{
				if(a.getIleDep().getNom().equals(tabArreteBonus[i][0]) && a.getIleArr().getNom().equals(tabArreteBonus[i][1]))
				{
					a.setBonus();
					a.setColoEdge(new Color(0,255,0));
				}
			}
		}
    }

	public void setLog(String sRet)
	{
		this.pnlCentre.setLog(sRet);
	}
	public String getLog(){return this.pnlCentre.getLog();}

	public void setLabelErreur(String txt){this.pnlBas.setLabelErreur(txt);}
	
	public void setLabel1(int point)      {this.pnlScore.setLabel1(point);}
	public void setLabel2(int point)      {this.pnlScore.setLabel2(point);}
	public void miseAjour(boolean b)      { this.pnlBas.miseAjour(b)     ;}


	public void majTirage()     { this.pnlCentre.majTirage(); }
	public void miseAjour()     { this.pnlBas.miseAjour();    }
	public void miseAjourScore(){this.pnlBas.miseAjourScore();}

	public void verifPasseTour(){this.pnlCentre.verifPasseTour();}
	public ArrayList<Ile> getEnsIle(){return this.archi2.getEnsIle();}
}
