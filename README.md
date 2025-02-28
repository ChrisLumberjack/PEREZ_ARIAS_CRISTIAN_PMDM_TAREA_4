# Spyro The Dragon - Guía Interactiva y Easter Egg

## Introducción

El proyecto es una actualización interactiva para la aplicación inspirada en el universo de **Spyro the Dragon**. El propósito principal es mejorar la experiencia del usuario mediante una **guía de inicio interactiva** y la incorporación de dos **Easter Eggs** dentro de la aplicación. La guía presenta de forma dinámica las principales secciones de la app, utilizando animaciones, sonidos y elementos gráficos. Los Easter Eggs agregan momentos de sorpresa y diversión para los usuarios al interactuar con ciertos elementos de la aplicación.

## Características principales

### Guía de inicio interactiva
La aplicación presenta una **guía de inicio interactiva** compuesta por varias pantallas que explican las funcionalidades de la app de manera visual y dinámica:

1. **Pantalla 1 - Bienvenida**: Introducción general con un fondo inspirado en Spyro. Incluye un botón de "Comenzar" que inicia la guía con una transición animada.
2. **Pantalla 2 - Personajes**: Explicación sobre los personajes de Spyro. Aparece un bocadillo informativo con animaciones.
3. **Pantalla 3 - Mundos**: Se explica la sección de mundos de Spyro, con un bocadillo informativo y animación.
4. **Pantalla 4 - Coleccionables**: Explicación de los coleccionables con un bocadillo animado.
5. **Pantalla 5 - Icono de Información**: Un bocadillo informativo señala el icono de información en la action bar.
6. **Pantalla 6 - Resumen**: Resumen de los pasos completados y un botón para finalizar la guía.

### Navegación de la guía
Cada pantalla de la guía incluye botones para avanzar a la siguiente sección o omitir la guía en cualquier momento. La interacción con la app queda bloqueada durante la visualización de la guía para mantener la atención del usuario.

### Animaciones
Se implementan varias animaciones para hacer la experiencia más atractiva:
- Animaciones de aparición para los bocadillos informativos.
- Transiciones visuales entre pantallas, como desvanecimientos y desplazamientos.

### Sonidos temáticos
Se agregan sonidos relacionados con el universo de Spyro que se reproducen en momentos clave de la guía, como al avanzar entre pantallas y al interactuar con los bocadillos informativos.

### Easter Eggs
Se han incorporado dos **Easter Eggs** dentro de la app:
1. **Easter Egg con vídeo**: Activado al hacer cuatro clics consecutivos sobre las Gemas en la pestaña de coleccionables. Al activarse, se reproduce un video temático en pantalla completa.
2. **Easter Egg con animación**: Se activa con una pulsación prolongada sobre el personaje de Spyro en la pestaña de personajes. Se muestra una animación que simula una llama de fuego saliendo de la boca de Spyro.

## Tecnologías utilizadas

- **Android SDK**: Framework de desarrollo para aplicaciones móviles.
- **Kotlin**: Lenguaje de programación principal para la app.
- **RecyclerView**: Para la visualización de los mundos y personajes.
- **Animation**: Librerías de Android para implementar las animaciones.
- **MediaPlayer**: Para reproducir sonidos y efectos temáticos.
- **Glide**: Para cargar y mostrar GIFs (como el GIF de Spyro).
- **SharedPreferences**: Para almacenar si el usuario ya ha completado la guía.

## Instrucciones de uso

### Clonar el repositorio

1. Abre Android Studio.
2. En el menú, selecciona **File > New > Project From Version Control...**.
3. Elige **Git** y pega el siguiente enlace en el campo "URL":  
