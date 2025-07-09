let students =
JSON.parse(localStorage.getItem("students")) || [];

function addStudent() {
  const name = document.getElementById("name").value;
  const roll = document.getElementById("roll").value;

  if (name && roll) {
    students.push({ name, roll });
    localStorage.setItem("students", JSON.stringify(students));
    document.getElementById("name").value = '';
    document.getElementById("roll").value = '';
    displayStudents();
  }
}

function deleteStudent(index) {
  students.splice(index, 1);
  localStorage.setItem("students", JSON.stringify(students));
  displayStudents();
}

function displayStudents() {
  const table = document.getElementById("studentTable");
  table.innerHTML = "";
  students.forEach((student, index) => {
    table.innerHTML += `
      <tr>
        <td>${student.name}</td>
        <td>${student.roll}</td>
        <td>
          <button onclick="editStudent(${index})">Edit</button>
          <button onclick="deleteStudent(${index})">Delete</button>
        </td>
      </tr>
    `;
  });
}

function editStudent(index) {
  const student = students[index];
  const newName = prompt("Edit Name", student.name);
  const newRoll = prompt("Edit Roll", student.roll);
  if (newName && newRoll) {
    students[index] = { name: newName, roll: newRoll };
    localStorage.setItem("students", JSON.stringify(students));
    displayStudents();
  }
}

// Load students on page load
window.onload = displayStudents;