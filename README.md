# Kata Puissance 4
L'objectif de ce kata est de réaliser le jeu Puissance 4

L'implémentation proposée consiste en :
- Une grille
- Un analyseur
- Un arbitre
- Une application
- Une vue

Les responsabilités de ces différents éléments sont :

## Grille
Une grille de Puissance 4 :
- donne l’état de ses 42 cellules (7 colonnes de 6 rangées)
- accepte jusqu’à 6 jetons dans une colonne
- se vide
- se représente sous forme de texte

## Analyseur
Un Analyseur de Puissance 4 :
- collabore avec une grille
- sait si un joueur a gagné :
  - ligne de 4 jetons de même couleur
  - horizontale, verticale, diagonale vers le haut, 
- diagonale vers le bas
- sait si la partie est nulle (grille est remplie, aucune ligne gagnante)

## Arbitre
Un Arbitre de Puissance 4 :
- dit à qui le tour de jouer (jaune ou rouge)
- Jaune commence la partie
- entre le coup du joueur courant 
- sait si la partie est en cours, gagnée (et par quel joueur) ou nulle

## Application
Une Application Puissance 4 :
- produit les affichages sur la console :
- la grille 
- a qui le tour ("JAUNE" ou "ROUGE")
- accepte à la console le numéro de colonne à jouer
- s’arrête lorsque la partie est gagnée ou nulle
- affiche le résultat de la partie (gagnant ou nulle)

## Vue
Une Vue Puissance 4 :
- envoie des messages (String) à la console
- reçoit des commandes (String) de la console

Supprimer le couplage entre la classe Application et la Console système

La classe Application :
- assure la boucle de jeu
- collabore avec un Arbitre, une Grille, une Vue
