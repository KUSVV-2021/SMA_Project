/*const drink = new Map([
    ["coke", 2],
    ["pepsi", 0],
])*/

var obj = null;
$('.menu_ui .drink').click( function () {
    /*var item = document.getElementById("Data");
    obj = JSON.parse(item.innerHTML);
    obj = obj.R.list;*/
    let str = this.innerHTML;
    let o = null;
    for ( let i = 0; i < obj.length; i++ ) {
        if ( obj[i].NAME == str && obj[i].STOCK>0 ) {
            o = obj[i];
            console.log(str+":"+o.NAME+":"+o.STOCK);
            break;
        }
    }
    if (o != null) {
        console.log(o.NAME+":"+o.STOCK);
        location.href = "/window2/buyDrink?SEQ="+o.SEQ+"&INDEX="+1;
    } else {
        //db 확인
        //console.log(o.NAME+":"+o.STOCK);
        location.href = "/window2/getDrinkInfoFromOtherDVM?D_NAME="+str+"&INDEX="+1;
        //let check = true;
        /*var xhr = new XMLHttpRequest();
        var yourUrl = "http://localhost:9080/MainProject/drink/getDrinkInfoFromOtherDVM";
        xhr.open("POST", yourUrl, false);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send(JSON.stringify({
            D_NAME: str,
            INDEX: 1
        }));
        try{
            yourUrl = JSON.parse(xhr.responseText);
        } catch (e) { check = false; }*/
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

    var Buy = document.getElementById("Buy");
    try {
        Buy = JSON.parse(Buy.innerHTML).R;
        location.href = '../window8?Drink='+Buy.NAME;
    }catch (e) { console.log(1);}

    var Other = document.getElementById("Other");
    try {
        Other = JSON.parse(Buy.innerHTML).R;
        location.href = '../window4?LONGITUDE='+Other.LONGITUDE+'&LATITUDE='+Other.LATITUDE;
    }catch (e) {
        if (Buy.innerHTML.indexOf("<")>=0)
            alert("죄송합니다.\n모든 자판기에 재고가 존재하지 않습니다.\n빠른 시일내에 재고를 확보하도록 하겠습니다.");
    }
}

