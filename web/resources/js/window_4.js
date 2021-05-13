let ls = localStorage.getItem("IDX_DVM");
if (ls == null || ls == "" || ls == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
    ls = 1;
} else {
    ls = ls*1;
}

function moveTo2(){
    location.href='../window2?INDEX='+ls;
}

let map;

function initMap() {
    const LO = document.getElementById("LO").innerHTML;
    const LA = document.getElementById("LA").innerHTML;
    map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: LO*1, lng: LA*1 },
        zoom: 17,
    });
    // The marker, positioned at Uluru
    const marker = new google.maps.Marker({
        position: { lat: LO*1, lng: LA*1 },
        map: map,
    });
}
window.onload = function () {
    /*const LO = document.getElementById("LO").innerHTML;
    const LA = document.getElementById("LA").innerHTML;
    //let check = true;
    var xhr = new XMLHttpRequest();
    var yourUrl = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+LO+","+LA+"&key=AIzaSyAEGJ5Q9a-TYjOy_n-UuJPf5fwuO3Ai4j8";
    xhr.open("POST", yourUrl, false);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send();
    try{
        yourUrl = JSON.parse(xhr.responseText);
    } catch (e) { check = false; }
    document.getElementById("results").innerHTML = yourUrl.results.formatted_address;*/
    initMap();
}