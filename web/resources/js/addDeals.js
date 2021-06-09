// This example requires the Places library. Include the libraries=places
// parameter when you first load the API. For example:
// <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBIwzALxUPNbatRBj3Xi1Uhp0fFzwWNBkE&libraries=places">
    
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        var photo = document.getElementById("photo");
        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(150);
            photo.value = e.target.result;
        };

        reader.readAsDataURL(input.files[0]);
    }
}

function front(pageAddDealIndex) {
    if (pageAddDealIndex === 1) {
        document.getElementById('step1').style.display = 'block';
        document.getElementById('step2').style.display = 'none';
        document.getElementById('step4').style.display = 'none';
        document.getElementById('step3').style.display = 'none';
        document.getElementById('step5').style.display = 'none';
    } else if (pageAddDealIndex === 2) {
        document.getElementById('step2').style.display = 'block';
        document.getElementById('step1').style.display = 'none';
        document.getElementById('step4').style.display = 'none';
        document.getElementById('step3').style.display = 'none';
        document.getElementById('step5').style.display = 'none';
    } else if (pageAddDealIndex === 3) {
        document.getElementById('step3').style.display = 'block';
        document.getElementById('step1').style.display = 'none';
        document.getElementById('step2').style.display = 'none';
        document.getElementById('step4').style.display = 'none';
        document.getElementById('step5').style.display = 'none';
    } else if (pageAddDealIndex === 4) {
        document.getElementById('step4').style.display = 'block';
        document.getElementById('step1').style.display = 'none';
        document.getElementById('step2').style.display = 'none';
        document.getElementById('step3').style.display = 'none';
        document.getElementById('step5').style.display = 'none';
    } else if (pageAddDealIndex === 5) {
        document.getElementById('step5').style.display = 'block';
        document.getElementById('step4').style.display = 'none';
        document.getElementById('step1').style.display = 'none';
        document.getElementById('step2').style.display = 'none';
        document.getElementById('step3').style.display = 'none';
    }
}

function back(pageAddDealIndex) {
    if (pageAddDealIndex === 1) {
        document.getElementById('step1').style.display = 'block';
        document.getElementById('step2').style.display = 'none';
        document.getElementById('step3').style.display = 'none';
        document.getElementById('step4').style.display = 'none';
        document.getElementById('step5').style.display = 'none';
    } else if (pageAddDealIndex === 2) {
        document.getElementById('step2').style.display = 'block';
        document.getElementById('step1').style.display = 'none';
        document.getElementById('step3').style.display = 'none';
        document.getElementById('step4').style.display = 'none';
        document.getElementById('step5').style.display = 'none';
    } else if (pageAddDealIndex === 3) {
        document.getElementById('step3').style.display = 'block';
        document.getElementById('step1').style.display = 'none';
        document.getElementById('step2').style.display = 'none';
        document.getElementById('step4').style.display = 'none';
        document.getElementById('step5').style.display = 'none';
    } else if (pageAddDealIndex === 4) {
        document.getElementById('step4').style.display = 'block';
        document.getElementById('step1').style.display = 'none';
        document.getElementById('step2').style.display = 'none';
        document.getElementById('step3').style.display = 'none';
        document.getElementById('step5').style.display = 'none';
    }
}


function closeModal(){
    document.getElementById('myModal').style.display = 'none';
    document.body.style.overflow = "visible";
}

function valideKey(evt){
    
    // code is the decimal ASCII representation of the pressed key.
    var code = (evt.which) ? evt.which : evt.keyCode;
    
    if(code==8) { // backspace.
      return true;
    } else if(code>=48 && code<=57) { // is a number.
      return true;
    } else{ // other keys.
      return false;
    }
}