const pagearr = [8, 4, 23];

setTimeout(function () {
    let page = pagearr[Math.round(Math.random()*2)];
    console.log(page);
    location.href = '../window'+page;
} , 3000);