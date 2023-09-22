
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrameScenar extends JFrame
{
	private PanelScenar pnlScenar;
	private Controleur ctrl;

	public FrameScenar(Controleur ctrl)
	{
		this.setLocation(860, 350);
		this.setSize(50, 70);
		this.ctrl = ctrl;

		this.pnlScenar = new PanelScenar(this.ctrl);
		this.add(this.pnlScenar);
		this.setIconImage(new ImageIcon(getClass().getResource("./images/btnMenu/icone.png")).getImage());

		this.setVisible(true);
	}
}
