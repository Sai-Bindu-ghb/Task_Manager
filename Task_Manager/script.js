const API = "http://localhost:8080/api";

// ------------------ LOGIN ------------------
async function loginUser() {
  const email = document.getElementById("loginEmail").value;
  const password = document.getElementById("loginPassword").value;

  const res = await fetch(`${API}/users/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, password })
  });

  if (res.ok) {
    const data = await res.json();
    localStorage.setItem("user", JSON.stringify(data));
    window.location.href = "dashboard.html";
  } else {
    alert("Invalid Email or Password");
  }
}

// ------------------ REGISTER ------------------
async function registerUser() {
  const user = {
    name: document.getElementById("regName").value,
    email: document.getElementById("regEmail").value,
    password: document.getElementById("regPassword").value,
  };

  const res = await fetch(`${API}/users/register`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(user),
  });

  if (res.ok) {
    alert("Registered Successfully!");
    window.location.href = "index.html";
  } else {
    alert("User already exists!");
  }
}

// ------------------ CREATE TASK ------------------
async function createTask() {
  const user = JSON.parse(localStorage.getItem("user"));

  const task = {
    title: document.getElementById("taskTitle").value,
    description: document.getElementById("taskDesc").value,
    createdById: user.id,
    assignedToId: user.id,
    status: "PENDING"
  };

  const res = await fetch(`${API}/tasks/create`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(task)
  });

  if (res.ok) {
    alert("Task Created!");
    window.location.href = "tasks.html";
  }
}

// ------------------ LOAD USER TASKS ------------------
async function loadTasks() {
  const user = JSON.parse(localStorage.getItem("user"));
  const res = await fetch(`${API}/tasks/user/${user.id}`);
  const tasks = await res.json();

  let list = document.getElementById("taskList");
  list.innerHTML = "";

  tasks.forEach(t => {
    list.innerHTML += `
      <div class="card">
        <h3>${t.title}</h3>
        <p>${t.description}</p>
        <small>Status: ${t.status}</small>
      </div>
    `;
  });
}
