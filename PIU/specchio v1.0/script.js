let isLocked = true;
let isFirstUnlock = true; // Variabile per sapere se è il primo sblocco

function changeScreen(screenId) {
    const screens = document.querySelectorAll('.screen');
    screens.forEach(screen => screen.style.display = 'none'); // Nascondi tutte le schermate
    document.getElementById(screenId).style.display = 'flex'; // Mostra la schermata selezionata
}

function toggleLock() {
    const lockIcon = document.querySelector('.icon-lock');
    const mirrorContainer = document.querySelector('.mirror-container');
    const aiIcon = document.getElementById('ai-icon');
    const weatherIcon = document.querySelector('.icon.weather');
    const avatarIcon = document.querySelector('.screen-avatar');
    const activityText = document.getElementById('activity-text');
    const weatherText = document.getElementById('weather-text');
    const aiText = document.getElementById('ai-activity-text');
    const weatherContainer = document.querySelector('.screen-dashboard');
    const checklistIcon = document.querySelector('.icon-checklist');
    const welcomeText = document.getElementById('welcome-text'); // Elemento per il messaggio di benvenuto

    // Se il lucchetto è chiuso (bloccato), sblocchiamo e mostriamo le icone
    if (isLocked) {
        lockIcon.textContent = '🔓'; // Mostra lucchetto aperto
        mirrorContainer.classList.remove('locked');
        aiIcon.classList.add('visible'); // Mostra l'icona IA
        weatherContainer.style.display = 'flex'; // Mostra il contenitore meteo
        weatherIcon.style.display = 'block'; // Mostra l'icona meteo
        avatarIcon.style.display = 'block'; // Mostra l'icona avatar
        checklistIcon.style.display = 'block'; // Mostra l'icona checklist
        activityText.style.display = 'none'; // Nascondi la scritta "lavarsi i denti"
        weatherText.style.display = 'none'; // Nascondi la scritta meteo
        aiText.style.display = 'none'; // Nascondi la scritta IA

        // Se è il primo sblocco, mostra il messaggio di benvenuto
        if (isFirstUnlock) {
            welcomeText.style.display = 'block';
            isFirstUnlock = false; // Dopo il primo sblocco, non mostrare più il benvenuto
        }
    } else {
        // Se il lucchetto è aperto, lo chiudiamo e nascondiamo le icone
        lockIcon.textContent = '🔒'; // Mostra lucchetto chiuso
        mirrorContainer.classList.add('locked');
        aiIcon.classList.remove('visible'); // Nascondi l'icona IA
        weatherContainer.style.display = 'none'; // Nascondi il contenitore meteo
        weatherIcon.style.display = 'none'; // Nascondi l'icona meteo
        avatarIcon.style.display = 'none'; // Nascondi l'icona avatar
        checklistIcon.style.display = 'none'; // Nascondi l'icona checklist
        activityText.style.display = 'none'; // Nascondi la scritta "lavarsi i denti"
        weatherText.style.display = 'none'; // Nascondi la scritta meteo
        aiText.style.display = 'none'; // Nascondi la scritta IA
        welcomeText.style.display = 'none'; // Nascondi il messaggio di benvenuto
    }

    isLocked = !isLocked; // Alterna lo stato di lock
}

// Funzione per aggiornare l'orario in tempo reale
function updateTime() {
    const timeElement = document.getElementById('time');
    const now = new Date();
    const hours = now.getHours().toString().padStart(2, '0');
    const minutes = now.getMinutes().toString().padStart(2, '0');
    const seconds = now.getSeconds().toString().padStart(2, '0');
    timeElement.textContent = `${hours}:${minutes}:${seconds}`;
}

// Aggiorna l'orario ogni secondo
setInterval(updateTime, 1000);

// Funzione per mostrare/nascondere la scritta "lavarsi i denti" quando si clicca sull'avatar
function toggleActivity() {
    const activityText = document.getElementById('activity-text');
    const weatherText = document.getElementById('weather-text');
    const aiText = document.getElementById('ai-activity-text');
    
    // Nascondi tutte le scritte prima di mostrare la nuova
    aiText.style.display = 'none';
    weatherText.style.display = 'none';
    
    // Toggle della scritta dell'avatar
    if (activityText.style.display === 'block') {
        activityText.style.display = 'none'; // Nascondi la scritta se è già visibile
    } else {
        activityText.style.display = 'block'; // Mostra la scritta
    }
}

// Funzione per mostrare/nascondere la scritta "IA" quando si clicca sull'icona IA
function toggleAiActivity() {
    const aiActivityText = document.getElementById('ai-activity-text');
    const activityText = document.getElementById('activity-text');
    const weatherText = document.getElementById('weather-text');
    
    // Nascondi tutte le scritte prima di mostrare la nuova
    activityText.style.display = 'none';
    weatherText.style.display = 'none';
    
    // Toggle della scritta dell'IA
    if (aiActivityText.style.display === 'block') {
        aiActivityText.style.display = 'none'; // Nascondi la scritta se è già visibile
    } else {
        aiActivityText.style.display = 'block'; // Mostra la scritta
    }
}

// Funzione per mostrare/nascondere la scritta del meteo quando si clicca sull'icona meteo
function toggleWeatherActivity() {
    const weatherText = document.getElementById('weather-text');
    const activityText = document.getElementById('activity-text');
    const aiText = document.getElementById('ai-activity-text');
    
    // Nascondi tutte le scritte prima di mostrare la nuova
    activityText.style.display = 'none';
    aiText.style.display = 'none';
    
    // Toggle della scritta meteo
    if (weatherText.style.display === 'block') {
        weatherText.style.display = 'none'; // Nascondi la scritta se è già visibile
    } else {
        weatherText.style.display = 'block'; // Mostra la scritta
    }
}

// Funzione per mostrare/nascondere la lista eventi quando si clicca sull'icona checklist
function toggleEvents() {
    const eventsList = document.getElementById('events-list');
    
    // Nascondi tutti i testi
    document.getElementById('activity-text').style.display = 'none';
    document.getElementById('weather-text').style.display = 'none';
    document.getElementById('ai-activity-text').style.display = 'none';

    // Toggle della visibilità della lista eventi
    if (eventsList.style.display === 'block') {
        eventsList.style.display = 'none'; // Nascondi la lista eventi se è visibile
    } else {
        eventsList.style.display = 'block'; // Mostra la lista eventi
    }
}
