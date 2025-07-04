let selectedRow = null;

function onFormSubmit() {
  const formData = readFormData();
  if (isValid(formData)) {
    if (selectedRow === null) {
      insertNewRecord(formData);
      alert("Your details are saved successfully.");
    } else {
      updateRecord(formData);
    }
    resetForm();
  } else {
    alert("Please fill in all fields.");
  }
}

function readFormData() {
  return {
    facName: document.getElementById("facName").value.trim(),
    facDep: document.getElementById("facDep").value.trim(),
    facSub: document.getElementById("facSub").value.trim()
  };
}

function insertNewRecord(data) {
  const table = document.getElementById("faclist").getElementsByTagName("tbody")[0];
  const newRow = table.insertRow();

  newRow.insertCell(0).innerHTML = data.facName;
  newRow.insertCell(1).innerHTML = data.facDep;
  newRow.insertCell(2).innerHTML = data.facSub;
  newRow.insertCell(3).innerHTML = `
    <a href="#" onClick="onEdit(this)">Update</a> |
    <a href="#" onClick="onDelete(this)">Delete</a>
  `;
}

function resetForm() {
  document.getElementById("facName").value = "";
  document.getElementById("facDep").value = "";
  document.getElementById("facSub").value = "";
  selectedRow = null;
}

function onEdit(td) {
  if (confirm("Do you want to update this record?")) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("facName").value = selectedRow.cells[0].innerHTML;
    document.getElementById("facDep").value = selectedRow.cells[1].innerHTML;
    document.getElementById("facSub").value = selectedRow.cells[2].innerHTML;
  }
}

function updateRecord(formData) {
  alert("Record updated successfully.");
  selectedRow.cells[0].innerHTML = formData.facName;
  selectedRow.cells[1].innerHTML = formData.facDep;
  selectedRow.cells[2].innerHTML = formData.facSub;
}

function onDelete(td) {
  if (confirm("Are you sure you want to delete this record?")) {
    const row = td.parentElement.parentElement;
    document.getElementById("faclist").deleteRow(row.rowIndex);
    resetForm();
  }
}

function isValid(data) {
  return data.facName !== "" && data.facDep !== "" && data.facSub !== "";
}
