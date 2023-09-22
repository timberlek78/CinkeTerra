import java.awt.Color;

public class Joueur 
{
	private static int ID = 1;
	private static 	Color clr1 = Color.RED;
	private static 	Color clr2 = Color.BLUE;
	private			Color clrDeb;

	private int id;
	private boolean bOk;
	private int pointRouge;
	private int pointBleu;

	private String nomIleDep;

	private Pioche p;

	public Joueur(Pioche p)
	{
		this.p = p;

		int defColor = (int) (Math.random()*2);

		if(defColor == 0) clrDeb = Joueur.clr1;
		if(defColor == 1) clrDeb = Joueur.clr2;

		if(this.clrDeb.equals(Color.BLUE))
		{
			this.nomIleDep = "Mutaa";
		}
		else
		{
			this.nomIleDep = "Tico"; //Mettre le o avec accent 
		}
		this.id = Joueur.ID++;
	}

	public Joueur(Pioche p, Color coloJoueur)
	{
		this.p = p;

		// int defColor = (int) (Math.random()*2);

		// if(defColor == 0) clrDeb = Joueur.clr1;
		// if(defColor == 1) clrDeb = Joueur.clr2;
		clrDeb = Joueur.clr2;

		if(this.clrDeb.equals(Color.BLUE))
		{
			this.nomIleDep = "Mutaa";
		}
		else
		{
			this.nomIleDep = "Tico"; //Mettre le o avec accent 
		}
	}

	public Color getClrDeb()    { return clrDeb;         }
	public String getNomIleDep(){ return this.nomIleDep; }

	public void setColor(Color colo){this.clrDeb = colo;}
	
	public void setAjoue(boolean verif){this.bOk = verif;}
	public boolean aJoue()             { return this.bOk;}

	public void setClrDeb()
	{
		if(this.clrDeb == Color.RED)  this.clrDeb = Color.BLUE;
		else
			if(this.clrDeb == Color.BLUE) this.clrDeb = Color.RED;
	}

	public int getId(){return this.id;}

	public void setPointRouge(int pts){this.pointRouge = pts;}
	public void setPointBleu (int pts){this.pointBleu  = pts;}

	public int getPointBleu (){return this.pointBleu;}
	public int getPointRouge(){return pointRouge    ;}
}
