package frontiere;

import java.util.Iterator;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		int tailleTableau = controlAfficherMarche.donnerNbEtal() * 3;
		String[] infosMarche = new String[tailleTableau];
		infosMarche=controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length==0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
		else {
			System.out.println(nomAcheteur+ ", vous trouverez au marché: ");
			for (int i = 0; i<infosMarche.length; i++) {
				System.out.println("-"+ infosMarche[i] +" qui vend "+ infosMarche[i+1]+" "+ infosMarche[i+2]);
				i+=3;
			}
		}
	}
}
