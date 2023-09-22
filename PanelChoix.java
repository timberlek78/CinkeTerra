import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import java.awt.GridLayout;

public class PanelChoix extends JPanel
{
	private JButton btnSolo;
	private JButton btnDuo;
	
	private JMenuBar lstScenario;

	public PanelChoix()
	{
		this.setLayout(new GridLayout(3, 1));
		
		this.btnSolo = new JButton("Mode solo");
		this.btnDuo  = new JButton("Mode duo");


		this.lstScenario = new JMenuBar();

		this.add( this.btnSolo     );
		this.add( this.btnDuo      );
		this.add( this.lstScenario );

	}
}
