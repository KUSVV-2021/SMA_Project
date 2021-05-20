/*const drink = new Map([
    ["coke", 2],
    ["pepsi", 0],
])*/
let ls = localStorage.getItem("IDX_DVM");
if (ls == null || ls == "" || ls == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
    ls = 1;
} else {
    ls = ls*1;
}

window.onkeydown = function (e) {
    if (e.code == 'KeyR') {
        inputR();
    }
}

//r를 누르면 window1로 넘어간다.
function inputR() {
    alert("카드가 제거 되었습니다.");
    location.href='../window1';
}


var obj = null;
$('.menu_ui .drink').click( function () {
    let str = this.innerHTML;
    let o = null;
    //10% 확률로 결제 실패(원인: 카드 임시 제거, 카드 한도 초과, 잔고부족, 기한 초과 등 다양함)
    //Window-1로 돌아간다.
    if (Math.floor(Math.random()*10) == 4) {
        alert("카드결제를 실패하였습니다. 카드를 제거해주세요.");
        location.href = '../window1';
    }

    for ( let i = 0; i < obj.length; i++ ) {
        if ( obj[i].NAME == str && obj[i].STOCK>0 ) {
            o = obj[i];
            console.log(str+":"+o.NAME+":"+o.STOCK);
            break;
        }
    }
    if (o != null) {
        console.log(o.NAME+":"+o.STOCK);
        if ( confirm(o.NAME+"을(를) 구매 하시겠습니까?") )
            location.href = "/window2/buyDrink?SEQ="+o.SEQ+"&INDEX="+ls;
    } else {
        location.href = "/window2/getDrinkInfoFromOtherDVM?D_NAME="+str+"&INDEX="+ls;
    }
} );

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

    var Other = document.getElementById("Other");
    try {
        Other = JSON.parse(Other.innerHTML);
        console.log(Other);
        location.href = '../window4?DVM_SEQ='+Other.DVM_SEQ+'&LONGITUDE='+Other.LONGITUDE+'&LATITUDE='+Other.LATITUDE+'&D_NAME='+Other.D_NAME;
        return;
    }catch (e) {
        if (Other.innerHTML.includes("<"))
            alert("죄송합니다.\n모든 자판기에 재고가 존재하지 않습니다.\n빠른 시일내에 재고를 확보하도록 하겠습니다.");
    }

    var Buy = document.getElementById("Buy");
    try {
        Buy = JSON.parse(Buy.innerHTML);
        if (Buy.R.NAME!=="undefined"){
            location.href = '../window8?Drink='+Buy.R.NAME;
        }
        return;
    }catch (e) { console.log(1);}

}

