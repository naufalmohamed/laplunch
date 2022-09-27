function myFunc() {
    var x = document.getElementById("myDIV");
    if (x.innerHTML === "Add") {
      x.innerHTML = "Swapped text!";
    } else {
      x.innerHTML = "Add";
    }
  }