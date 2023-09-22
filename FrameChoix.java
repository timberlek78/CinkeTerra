import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrameChoix extends JFrame
{
	private PanelLanceur pnl;
	public FrameChoix()
	{
		this.setTitle   ( "Choix du mode de jeux");
		this.setSize    (500,300 );
		this.setLocation(  475, 90 );
		this.setIconImage(new ImageIcon(getClass().getResource("./images/btnMenu/icone.png")).getImage());

		this.pnl = new PanelLanceur();

		this.add(this.pnl);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Active la vivibilité de la frame 
		this.setVisible(true);
		this.pack();
	}

	public static void main(String[] args) 
	{
		new FrameChoix();
	}
}
