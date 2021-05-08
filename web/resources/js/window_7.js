const pagearr = [8, 4, 23];

function getParam(sname) {
    let params = location.search.substr(location.search.indexOf("?") + 1);
    let sval = "";
    params = params.split("&");
    let temp;
    for (let i = 0; i < params.length; i++) {
        temp = params[i].split("=");
        if ([temp[0]] == sname) {
            sval = temp[1];
        }
    }
    return sval;

}

setTimeout(function () {
    let page = pagearr[Math.round(Math.random()*2)];
    console.log(page);
    location.href = '../window'+getParam('Page');
} , 3000);


