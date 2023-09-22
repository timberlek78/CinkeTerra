import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTour extends JPanel implements ActionListener
{
	private Controleur ctrl;

	private Archipel archi;

	private JLabel lblCouleur;
	private JLabel lblCarte;
	private JLabel lblDosCaret;

	private JPanel  panelPasseTour;

	private JButton btnPasseTour;

	private boolean aPasseSonTour;

	public PanelTour( Controleur ctrl, Archipel archi)
	{
		this.setLayout(new BorderLayout());
		this.ctrl          = ctrl;
		this.archi         = archi;
		this.aPasseSonTour = false;

		/*------------------------*/
		/*CrÃ©ation des composants */
		/*------------------------*/

		//composants du panel passe tour
		this.panelPasseTour = new JPanel();
		this.panelPasseTour.setLayout( new GridLayout( 3, 1, 5, 5 ) );
		this.btnPasseTour   = new JButton( "Passer son tour" );

		if ( this.ctrl.getCouleurJoueur() == Color.red)
			this.lblDosCaret    = new JLabel( new ImageIcon( "images/cartes/dos_RED.png" ) );
		else
			this.lblDosCaret    = new JLabel( new ImageIcon( "images/cartes/dos_BLUE.png" ) );
		
		this.lblCouleur     = new JLabel(this.ctrl.getNomIleDep());
		this.lblCarte       = new JLabel(new ImageIcon());
		majTirage();

		

		/*-----------------------------*/
		/*positonnement des composants */
		/*-----------------------------*/

		//positionnement des elements du panel passe tour
		this.panelPasseTour.add( this.lblDosCaret );
		this.panelPasseTour.add( this.lblCouleur  );
		this.panelPasseTour.add( this.lblCarte    );

		this.add( this.panelPasseTour, BorderLayout.CENTER );
		this.add( this.btnPasseTour,   BorderLayout.SOUTH   );

		/*Activation des composanats*/

		this.btnPasseTour.addActionListener(this);
	}

	public void   changementCarte( JLabel lbl,Icon carte ) { lbl.setIcon(carte); }
	
	public JLabel getLabelCouleur() { return this.lblCouleur ;}
	public JLabel getLabelCarte  () { return this.lblCarte   ;}

	public void majCouleurCarte( )
	{
		if ( this.ctrl.getCouleurJoueur() == Color.red)
			this.lblDosCaret.setIcon( new ImageIcon( "images/cartes/dos_RED.png" ) );
		else
			this.lblDosCaret.setIcon( new ImageIcon( "images/cartes/dos_BLUE.png" ) );
	}

	public void majTirage( )
	{
		String res = ".";
		String[] lienImg = this.ctrl.getPioche(0).toString().split("/");
		for (int i = 1; i < lienImg.length; i++) 
		{
			if(i == 2)
				res += "/Cartes/CarteEnGrand";
			else
			res += "/" + lienImg[i];
		}
		this.lblCarte.setIcon(new ImageIcon(res)) ;
		this.majCouleurCarte();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btnPasseTour)
		{
			this.ctrl.passeTonTour(0);
			
			String res = ".";
			String[] lienImg = this.ctrl.getPioche(0).toString().split("/");
			for (int i = 1; i < lienImg.length; i++) 
			{
				if(i == 2)
					res += "/Cartes/CarteEnGrand";
				else
				res += "/" + lienImg[i];
			}
			this.lblCarte.setIcon(new ImageIcon(res)) ;
			this.ctrl.majCouleur();
			//System.out.println(this.ctrl.getTaillePioche());
			if(this.ctrl.getTaillePioche(0) == 0 && this.ctrl.getFinduJeu(0) == 0)
			{
				this.ctrl.changementCouleur();
			}
			if(this.ctrl.getTaillePioche(0) == 0 && this.ctrl.getFinduJeu(0) == 1)
			{
				JOptionPane.showMessageDialog(null,"Pioche vide, Fin de partie" ); //A changer (j'avais la flemme)
			}

			this.majCouleurCarte();
		}
	}

	public boolean getPasseTour() { return this.aPasseSonTour;  }
	public void    setPasseTour() { this.aPasseSonTour = false; }	
}
