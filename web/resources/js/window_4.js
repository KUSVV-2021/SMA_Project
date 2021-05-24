if (localStorage.getItem("IDX_DVM") == null || localStorage.getItem("IDX_DVM") == "" || localStorage.getItem("IDX_DVM") == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
}

const dvm = new DVM(localStorage.getItem("IDX_DVM") * 1, null);

let pr = new Payment();

document.getElementById("prepay").onclick = function () {
    pr.prePayment(1000);
}

document.getElementById("moveTo2").onclick = function () {
    dvm.moveTo2();
}

window.onkeydown = function (e) {
    if (e.code == 'KeyR') {
        dvm.removeCard();
    }
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
    initMap();
}

function getParam(sname) {
    let params = location.search.substr(location.search.indexOf("?") + 1);
    console.log(params);
    let sval = "";
    params = params.split("&");
    let temp;
    for (let i = 0; i < params.length; i++) {
        temp = params[i].split("=");
        if ([temp[0]] == sname) {
            sval = temp[1];
        }
    }
    return sval;
}
