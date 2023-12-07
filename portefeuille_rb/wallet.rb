class PortefeuilleVirtuel
    def initialize
      @solde = 0
    end
  
    def afficher_solde
      puts "Solde actuel : #{@solde} euros"
    end
  
    def ajouter_argent
      print "Entrez le montant à ajouter : "
      montant = gets.chomp.to_f
  
      if montant > 0
        @solde += montant
        puts "Vous avez ajouté #{montant} euros à votre portefeuille."
      else
        puts "Veuillez entrer un montant valide."
      end
    end
  
    def retirer_argent
      print "Entrez le montant à retirer : "
      montant = gets.chomp.to_f
  
      if 0 < montant && montant <= @solde
        @solde -= montant
        puts "Vous avez retiré #{montant} euros de votre portefeuille."
      else
        puts "Veuillez entrer un montant valide ou vérifier votre solde."
      end
    end
  
    def menu_principal
      loop do
        puts "\nMenu principal :"
        puts "1. Afficher le solde"
        puts "2. Ajouter de l'argent"
        puts "3. Retirer de l'argent"
        puts "0. Quitter"
  
        print "Choisissez une option : "
        choix = gets.chomp
  
        case choix
        when "1"
          afficher_solde
        when "2"
          ajouter_argent
        when "3"
          retirer_argent
        when "0"
          puts "Merci, au revoir !"
          break
        else
          puts "Option invalide. Veuillez réessayer."
        end
      end
    end
  end
  
  # Lancement du programme
  portefeuille = PortefeuilleVirtuel.new
  portefeuille.menu_principal
  