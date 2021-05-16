let ls = localStorage.getItem("IDX_DVM");
if (ls == null || ls == "" || ls == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
    ls = 1;
} else {
    ls = ls*1;
}

window.onkeydown = function (e) {
    inputC();
}

function inputC() {
    ls = localStorage.getItem("IDX_DVM");
    if (e.code == 'KeyC') location.href='../window2?INDEX='+ls;
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
            location.href="../window12?INDEX="+ls;
        } else {
            alert("잘못된 입력입니다.");
        }
    } else {
        input += e.target.innerText;
    }
}

let inputc = "";
function chgDVMNumber() {
    input = "";
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
        if (inputc*1 > 0 && inputc*1 <=5) {
            localStorage.setItem("IDX_DVM", inputc);
            alert("변경된 dvm 번호는 "+inputc+"입니다.");
            const div = document.getElementsByClassName("c_key_pad")[0];
            div.remove();
        } else {
            alert("잘못된 입력입니다.");
        }
    } else {
        inputc += e.target.innerText;
    }
}