function checkNextPage() {
    let code = document.getElementsByClassName('input_code')[0].value;
    console.log(code);
    location.href="../window8?PageNum=3&Number=" + code ;
}