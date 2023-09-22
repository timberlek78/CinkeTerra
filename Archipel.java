import java.util.ArrayList;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Archipel extends JPanel implements MouseListener
{
	private ArrayList<Ile> ensIle;
	private ArrayList<Arete> ensEdge;
	private Lecteur lecteur;

	//Variable pour une vérification dans le mouseListener
	private Ile ileTmp;
	private Ile ileTmp1;
	private Ile ileTmp2;
	private boolean verif;
	

	public Archipel(Lecteur lctr)
	{
		this.lecteur = lctr;

		this.ensIle  = new ArrayList<Ile>  ();
		this.ensEdge = new ArrayList<Arete>();
		this.verif = this.lecteur.getVerifMode();
		this.setBackground(new Color(182, 211, 229));
		this.addMouseListener(this);
	}
	
	public boolean hasEdge(Ile il1, Ile il2)
	{
		for (Arete e:this.ensEdge)
		{
			if(e.getIleDep() == il1 && e.getIleArr() == il2)
				return true;
		}
		return false;
	}

	public ArrayList<Ile> getEnsIle(){return this.ensIle;}
	public void addIle(Ile n)               { this.ensIle .add(n); }

	public void addEdge(Arete e)            { this.ensEdge.add(e); }

	public Ile getIle1()                    { return this.ileTmp1; }

	public Ile getIle2()                    { return this.ileTmp2; }
		
	public ArrayList<Arete> getEnsEdge()    { return this.ensEdge; }

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		//Création des  arrêtes
		g2d.setStroke(new BasicStroke(2));
		for(Arete a: this.ensEdge)
		{
			g2d.setColor(a.getColoEdge());
			
			if(this.verif == true)
				g2d.drawLine((int)(a.getPosXDep()/(double)(1.15)),(int)(a.getPosYDep()/(double)(1.15)), (int)(a.getPosXArr()/(double)(1.15)), (int)(a.getPosYArr()/(double)(1.15)));
			else
				g2d.drawLine(a.getPosXDep(), a.getPosYDep(), a.getPosXArr(), a.getPosYArr());
		}

		//Création des iles
		for(Ile ile: this.ensIle)
		{
			if(this.verif == true)
			{
				g2d.drawImage(ile.getImgIle(), (int)(ile.getPosX()/(double)(1.15)), (int)(ile.getPosY()/(double)(1.15)), 75, 57, this);
				g2d.setColor(Color.BLACK);
				g2d.drawString(ile.getNom(), (int)(ile.getPosX()/(double)(1.15))+25, (int)(ile.getPosY()/(double)(1.15))+65);
			}
			else
			{
				g2d.drawImage(ile.getImgIle(), ile.getPosX(), ile.getPosY(), 75, 57, this);
				g2d.setColor(Color.BLACK);
				g2d.drawString(ile.getNom(), ile.getPosX()+25, ile.getPosY()+65);
			}
		}

	}

	
	public void mouseClicked(MouseEvent e) 
	{
		int x = e.getX();
		int y = e.getY();

		for(int cpt=0; cpt < ensIle.size(); cpt++)
		{
			if(this.verif == true)
			{
				if(	(int)(ensIle.get(cpt).getPosXCentre()/(double)(1.15)) < x+25 &&
					(int)(ensIle.get(cpt).getPosXCentre()/(double)(1.15)) > x-25 &&
					(int)(ensIle.get(cpt).getPosYCentre()/(double)(1.15)) > y-25 &&
					(int)(ensIle.get(cpt).getPosYCentre()/(double)(1.15)) < y+25 )
				{
					if(this.ileTmp != null)
					{
						this.lecteur.setLog("Deuxième île sélectionnée: " + this.ensIle.get(cpt).getNom());
						this.ileTmp1 = this.ileTmp;
						this.ileTmp2 = ensIle.get(cpt);
						this.lecteur.setLog("Création d'une nouvelle arête: " + this.ileTmp.getNom() + "<->" + this.ensIle.get(cpt).getNom());
						this.lecteur.colorEdge(this.ileTmp, ensIle.get(cpt));
						this.ileTmp = null;
						this.repaint();
					}
					else
					{
						if(this.ileTmp == null )
						{
							this.ileTmp = ensIle.get(cpt);
							this.lecteur.setLog("Première île sélectionnée: " + this.ileTmp.getNom());
						}
						else
						{
							if(this.ileTmp == ensIle.get(cpt))
								this.ileTmp = null;
						}
					}
				
				}
			}
			else
			{
				if(	ensIle.get(cpt).getPosXCentre() < x+25 &&
					ensIle.get(cpt).getPosXCentre() > x-25 &&
					ensIle.get(cpt).getPosYCentre() > y-25 &&
					ensIle.get(cpt).getPosYCentre() < y+25 )
				{
					if(this.ileTmp != null)
					{
						this.ileTmp1 = this.ileTmp;
						this.ileTmp2 = ensIle.get(cpt);
						this.lecteur.colorEdge(this.ileTmp, ensIle.get(cpt));
						this.ileTmp = null;
						this.repaint();
					}
					else
					{
						if(this.ileTmp == null )
						{
							this.ileTmp = ensIle.get(cpt);
						}
						else
						{
							if(this.ileTmp == ensIle.get(cpt))
								this.ileTmp = null;
						}
					}
				
				}
			}

		}
	}


	
	public void mousePressed	(MouseEvent e) {}
	public void mouseReleased	(MouseEvent e) {}
	public void mouseEntered	(MouseEvent e) {}
	public void mouseExited		(MouseEvent e) {}
}
