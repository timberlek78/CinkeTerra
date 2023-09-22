import java.awt.Color;
import java.util.ArrayList;

public class Controleur
{
	private Frame ihm;
	private Lecteur metier;

	private Lecteur lctJoueur1;
	private Lecteur lctJoueur2;

	private Joueur j1;
	private Joueur j2;

	private boolean bOk;
	private FrameDuo frame;

	private Pioche pioche1Joueur;
	private Pioche pioche;
	private Pioche pioche2;

	private boolean estFini;
	private int cpt;


	public Controleur()
	{
		
		this.bOk = false;
		this.pioche1Joueur = new Pioche();
		this.metier = new Lecteur(this, this.pioche1Joueur);
		this.ihm    = new Frame ( this );
		this.estFini = true;
	}

	public Controleur(Pioche p, Color coloJoueur)
	{
		this.bOk = false;
		this.metier = new Lecteur(this, p, coloJoueur);
		this.ihm    = new Frame ( this );
		this.estFini = true;
	}

	public Controleur(int i)
	{
		this.bOk = true;

		this.pioche = new Pioche();
		this.pioche2 = new Pioche(this.pioche);

		this.j1 = new Joueur(pioche);
		this.j2 = new Joueur(pioche2);

		this.j1.setColor(Color.RED);
		this.j2.setColor(Color.BLUE);

		this.lctJoueur1 = new Lecteur(this, this.pioche,  j1);
		this.lctJoueur2 = new Lecteur(this, this.pioche2, j2);
	
		this.frame = new FrameDuo(this);
	}
	public boolean les2OntJoue()
	{
		return this.j1.aJoue() && this.j2.aJoue();
	}

	public FrameDuo getFrame() {
		return frame;
	}

	public Frame getIhm() {
		return ihm;
	}

	public String getCouleurCarte(int id)
	{
		if(this.lctJoueur1 != null && id == 0)	
			return "j1:" + this.j1.getNomIleDep();

		if(this.lctJoueur2 != null && id == 1)	
			return "j2:" + this.j1.getNomIleDep();
		
		return null;
	}

	public Archipel getArchi()      { return this.metier.getArchipel();      }

	public Archipel getArchiJoueur1(){return this.lctJoueur1.getArchipel();}

	public Archipel getArchiJoueur2(){return this.lctJoueur2.getArchipel();}


	public ArrayList<Ile> getEnsIle()
	{
		if(this.metier != null && this.metier.getLecteur() == 0 )
		{
			return this.ihm.getEnsIle();
		}
		else
		{
			return this.frame.getEnsIle();
		}

	}

	public void setLog(String sTmp)
	{
		if(this.lctJoueur1 != null && this.lctJoueur1.getLecteur() == 1)
		{
			this.frame.setLog(sTmp);
		}
	}
	public String getLog(){return this.frame.getLog();}

	public Carte getPioche(int id)     
	{
		if(this.metier != null && this.metier.getLecteur() == 0 && id == 0)
		{
			return this.metier.getCarte();
		}
		
		if(this.lctJoueur1 != null && this.lctJoueur2 != null && this.lctJoueur1.getLecteur() == 1 && (id == 1 || id == 2))
		{
			if(id == 1)
				return this.lctJoueur1.getCarte(); 
			else
				return this.lctJoueur2.getCarte();
		}

		return new Carte("POUR PAS QUE SA PLANTE");
	}

	public Carte    getPiocher()    { return this.metier.getPioche();        }

	public Color getCouleurJoueur() { return this.metier.getCouleurJoueur(); }

	public boolean getEstfini()     { return this.estFini;                   }

	public boolean getPasseTour()   { return this.ihm   .getPasseTour();     }


	public void passeTonTour(int id)  
	{
		if(this.metier != null && this.metier.getLecteur() == 0 && id == 0)
		{
			this.metier.passeTonTour();
		}

		if(this.lctJoueur1 != null && this.lctJoueur2 != null && this.lctJoueur1.getLecteur() == 1 && (id == 1 || id == 2))
		{
			if(id == 1)
			{
				this.lctJoueur1.passeTonTour();
				this.lctJoueur1.getJoueur().aJoue();
			}
			else
			{
				this.lctJoueur2.passeTonTour();
				this.lctJoueur2.getJoueur().aJoue();
			}
		}
 	}

	public boolean getVerifMode()	{ return this.bOk;						 }	


	public Lecteur getLecteur(){return this.metier;}

	public void coloEdgecolorEdge(Ile ile1, Ile ile2) { this.metier.colorEdge(ile1, ile2); }

