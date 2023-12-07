import java.util.Scanner;

public class Wallet {
    private double solde;

    public Wallet() {
        this.solde = 0;
    }

    public void afficherSolde() {
        System.out.println("Solde actuel : " + solde + " euros");
    }

    public void ajouterArgent() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Entrez le montant à ajouter : ");
            double montant = scanner.nextDouble();
            if (montant > 0) {
                solde += montant;
                System.out.println("Vous avez ajouté " + montant + " euros à votre portefeuille.");
            } else {
                System.out.println("Veuillez entrer un montant valide.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Veuillez entrer un montant numérique valide.");
            scanner.nextLine(); // Clear the input buffer
        }
    }

    public void retirerArgent() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Entrez le montant à retirer : ");
            double montant = scanner.nextDouble();
            if (0 < montant && montant <= solde) {
                solde -= montant;
                System.out.println("Vous avez retiré " + montant + " euros de votre portefeuille.");
            } else {
                System.out.println("Veuillez entrer un montant valide ou vérifier votre solde.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Veuillez entrer un montant numérique valide.");
            scanner.nextLine();
        }
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu principal :");
            System.out.println("1. Afficher le solde");
            System.out.println("2. Ajouter de l'argent");
            System.out.println("3. Retirer de l'argent");
            System.out.println("0. Quitter");

            System.out.print("Choisissez une option : ");
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    afficherSolde();
                    break;
                case "2":
                    ajouterArgent();
                    break;
                case "3":
                    retirerArgent();
                    break;
                case "0":
                    System.out.println("Merci, au revoir !");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    public static void main(String[] args) {
        Wallet portefeuille = new Wallet();
        portefeuille.menuPrincipal();
    }
} 
