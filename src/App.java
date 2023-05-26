import java.security.SecureRandom;
import java.util.Scanner;

public class App {

	public static final char O = 'O';
	public static final char X = 'X';
	public static Scanner entreeInt = new Scanner(System.in);
	public static Scanner entreeStr = new Scanner(System.in);
	public static int input;
	public static String newGame = "O";

	private static void afficherGrille(char [] grille) {
		System.out.println("" + grille[6] + '|' + grille[7] + '|' + grille[8] + "");
		System.out.println("" + "-" + '+' + "-" + '+' + "-" + "");
		System.out.println("" + grille[3] + '|' + grille[4] + '|' + grille[5] + "");
		System.out.println("" + "-" + '+' + "-" + '+' + "-" + "");
		System.out.println("" + grille[0] + '|' + grille[1] + '|' + grille[2] + "");
	}

	public static void main(String[] args) throws Exception {
		
		while(newGame == "O") {
			commencerPartie();
			newGame = "O";
			System.out.println();
			System.out.println("Voulez-vous rejouer ? (O ou N) ");
			newGame = entreeStr.nextLine();
		}

	}

	public static void verificationPositionPrise(char [] grille, char joueur) {
		boolean positionPrise = true;

		while (positionPrise == true) {
			positionPrise = false;
			if (grille[input-1] == O || grille[input-1] == X) {
				System.out.println();
				System.out.println("Position déjà prise, indiquez une autre position sur laquelle mettre " + joueur + " : ");
				input = entreeInt.nextInt();
				positionPrise = true;
			}
		}
	}

	public static boolean verificationJoueurGagne(char [] grille, char joueur) {
		boolean cas1 = joueur == grille[0] && joueur == grille[1] && joueur == grille[2];
		boolean cas2 = joueur == grille[3] && joueur == grille[4] && joueur == grille[5];
		boolean cas3 = joueur == grille[6] && joueur == grille[7] && joueur == grille[8];
		boolean cas4 = joueur == grille[0] && joueur == grille[3] && joueur == grille[6];
		boolean cas5 = joueur == grille[1] && joueur == grille[4] && joueur == grille[7];
		boolean cas6 = joueur == grille[2] && joueur == grille[5] && joueur == grille[8];
		boolean cas7 = joueur == grille[0] && joueur == grille[4] && joueur == grille[8];
		boolean cas8 = joueur == grille[2] && joueur == grille[4] && joueur == grille[6];

		if (cas1 || cas2 || cas3 || cas4 || cas5 || cas6 || cas7 || cas8) {
			System.out.println();
			System.out.println("Le joueur " + joueur + " a gagné ! ");
			return true;
		}

		return false;
	}
	public static void commencerPartie() throws InterruptedException {
		char [] grille = 
		{ 
			' ', ' ', ' ',
			' ', ' ', ' ',
			' ', ' ', ' '
		};
		System.out.println();
		System.out.println("Une nouvelle partie vient de commencer");

		SecureRandom random = new SecureRandom();
		int nbAleatoire = random.nextInt(2);

		char joueur = X;

		if (nbAleatoire == 1) {
			joueur = O;
		}

		int tour = 1;
		boolean gagne = false;

		while (tour < 10 && gagne == false) {			
			
			afficherGrille(grille);

			if (joueur == O) {
				joueur = X;
			} else {
				joueur = O;
			}

			System.out.println();
			System.out.println("Indiquez la position sur laquelle mettre " + joueur + " :");
			input = entreeInt.nextInt();

			verificationPositionPrise(grille, joueur);

			grille[input-1] = joueur;
			tour += 1;
			gagne = verificationJoueurGagne(grille, joueur);
			if (tour == 10 && gagne == false) {
				System.out.println();
				System.out.println("Aucun joueur n'a gagné ! ");
			}
		}

		afficherGrille(grille);
	}
}
