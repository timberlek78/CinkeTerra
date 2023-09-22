
import java.util.ArrayList;

public class Region
{
	private String id;

	private ArrayList<Ile>  ensIle;

	private int sommetVisite;

	private boolean estVisite;

	public Region( String id )
	{
		this.id     = id;
		this.ensIle = new ArrayList<Ile>();
	}

	// Permet d'ajouter à une Région
	public void ajouterIle( Ile ile )
	{
		ile.ajouterReg(this);
		this.ensIle.add(ile);
	}

	// return si la région est visitée ou non
	public boolean estVisite()        { return this.estVisite;  }

	//Retourne le nom de la Région
	public String getId()             { return this.id;         }

	//Retourne les îles d'une même Région
	public ArrayList<Ile> getEnsIle() { return ensIle;          }

	// sommetVisite les sommets de la région étant visités par l'utilisateur
	public void setSommetVisite()     { this.sommetVisite++;    }

	// Permet de modifier le nom de la Région
	public void setId( String id )    { this.id = id;           }

	// estVisite Rend la région non visitée
	public void setVisiteFalse()      { this.estVisite = false; }

	// Region Rend la région visitée si au moin un de ses sommets est visité
	public void setVisite()
	{
		for(Ile n:this.ensIle)
		{
			if(n.aVisite()) 
			{
			
				this.estVisite = true;
			}
		}
	}
		
	// return les sommets de la région étant visités par l'utilisateur
	public int getSommetVisite() { return this.sommetVisite;  }

	// return le nombre de sommets présent dans la région
	public int getNbSommet()     { return this.ensIle.size(); }


}