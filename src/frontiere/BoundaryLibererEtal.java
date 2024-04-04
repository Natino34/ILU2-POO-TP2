package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu=controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!");
		}
		else {
			String[] donneesEtal = new String[5];
			donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0]=="true") {
				System.out.println("Vous avez vendu "+ donneesEtal[4] +" sur " + donneesEtal[3] +" "+ donneesEtal[2] +".");
				System.out.println("En revoir "+ nomVendeur +", passez une bonne journée");
			}
		}
	}

}
