# Projet_Java_Bryan_Moreau
Une interface graphique a été ajoutée au projet initial</br></br>
J'ai considéré que les types de produit n'avaient aucune influence sur celui-ci (pas de fonctionnalité spéciale/secondaire), le type est donc juste un attribut String dans la classe Produit</br></br>
Il faut avoir JAVA 16 et Maven</br></br>
Si vous êtes sur eclipse ou intellij vous avez juste à aller sur la classe Main et cliquez sur run</br>
Sinon, il faut aller dans un CMD et installer les librairies grâce à <b>mvn install</b>, puis lancer l'application en allant dans le dossier target et en écrivant <b>java -jar TpJava-0.0.1-SNAPSHOT.jar</b></br></br>
Les deux clients présent dans la base de données ont comme numéro client 21 et 1 </br></br>
Les difficultés rencontrées sont :</br>
- un problème d’enregistrement et de récupération de l’historique des commandes (qui à été réglé)</br>
- un problème d'utilisation des threads avec JavaFX (réglé)</br>
- un problème avec les sleeps qui bloquait l'interface JavaFX (réglé) </br>
- un problème avec la récupération des historiques de commandes liée à l'aspect classe générique (réglé) </br>
