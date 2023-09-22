import java.awt.Color;

public class Arete
{
	private static int IDARETE=0;
	private int id;
	private boolean estBonus;

	private Ile ileDep;
	private Ile ileArr;

	private Color coloEdge;

	public Arete(Ile ile1, Ile ile2)
	{
		this.id = id;
		
		this.ileDep = ile1;
		this.ileArr = ile2;

		this.coloEdge = new Color(255, 150, 150);
		this.id = Arete.IDARETE++;
	}

	/**
	 * @return l'identifiant de l'arête
	 */
	public int getId()         { return this.id;  }

	//Retourne l'Ile de d'arriver
	public Ile getIleArr()     { return ileArr;   }

	//Retourne l'Ile de départ
	public Ile getIleDep()     { return ileDep;   }

	//Retourne la couleur de l'arete
	public Color getColoEdge() { return coloEdge; }

	
	//Retourne la position X de l'Ile de départ
	public int getPosXDep()    { return this.ileDep.getPosXCentre(); }

	//Retourne la position X de l'Ile d'arriver
	public int getPosXArr()    { return this.ileArr.getPosXCentre(); }

	//Retourne la position Y de l'Ile de départ
	public int getPosYDep()    { return this.ileDep.getPosYCentre(); }

	//Retourne la position Y de l'Ile d'arriver 
	public int getPosYArr()    { return this.ileArr.getPosYCentre(); }

	//Permet de changer la couleur de l'arrete 
	public void setColoEdge(Color coloEdge) { this.coloEdge = coloEdge; }

	//renvoie que l'arrête est une arête bonus!
	public void setBonus()       { this.estBonus = true;}
	public boolean getEstBonus() {return this.estBonus ;}
}
