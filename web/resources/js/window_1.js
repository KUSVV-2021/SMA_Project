let ls = localStorage.getItem("IDX_DVM");
if (ls == null || ls == "" || ls == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
    ls = 1;
} else {
    ls = ls*1;
}

window.onkeydown = function (e) {
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
            location.href="../window12";
        } else {
            alert("잘못된 입력입니다.");
        }
    } else {
        input += e.target.innerText;
    }
}