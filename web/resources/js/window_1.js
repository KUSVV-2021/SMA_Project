//let ls = localStorage.getItem("IDX_DVM");
if (localStorage.getItem("IDX_DVM") == null || localStorage.getItem("IDX_DVM") == "" || localStorage.getItem("IDX_DVM") == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
}

const dvm = new DVM(localStorage.getItem("IDX_DVM") * 1, null);

window.onkeydown = function (e) {
    dvm.inputC(e);
}

let input = "";

function openKeyPad() {
    input = "";
    const div = document.createElement("div");
    div.classList.add("key_pad");
    const table = document.createElement("table");
    let tr = document.createElement("tr");
    let td = document.createElement("td");
    td.innerText = "1";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "2";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "3";
    tr.appendChild(td);
    table.appendChild(tr);
    tr = document.createElement("tr");
    td = document.createElement("td");
    td.innerText = "4";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "5";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "6";
    tr.appendChild(td);
    table.appendChild(tr);
    tr = document.createElement("tr");
    td = document.createElement("td");
    td.innerText = "7";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "8";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "9";
    tr.appendChild(td);
    table.appendChild(tr);
    tr = document.createElement("tr");
    td = document.createElement("td");
    td.innerText = "0";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "delete";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "enter";
    tr.appendChild(td);
    table.appendChild(tr);
    div.appendChild(table);
    const main = document.getElementsByClassName("main_view")[0];
    main.onclick = (e) => removePad(e);
    main.appendChild(div);
    $('.key_pad td').click( (e) => clickPad(e) );
}

let chk = false;

function removePad(e) {
    if ( !chk ) chk = true;
    else {
        const div = document.getElementsByClassName("key_pad")[0];
        const x = e.pageX;
        const y = e.pageY;
        if ( !( x >= div.offsetLeft && x <= ( div.offsetLeft + div.offsetWidth ) && y >= div.offsetTop && y <= ( div.offsetTop + div.offsetHeight ) ) ) {
            div.remove();
            chk = false;
        }
    }
}

function clickPad(e) {
    if ( e.target.innerText == "delete" ) {
        input = input.slice(0, -1)
    } else if ( e.target.innerText == "enter" ) {
        if (input == "1234") {
            dvm.backToPage(12);
        } else {
            alert("????????? ???????????????.");
        }
    } else {
        input += e.target.innerText;
    }
}

let inputc = "";
function chgDVMNumber() {
    inputc = "";
    const div = document.createElement("div");
    div.classList.add("c_key_pad");
    const table = document.createElement("table");
    let tr = document.createElement("tr");
    let td = document.createElement("td");
    td.innerText = "1";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "2";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "3";
    tr.appendChild(td);
    table.appendChild(tr);
    tr = document.createElement("tr");
    td = document.createElement("td");
    td.innerText = "4";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "5";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "6";
    tr.appendChild(td);
    table.appendChild(tr);
    tr = document.createElement("tr");
    td = document.createElement("td");
    td.innerText = "7";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "8";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "9";
    tr.appendChild(td);
    table.appendChild(tr);
    tr = document.createElement("tr");
    td = document.createElement("td");
    td.innerText = "0";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "delete";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "enter";
    tr.appendChild(td);
    table.appendChild(tr);
    div.appendChild(table);
    const main = document.getElementsByClassName("main_view")[0];
    main.appendChild(div);
    $('.c_key_pad td').click( (e) => clickCPad(e) );
}

function clickCPad(e) {
    if ( e.target.innerText == "delete" ) {
        inputc = inputc.slice(0, -1)
    } else if ( e.target.innerText == "enter" ) {
        if (inputc*1 > 0 && inputc*1 <=10) {
            localStorage.setItem("IDX_DVM", inputc);
            dvm.setDVMId(inputc);
            alert("????????? dvm ????????? "+inputc+"?????????.");
            const div = document.getElementsByClassName("c_key_pad")[0];
            div.remove();
        } else {
            alert("????????? ???????????????.");
        }
    } else {
        inputc += e.target.innerText;
    }
}

function choosePrepayment() {
    dvm.choosePrepayment();
}