import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import java.awt.Color;
import java.awt.geom.Line2D;
import java.io.FileInputStream;
import iut.algo.*;

public class Lecteur 
{
	private Controleur ctrl;
	private Region[] tabRegion = {new Region("EfTera"), new Region("EmTera"), new Region("HelTera"), new Region("KhaTera"), new Region("TéhTera")};

	private Archipel archiPelle;

	private ArrayList<Arete>  ensEdgeColorie;
	private ArrayList<Ile>    ensIleColorie;
	private ArrayList<Region> ensReg;

	private Joueur joueur;

	private Bonus bonus;

	private int cpt;
	private int finDuJeu;
	private int pointsBleu;
	private int pointsRouge;
	private int ndNodeBleu ;
	private int nbRegBleu  ;
	private int nbEdgeBleu ;
	private int nbArete;
	
	private Color coloEdge;

	private Ile extrm1;
	private Ile extrm2;
	private Ile ile1;
	private Ile ile2;
	private Ile ileAffiche;
	private Ile rouge;
	private Ile bleu;

	private boolean quiVerif;

	private Pioche pioche;

	private Carte crtTmp;

	public Lecteur(Controleur ctrl, Pioche p, Joueur j)
	{
		this.ctrl           = ctrl;
		this.ensReg         = new ArrayList<Region>();
		this.ensReg         = this.getTabRegion();
		this.archiPelle     = new Archipel(this);
		this.ensEdgeColorie = new ArrayList<Arete>();
		this.ensIleColorie  = new ArrayList<Ile>();
		this.pioche         = 				p;
		this.joueur         = j;
		this.bonus          = new Bonus(this);


		this.cpt      = 1;
		this.finDuJeu = 0;
		this.crtTmp   = this.pioche.piocher(this.pioche.getPioche());
		this.coloEdge = this.getCouleurJoueur();

		this.lancerLecteur();
	}

	public String getCouleurCarte(){return this.crtTmp.getCouleur();}

	public Lecteur(Controleur ctrl, Pioche p, Color coloJoueur)
	{
		this.archiPelle     = new Archipel(this);
		this.ctrl           = ctrl;
		this.ensReg         = new ArrayList<Region>();
		this.ensReg         = this.getTabRegion();

		this.ensEdgeColorie = new ArrayList<Arete>();
		this.ensIleColorie  = new ArrayList<Ile>();
		this.pioche         = p;
		this.joueur         = new Joueur(this.pioche, coloJoueur);
		this.bonus          = new Bonus(this);


		this.cpt      = 0;
		this.finDuJeu = 0;
		this.crtTmp   = this.pioche.piocher(this.pioche.getPioche());
		this.coloEdge = this.getCouleurJoueur();

		this.lancerLecteur();
	}

	public Lecteur(Controleur ctrl, Pioche p)
	{
		this.ctrl           = ctrl;
		this.ensReg         = new ArrayList<Region>();
		this.ensReg         = this.getTabRegion();
		this.archiPelle     = new Archipel(this);
		this.ensEdgeColorie = new ArrayList<Arete>();
		this.ensIleColorie  = new ArrayList<Ile>();
		this.pioche         = 				p;

		this.joueur         = new Joueur(this.pioche);
		this.bonus          = new Bonus(this);


		this.cpt      = 0;  //le lecteur sait si il y a deux 2 joueurs ou pas
		this.finDuJeu = 0;
		this.crtTmp   = this.pioche.piocher(this.pioche.getPioche());
		this.ctrl.setLog("Première carte pioché: " + this.crtTmp.getCouleur());
		this.coloEdge = this.getCouleurJoueur();

		this.lancerLecteur();
	}

	public void setLog(String sRet)
	{
		this.ctrl.setLog(sRet);
	}

	public Joueur getJoueur(){return this.joueur;}
	public int   getLecteur(){return this.cpt  ;}

	

