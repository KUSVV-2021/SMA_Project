
if (localStorage.getItem("IDX_DVM") == null || localStorage.getItem("IDX_DVM") == "" || localStorage.getItem("IDX_DVM") == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
}

const dvm = new DVM(localStorage.getItem("IDX_DVM") * 1, null);

let pr = new Payment();

var obj;
$('.menu_ui .drink').click( function () {
    let str = this.innerHTML;
    if (str == "") {
        return;
    }
    dvm.openChgMenu(str);
} );

function addButton() {
    if (obj.length < 20)
        location.href='../window13';
    else
        alert("더이상 추가할 수 없습니다.");
}

window.onload = function () {

    var item = document.getElementById("Data");
    try {
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
        for ( let i = 0; i < 9 && i < obj.length; i++ ) {
            const a = document.getElementById((i+1)+"");
            a.innerHTML = obj[i].NAME;
        }
    } catch (e) {
        console.log(item.innerHTML);
        switch (item.innerHTML.split("result=\"")[1].split("\"")[0]*1) {
            case 1:
                alert("db에러가 발생했습니다.");
                break;
            case 2:
                alert("이미 있는 음료입니다.");
                break;
        }
        dvm.backToPage(12);
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

document.getElementById("openDelMenu").onclick = function () {
    if (obj.length > 2)
        dvm.openDelMenu();
    else
        alert("더이상 삭제할 수 없습니다.");
}

document.getElementById("getPaymentList").onclick = function () {
    pr.getPaymentList();
}
