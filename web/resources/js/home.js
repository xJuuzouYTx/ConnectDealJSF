$=jQuery;
$("#notify").click(notify);

window.addEventListener("popstate", newUrl, false);

window.onload = load;

function showDel(){
    var esVisible = $("#checkAll").is(":visible");
    var check = document.getElementsByClassName("check");
    if (esVisible){
        document.getElementById("checkAll").style.display = "none";
        for (var i = 0, len = check.length; i < len; i++){
                check[i].style["display"] = "none";
        }
    }else{
        document.getElementById("checkAll").style.display = "inline-block";
        for (var i = 0, len = check.length; i < len; i++){
            check[i].style["display"]  = "inline-block";
        }
    }
    
}

function load(){
    var i1 = document.getElementById("name");
    i1.value = "";
    alert(1);
}
function addDeal() {
    document.getElementById('myModal').style.display = 'block';
    document.body.style.overflow = "hidden";
}

window.addEventListener('click', function (e) {
    if (!document.getElementById('menu').contains(e.target)) {
        $(".container").click(function () {
            var esVisible = $(".menu").is(":visible");
            if (esVisible) {
                $(".menu").hide();
            }
        });
    }
    if (document.getElementById('user').contains(e.target)) {
        $(".menu").show();
    }
    if (document.getElementById('listProducts').contains(e.target) || document.getElementById('btnSearch').contains(e.target)){
        document.getElementById('listProducts').style.display = "block";
    }else{
        document.getElementById('listProducts').style.display = "none";
    }
});

function showMenu(){
    $(".menu").show();
}

const val = function validateField(field) {
    var charOrNumber = false;
    for (var i = 0; i < field.length; i++) {
        if ((field.charCodeAt(i) >= 33 && field.charCodeAt(i) <= 47) || (field.charCodeAt(i) >= 58 && field.charCodeAt(i) <= 64 )){
            charOrNumber = true;
        }
    }
    if (charOrNumber) {
        return true;
    }
    return false;
}

function productDetails(productId){
    var formProductDetails = document.getElementById("formProductDetails");
    var pid = document.getElementById("pid");
    pid.value = productId;
    formProductDetails.submit();
}

/*Enciptacion*/

function encrypt(name) {
    var encrypted = CryptoJS.AES.encrypt(name,"dsad");
    alert(encrypted);
    return encrypted;
}

function decrypt(input) {
    var decrypted = CryptoJS.AES.decrypt(input, "dsad").toString(CryptoJS.enc.Utf8);
    alert(decrypted);
    return decrypted;
}
        