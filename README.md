TV Series Explorer

Projet Android – Jetpack Compose
Auteurs : Clément.F & Julien.R

1. Présentation du projet

TV Series Explorer est une application Android développée en Kotlin avec Jetpack Compose.
Elle permet de rechercher des séries TV, d’afficher les plus populaires et de consulter le détail complet de chaque série.

L'application s'appuie sur l’API publique TVMaze / Episodate pour récupérer les données en temps réel.

2. Fonctionnalités principales
Recherche de séries

Barre de recherche intégrée en haut de l’écran.

Saisie dynamique du nom d’une série.

Résultats affichés sous forme de liste moderne (Jetpack Compose).

Séries populaires

Section dédiée aux séries les plus populaires.

Récupération en temps réel via l’API.

Affichage avec image, nom et statut.

Détail d’une série

Chaque série sélectionnée affiche :

Image en haute résolution.

Nom complet.

Date de début.

Statut (Running / Ended).

Réseau TV (Netflix, HBO, etc.).

Résumé complet.

Bouton retour entièrement fonctionnel (navigation Compose).

Mode sombre (si activé dans le système)

Support automatique du mode sombre.

Thème Material 3 basé sur isSystemInDarkTheme().

3. Architecture du projet

Le projet utilise une architecture moderne recommandée pour Android :

Jetpack Compose pour l’UI

MVVM (Model – ViewModel – Repository)

Hilt (Dagger) pour l’injection de dépendances

Retrofit + Gson pour l’appel API

Navigation Compose pour la gestion des écrans

4. Structure du code
app/
 ├── data/
 │    ├── remote/
 │    │     ├── EpisodateApi.kt
 │    │     └── EpisodateModels.kt
 │    └── repository/
 │          └── TvShowsRepository.kt
 │
 ├── di/
 │    └── NetworkModule.kt
 │
 ├── ui/
 │    ├── home/
 │    │     ├── HomeScreen.kt
 │    │     └── HomeViewModel.kt
 │    ├── details/
 │    │     ├── DetailsScreen.kt
 │    │     └── DetailsViewModel.kt
 │    ├── navigation/
 │    │     └── NavRoutes.kt
 │    └── theme/
 │          ├── Color.kt
 │          ├── Theme.kt
 │          └── Type.kt
 │
 ├── MainActivity.kt
 └── TvSeriesExplorerApp.kt

5. Backend API

L'application consomme les endpoints suivants :

Séries populaires :
https://www.episodate.com/api/most-popular?page=1

Recherche :
https://www.episodate.com/api/search?q={nom}

Détails d’une série :
https://www.episodate.com/api/show-details?q={id}

6. Outils et technologies

Kotlin

Jetpack Compose (Material3)

Android Studio Electric Eel ou supérieur

Hilt / Dagger

Retrofit2 + Gson Converter

Coil (chargement d’images)

Navigation Compose


Vérifier que l’émulateur dispose d'une connexion internet.

Exécuter l'application avec le bouton "Run".
