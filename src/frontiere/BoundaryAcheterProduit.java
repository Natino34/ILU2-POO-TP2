package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit=Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		Gaulois[] vendeurs=controlAcheterProduit.afficherVendeurProduit(produit);
		StringBuilder question = new StringBuilder();
		if(controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			question.append("Je suis désolée "+ nomAcheteur +" mais il faut être un habitant de notre village pour commercer ici.");
		}
		else if (vendeurs.length==0) {
			question.append("Désolé, personne ne vend ce produit au marché.");
		}
		else {
			question.append("Chez quel commerçant voulez-vous acheter des fleurs ?\n");
			for(int i=0; i<vendeurs.length; i++) {
			question.append("- "+ vendeurs[i].getNom());
			}
			int numVendeur=Clavier.entrerEntier(question.toString());
			if(!controlAcheterProduit.verifierIdentite(vendeurs[numVendeur].getNom())){
				System.out.println("Je suis désolé "+ vendeurs[numVendeur].getNom() +" mais il faut être un habitant de notre village pour commercer ici");
			}
			else {
				System.out.println(nomAcheteur +" se déplace jusqu'à l'étal du vendeur "+ vendeurs[numVendeur].getNom());
				int achatNbProduit = Clavier.entrerEntier("Bonjour "+ nomAcheteur +"\n combien de fleurs voulez-vous acheter ?");
				int nbProduit = controlAcheterProduit.acheterProduit(vendeurs[numVendeur].getNom(), achatNbProduit);
				if(nbProduit == 0) {
					System.out.println(nomAcheteur +" veut acheter " + achatNbProduit +" "+ produit +", malheureusement il n'y en a plus !");
				}
				else if(achatNbProduit>nbProduit) {
					System.out.println(nomAcheteur +" veut acheter "+ achatNbProduit +" "+ produit +", malheureusement "+ vendeurs[numVendeur].getNom() +" n'en a plus que 3. "+ nomAcheteur +" achète tout le stock de Bonemine");
				}
				else {
					System.out.println(nomAcheteur +" achète "+ nbProduit +" "+ produit +" à "+ vendeurs[numVendeur].getNom() +"."); 
				}
			}
		}
	}
}
