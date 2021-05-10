function checkNextPage() {
    let code = document.getElementsByClassName('input_code')[0].value;
    let randS = [8, 19, 22];
    let randomN = Math.floor(Math.random()*3);
    console.log(randS[randomN]);
    let str = "../window"+randS[randomN]+"?PageNum=3";
    if (randS[randomN] == 8) {
        str += "&Number=" + code ;
    }
    location.href=str;
}