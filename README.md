# Outil d'Appariement d'Étudiants

Ce projet est une application de bureau développée avec Java et JavaFX. Son objectif est de fournir une interface graphique intuitive pour faciliter l'appariement d'étudiants (par exemple, dans le cadre d'un programme d'échange) en se basant sur un système de calcul d'affinités personnalisable.

## ✨ Fonctionnalités Principales

- **Gestion des Étudiants :** Charge et affiche une liste d'étudiants à partir d'un fichier `infoetu.csv`.
- **Profil Détaillé :** Permet de consulter les informations complètes de chaque étudiant (préférences, allergies, hobbies, etc.).
- **Calcul d'Affinité :** Un algorithme calcule un score d'affinité entre les étudiants en se basant sur plusieurs critères.
- **Pondération des Critères :** L'utilisateur peut activer, désactiver et ajuster l'importance (le "poids") de chaque critère (hobbies, genre, date de naissance, etc.) dans le calcul du score.
- **Contraintes Manuelles :** Possibilité de forcer des paires (`Fixer`) ou d'interdire certains appariements (`Éviter`) pour affiner les résultats.
- **Visualisation des Résultats :** Affiche la liste finale des paires d'étudiants formées, triées par leur score d'affinité.

---

## 🛠️ Technologies Utilisées

- **Java** (Version 17 ou supérieure)
- **JavaFX** (Version 21) pour l'interface graphique
- **Maven** pour la gestion des dépendances et du cycle de vie du projet

---

## 🚀 Démarrage Rapide

Suivez ces étapes pour lancer l'application sur votre machine.

### 1. Prérequis

Assurez-vous d'avoir les logiciels suivants installés :

- **JDK (Java Development Kit) :** Version 17 ou plus récente.
- **Apache Maven :** L'outil de build pour les projets Java. La plupart des IDE modernes (IntelliJ, Eclipse, VS Code) l'intègrent, mais vous pouvez aussi l'installer manuellement.

### 2. Installation

Clonez ce dépôt sur votre machine locale avec la commande suivante :

```bash
git clone <URL_de_votre_depot_git>
cd D6
```
*(Remplacez `<URL_de_votre_depot_git>` par l'URL de votre projet si vous l'avez mis sur une plateforme comme GitHub.)*

### 3. Lancement de l'Application

Une fois dans le dossier racine du projet (`D6`), exécutez la commande Maven suivante dans votre terminal :

```bash
mvn javafx:run
```

> **Note :** Le premier lancement peut prendre quelques minutes, car Maven doit télécharger toutes les dépendances nécessaires (comme JavaFX). Les lancements suivants seront beaucoup plus rapides.

---

## 📂 Structure du Projet

Voici un aperçu de l'organisation des fichiers importants :

```
.
├── doc/
│   └── img/              # Dossier pour les icônes et images (logo.png, etc.)
├── src/
│   ├── ihm/              # Code de l'Interface Homme-Machine
│   │   ├── fxml/         # Fichiers FXML (structure des fenêtres) et CSS (style)
│   │   ├── AppIhm.java   # Point d'entrée de l'application JavaFX
│   │   └── Controleur... # Classes qui gèrent la logique des interfaces
│   └── sae/              # Code de la logique métier
│       ├── Student.java
│       └── Affectation.java
├── pom.xml               # Fichier de configuration Maven
└── README.md             # Ce que vous lisez actuellement
```

##🎨 Personnalisation

- **Style Visuel :** Pour modifier les couleurs, les polices ou l'apparence générale, éditez le fichier : `src/ihm/fxml/style.css`.
- **Données des Étudiants :** L'application charge les étudiants depuis le fichier `infoetu.csv` situé dans le dossier `doc/`. Vous pouvez modifier ce fichier pour utiliser vos propres données.
