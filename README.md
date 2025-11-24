📱 TV Series Explorer

Application Android développée en Kotlin / Jetpack Compose
Auteurs : Clément.F & Julien.R

📖 Description

TV Series Explorer est une application mobile permettant de rechercher des séries, consulter les séries les plus populaires, et afficher le détail complet d’une série grâce à l’API publique Episodate.

Le projet suit le cahier des charges imposé et respecte les bonnes pratiques Android modernes :

Jetpack Compose

Navigation Compose

Architecture MVVM

Hilt (Dagger) pour l’injection de dépendances

Appels API via Retrofit

✨ Fonctionnalités principales
🔍 Recherche de séries

Champ de recherche moderne en haut de l’écran

Saisie du nom d’une série

Requête API dynamique

Affichage des résultats sous forme de liste

Message d’erreur clair si aucun résultat ou problème réseau

⭐ Séries populaires

Section dédiée aux séries les plus consultées

Liste visuelle moderne et responsive

Navigation vers le détail d’une série

📄 Détail d’une série

Chaque série affiche :

🖼️ Image d'affiche

🎭 Nom complet

📅 Date de début

🔁 Statut (Running / Ended)

📡 Réseau TV

📝 Résumé complet

🔙 Bouton retour fonctionnel (via Navigation Compose)

🔚 Navigation

Entièrement gérée via Navigation Compose

Deux écrans :

HomeScreen

DetailsScreen

Passage de paramètres (showId) sécurisé

Bouton retour intégré dans la TopAppBar

🎨 Bonus implémentés / en cours

✨ Animations Jetpack Compose (préparées)

🌙 Mode sombre prêt à être ajouté avec Material 3

📦 Architecture propre (MVVM + repository)

Si tu veux, je peux aussi intégrer directement le thème Dark/Light.

🏗️ Architecture du projet
app/
 ├── data/
 │    ├── remote/        → API, Retrofit, DTO
 │    └── model/         → Modèles de données
 │
 ├── ui/
 │    ├── home/          → HomeScreen + ViewModel
 │    ├── details/       → DetailsScreen + ViewModel
 │    ├── navigation/    → NavHost, routes
 │    └── theme/         → Couleurs, typographies
 │
 ├── di/                 → Modules Hilt
 └── TvSeriesExplorerApp.kt

🔌 Backend API

L’application utilise l’API gratuite :

➡️ https://www.episodate.com/api

Endpoints utilisés :

/search?q=keyword

/most-popular?page=1

/show-details?q=ID

🛠️ Technologies utilisées

Kotlin

Jetpack Compose

Material 3

Navigation Compose

Retrofit + Gson

Hilt (Dagger)

MVVM

Coroutines + Flow

Android Studio

🚀 Installation (développeurs)

Cloner le repo :

git clone https://github.com/<TON-PSEUDO>/TVSeriesExplorer.git


Ouvrir dans Android Studio

Lancer un émulateur ou un appareil connecté

Build & Run

🐞 Problèmes connus

L’émulateur Android nécessite un accès internet activé

L’API Episodate peut parfois renvoyer des erreurs de réseau

👥 Auteurs

Clément.F & Julien.R
