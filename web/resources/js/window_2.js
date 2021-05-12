const drink = new Map([
    ["coke", 2],
    ["pepsi", 0],
])

$('.menu_ui img').click( function () {
    let str = this.src.split('.')[0].split('/');
    str = str[str.length-1];
    if (drink.get(str) > 0) {
        location.href = '../window8';
    } else {
        //db 확인
        let check = true;
        if(check == false) {
            alert("죄송합니다.\n모든 자판기에 재고가 존재하지 않습니다.\n빠른 시일내에 재고를 확보하도록 하겠습니다.");
        } else {
            location.href = '../window4';
        }
    }
} );
var obj = null;
window.onload = function () {
    var item = document.getElementById("Data");
    obj = JSON.parse(item.innerHTML);
    obj = obj.R.list;
    const body = document.getElementsByClassName("fit_contents")[0];
    console.log(obj.length/9);
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
        for ( let i = 0+(9*(n-1)-1); i < 9+(9*(n-1)-1); i++ ) {
            var a = document.getElementById((i+1-(9*(n-1)-1))+"");
            console.log((i+1-(9*(n-1)-1))+"");
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

