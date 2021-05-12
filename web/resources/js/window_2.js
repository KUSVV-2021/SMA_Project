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
