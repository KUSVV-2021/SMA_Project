if (localStorage.getItem("IDX_DVM") == null || localStorage.getItem("IDX_DVM") == "" || localStorage.getItem("IDX_DVM") == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
}

const dvm = new DVM(localStorage.getItem("IDX_DVM") * 1, null);

function addItemlist() {
    if ( ( document.getElementById("name").value == "" )               //음료의 이름이 없을경우
        || ( document.getElementById("price").value == "" )             //가격이 비어있을 경우
        || ( document.getElementById("price").value == "0" )            //가격이 0이 입력된 경우
        || (document.getElementById("price").value*1 > 50000)   //가격이 5만원을 초과한 경우
        || (document.getElementById("price").value*1 < 1) ) {
        alert("잘못된 입력입니다.");
        return;
    } else {
        if ( document.getElementById("name").value.length > 20 ) {
            alert("음료 이름의 길이는 20자를 넘길수 없습니다.");
            return;
        } else {
            dvm.addItemlist(document.getElementById("name").value, document.getElementById("price").value);
        }
    }
}
function backToPage() {
    dvm.backToPage(12);
}

//음료 이름의 길이는 20자를 넘길 수 없습니다.
function drinkNameCheck(o) {
    if ( o.value.length > 20 ) {
        alert("음료 이름의 길이는 20자를 넘길수 없습니다.");
        o.value -= o.value[o.value.length-1];
    }
}