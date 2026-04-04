const BASE_URL = 'http://localhost:8080';

/**
 * Legge il valore del cookie XSRF-TOKEN impostato da Spring Security.
 */
function getCsrfToken() {
  const match = document.cookie.match(/(?:^|;\s*)XSRF-TOKEN=([^;]*)/);
  return match ? decodeURIComponent(match[1]) : null;
}


const ENTITY_ENDPOINTS = {
  anagrafiche: '/anagrafica/getAll',
  giocatori: '/giocatori',
  squadre: '/squadre'
};

const FIELD_CONFIG = {
  anagrafiche: {
    name: (item) => `${String(item.nome ?? '')} ${String(item.cognome ?? '')}`.trim() || `ID ${String(item.id ?? '')}`,
    fields: ['codiceFiscale', 'email', 'citta', 'telefono', 'dataNascita', 'indirizzo', 'cap']
  },
  giocatori: {
    name: (item) => String(item.nome ?? item.cognome ?? `ID ${String(item.id ?? '')}`),
    fields: ['ruolo', 'numero_maglia', 'squadra', 'eta']
  },
  squadre: {
    name: (item) => String(item.nome ?? `ID ${String(item.id ?? '')}`),
    fields: ['citta', 'allenatore', 'stadio', 'giocatori']
  }
};

async function fetchData(entity) {
  const btnClass = entity === 'anagrafiche' ? 'anagrafica' : entity;
  const btn = document.querySelector(`.btn-${btnClass}`);
  const resultsEl = document.getElementById(`results-${entity}`);
  const countEl = document.getElementById(`count-${entity}`);

  if (!btn || !resultsEl || !countEl) {
    return;
  }

  btn.classList.add('loading');
  const btnText = btn.querySelector('span');
  if (btnText) {
    btnText.textContent = 'Caricamento...';
  }

  btn.disabled = true;
  resultsEl.innerHTML = '';

  try {
    const endpoint = ENTITY_ENDPOINTS[entity] || `/${entity}`;
    const res = await fetch(`${BASE_URL}${endpoint}`);
    if (!res.ok) {
      throw new Error(`HTTP ${res.status} - ${res.statusText}`);
    }

    const data = await res.json();
    const listRaw = Array.isArray(data) ? data : (data.content ?? data.data ?? [data]);
    const list = Array.isArray(listRaw) ? listRaw : [];

    countEl.innerHTML = `<span>${list.length}</span> risultati trovati`;

    if (list.length === 0) {
      resultsEl.innerHTML = [
        '<div class="empty-state">',
        '<div class="empty-icon">📭</div>',
        '<div class="empty-text">Nessun record trovato</div>',
        '</div>'
      ].join('');
      return;
    }

    const config = FIELD_CONFIG[entity];

    list.forEach((item, i) => {
      const row = document.createElement('div');
      row.className = 'result-row';
      row.style.animationDelay = `${i * 40}ms`;

      const fields = config.fields
        .filter((f) => item[f] !== undefined && item[f] !== null && item[f] !== '')
        .map((f) => `<div class="field-pill"><strong>${f}:</strong> ${String(item[f])}</div>`)
        .join('');

      row.innerHTML = [
        '<div class="result-row-header">',
        `<div class="result-name">${config.name(item)}</div>`,
        `<div class="result-id">#${String(item.id ?? i + 1)}</div>`,
        '</div>',
        fields ? `<div class="result-fields">${fields}</div>` : ''
      ].join('');

      resultsEl.appendChild(row);
    });
  } catch (err) {
    const message = err instanceof Error ? err.message : 'Errore sconosciuto';
    countEl.innerHTML = '<span style="color:var(--accent3)">Errore</span>';
    resultsEl.innerHTML = `<div class="error-state">⚠️ ${message}</div>`;
  } finally {
    btn.classList.remove('loading');

    if (btnText) {
      btnText.textContent =
        entity === 'anagrafiche'
          ? 'Carica Anagrafiche'
          : entity === 'giocatori'
            ? 'Carica Giocatori'
            : 'Carica Squadre';
    }

    btn.disabled = false;
  }
}

async function logout() {
  try {
    const csrfToken = getCsrfToken();
    const headers = {};
    if (csrfToken) {
      headers['X-XSRF-TOKEN'] = csrfToken;
    }
    await fetch(`${BASE_URL}/api/auth/logout`, {
      method: 'POST',
      headers: headers,
      credentials: 'include'
    });
  } catch (_) {
    // anche se la chiamata fallisce, procedi col logout lato client
  }
  localStorage.removeItem('access_token');
  window.location.href = '/login';
}

window.fetchData = fetchData;
window.logout = logout;

