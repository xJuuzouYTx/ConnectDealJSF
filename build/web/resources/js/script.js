var load = document.getElementById("load");

var card = document.querySelector(".card");
var cardLogin = document.querySelector(".cardLogin");
var cardSignUp = document.querySelector(".cardSignUp");
var loginForm = document.querySelector(".loginForm");
var signUpForm = document.querySelector(".signUpForm");
var container = document.querySelector(".container");


function showRegister(){
   cardSignUp.style.display = "none";
   signUpForm.style.display = "block";
   loginForm.style.display = "none";
   cardLogin.style.display = "block";

}
function showLogin(){
   loginForm.style.display = "block";
   cardLogin.style.display = "none";
   signUpForm.style.display = "none";
   cardSignUp.style.display = "block";
}

function validarLogin(){
    var email = document.getElementById("Lemail").value;
    var password = document.getElementById("Lpassword").value;    
    
    if (email.length < 10){
        return false;
    }
    if(password.length < 1){
        alertDiv.innerHTML = "<strong>Error!</strong> Asegurese de completar todos los campos!";
        setTimeout(alertSpan, 5000);
        alertDiv.style.display = "block";
        return false;
    }
    return true;
}
function validarSignUp(){
    var name = document.getElementById("Rname").value;
    var lastname = document.getElementById("Rlastname").value;
    var email = document.getElementById("Remail").value;
    var password = document.getElementById("Rpassword").value;    
    
    if (name.length < 2){
        $("#registerError").html("<span style='color:#cc0000'>Error: Ingrese un nombre valido. </span>");
         load.style.display = "none";
        return false;
    }
    //
    if (lastname.length < 2){
        $("#registerError").html("<span style='color:#cc0000'>Error: Ingrese un Apellido valido. </span>");
         load.style.display = "none";
        return false; 
    }
    if (email.length < 13){
        $("#registerError").html("<span style='color:#cc0000'>Error: Ingrese un correo valido. </span>");
         load.style.display = "none";
        return false;
    }
    if (!validatePassword(password)){
        $("#registerError").html("<span style='color:#cc0000'>Error: Contraseña debe contener 8 caracteres como minimo, una mayuscula, una minuscula y un número. </span>");
         load.style.display = "none";
        return false;
    }
    return true;
}

 function validatePassword(password){
    if(password.length >= 8){		
	var mayuscula = false;
	var minuscula = false;
	var numero = false;
	for(var i = 0;i<password.length;i++){
            if(password.charCodeAt(i) >= 65 && password.charCodeAt(i) <= 90){
		mayuscula = true;
            }else if(password.charCodeAt(i) >= 97 && password.charCodeAt(i) <= 122){
                minuscula = true;
            }else if(password.charCodeAt(i) >= 48 && password.charCodeAt(i) <= 57){
		numero = true;
            }
	}
	if(mayuscula == true && minuscula == true && numero == true){
            return true;
        }
    }
    return false;
}

/*Enciptacion*/

function encrypt(name) {
    var key = generateKeyString(16);
    var encrypted = CryptoJS.AES.encrypt(name, key);
    var result = [key, encrypted];
    return result;
}
function decrypt(input, key) {
    var decrypted = CryptoJS.AES.decrypt(input, key).toString(CryptoJS.enc.Utf8);
    return decrypted;
}
function generateKeyString(length) {
  var ret = "";
  while (ret.length < length) {
    ret += Math.random().toString(16).substring(2);
  }
  return ret.substring(0,length);
}
