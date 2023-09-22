import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PanelScenar extends JPanel implements ActionListener
{
	private Controleur ctrl;
	private ArrayList<Ile> ensIle;

	private JMenuBar menuScenar;

	private JMenu lstScenar;

	private JMenuItem cycle;
	private JMenuItem cycle2;
	private JMenuItem commencement1;
	private JMenuItem pioche;
	private JMenuItem pioche2;



	public PanelScenar(Controleur ctrl)
	{
		this.menuScenar = new JMenuBar();
		this.lstScenar  = new JMenu("Liste des scénarios:");

		this.cycle      	= new JMenuItem("Cycle, Croisement, Continuité, Un seul passage par arêtes pour le solo");
		this.cycle2      	= new JMenuItem("Cycle, Croisement, Continuité, Un seul passage par arêtes pour le duo");
		this.commencement1 	= new JMenuItem("Commencer à la bonne île en mode solo");
		this.pioche    	 	= new JMenuItem("Pioche et passement de tour pour le mode solo");
		this.pioche2     	= new JMenuItem("Pioche pour le mode duo, passement de tour et gestion des tours");

		this.lstScenar.add(this.cycle);
		this.lstScenar.add(this.cycle2);
		this.lstScenar.add(this.commencement1);
		this.lstScenar.add(this.pioche);
		this.lstScenar.add(this.pioche2);

		this.menuScenar.add(this.lstScenar);

		this.cycle.addActionListener(this);
		this.cycle2.addActionListener(this);
		this.commencement1.addActionListener(this);
		this.pioche.addActionListener(this);
		this.pioche2.addActionListener(this);

		this.add(this.menuScenar);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.cycle)
		{
			this.ctrl = new Controleur(new Pioche(Color.blue), Color.blue);
			this.ensIle = this.ctrl.getEnsIle();
			

				Pioche pioche = new Pioche( Color.blue );// set la pioche a --> rouge jaune jaune brun vert
				this.ctrl.setPioche(pioche);
				this.ctrl.getLecteur().colorEdge(this.ensIle.get(14), this.ensIle.get(13));
				this.ctrl.majCouleur();
				this.ctrl.getLecteur().colorEdge(this.ensIle.get(13), this.ensIle.get(12));
				this.ctrl.majCouleur();
				this.ctrl.getLecteur().colorEdge(this.ensIle.get(14), this.ensIle.get(16));
				this.ctrl.passeTonTour(0);
				this.ctrl.majCouleur();
			
		}
		else if (e.getSource() == this.cycle2)
		{
			Controleur ctrl2 = new Controleur(1);
			this.ensIle = ctrl2.getEnsIle();
		}
		else if (e.getSource() == this.commencement1)
		{
			Controleur ctrl2 = new Controleur(new Pioche(Color.blue), Color.blue);
		}

		else if (e.getSource() == this.pioche)
		{
			new Pioche();
			this.ctrl = new Controleur();
				this.ctrl.passeTonTour(0);
				this.ctrl.majCouleur();
				this.ctrl.passeTonTour(0);
				this.ctrl.majCouleur();
				this.ctrl.passeTonTour(0);
				this.ctrl.majCouleur();
				this.ctrl.passeTonTour(0);
				this.ctrl.majCouleur();
				this.ctrl.passeTonTour(0);
				this.ctrl.majCouleur();
				this.ctrl.passeTonTour(0);
				this.ctrl.majCouleur();
		}
		else if (e.getSource() == this.pioche2)
		{
			new Pioche();
			this.ctrl = new Controleur(1);
			this.ctrl.passeTonTour(1);
			this.ctrl.passeTonTour(2);
			this.ctrl.getJ1().setAjoue(true);
			this.ctrl.getJ2().setAjoue(true);
			this.ctrl.majCouleur2();
			this.ctrl.passeTonTour(1);
			this.ctrl.passeTonTour(2);
			this.ctrl.getJ1().setAjoue(true);
			this.ctrl.getJ2().setAjoue(true);
			this.ctrl.majCouleur2();
			this.ctrl.passeTonTour(1);
			this.ctrl.passeTonTour(2);
			this.ctrl.getJ1().setAjoue(true);
			this.ctrl.getJ2().setAjoue(true);
			this.ctrl.majCouleur2();
			this.ctrl.passeTonTour(1);
			this.ctrl.passeTonTour(2);
			this.ctrl.getJ1().setAjoue(true);
			this.ctrl.getJ2().setAjoue(true);
			this.ctrl.majCouleur2();
			this.ctrl.passeTonTour(1);
			this.ctrl.passeTonTour(2);
			this.ctrl.getJ1().setAjoue(true);
			this.ctrl.getJ2().setAjoue(true);
			this.ctrl.majCouleur2();
			this.ctrl.passeTonTour(1);
			this.ctrl.passeTonTour(2);
			this.ctrl.getJ1().setAjoue(true);
			this.ctrl.getJ2().setAjoue(true);
			this.ctrl.majCouleur2();
			
		}

	}



	
}
