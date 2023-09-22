import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class PanelPoint extends JPanel 
{
	private Controleur ctrl;

	private JLabel lblPoint1;
	private JLabel lblPoint2;
	private JLabel lblErreur;

	private JPanel erreurPanel; // Nouveau JPanel pour lblErreur

	public PanelPoint(Controleur ctrl) 
    {
		this.setLayout(new FlowLayout());
		this.ctrl = ctrl;

		/* Création des composants */
		this.lblPoint1 = new JLabel("00");
		this.lblPoint2 = new JLabel("00");
		this.lblErreur = new JLabel("Label Erreur");

		/* Positionnement des composants */
		this.add(new JLabel("Point Bleu :"));
		this.add(this.lblPoint1);
		this.add(new JLabel("Point Rouge  :"));
		this.add(this.lblPoint2);

		// Panel pour lblErreur avec FlowLayout vertical
		erreurPanel = new JPanel();
		erreurPanel.setLayout(new FlowLayout()); // Alignement au centre
		erreurPanel.add(this.lblErreur);

		// Ajouter le panel des erreurs sous les points
		this.add(erreurPanel,FlowLayout.RIGHT);
	}

	
	// Setter des Labels pour la mise à jour des scores
	public void setLabel1(int point) { this.lblPoint1.setText(String.format("%03d", point)); }

	public void setLabel2(int point) { this.lblPoint1.setText(String.format("%03d", point)); }

	// Setter des Labels pour la mise à jour des scores
	public void setLabelBleu (int point) { this.lblPoint1.setText(String.format("%03d", point)); }

	public void setLabelRouge(int point) { this.lblPoint2.setText(String.format("%03d", point)); }

	public void setLabelErreur(String text) 
	{
		String txt = "";
		switch (text) {
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