
let ls = localStorage.getItem("IDX_DVM");
if (ls == null || ls == "" || ls == 0) {
    localStorage.setItem("IDX_DVM", 1+"");
    ls = 1;
} else {
    ls = ls*1;
}

function removeItem(){
    location.href = '../window15/removeItemlist?D_NAME='+document.getElementById("Drink").innerHTML+"&INDEX="+ls;
}