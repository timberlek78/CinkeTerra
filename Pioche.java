import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Pioche
{
	private ArrayList<Carte> pioche;
	private ArrayList<Carte> piochePasSchuffle;

	private int cpt = 0;

	private Carte crt0;
	private Carte crt1;
	private Carte crt2;
	private Carte crt3;
	private Carte crt4;
	private Carte crt5;
	private Carte crt6;
	private Carte crt7;
	private Carte crt8;
	private Carte crt9;
	
	public Pioche()
	{
		this.pioche = new ArrayList<Carte>();
		this.piochePasSchuffle = new ArrayList<Carte>();

		this.crt5 = new Carte("./images/Cartes/carte_brun.png" );
		this.crt6 = new Carte("./images/Cartes/carte_jaune.png");
		this.crt7 = new Carte("./images/Cartes/carte_multi.png");
		this.crt8 = new Carte("./images/Cartes/carte_rouge.png");
		this.crt9 = new Carte("./images/Cartes/carte_verte.png");
		this.crt0 = new Carte("./images/Cartes/carte_b_brun.png" );
		this.crt1 = new Carte("./images/Cartes/carte_b_jaune.png");
		this.crt2 = new Carte("./images/Cartes/carte_b_multi.png");
		this.crt4 = new Carte("./images/Cartes/carte_b_verte.png");
		this.crt3 = new Carte("./images/Cartes/carte_b_rouge.png");



		//Ajout des secondaires
		this.pioche.add(this.crt0);
		this.pioche.add(this.crt1);
		this.pioche.add(this.crt2);
		this.pioche.add(this.crt3);
		this.pioche.add(this.crt4);

		//Ajout des primaires
		this.pioche.add(this.crt5);
		this.pioche.add(this.crt6);
		this.pioche.add(this.crt7);
		this.pioche.add(this.crt8);
		this.pioche.add(this.crt9);

		//Ajout des primaires dans pioche pas mélangée
		this.piochePasSchuffle.add(this.crt5);
		this.piochePasSchuffle.add(this.crt6);
		this.piochePasSchuffle.add(this.crt7);
		this.piochePasSchuffle.add(this.crt8);
		this.piochePasSchuffle.add(this.crt9);

		//Ajout des secondaires dans pioche pas mélangée
		this.piochePasSchuffle.add(this.crt0);
		this.piochePasSchuffle.add(this.crt1);
		this.piochePasSchuffle.add(this.crt2);
		this.piochePasSchuffle.add(this.crt3);
		this.piochePasSchuffle.add(this.crt4);

		//Mélange la pioche
		Collections.shuffle(this.pioche);
	}

	public Pioche(Color coul)
	{
		this.pioche = new ArrayList<Carte>();
		this.piochePasSchuffle = new ArrayList<Carte>();

		this.crt5 = new Carte("./images/Cartes/carte_brun.png" );
		this.crt6 = new Carte("./images/Cartes/carte_jaune.png");
		this.crt7 = new Carte("./images/Cartes/carte_multi.png");
		this.crt8 = new Carte("./images/Cartes/carte_rouge.png");
		this.crt9 = new Carte("./images/Cartes/carte_verte.png");
		this.crt0 = new Carte("./images/Cartes/carte_b_brun.png" );
		this.crt1 = new Carte("./images/Cartes/carte_b_jaune.png");
		this.crt2 = new Carte("./images/Cartes/carte_b_multi.png");
		this.crt4 = new Carte("./images/Cartes/carte_b_verte.png");
		this.crt3 = new Carte("./images/Cartes/carte_b_rouge.png");


		if (coul .equals( Color.blue ))
		{       // faut set la pioche a --> rouge jaune jaune brun vert
			// this.pioche.add(this.crt8);
			this.pioche.add(this.crt7);
			this.pioche.add(this.crt7);
			this.pioche.add(this.crt2);
			this.pioche.add(this.crt0);
			this.pioche.add(this.crt9);
			this.pioche.add(this.crt6);
			this.pioche.add(this.crt6);
			this.pioche.add(this.crt3);
			this.pioche.add(this.crt1);
			this.pioche.add(this.crt4);

			this.piochePasSchuffle.add(this.crt8);
			this.piochePasSchuffle.add(this.crt6);
			this.piochePasSchuffle.add(this.crt1);
			this.piochePasSchuffle.add(this.crt0);
			this.piochePasSchuffle.add(this.crt9);
			this.piochePasSchuffle.add(this.crt5);
			this.piochePasSchuffle.add(this.crt7);
			this.piochePasSchuffle.add(this.crt3);
			this.piochePasSchuffle.add(this.crt2);
			this.piochePasSchuffle.add(this.crt4);

		}
		else    // faut set la pioche a --> jaune rouge vert jaune brun
		{
			this.pioche.add(this.crt6);
			this.pioche.add(this.crt3);
			this.pioche.add(this.crt9);
			this.pioche.add(this.crt1);
			this.pioche.add(this.crt0);
			this.pioche.add(this.crt5);
			this.pioche.add(this.crt7);
			this.pioche.add(this.crt8);
			this.pioche.add(this.crt2);
			this.pioche.add(this.crt4);

			this.piochePasSchuffle.add(this.crt6);
			this.piochePasSchuffle.add(this.crt3);
			this.piochePasSchuffle.add(this.crt9);
			this.piochePasSchuffle.add(this.crt1);
			this.piochePasSchuffle.add(this.crt0);
			this.piochePasSchuffle.add(this.crt5);
			this.piochePasSchuffle.add(this.crt7);
			this.piochePasSchuffle.add(this.crt8);
			this.piochePasSchuffle.add(this.crt2);
			this.piochePasSchuffle.add(this.crt4);
		}
	}

	public Pioche(Pioche p)
	{
		this.pioche = new ArrayList<Carte>();
		this.piochePasSchuffle = new ArrayList<Carte>();
		
		for(Carte c : p.pioche)
		{
			this.pioche.add(c);
		}
		for(Carte c : p.piochePasSchuffle)
		{
			this.piochePasSchuffle.add(c);
		}

		this.crt0 = p.crt0;
		this.crt1 = p.crt1;
		this.crt2 = p.crt2;
		this.crt3 = p.crt3;
		this.crt4 = p.crt4;
		this.crt5 = p.crt5;
		this.crt6 = p.crt6;
		this.crt7 = p.crt7;
		this.crt8 = p.crt8;
		this.crt9 = p.crt9;
	}

	public int nbTours()
	{
		for(int cpt2=0; cpt2 < this.pioche.size(); cpt2++)
		{
			while(	this.pioche.contains(this.crt0) ||
				 	this.pioche.contains(this.crt1) ||
					this.pioche.contains(this.crt2) ||
					this.pioche.contains(this.crt3) ||
					this.pioche.contains(this.crt4) )
			{
				this.cpt++;
			}

		}
		return this.cpt;
	}
	
	public Carte piocher(ArrayList<Carte> p)
	{
		int index = 0;
		for(int i = 0;i<p.size();i++)
		{
			if(this.piochePasSchuffle.get(i) == p.get(0))
			{
				index = i;
			}
		}
		this.piochePasSchuffle.remove(index);
		return p.remove(0);
	}

	public boolean estVide()   { return this.pioche.isEmpty(); }

	public Carte getCarte5()   { return this.crt5;}
	public Carte getCarte6()   { return this.crt6;}
	public Carte getCarte7()   { return this.crt7;}
	public Carte getCarte8()   { return this.crt8;}
	public Carte getCarte9()   { return this.crt9;}

	public boolean finDuTour()
	{
			if(	!(this.pioche.contains(this.crt5)) && 
				!(this.pioche.contains(this.crt6)) && 
				!(this.pioche.contains(this.crt7)) && 
				!(this.pioche.contains(this.crt8)) &&
				!(this.pioche.contains(this.crt9)) ){ return true; }

			return false;
	}
	
	public ArrayList<Carte> getPioche()            { return this.pioche;            }
	public ArrayList<Carte> getPiochePasSchuffle() { return this.piochePasSchuffle; }
}
