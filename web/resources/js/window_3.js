function checkNextPage() {
    let code = document.getElementsByClassName('input_code')[0].value;
    let randS = [8, 19, 22];
    let randomN = Math.floor(Math.random()*3);
    console.log(randS[randomN]);
    switch (randS[randomN]){
        case 8:
            let str = "../window"+randS[randomN]+"?PageNum=3&Number=" + code ;
            location.href=str;
            break;
        case 19:
            alert("잘못된 입력입니다.");
            break;
        case 22:
            alert("이 기기에서는 해당 선결제 코드를 사용할 수 없습니다.");
            break;
    }
}