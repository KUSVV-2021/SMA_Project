$('.menu_ui img').click( function () {
    location.href = '../window15?Drink=' + this.src.split('.')[0];
} );