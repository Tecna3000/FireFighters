
## Objectif :
Le but de ce projet est d'implémenter un proto-simulateur d'automate cellulaire. On commencera par une
execution sur une grille où les éléments seront des pompiers et des feux. A chaque tour, chaque pompier
éteindra soit tous les feux autour de lui soit se dirigera vers le feu le plus proche et éteindra ensuite le feu autour de lui. Le feu de son côté s'étendra autour de lui tous les deux tours. Le but est de voir en combien de tours les pompiers arriveront à éteindre le feu.

Le but principal de ce projet est de rendre du code qui respecte les principes SOLID.

- <strong>Tâche 1 : </strong><br> 
 Un modèle FireFighters qui devra être étendu avec les fonctionnalités supplémentaires :

- Des nuages qui se déplacent aléatoirement et qui éteignent les feux.
- Des pompiers motorisés qui peuvent se déplacer de deux cases.
- Des cases montagnes qui en sont pas franchissable par le feu ni par les pompiers.
- Des cases routes qui ne sont franchissables que par les pompiers.
- Des cases rocailles sur lesquelles le feu mets quatre tours à se propager.
 <br><br>

- <strong>Tâche 2 : </strong><br>
Implémentation d'un autre modèle au choix avec de nouvelles règles.

# Virus-population-médecin:
- Des virus qui se propagent chaque 2 tour, et qui éliminent les personnes sur leurs chemins.
- Des médecins qui se dirigent vers les virus et les éliminent.
- Des virologistes qui avancent de deux cases et qui éliminent le virus.
- Des personnes malades qui se déplacent aléatoirement et qui contaminent les personnes vaccinées.
- Des personnes vaccinées (VaccinatedPeople) qui ne se déplacent pas et qui ne peuvent pas être contaminées par le virus.
<br> <br>


## Réalisé par :
* [Meriem RAMDANI](https://github.com/Tecna3000/)