	public void IncrementeBonusArrete(int e){this.nbArete = this.nbArete + e;}


	public void  passeTonTour() 
	{
		if(this.cpt == 0)
		{
			if(this.pioche.finDuTour())
			{
				if(this.finDuJeu == 1)
				{
					pointsRouge =  this.bonus.setnbMaxBonus()* this.bonus.getNbRegionVisite() + this.getBonusArrete();
					if(cpt == 0)
						this.ctrl .setLabelRouge(pointsRouge);
					this.bonus.remiseAzero();

					//Les deux prochaines lignes permettent l'affichage de la page présente quand la partie est terminée
					this.archiPelle.repaint();
					JOptionPane.showMessageDialog(null,"Partie terminée! Voici vos points:" + "\n" + "Points bleu: " + pointsBleu + "( "  + this.ndNodeBleu + "x" +  this.nbRegBleu +   "+" + this.nbEdgeBleu + " )" +  "\n" + "Points rouge:" + pointsRouge  + "( "  + this.bonus.setnbMaxBonus() + "x" +  this.bonus.getNbRegionVisite() +   "+" + this.getBonusArrete() + " )" ) ;
					this.ctrl.getIhm().dispose();
				}
				this.ctrl.changementCouleur();
			}
			else
				if(!this.pioche.estVide())
					this.crtTmp = this.pioche.piocher(this.pioche.getPioche());
		}


		if(this.cpt == 1)
		{
			if(this.pioche.finDuTour())
			{
				if(this.finDuJeu == 1)
				{
					//Calcul le nombre de point du chemin rouge
					pointsRouge =  this.bonus.setnbMaxBonus()* this.bonus.getNbRegionVisite() + this.getBonusArrete();
					if(cpt == 0)
						this.ctrl .setLabelRouge(pointsRouge);
					this.bonus.remiseAzero();

					//Les deux prochaines lignes permettent l'affichage de la page présente quand la partie est terminée
					this.archiPelle.repaint();
					JOptionPane.showMessageDialog(null,"Partie terminée! Voici vos points:" + "\n" + "Points bleu: " + pointsBleu + "( "  + this.ndNodeBleu + "x" +  this.nbRegBleu +   "+" + this.nbEdgeBleu + " )" +  "\n" + "Points rouge:" + pointsRouge  + "( "  + this.bonus.setnbMaxBonus() + "x" +  this.bonus.getNbRegionVisite() +   "+" + this.getBonusArrete() + " )" ) ;
					this.ctrl.getFrame().dispose();

				}
				this.ctrl.changementCouleurDuo(this.joueur.getId());
			}

			else
			{
				this.joueur.aJoue();
				if(!this.pioche.estVide())
				{
					this.crtTmp = this.pioche.piocher(this.pioche.getPioche());
				}
			}

		}
	}

	


