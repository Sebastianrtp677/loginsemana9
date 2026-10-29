# SimpleGPSMapApp

Aplicación Android (Java) que muestra un mapa de Google con la ubicación actual del usuario,
permite añadir marcadores y capturar y mostrar una imagen.

## Funcionalidades

- Mostrar la ubicación actual en un mapa de Google Maps (punto azul + cámara centrada).
- Añadir marcadores: pulsación larga en cualquier punto del mapa, o botón **Marcar aquí** para
  dejar un marcador en la ubicación actual.
- Dirección del marcador obtenida con geocodificación inversa en un hilo secundario (`ExecutorService`),
  sin bloquear la interfaz.
- Capturar una foto con la cámara, mostrarla en pantalla y guardarla (JPEG) en el almacenamiento
  interno de la app, también en un hilo secundario.
- Solicitud de permisos de ubicación en tiempo de ejecución.

## Login y base de datos (SQLite)

- `LoginActivity` es la pantalla inicial; `RegisterActivity` crea cuentas nuevas.
- `DatabaseHelper` (`SQLiteOpenHelper`) maneja la tabla `users`. Las contraseñas se guardan con
  hash PBKDF2-HMAC-SHA256 + salt aleatoria, nunca en texto plano.
- `SessionManager` (SharedPreferences) recuerda la sesión; `MainActivity` redirige al login si no
  hay sesión y tiene un botón **Salir** para cerrarla.
- El hash se calcula en un hilo secundario (`ExecutorService`) para no bloquear la interfaz.

## Instrucciones de Ejecución

1. Clona el repositorio: `git clone https://github.com/USERNAME/SimpleGPSMapApp.git`
2. Abre el proyecto en Android Studio.
3. Obtén una API Key de *Maps SDK for Android* en Google Cloud Console y añádela en
   `app/src/main/res/values/google_maps_api.xml` (reemplaza `TU_API_KEY_AQUI`).
4. Ejecuta la aplicación en un dispositivo o emulador Android con Google Play Services
   (minSdk 30). En el emulador, fija una ubicación desde *Extended controls > Location*.

## Tecnologías

Java, Google Maps SDK (`play-services-maps`), Fused Location Provider (`play-services-location`),
Activity Result API (permisos y cámara), `ExecutorService` para tareas en segundo plano.
