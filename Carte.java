public class Carte 
{
	private static int IDCARTE;
	private        int idCarte;

	private String lienImg;

	public Carte(String lienImg)
	{
		this.lienImg =  lienImg;
		this.idCarte = Carte.IDCARTE++;
	}

	/**
	 * @return the lienImg
	 */
	public String getLienImg() { return lienImg; }

	/**
	 * @return the idCarte
	 */
	public int getIdCarte()    { return idCarte; }

	/**
	 * @param lienImg the lienImg to set
	 */
	public void setLienImg(String lienImg) { this.lienImg = lienImg; }

	public String getCouleur()
	{
		switch(this.lienImg)
		{
			case "./images/Cartes/carte_b_brun.png" 	: return "Brun";
			case "./images/Cartes/carte_b_jaune.png" 	: return "Jaune";
			case "./images/Cartes/carte_b_multi.png" 	: return "Multicolor";
			case "./images/Cartes/carte_b_rouge.png" 	: return "Rouge";
			case "./images/Cartes/carte_b_verte.png" 	: return "Vert";
			case "./images/Cartes/carte_brun.png"  		: return "Brun";
			case "./images/Cartes/carte_jaune.png" 		: return "Jaune";
			case "./images/Cartes/carte_multi.png" 		: return "Multicolor";
			case "./images/Cartes/carte_rouge.png" 		: return "Rouge";
			case "./images/Cartes/carte_verte.png" 		: return "Vert";
		}
		return null;

	}


	@Override
	public String toString() { return "" + this.lienImg; }
}
