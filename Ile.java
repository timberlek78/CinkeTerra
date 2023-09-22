import java.awt.Image;
import java.util.ArrayList;

public class Ile 
{
	private static int ID=0;
	private        int id;

	private String nom;
	private String coloIle;

	private boolean visite;

	private Region reg;

	private int posX;
	private int posY;
	private int posXCentre;
	private int posYCentre;

	private Image imgIle;

	private ArrayList<Ile> voisines;

	public Ile(Region reg, String nom, String coloIle, int posX, int posY, int posXCentre, int posYCentre)
	{
		this.nom        = nom;
		this.reg        = reg;
		this.posX       = posX;
		this.posY       = posY;
		this.posXCentre = posXCentre;
		this.posYCentre = posYCentre;

		this.voisines = new ArrayList<Ile>();

		this.coloIle = coloIle;

		this.id = Ile.ID++;
	}

	//Getteurs

	public String getNom() 						{ return nom; }
	
	public int getPosX() 						{ return posX/2; }
	
	public int getPosY() 						{ return posY/2; }
	
	public int getPosXCentre() 					{ return posXCentre/2; }

	public int getPosYCentre() 					{ return posYCentre/2; }

	public Region getReg() 						{ return reg; }

	public ArrayList<Ile> getVoisines() 		{ return voisines; }

	public String getColoIle() 					{ return coloIle; }

	public int getId() 							{ return id; }

	public Image getImgIle() 					{ return imgIle; }

	
	//setteurs
	public void setnom(String nom) 				{ this.nom = nom; }
	
	public void setPosX(int posX) 				{ this.posX = posX; }
	
	public void setPosXCentre(int posXCentre) 	{ this.posXCentre = posXCentre; }
	
	public void setPosY(int posY) 				{ this.posY = posY; }
	
	public void setPosYCentre(int posYCentre) 	{ this.posYCentre = posYCentre; }

	public void setColoIle(String coloIle) 		{ this.coloIle = coloIle; }

	public void setImgIle(Image imgIle)         { this.imgIle = imgIle; }

	//pour definir la region
	public void ajouterReg(Region reg) 
	{
		if(reg == null)
			this.reg = reg;
	}

	//pour les aretes
	public void setVoisines(ArrayList<Ile> voisines) { this.voisines = voisines; }

	/**
	 * @param visite rend le sommet visité lorsque l'utilisateur clique dessus
	 */
	public void estVisite()  {this.visite = true; }
	/**
	 * @return si le sommet est visité ou non
	 */
	public boolean aVisite() { return this.visite; }

	/**
	 * @param visite rend le sommet non visité
	 */
	public void setVisite()  { this.visite = false; }

	public String toString()
	{
		return "nom : " + this.nom + " ( " + this.posX + " : " + this.posY + " ) ";
	}

	
}
