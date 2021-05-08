const drink = [{key:"coke", value:2},
    {key:"pepsi", value:0}];

$('.menu_ui img').click( function () {
    if (drink.get(this.src.split('.')[0]) > 0) {
        location.href = '../window8';
    } else {
        //db 확인
        let check = true;
        if(check == false) {
            location.href = '../window23';
        } else {
            location.href = '../window4';
        }
    }
} );
