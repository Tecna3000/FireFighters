
## Objectif :
Le but de ce projet est d'implémenter un proto-simulateur d'automate cellulaire. On commencera par une
execution sur une grille où les éléments seront des pompiers et des feux. A chaque tour, chaque pompier
éteindra soit tous les feux autour de lui soit se dirigera vers le feu le plus proche et éteindra ensuite le feu autour de lui. Le feu de son côté s'étendra autour de lui tous les deux tours. Le but est de voir en combien de tours les pompiers arriveront à éteindre le feu.

Le but principal de ce projet est de rendre du code qui respecte les principes SOLID.

- <strong>Tâche 1 : </strong><br> 

- Des nuages qui se déplacent aléatoirement et qui éteignent les feux.
- Des pompiers motorisés qui peuvent se déplacer de deux cases.
- Des cases montagnes qui en sont pas franchissable par le feu ni par les pompiers.
- Des cases routes qui ne sont franchissables que par les pompiers.
- Des cases rocailles sur lesquelles le feu mets quatre tours à se propager.
  
- <strong>Tâche 2 : </strong><br>
Implémentation d'un autre modèle au choix avec de nouvelles règles.

Virus-population-médecin
Pierre-feuille-ciseau : si un élément pierre atteint une case avec un ciseau, le ciseau est détruit etc... le
premier type à éliminer toutes ses cibles gagne.
Tout modèle qui sera validé par votre chargé de TP.
L'objectif de cette seconde partie est de réutilisé tout le code strcuturel du premier modèle.
Ceci est une version préliminaire du projet, des tâches pourront être ajoutées prochainement.