	public void colorEdge(Ile ile1, Ile ile2)
	{
		ArrayList<Arete> ensEdge = this.archiPelle.getEnsEdge();
		this.quiVerif = true ;
		this.ile1 = ile1;
		this.ile2 = ile2;

		for(Arete edge:ensEdge)
		{
			//Verifie que ça va colorier la bonne arete 
			if((edge.getIleDep() == ile1 && edge.getIleArr() == ile2)||(edge.getIleDep() == ile2 && edge.getIleArr() == ile1))
			{
				Line2D areteAverif = new Line2D.Double(ile1.getPosXCentre(), ile1.getPosYCentre(), ile2.getPosXCentre(), ile2.getPosYCentre());
				for(Arete edgeTmp:ensEdgeColorie)
				{
					Line2D verif = new Line2D.Double(edgeTmp.getPosXDep(), edgeTmp.getPosYDep(), edgeTmp.getPosXArr(), edgeTmp.getPosYArr());

						//Verifie les intersections
						if(verif.intersectsLine(areteAverif))
						{
							//Verifie l'adjacence (oui) des deux aretes
							if(!(areteAverif.getP1().equals(verif.getP1()) || 
							     areteAverif.getP1().equals(verif.getP2()) || 
							     areteAverif.getP2().equals(verif.getP1()) ||
							     areteAverif.getP2().equals(verif.getP2())))
							{ 
								this.quiVerif = false;  
								this.ctrl.setLabelErreur("9");
							}
						}

				}
				//Verifie les cycles
				if(ensIleColorie.contains(ile1) && ensIleColorie.contains(ile2))
				{ 
					this.quiVerif = false;  
					this.ctrl.setLabelErreur("4");
				}

				//Verifie u'on ne peut pas repasser sur une arete coloriée
				if(ensEdgeColorie.contains(edge))
				{ 
					this.quiVerif = false; 
					this.ctrl.setLabelErreur("5");
				}

				//Verifie que l'on commence sur la bonne ile en fonction de rouge ou bleu
				if(ensEdgeColorie.size() == 0)
				{
					if(this.joueur.getClrDeb() == Color.BLUE)
					{
						if(!(ile1.getNom().equals("Mutaa") || ile2.getNom().equals("Mutaa"))) 	
						{
							this.quiVerif = false; 
							this.ctrl.setLabelErreur("6");
						}
					}


					if(this.joueur.getClrDeb() == Color.RED)
					{
						if(!(ile1.getNom().equals("Ticó") || ile2.getNom().equals("Ticó"))) 	
						{
							this.quiVerif = false; 
							this.ctrl.setLabelErreur("6");
						}
					}
						
				}

				//Verifie que on trace la suite de la ligne à partir d'une de ses extrémitées
				if(extrm1 != null && extrm2 != null && !((ile1 == extrm1 || ile1 == extrm2) || (ile2 == extrm1 || ile2 == extrm2))) 
				{
					this.quiVerif = false; 
					this.ctrl.setLabelErreur("7");
				}

				//Vérifie le couleur de l'ile cliqué
				if((!this.crtTmp.getCouleur().equals(ile2.getColoIle())) && !crtTmp.getCouleur().equals("Multicolor")) 
				{
					this.quiVerif = false; 
					this.ctrl.setLabelErreur("8");
				}

				//verfication pas jouer 2X
				if(this.cpt == 1 && this.joueur.aJoue())
				{
					this.quiVerif = false;
				}

				//if(cpt == 1 && this.joueur.aJoue())  this.quiVerif = false;

				//Si tt est bon ça applique
				if(this.quiVerif)
				{
					if(ensEdgeColorie.size() == 0)
					{
						this.extrm1 = ile1;
						this.extrm2 = ile2;
					}
					else
					{
						if		(extrm1 == ile1) 
							extrm1 = ile2;
						else if	(extrm1 == ile2) 
							extrm1 = ile1;
						else if	(extrm2 == ile1) 
							extrm2 = ile2;
						else if	(extrm2 == ile2) 
							extrm2 = ile1;
					}
					ile1.estVisite();
					ile2.estVisite();
					verifierRegion();
					

					edge.setColoEdge(joueur.getClrDeb());
					ensEdgeColorie.add(edge);
					if(cpt == 0)
						this.ctrl.setLabelErreur("");

					if(!ensIleColorie.contains(ile1))
						ensIleColorie.add(ile1);
					
					if(!ensIleColorie.contains(ile2))
						ensIleColorie.add(ile2);

					//Compte le nombre d'arrêtes bonus prises
					if(edge.getEstBonus())
					{
						this.IncrementeBonusArrete(1);
					}
					
					if(quiVerif)
					{
						if(this.cpt == 1)
							this.joueur.setAjoue(true);
					}
					if(cpt == 1 && this.ctrl.les2OntJoue())
					{

						if(this.pioche.finDuTour() )
						{
							if(this.finDuJeu == 1)
							{
								//Calcul le nombre de point du chemin rouge
								this.pointsRouge =  this.bonus.setnbMaxBonus()* this.bonus.getNbRegionVisite() + this.getBonusArrete();
								if(cpt == 0)
								{
									this.ctrl .setLabelRouge(this.pointsRouge);
									this.ctrl .setLabelBleu (this.pointsBleu );
								}
								this.bonus.remiseAzero();

								//Les deux prochaines lignes permettent l'affichage de la page présente quand la partie est terminée
								this.archiPelle.repaint();
								JOptionPane.showMessageDialog(null,"Partie terminée! Voici vos points:" + "\n" + "Points bleu: " + this.pointsBleu + "( "  + this.ndNodeBleu + "x" +  this.nbRegBleu +   "+" + this.nbEdgeBleu + " )" +  "\n" + "Points rouge:" + this.pointsRouge  + "( "  + this.bonus.setnbMaxBonus() + "x" +  this.bonus.getNbRegionVisite() +   "+" + this.getBonusArrete() + " )" ) ;
								System.exit(1);
							}
							else
							{

								this.ctrl.setLog("Carte piochée: " + this.crtTmp.getCouleur());
								
								//Calcul le nombre de point du chemin bleu
								int i1 = this.bonus.setnbMaxBonus    ();
								int i2 = this.bonus.getNbRegionVisite();
								int i3 = this.getBonusArrete();
								this.pointsBleu = i1*i2 + i3 ;
								if(cpt == 0)
								{
									this.ctrl.setLabelBleu (this.pointsBleu );
									this.ctrl.setLabelRouge(this.pointsRouge);
								}

								//Réinitialise les arrêtes bonus à 0 pour la seconde phase
								for(Ile n: this.ensIleColorie)
								{
									n.setVisite();
								}
								for(Region r : this.tabRegion)
								{
									r.setVisiteFalse();
								}
							}
							if(cpt == 0 || this.ctrl.les2OntJoue() )
								this.changementCouleur();
						}
						else
						{
							if(cpt == 1 && this.ctrl.getJ1().aJoue()  )
							{
								this.ctrl.verifPasseTour();
								this.ctrl.miseAjourScore();

							}
							if(cpt == 1 )
							{
								this.ctrl.verifPasseTour();
								this.ctrl.miseAjourScore();

							}

							if(cpt == 0 )
							{
								this.joueur.setPointBleu (this.pointsBleu);
								this.joueur.setPointRouge(this.pointsRouge);

								if(cpt == 1)
								{
									this.ctrl.miseAjourScore();
									this.ctrl.getJ1().setAjoue(false);
									this.ctrl.getJ2().setAjoue(false);
								}

								this.crtTmp = this.pioche.piocher(this.pioche.getPioche());
							}	
						}
					}
					else
					{
						if(!(this.pioche.finDuTour()))
							this.crtTmp = this.pioche.piocher(this.pioche.getPioche());
						else
						{
							if(this.finDuJeu == 1)
								{
									this.pointsRouge =  this.bonus.setnbMaxBonus()* this.bonus.getNbRegionVisite() + this.getBonusArrete();
									if(cpt == 0)
									{
										if(this.joueur.getClrDeb().equals(Color.BLUE))
											this.ctrl .setLabelRouge(this.pointsRouge);
										else
											this.ctrl .setLabelBleu (this.pointsBleu);
									}
									else 
										this.ctrl.miseAjourScore();

									this.bonus.remiseAzero();

									//Les deux prochaines lignes permettent l'affichage de la page présente quand la partie est terminée
									this.archiPelle.repaint();
									JOptionPane.showMessageDialog(null,"Partie terminée! Voici vos points:" + "\n" + "Points bleu: " + this.pointsBleu + "( "  + this.ndNodeBleu + "x" +  this.nbRegBleu +   "+" + this.nbEdgeBleu + " )" +  "\n" + "Points rouge:" + this.pointsRouge  + "( "  + this.bonus.setnbMaxBonus() + "x" +  this.bonus.getNbRegionVisite() +   "+" + this.getBonusArrete() + " )" );
									System.exit(1);
								}
							this.changementCouleur();
						}
					}
				}
			}
		}
		this.ctrl.majCouleur();
	}

