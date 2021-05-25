if (localStorage.getItem("IDX_DVM") == null || localStorage.getItem("IDX_DVM") == "" || localStorage.getItem("IDX_DVM") == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
}

const dvm = new DVM(localStorage.getItem("IDX_DVM") * 1, null);

setTimeout(function () {
    dvm.moveTo2();
} , 5000);

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
    initMap();
}
