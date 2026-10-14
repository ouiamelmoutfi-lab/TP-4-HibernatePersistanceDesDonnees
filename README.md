# TP4 : Hibernate et persistance des donnees
Dans ce TP, nous avons utilise Hibernate et MySQL pour enregistrer des salles et des machines.
Les captures montrent les etapes du travail et les resultats obtenus.

## Structure du projet

Nous avons cree les entites `Salle` et `Machine`, leurs DAO et leurs services.
La classe `MainTest` permet de lancer l'insertion des donnees.

<img width="562" height="585" alt="Screenshot 2026-10-14 182007" src="https://github.com/user-attachments/assets/9badbcc9-45f3-49a5-8761-5d8e3847d78e" />

## Premiere execution : insertion des donnees

Nous avons execute `MainTest` pour creer la salle `S1` et la machine `M-101` de marque `Dell`.
La console affiche la requete SQL et le message `Donnees inserees avec succes !`.

<img width="670" height="307" alt="Screenshot 2026-10-14 184246" src="https://github.com/user-attachments/assets/5fdcaefd-f585-40bc-85c0-bf4716c7ffb1" />

Nous avons ensuite verifie les tables dans phpMyAdmin. Les tables `salles` et `machines` sont presentes avec une ligne chacune.

<img width="1303" height="199" alt="Screenshot 2026-10-14 184315" src="https://github.com/user-attachments/assets/4dfe829b-5d98-4f66-a5a6-6c7fb8a11d7a" />

## Deuxieme execution : test avec JUnit

Nous avons execute `testCreateSalle` pour creer la salle `S2`, de libelle `Salle Reseau`. Le test reussit.

<img width="1822" height="649" alt="Screenshot 2026-10-14 184805" src="https://github.com/user-attachments/assets/c0c99790-a50c-4172-a1ed-066cfa1a3ed1" />

Dans la table `salles`, nous retrouvons la salle `S1` ajoutee avec `MainTest` et la salle `S2` ajoutee avec le test JUnit.

<img width="330" height="123" alt="Screenshot 2026-10-14 184854" src="https://github.com/user-attachments/assets/6419821e-642c-401f-bc91-92bb0e99d918" />