	public void lancerLecteur()
	{
		ArrayList<Ile> ensIle = new ArrayList<Ile>();
		try
		{
			Scanner sc = new Scanner ( new FileInputStream ( "Donnees.txt" ), "UTF8" );

			String	idIle   = "";
			String	coloIle = "";

			int posX;
			int posY;
			int posXCentre;
			int posYCentre;

			sc.nextLine();
			sc.nextLine();
			while ( sc.hasNextLine() )
			{
				String ligne = sc.nextLine();

				if(!ligne.isEmpty())
				{
					Decomposeur dec = new Decomposeur(ligne);

					if(dec.getChar(0) == 'T')
					{
						idIle = 		dec.getString	(0);
						coloIle = 		dec.getString	(1);
						posXCentre = 	dec.getInt		(2);
						posYCentre = 	dec.getInt		(3);
						posX = 			dec.getInt		(4);
						posY = 			dec.getInt		(5);
		
						Ile ile = new Ile (this.tabRegion[4], idIle, coloIle, posX, posY, posXCentre, posYCentre);
						if(ile.getNom().equals("Ticó")) this.rouge = ile;
						ile.setImgIle(new ImageIcon("./images/" + idIle + ".png").getImage());
						this.archiPelle.addIle(ile);
						ensIle.add(ile);
						this.tabRegion[4].ajouterIle(ile);
					}
					
					if(dec.getChar(0) == 'K')
					{
						idIle = 		dec.getString	(0);
						coloIle = 		dec.getString	(1);
						posXCentre = 	dec.getInt		(2);
						posYCentre = 	dec.getInt		(3);
						posX = 			dec.getInt		(4);
						posY = 			dec.getInt		(5);
		
						Ile ile = new Ile (this.tabRegion[3], idIle, coloIle, posX, posY, posXCentre, posYCentre);
						ile.setImgIle(new ImageIcon("./images/" + idIle + ".png").getImage());
						this.archiPelle.addIle(ile);
						ensIle.add(ile);
						this.tabRegion[3].ajouterIle(ile);
					}
					if(dec.getChar(0) == 'L')
					{
						idIle = 		dec.getString	(0);
						coloIle = 		dec.getString	(1);
						posXCentre = 	dec.getInt		(2);
						posYCentre = 	dec.getInt		(3);
						posX = 			dec.getInt		(4);
						posY = 			dec.getInt		(5);
		
						Ile ile = new Ile (this.tabRegion[2], idIle, coloIle, posX, posY, posXCentre, posYCentre);
						ile.setImgIle(new ImageIcon("./images/" + idIle + ".png").getImage());
						this.archiPelle.addIle(ile);
						ensIle.add(ile);
						this.tabRegion[2].ajouterIle(ile);
					}
					if(dec.getChar(0) == 'M')
					{
						idIle = 		dec.getString	(0);
						coloIle = 		dec.getString	(1);
						posXCentre = 	dec.getInt		(2);
						posYCentre = 	dec.getInt		(3);
						posX = 			dec.getInt		(4);
						posY = 			dec.getInt		(5);
		
						Ile ile = new Ile (this.tabRegion[1], idIle, coloIle, posX, posY, posXCentre, posYCentre);
						ile.setImgIle(new ImageIcon("./images/" + idIle + ".png").getImage());
						if(ile.getNom().equals("Mutaa")) this.bleu = ile;
						this.archiPelle.addIle(ile);
						ensIle.add(ile);
						this.tabRegion[1].ajouterIle(ile);
					}
					if(dec.getChar(0) == 'F')
					{
						idIle = 		dec.getString	(0);
						coloIle = 		dec.getString	(1);
						posXCentre = 	dec.getInt		(2);
						posYCentre = 	dec.getInt		(3);
						posX = 			dec.getInt		(4);
						posY = 			dec.getInt		(5);
		
						Ile ile = new Ile (this.tabRegion[0], idIle, coloIle, posX, posY, posXCentre, posYCentre);
						ile.setImgIle(new ImageIcon("./images/" + idIle + ".png").getImage());
						this.archiPelle.addIle(ile);
						ensIle.add(ile);
						this.tabRegion[0].ajouterIle(ile);
					}
				}	
			}
			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }

		try
		{
			Scanner sc = new Scanner ( new FileInputStream ( "Arete.txt" ), "UTF8" );

				// création et positionnement des arêtes

				while (sc.hasNextLine()) 
				{
					String ligne = sc.nextLine();
					String[] tabStrings = ligne.split("\t");

					for (int i = 1; i < tabStrings.length; i++) 
					{
							this.archiPelle.addEdge(new Arete(ensIle.get(Integer.parseInt(tabStrings[i-1])), ensIle.get(Integer.parseInt(tabStrings[i]))));
					}
				}

			sc.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}

	public void changementCouleur()
	{
		this.pioche = new Pioche();

		this.ensIleColorie = new ArrayList<Ile>();

		this.crtTmp = this.pioche.piocher(this.pioche.getPioche());

		this.ctrl.setLog("Carte piochée: " + this.crtTmp.getCouleur());

		if(this.joueur.getClrDeb() == Color.BLUE)
		{
			this.extrm1 = this.ile1 = this.rouge;
			this.extrm2 = this.ile2 = this.rouge;
		}

		if(this.joueur.getClrDeb() == Color.RED)
		{
			this.extrm1 = this.ile1 = this.bleu;
			this.extrm2 = this.ile2 = this.bleu;
		}
	

		if(this.joueur.getId() == 2)
		{
			this.pioche = this.ctrl.getPiocheAutreJoueur();
			this.crtTmp = this.ctrl.getCarteActuAutreJoueur();
		}

		joueur.setClrDeb();
		this.coloEdge = this.getCouleurJoueur();
		this.nbArete = 0;
		
		this.bonus.zero();
		this.ctrl.miseAjour(true);
		this.finDuJeu++;
	}

	public Joueur setJoueur(Joueur j){return this.joueur = j;}

	public Carte getCarte()         { return this.crtTmp; }

	public int getTaillePioche()    { return this.pioche.getPioche().size(); }

	public int getFinduJeu()        { return this.finDuJeu; }

	public String getNomIleDep()    {return this.joueur.getNomIleDep(); }
	
	public Archipel getArchipel()   { return this.archiPelle;        }

	public Color getCouleurJoueur() { return this.joueur.getClrDeb();}

	public boolean getVerifMode()	{
		if(cpt == 1)
			return this.ctrl.getVerifMode();
		return true;
	}

	public void  setPioche(Pioche p){ this.pioche = p               ;}
	public Carte getPioche()        { return this.pioche.piocher(this.pioche.getPioche())  ;}

	public ArrayList<Region> getEnsReg() { return ensReg; }

	//Cette méthode renvoie le nombre de point par arrete bonus colorier
	public int getBonusArrete()     { return this.nbArete;}

	public ArrayList<Region> getTabRegion()
	{
		for(int cpt = 0; cpt < this.tabRegion.length; cpt++)
		{
			this.ensReg.add(this.tabRegion[cpt]);
		}
		return this.ensReg;
	}


	public void verifierRegion()
	{
		for(Region r :this.ensReg)
		{
			r.setVisite();
		}
	}


	public Pioche getDeck()
	{
		return new Pioche(this.pioche);
	}


	public Carte getCarteActu()
	{
		return this.crtTmp;
	}

	
}