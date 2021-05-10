function openKeyPad(str) {
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
    $('.key_pad td').click( (e) => clickPad(e, str) );
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

function clickPad(e, str) {
    const input = document.getElementById(str);
    if ( e.target.innerText == "delete" ) {
        input.value = input.value.slice(0, -1)
    } else if ( e.target.innerText == "enter" ) {
        if ( input.value*1 < 0 ) {
            alert("잘못된 입력입니다.");
        } else {
            const div = document.getElementsByClassName("key_pad")[0];
            div.remove();
        }
    } else {
        input.value += e.target.innerText;
    }
}