
let ls = localStorage.getItem("IDX_DVM");
if (ls == null || ls == "" || ls == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
    ls = 1;
} else {
    ls = ls*1;
}
window.onkeydown = function (e) {
    if ( e.code == 'Enter' ) location.href = '../window2?INDEX='+ls;
}