/*const inputElement = document.getElementById("img");
inputElement.addEventListener("change", handleFiles, false);
function handleFiles() {
    const fileList = this.files; /!* 이제 파일 리스트로 작업할 수 있습니다 *!/
    console.log(fileList[0]);

    const img = document.getElementById("img_result");
    img.src = window.URL.createObjectURL(fileList[0]);
}*/
let ls = localStorage.getItem("IDX_DVM");
if (ls == null || ls == "" || ls == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
    ls = 1;
} else {
    ls = ls*1;
}

function addItem() {
    if ( document.getElementById("name").value == "" ) {
        alert("잘못된 입력입니다.");
        return;
    }
    location.href = '../window13/addItemlist?NAME='+document.getElementById("name").value+
        '&PRICE='+document.getElementById("price").value+'&INDEX='+ls;
}
function backToPage() {
    location.href = '../window12?INDEX='+ls;
}

//음료 이름의 길이는 20자를 넘길 수 없습니다.
function drinkNameCheck(obj) {
    if ( obj.value.length > 20 ) {
        alert("음료 이름의 길이는 20자를 넘길수 없습니다.");
        obj.value -= obj.value[obj.value.length-1];
    }
}