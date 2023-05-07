import java.security.SecureRandom;
import java.util.Scanner;

public class App {

	public static final char O = 'O';
	public static final char X = 'X';

	private static void afficherGrille(char [] grille) {
		System.out.println("[" + grille[0] + '|' + grille[1] + '|' + grille[2] + "]");
		System.out.println("[" + grille[3] + '|' + grille[4] + '|' + grille[5] + "]");
		System.out.println("[" + grille[6] + '|' + grille[7] + '|' + grille[8] + "]");
	}

	public static void main(String[] args) throws Exception {
		char [] grille = 
		{ 
			'1', '2', '3',
			'4', '5', '6',
			'7', '8', '9'
		};

		Scanner scan = new Scanner(System.in);
		int input;

		SecureRandom random = new SecureRandom();
		int nbAleatoire = random.nextInt(2);

		char joueur = X;

		if (nbAleatoire == 1) {
			joueur = O;
		}

		int tour = 1;

		while (tour <= 9) {
			boolean cas1 = joueur == grille[0] && joueur == grille[1] && joueur == grille[2];
			boolean cas2 = joueur == grille[3] && joueur == grille[4] && joueur == grille[5];
			boolean cas3 = joueur == grille[6] && joueur == grille[7] && joueur == grille[8];
			boolean cas4 = joueur == grille[0] && joueur == grille[3] && joueur == grille[6];
			boolean cas5 = joueur == grille[1] && joueur == grille[4] && joueur == grille[7];
			boolean cas6 = joueur == grille[2] && joueur == grille[5] && joueur == grille[8];
			boolean cas7 = joueur == grille[0] && joueur == grille[4] && joueur == grille[8];
			boolean cas8 = joueur == grille[2] && joueur == grille[4] && joueur == grille[6];
			
			afficherGrille(grille);

			if (cas1 || cas2 || cas3 || cas4 || cas5 || cas6 || cas7 || cas8) {
				System.out.println("Le joueur " + joueur + " a gagné ! ");
				break;
			}

			if (joueur == O) {
				joueur = X;
			} else {
				joueur = O;
			}

			System.out.println("Indiquez la position sur laquelle mettre " + joueur + " :");
			input = scan.nextInt();

			boolean positionPrise = true;

			while (positionPrise == true) {
				positionPrise = false;
				if (grille[input-1] == O || grille[input-1] == X) {
					System.out.println("Position déjà prise, indiquez une autre position sur laquelle mettre " + joueur + " : ");
					input = scan.nextInt();
					positionPrise = true;
				}
			}

			grille[input-1] = joueur;
			tour += 1;
		}

		System.out.println("Aucun joueur n'a gagné ! ");
		afficherGrille(grille);


	}
}
