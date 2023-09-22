import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameHelp extends JFrame
{

	
	public FrameHelp ()
	{
		PanelHelp panelHelp;
		
		this.setLayout(new BorderLayout());
		this.setTitle   ( "Help");
		this.setSize    ( 820,540 );
		this.setLocation(  50, 50 );
		this.setIconImage(new ImageIcon(getClass().getResource("./images/btnMenu/icone.png")).getImage());

		panelHelp = new PanelHelp();
		this.add(panelHelp);
		this.pack();
		this.setVisible(true);
		
	}


}
   