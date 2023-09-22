import java.awt.GridLayout;
import java.awt.ImageCapabilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTour2 extends JPanel implements ActionListener
{
	private Controleur ctrl;
	private Archipel archi;
	private JLabel lblCarte;
	private JLabel futurEspaceCartePioche;

	private JScrollPane scpJournal;
	private JTextArea journal;

	private JLabel  lblCouleur;
	private JLabel  lblIleDep;
	private JLabel  lblIleDep2;

	private JPanel  panelPasseTour;
	private JButton btnPasseTour1;
	private JButton btnPasseTour2;

	private boolean aPasseSonTour;
	private boolean bOk1;
	private boolean bOk2;

	public PanelTour2( Controleur ctrl, Archipel archi)
	{
		this.setLayout(new BorderLayout());
		this.ctrl = ctrl;
		this.archi = archi;
		this.setPreferredSize(new Dimension(10, 50));
		this.aPasseSonTour = false;

		/*------------------------*/
		/*CrÃ©ation des composants */
		/*------------------------*/

		//composants du panel passe tour
		JPanel resizeCarte   	= new JPanel(new GridLayout(1, 2));
		this.panelPasseTour  	= new JPanel();
		JPanel pnlBtn        	= new JPanel(new GridLayout(1, 2));
		this.panelPasseTour.setLayout( new GridLayout( 4, 1) );
		this.btnPasseTour1   	= new JButton( "Joueur 1" );
		this.btnPasseTour2   	= new JButton( "Joueur 2" );

		this.journal 			= new JTextArea();
		this.journal.setLineWrap(true);
		this.journal.setWrapStyleWord(true);

		this.scpJournal 		= new JScrollPane(this.journal);

		JPanel img 				= new JPanel();

		this.lblIleDep       	= new JLabel(new ImageIcon(this.ctrl.getLienImg()));
		this.lblIleDep2      	= new JLabel(new ImageIcon(this.ctrl.getLienImg()));


		this.futurEspaceCartePioche    = new JLabel( new ImageIcon("images/Cartes/CarteEnGrand/imgVide.jpg"));
		
		this.lblCarte       = new JLabel(new ImageIcon() );
		majTirage();


		

		/*-----------------------------*/
		/*positonnement des composants */
		/*-----------------------------*/

		//positionnement des elements du panel passe tour
		img.add(this.lblIleDep);
		img.add(new JPanel());
		img.add(this.lblIleDep2);


		resizeCarte.add(this.futurEspaceCartePioche, BorderLayout.SOUTH);
		this.panelPasseTour.add( resizeCarte      );
		this.panelPasseTour.add( this.lblCarte    );
		this.panelPasseTour.add( this.scpJournal);
		this.panelPasseTour.add(new JLabel("Boutons passer son tour:"));


		pnlBtn.add( this.btnPasseTour1);
		pnlBtn.add( this.btnPasseTour2);

		pnlBtn.setPreferredSize(new Dimension(100, 80));

		this.add( this.panelPasseTour, BorderLayout.CENTER );
		this.add(pnlBtn, BorderLayout.SOUTH);



		/*Activation des composanats*/

		this.btnPasseTour1.addActionListener(this);
		this.btnPasseTour2.addActionListener(this);
	}

	public void   changementCarte( JLabel lbl,Icon carte ) { lbl.setIcon(carte); }
	
	public JLabel getLabelCouleur() { return this.lblCouleur; }
	public JLabel getLabelCarte  () { return this.lblCarte  ; }
	public void setLog(String sTmp)
	{
		this.journal.append(sTmp + '\n');
	}

	public String getLog(){return this.journal.getText();}

	public void majTirage( )
	{
		// this.lblCarte.setIcon(new ImageIcon(this.ctrl.getPioche().toString())) ;
		String res = ".";
		String[] lienImg = this.ctrl.getPioche(2).toString().split("/");
		for (int i = 1; i < lienImg.length; i++) 
		{
			if(i == 2)
				res += "/Cartes/CarteEnGrand";
			else
			res += "/" + lienImg[i];
		}
		this.futurEspaceCartePioche.setIcon(new ImageIcon(res)) ;
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == this.btnPasseTour1)
		{
			this.ctrl.getJ1().setAjoue(true);
			this.ctrl.setLog("Joueur 2 à passé son tour MABOY");
			this.btnPasseTour1.setEnabled(false);
			this.verifPasseTour();
		}
		if(e.getSource() == this.btnPasseTour2)
		{
			this.ctrl.getJ2().setAjoue(true);
			this.ctrl.setLog("Joueur 2 à passé son tour MABOY");
			this.btnPasseTour2.setEnabled(false);
			this.verifPasseTour();
		}
	}
	public boolean getPasseTour(){return this.aPasseSonTour ;}
	public void    setPasseTour(){this.aPasseSonTour = false;}

	public void verifPasseTour()
	{
		if(this.ctrl.getJ1().aJoue() && this.ctrl.getJ2().aJoue())
		{
			this.ctrl.passeTonTour(1);
			this.ctrl.passeTonTour(2);
			String res = ".";
			String[] lienImg = this.ctrl.getPioche(1).toString().split("/");
			for (int i = 1; i < lienImg.length; i++) 
			{
				if(i == 2)
					res += "/Cartes/CarteEnGrand";
				else
				res += "/" + lienImg[i];
			}
			this.futurEspaceCartePioche.setIcon(new ImageIcon(res)) ;
			this.ctrl.miseAjour();
			this.ctrl.getJ1().setAjoue  (false);
			this.ctrl.getJ2().setAjoue  (false);	
		
			this.btnPasseTour1.setEnabled(true);
			this.btnPasseTour2.setEnabled(true);
		}
	}

	
}