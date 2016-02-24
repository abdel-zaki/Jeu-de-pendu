# Jeu-de-pendu
ça se joue à deux joueurs et consiste à trouver un mot en devinant quelles sont les lettres qui le composent. Quand le dessin est terminé on voit un bonhomme allumette pendu.

Ceci est mon propre essai de coder ce jeu en Java, ce travail est organisé en 4 classes :

La Classe Dessin de type JPanel qui se charge du dessin du bonhomme allumette
La Classe Interface de type JPanel qui inclut un objet de type Dessin et compète le reste de l'interface utilisateur
La Classe Application contenant la méthode principale main() et d'autres procédures et fonctions qui font les traitements nécessaires
La Classe Adaptateur implémente des interfaces d'éventements utilisateur (clavier et souri) et gère les interactions entre les classes Interface et Application (appel des procédures / fonctions appropriées aux éventements exécutés par l'utilisateur)
