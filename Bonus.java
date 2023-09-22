import java.util.ArrayList;

public class Bonus 
{
	private Lecteur metier;
	private int nbMaxBonus;
	private int nbArete;
	private int nbRegVis;

	private ArrayList<Region> ensReg;

	public Bonus(Lecteur metier)
	{
		this.metier     = metier;
		this.nbMaxBonus = 0;
		this.nbArete    = 0;
		this.nbRegVis   = 0;
		this.ensReg     = this.metier.getEnsReg();
	}


	//Compte le nombre de sommets max visités dans une région
	public int setnbMaxBonus() //ca marche
	{
		int cpt2;
		for(Region r: this.ensReg)
		{
			cpt2 = 0;
			for(Ile i: r.getEnsIle())
			{
				if(i.aVisite())
				{
					cpt2++;
				}
			}
			if(cpt2 > this.nbMaxBonus) 
			{
				this.nbMaxBonus = cpt2;
			}
		}
		return this.nbMaxBonus;
	}

	//Cette méthode permet d'incrementer le nombre d'arrete bonus colorier
	public void IncrementeBonusArrete()     { this.nbArete++;      }

	//Cette méthode renvoie le nombre de point par arrete bonus colorier
	public int getBonusArrete()             { return this.nbArete; }

	//Reinitialise 
	public void remiseAzero()               { this.nbArete = 0;    }

	public void zero()
	{
		this.nbMaxBonus = 0;
		this.nbArete    = 0;
		this.nbRegVis   = 0;
	}

	//Compte le nombre de régions visitées
	public int getNbRegionVisite()
	{
		int cpt=0;
		for(Region r: this.ensReg)
		{
			if(r.estVisite()) 
			{
				cpt++;
			}
		}
		this.nbRegVis = cpt;
		return cpt;
	}


}
