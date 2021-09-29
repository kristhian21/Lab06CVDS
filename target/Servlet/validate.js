function validateForm() {
    let x = document.forms["myForm"]["id"].value;
    if (x == "") {
        alert("No se ingreso ningun parametro");
        return false;
    }
    else if(!Number.isInteger(x)) {
        alert("No es un entero");
        return false;
    }
  }