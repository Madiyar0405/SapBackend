const apiBase = "/api";
const authForm = document.getElementById("auth-form");
const incidentForm = document.getElementById("incident-form");
const incidentsContainer = document.getElementById("incidents");
const refreshBtn = document.getElementById("refresh-btn");
const authStatus = document.getElementById("auth-status");
const incidentStatus = document.getElementById("incident-status");
const userLabel = document.getElementById("user-label");
const logoutBtn = document.getElementById("logout-btn");

let authToken = localStorage.getItem("sap_token");

function setAuth(token, username) {
    authToken = token;
    if (token) {
        localStorage.setItem("sap_token", token);
        userLabel.textContent = username || "Авторизован";
        logoutBtn.classList.remove("hidden");
    } else {
        localStorage.removeItem("sap_token");
        userLabel.textContent = "Не авторизован";
        logoutBtn.classList.add("hidden");
    }
}

logoutBtn.addEventListener("click", () => {
    setAuth(null);
    authStatus.textContent = "Сессия завершена.";
});

authForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();
    authStatus.textContent = "Входим...";
    try {
        const res = await fetch(`${apiBase}/v1/auth/authenticate`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password })
        });
        if (!res.ok) throw new Error("Неверные учетные данные");
        const data = await res.json();
        setAuth(data.accessToken, username);
        authStatus.textContent = "Успешный вход. Токен сохранён.";
    } catch (err) {
        console.error(err);
        authStatus.textContent = "Ошибка авторизации: " + err.message;
    }
});

incidentForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    const initiatorName = document.getElementById("initiatorName").value.trim();
    const incidentDescription = document.getElementById("incidentDescription").value.trim();
    const additionalInfo = document.getElementById("additionalInfo").value.trim();
    if (!incidentDescription || !initiatorName) return;

    incidentStatus.textContent = "Создание инцидента...";
    try {
        const res = await fetch(`${apiBase}/incident-requests`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                ...(authToken ? { Authorization: `Bearer ${authToken}` } : {})
            },
            body: JSON.stringify({
                initiatorName,
                incidentDescription,
                additionalInfo
            })
        });
        if (!res.ok) throw new Error("Не удалось создать заявку");
        incidentStatus.textContent = "Инцидент создан.";
        incidentForm.reset();
        await loadIncidents();
    } catch (err) {
        console.error(err);
        incidentStatus.textContent = "Ошибка: " + err.message;
    }
});

refreshBtn.addEventListener("click", loadIncidents);

async function loadIncidents() {
    incidentsContainer.innerHTML = "<div class='muted'>Загрузка...</div>";
    try {
        const res = await fetch(`${apiBase}/incident-requests/with-status`, {
            headers: {
                ...(authToken ? { Authorization: `Bearer ${authToken}` } : {})
            }
        });
        if (!res.ok) throw new Error("Не удалось получить список инцидентов");
        const data = await res.json();
        renderIncidents(data);
    } catch (err) {
        console.error(err);
        incidentsContainer.innerHTML = `<div class="muted">Ошибка загрузки: ${err.message}</div>`;
    }
}

function renderIncidents(list) {
    if (!list.length) {
        incidentsContainer.innerHTML = "<div class='muted'>Инцидентов пока нет.</div>";
        return;
    }
    const template = document.getElementById("incident-row").content;
    incidentsContainer.innerHTML = "";
    list
        .sort((a, b) => new Date(b.registrationDatetime) - new Date(a.registrationDatetime))
        .forEach(item => {
            const clone = document.importNode(template, true);
            clone.querySelector(".incident-title").textContent = `#${item.requestId} · ${item.initiatorName || "Неизвестно"}`;
            const meta = [
                item.registrationDatetime ? new Date(item.registrationDatetime).toLocaleString("ru-RU") : "—",
                item.supportGroup?.name || "Без группы"
            ].join(" · ");
            clone.querySelector(".incident-meta").textContent = meta;
            clone.querySelector(".incident-desc").textContent = item.incidentDescription || "Описание отсутствует";
            clone.querySelector(".incident-extra").textContent = item.additionalInfo || "Доп. информации нет";
            const statusBadge = clone.querySelector("[data-status]");
            statusBadge.textContent = item.incidentStatus?.name || "Новая";
            statusBadge.setAttribute("data-status", statusBadge.textContent);
            incidentsContainer.appendChild(clone);
        });
}

// Автозагрузка при открытии
if (authToken) {
    userLabel.textContent = "Авторизован (токен сохранён)";
    logoutBtn.classList.remove("hidden");
}
loadIncidents();
