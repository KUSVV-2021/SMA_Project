
if (localStorage.getItem("IDX_DVM") == null || localStorage.getItem("IDX_DVM") == "" || localStorage.getItem("IDX_DVM") == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
}

const dvm = new DVM(localStorage.getItem("IDX_DVM") * 1, null);

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
    main.appendChild(div);
    $('.key_pad td').click( (e) => clickPad(e, str) );
}

function clickPad(e, str) {
    const input = document.getElementById(str);
    if ( e.target.innerText == "delete" ) {
        input.value = input.value.slice(0, -1)
    } else if ( e.target.innerText == "enter" ) {
        if ( input.value*1 < 1 ) {
            alert("잘못된 입력입니다.");
        } else {
            const div = document.getElementsByClassName("key_pad")[0];
            div.remove();
        }
    } else {
        input.value += e.target.innerText;
    }
}

function changeStock() {
    if ( ( document.getElementById("price").value == "" )               //가격이 비어있는 경우
        || ( document.getElementById("price").value == "0" )            //가격이 0이 입력된 경우
        || ( document.getElementById("left").value == "" )             //잔고가 비어있는 경우
        || (document.getElementById("price").value*1 > 50000)) {    //가격이 5만원을 초과한 경우
        alert("잘못된 입력입니다.");
        return;
    }
    dvm.changeStock(document.getElementById("Drink").innerHTML, document.getElementById("price").value, document.getElementById("left").value);
}

function backToPage() {
    dvm.backToPage(12);
}