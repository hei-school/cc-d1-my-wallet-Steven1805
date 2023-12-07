const readlineSync = require('readline-sync');

let solde = 0;

function afficherSolde() {
    console.log(`Solde actuel : ${solde} euros`);
}

function ajouterArgent() {
    const montant = parseFloat(readlineSync.question('Entrez le montant à ajouter : '));
    if (!isNaN(montant) && montant > 0) {
        solde += montant;
        console.log(`Vous avez ajouté ${montant} euros à votre portefeuille.`);
    } else {
        console.log('Veuillez entrer un montant valide.');
    }
}

function retirerArgent() {
    const montant = parseFloat(readlineSync.question('Entrez le montant à retirer : '));
    if (!isNaN(montant) && montant > 0 && montant <= solde) {
        solde -= montant;
        console.log(`Vous avez retiré ${montant} euros de votre portefeuille.`);
    } else {
        console.log('Veuillez entrer un montant valide ou vérifier votre solde.');
    }
}

function menuPrincipal() {
    while (true) {
        console.log('\nMenu principal :');
        console.log('1. Afficher le solde');
        console.log('2. Ajouter de l\'argent');
        console.log('3. Retirer de l\'argent');
        console.log('0. Quitter');

        const choix = parseInt(readlineSync.question('Choisissez une option : '));

        switch (choix) {
            case 1:
                afficherSolde();
                break;
            case 2:
                ajouterArgent();
                break;
            case 3:
                retirerArgent();
                break;
            case 0:
                console.log('Merci, au revoir !');
                process.exit(0);
            default:
                console.log('Option invalide. Veuillez réessayer.');
        }
    }
}

menuPrincipal();
