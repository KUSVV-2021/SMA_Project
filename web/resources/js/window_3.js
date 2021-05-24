if (localStorage.getItem("IDX_DVM") == null || localStorage.getItem("IDX_DVM") == "" || localStorage.getItem("IDX_DVM") == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
}

const dvm = new DVM(localStorage.getItem("IDX_DVM") * 1, null);

function answerPrecodeInfo() {
    dvm.answerPrecodeInfo();
}

let input;
function openKeyPad() {
    input = "";
    const div = document.createElement("div");
    div.classList.add("key_pad");
    const table = document.createElement("table");
    let tr = document.createElement("tr");

    let td = document.createElement("td");
    td.innerText = "a";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "b";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "c";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "d";
    tr.appendChild(td);
    table.appendChild(tr);
    tr = document.createElement("tr");
    td = document.createElement("td");
    td.innerText = "e";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "f";
    tr.appendChild(td);



    td = document.createElement("td");
    td.innerText = "1";
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "2";
    tr.appendChild(td);
    table.appendChild(tr);
    tr = document.createElement("tr");
    td = document.createElement("td");
    td.innerText = "3";
    tr.appendChild(td);
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
    td = document.createElement("td");
    td.innerText = "0";
    tr.appendChild(td);
    td = document.createElement("td");
    table.appendChild(tr);
    tr = document.createElement("tr");
    td.innerText = "delete";
    td.colSpan=2;
    tr.appendChild(td);
    td = document.createElement("td");
    td.innerText = "enter";
    td.colSpan=2;
    tr.appendChild(td);
    table.appendChild(tr);
    div.appendChild(table);
    const main = document.getElementsByClassName("main_view")[0];
    main.appendChild(div);
    $('.key_pad td').click( (e) => clickPad(e) );
}

function removePad() {
    const div = document.getElementsByClassName("key_pad")[0];
    div.remove();
}

function clickPad(e) {
    const inputC = document.getElementsByClassName("input_code")[0];
    if ( e.target.innerText == "delete" ) {
        inputC.value = inputC.value.slice(0, -1)
    } else if ( e.target.innerText == "enter" ) {
        removePad();
    } else {
        inputC.value += e.target.innerText;
    }
}

window.onload = function () {
    let Info = document.getElementById("Info");
    if ( Info.innerHTML != "" ) {
        Info = JSON.parse(Info.innerHTML);
        switch (Info.R.RESULT){
            case 3:
                let str = "../window8?Drink=" + Info.R.D_NAME ;
                location.href=str;
                break;
            case 2:
                alert("재고가 없거나 이미 쓴 코드입니다.");
                break;
            case 1:
                alert("이 기기에서는 해당 선결제 코드를 사용할 수 없습니다.");
                break;
            case 0:
                alert("잘못된 입력입니다.");
                break;
        }
    }
}
