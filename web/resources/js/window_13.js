const inputElement = document.getElementById("img");
inputElement.addEventListener("change", handleFiles, false);
function handleFiles() {
    const fileList = this.files; /* 이제 파일 리스트로 작업할 수 있습니다 */
    console.log(fileList[0]);

    const img = document.getElementById("img_result");
    img.src = window.URL.createObjectURL(fileList[0]);
}

function addItem() {
    alert("추가 완료 되었습니다.");
    location.href = '../window12';
}