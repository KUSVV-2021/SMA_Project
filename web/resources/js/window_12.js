
let ls = localStorage.getItem("IDX_DVM");
if (ls == null || ls == "" || ls == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
    ls = 1;
} else {
    ls = ls*1;
}


var obj;
$('.menu_ui .drink').click( function () {
    let str = this.innerHTML;
    location.href = '../window16?Drink=' + str;
} );

function addButton() {
    if (obj.length < 20)
        location.href='../window13';
    else
        alert("더이상 추가할 수 없습니다.");
}

window.onload = function () {

    var item = document.getElementById("Data");
    obj = JSON.parse(item.innerHTML);
    obj = obj.R.list;
    const body = document.getElementsByClassName("fit_contents")[0];
    for ( let i = 0; i < obj.length/9; i++ ) {
        const a = '<button class="round_btn menu_btn">'+(i+1)+'</button>';
        body.innerHTML+=a;
        if ( i == 0 ) {
            document.getElementsByClassName("round_btn")[0].classList.add("active");
        }
    }
    for ( let i = 0; i < 9; i++ ) {
        const a = document.getElementById((i+1)+"");
        a.innerHTML = obj[i].NAME;
    }
    $('.round_btn').click( function () {
        if ( this.classList.value.indexOf("active") >= 0 ) return;
        let n = this.innerText*1;
        if ( n-1 != 0 ) n = (9*(n-1));
        else n = 0;
        for ( let i = 0+n; i < 9+n; i++ ) {
            var a = document.getElementById((i+1-n)+"");
            if ( obj[i] != null )
                a.innerHTML = obj[i].NAME;
            else
                a.innerHTML = "";
        }
        const btn = document.getElementsByClassName("active")[0];
        btn.classList.remove("active");
        this.classList.add("active");
    });
}

function getRecord() {
    location.href = '../window17?INDEX='+ls;
}

function removeItem() {
    location.href='../window14?INDEX='+ls;
}