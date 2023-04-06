package hitema.java;

import java.util.Scanner;

public class Morpion {
    public static String[][] elements = new String[3][3];

    public static void affichageTableau(){
        System.out.print("\n");
        for(int k=0; k<=2; k++) {
            for(int j=0; j<=2; j++) {
                System.out.print("     ");
                if(j==0) {
                    System.out.print(elements[k][j]+"     |\t");
                }
                if(j==1) {
                    System.out.print(elements[k][j]+"        |\t");
                }
                if(j==2) {
                    System.out.print(elements[k][j]+"\t");
                }
                if(j==2 && k<2) {
                    System.out.print("\n___________|__________________|______________\n");
                }
                if(k==2 && j==2){
                    System.out.println("\n           |                  |              \n");
                }
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        Boolean continuerPartie = true;

        do{

            Scanner saisie = new Scanner(System.in);
            String[][] joueur1 = new String[3][3];
            String[][] joueur2 = new String[3][3];

            String choixSymbole="";
            while(!(choixSymbole.toUpperCase().equals("X") || choixSymbole.toUpperCase().equals("O")) ) {
                System.out.print("Joueur 1 choissisez symbole soit X soit O: ");
                choixSymbole = saisie.nextLine();
            }

            String joueur1_symbole = choixSymbole.toUpperCase();
            String joueur2_symbole="";
            if(joueur1_symbole.equals("O")) {
                joueur2_symbole="X";
            }
            if(joueur1_symbole.equals("X")) {
                joueur2_symbole="O";
            }


            for(int i=0; i<=2; i++) {
                for(int j=0; j<=2; j++) {
                    elements[i][j] = " ";
                    joueur1[i][j] = "";
                    joueur2[i][j] = "";
                }
            }


            affichageTableau();//affichage du tableau non rempli

            String joueurActuel = "joueur1";
            int tour = 1;
            int nombreCoup=1;
            boolean victoire = false;
            String vainqueur="";

            while(nombreCoup<10 && victoire!=true) {
                System.out.print("\nAu tour du "+joueurActuel+"\n");

                int ligne, colonne, verification=0;
                Boolean verificationEntree = true;

                //verification de l'entre de l'utilisateur
                do {
                    if(verification!=0) {
                        System.out.print("\nIl y a deja un symbole a cette emplacement\n");
                    }
                    do{
                        System.out.print("Entrer la ligne: ");
                        ligne = saisie.nextInt();

                        System.out.print("Entrer la colonne: ");
                        colonne = saisie.nextInt();

                        if(ligne>3 || ligne<=0 || colonne>3 || colonne<=0){
                            System.out.print("\nLes lignes et les colonnes sont compris entre 1 et 3\n");
                        }

                    }while(ligne>3 || ligne<=0 || colonne>3 || colonne<=0);

                    verification++;
                }while(!elements[ligne-1][colonne-1].equals(" "));

                if(joueurActuel.equals("joueur1")) {
                    elements[ligne-1][colonne-1] = joueur1_symbole;
                }
                if(joueurActuel.equals("joueur2")) {
                    elements[ligne-1][colonne-1] = joueur2_symbole;
                }

                if(joueurActuel.equals("joueur1")) {
                    joueur1[ligne-1][colonne-1] = joueur1_symbole;
                }
                else if(joueurActuel.equals("joueur2")) {
                    joueur2[ligne-1][colonne-1] = joueur2_symbole;
                }
                /*fin de la memorisation des coups de joueurs*/


                affichageTableau();/*Affichage des elements du tableau*/


                /*debut de la verification de la victoire*/

                if(joueurActuel.equals("joueur1")) {
                    /*Ici on teste toutes les conditions de victoire pour le joueur 1*/
                    if(joueur1[0][0].equals(joueur1_symbole) && joueur1[0][1].equals(joueur1_symbole) && joueur1[0][2].equals(joueur1_symbole) ){
                        victoire = true;
                    }

                    if(joueur1[1][0].equals(joueur1_symbole) && joueur1[1][1].equals(joueur1_symbole) && joueur1[1][2].equals(joueur1_symbole) ){
                        victoire = true;
                    }

                    if(joueur1[2][0].equals(joueur1_symbole) && joueur1[2][1].equals(joueur1_symbole) && joueur1[2][2].equals(joueur1_symbole) ){
                        victoire = true;
                    }

                    if(joueur1[0][0].equals(joueur1_symbole) && joueur1[1][1].equals(joueur1_symbole) && joueur1[2][2].equals(joueur1_symbole) ){
                        victoire = true;
                    }

                    if(joueur1[0][2].equals(joueur1_symbole) && joueur1[1][1].equals(joueur1_symbole) && joueur1[2][0].equals(joueur1_symbole) ){
                        victoire = true;
                    }

                    if(joueur1[0][0].equals(joueur1_symbole) && joueur1[1][0].equals(joueur1_symbole) && joueur1[2][0].equals(joueur1_symbole) ){
                        victoire = true;
                    }

                    if(joueur1[0][1].equals(joueur1_symbole) && joueur1[1][1].equals(joueur1_symbole) && joueur1[2][1].equals(joueur1_symbole) ){
                        victoire = true;
                    }

                    if(joueur1[0][2].equals(joueur1_symbole) && joueur1[1][2].equals(joueur1_symbole) && joueur1[2][2].equals(joueur1_symbole) ){
                        victoire = true;
                    }

                }
                if(joueurActuel.equals("joueur2")) {
                    /*Ici on teste toutes les conditions de victoire pour le joueur 2*/
                    if(joueur2[0][0].equals(joueur2_symbole) && joueur2[0][1].equals(joueur2_symbole) && joueur2[0][2].equals(joueur2_symbole) ){
                        victoire = true;
                    }

                    else if(joueur2[1][0].equals(joueur2_symbole) && joueur2[1][1].equals(joueur2_symbole) && joueur2[1][2].equals(joueur2_symbole) ){
                        victoire = true;
                    }

                    else if(joueur2[2][0].equals(joueur2_symbole) && joueur2[2][1].equals(joueur2_symbole) && joueur2[2][2].equals(joueur2_symbole) ){
                        victoire = true;
                    }

                    else if(joueur2[0][0].equals(joueur2_symbole) && joueur2[1][1].equals(joueur2_symbole) && joueur2[2][2].equals(joueur2_symbole) ){
                        victoire = true;
                    }

                    else if(joueur2[0][2].equals(joueur2_symbole) && joueur2[1][1].equals(joueur2_symbole) && joueur2[2][0].equals(joueur2_symbole) ){
                        victoire = true;
                    }

                    else if(joueur2[0][0].equals(joueur2_symbole) && joueur2[1][0].equals(joueur2_symbole) && joueur2[2][0].equals(joueur2_symbole) ){
                        victoire = true;
                    }

                    if(joueur2[0][1].equals(joueur2_symbole) && joueur2[1][1].equals(joueur2_symbole) && joueur2[2][1].equals(joueur2_symbole) ){
                        victoire = true;
                    }

                    if(joueur2[0][2].equals(joueur2_symbole) && joueur2[1][2].equals(joueur2_symbole) && joueur2[2][2].equals(joueur2_symbole) ){
                        victoire = true;
                    }
                }
                /*fin de la verification de la victoire*/

                if(victoire==true) {
                    vainqueur=joueurActuel;
                }

                /*Attribution du tour*/
                tour++;
                if(tour%2 == 0) {
                    joueurActuel = "joueur2";
                }
                else {
                    joueurActuel = "joueur1";
                }
                /*Fin d'attribution du tour*/
                nombreCoup++;
            }

            /*La partie est terminée, on affiche le nom du vainqueur s'il n'y a pas de match nul*/
            if(victoire==false) {
                System.out.print("\nMatch nul\n\n------Nouvelle Partie----------\n\n");
            }
            else if(victoire==true) {
                System.out.print("\nLe vainqueur est: "+vainqueur+"\n\n------Nouvelle Partie----------\n\n");
            }

        }while(continuerPartie==true);
    }
}