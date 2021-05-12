$('.menu_ui img').click( function () {
    location.href = '../window16?Drink=' + this.src;
} );

function addButton() {
    if (Math.floor(Math.random()*2) == 0)
        location.href='../window13';
    else
        alert("더이상 추가할 수 없습니다.");
}