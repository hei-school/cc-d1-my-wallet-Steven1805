class PortefeuilleVirtuel:
    def __init__(self):
        self.solde = 0

    def afficher_solde(self):
        print(f"Solde actuel : {self.solde} euros")

    def ajouter_argent(self):
        try:
            montant = float(input("Entrez le montant à ajouter : "))
            if montant > 0:
                self.solde += montant
                print(f"Vous avez ajouté {montant} euros à votre portefeuille.")
            else:
                print("Veuillez entrer un montant valide.")
        except ValueError:
            print("Veuillez entrer un montant numérique valide.")

    def retirer_argent(self):
        try:
            montant = float(input("Entrez le montant à retirer : "))
            if 0 < montant <= self.solde:
                self.solde -= montant
                print(f"Vous avez retiré {montant} euros de votre portefeuille.")
            else:
                print("Veuillez entrer un montant valide ou vérifier votre solde.")
        except ValueError:
            print("Veuillez entrer un montant numérique valide.")

    def menu_principal(self):
        while True:
            print("\nMenu principal :")
            print("1. Afficher le solde")
            print("2. Ajouter de l'argent")
            print("3. Retirer de l'argent")
            print("0. Quitter")

            choix = input("Choisissez une option : ")

            if choix == "1":
                self.afficher_solde()
            elif choix == "2":
                self.ajouter_argent()
            elif choix == "3":
                self.retirer_argent()
            elif choix == "0":
                print("Merci, au revoir !")
                break
            else:
                print("Option invalide. Veuillez réessayer.")

if __name__ == "__main__":
    portefeuille = PortefeuilleVirtuel()
    portefeuille.menu_principal()