	public void majCouleur()
	{
		if(this.metier != null && this.metier.getLecteur() == 0 )
		{
			this.ihm.majCouleur();
			this.ihm.miseAjour();
		}
		else
		{
			this.frame.majTirage();
			this.frame.miseAjour();
		}
	}

	public void majCouleur2()
	{
		this.frame.majTirage();
		this.frame.miseAjour();
	}

	public void miseAjour()
	{
		if(this.metier != null && this.metier.getLecteur() == 0)
		{
			this.ihm.miseAjour();
		}
		else
		{
			this.frame.miseAjour();
		}
	}

	public void miseAjour(boolean b) 
	{
		if(this.metier != null && this.metier.getLecteur() == 0)
		{
		 	this.ihm.miseAjour(b); 
		}
		else
		{
			this.frame.miseAjour(b); 
		}
	}


	//mettre pour duo?
	public void changementCouleur()  
	{
		this.metier.changementCouleur(); 
	}

	public void changementCouleurDuo(int id)
	{
		if(id == 1)
			this.lctJoueur1.changementCouleur(); 
		else
			this.lctJoueur2.changementCouleur(); 
	}

	public String getLienImg()
	{		

		if(this.cpt == 0)
		{
			this.cpt++;
			return "images/Mutaa.png";
		}
		else
		{
			this.cpt--;
			return "images/Ticó.png";
		}
	}

	public String getNomIleDep() 
	{
		if(this.metier != null && this.metier.getLecteur() == 0)
		{
			return this.metier.getNomIleDep();
		}
		
		if(this.lctJoueur1 != null && this.lctJoueur1.getLecteur() == 1)
		{
			return this.lctJoueur1.getNomIleDep();
		}

		if(this.lctJoueur2 != null && this.lctJoueur2.getLecteur() == 1)
		{
			return this.lctJoueur2.getNomIleDep();
		}
		return null;
	        
	}


	public void setLabel1     ( int point  ) 
	{
		if(this.metier != null && this.metier.getLecteur() == 0)
			this.ihm.setLabel1 (point);
		else
			this.frame.setLabel1 (point);
		 
    }
	public void setLabel2     ( int point  ) 
	{
		if(this.metier != null && this.metier.getLecteur() == 0)
        	this.ihm.setLabel2 (point);
		else 
			this.frame.setLabel1 (point);
		 
    }
	public void setLabelErreur( String txt ) 
	{ 
		if(this.metier != null && this.metier.getLecteur() == 0)
			this.ihm.setLabelErreur(txt);
		else
			this.frame.setLabelErreur(txt);
		
	}


	public int getTaillePioche(int id)
	{
//mettre une id en para pour savoir en multi ( comme passe tour )
		if(this.metier != null && this.metier.getLecteur() == 0 && id == 0)
			return this.metier.getTaillePioche();

		
		if(this.lctJoueur1 != null && this.lctJoueur2 != null && this.lctJoueur1.getLecteur() == 1 && (id == 1 || id == 2))
		{
			if(id == 0)
				return this.lctJoueur1.getTaillePioche();
			else
				return this.lctJoueur2.getTaillePioche();
		}
		return -1;
	}

	public int getFinduJeu    (int id)
	{
		
		if(this.metier != null && this.metier.getLecteur() == 0 && id == 0)
			return this.metier.getFinduJeu()    ;

//mettre une id en para pour savoir en multi ( comme passe tour )
		if(this.lctJoueur1 != null && this.lctJoueur2 != null && this.lctJoueur1.getLecteur() == 1 && (id == 1 || id == 2))
		{
			if(id == 0)
				return this.lctJoueur1.getFinduJeu()    ;
			else
				return this.lctJoueur2.getFinduJeu()    ;

		}
		return -1;
	}

	public Joueur getJ1(){return this.j1;}
	public Joueur getJ2(){return this.j2;}
	public void miseAjourScore(){this.frame.miseAjourScore();}

	public void verifPasseTour(){this.frame.verifPasseTour();}               
	public void setLabelBleu     ( int point  ) { this.ihm.setLabelBleu  (point);  }
	public void setLabelRouge    ( int point  ) { this.ihm.setLabelRouge (point);  }

	public void setPioche		 ( Pioche pio ) { this.metier.setPioche(pio);      }

	public Pioche getPiocheAutreJoueur()
	{
		return this.lctJoueur1.getDeck();
	}

	public Carte getCarteActuAutreJoueur()
	{
		return this.lctJoueur1.getCarteActu();
	}

}