class DVM {
    constructor(seq, itemList) {
        this.seq = seq;
        this.itemList = itemList;
    }
    getDVMId() {
        return this.seq;
    }

    getItemList() {
        return this.itemList;
    }

    setDVMId(seq) {
        this.seq = seq;
    }

    setItemList(itemList) {
        this.itemList = itemList;
    }

    inputC(e) {
        if (e.code == 'KeyC') location.href='../window2?INDEX='+this.seq;
    }   //c를 누르면 window2로 넘어간다.

    removeCard() {
        alert("카드가 제거 되었습니다.");
        location.href='../window1';
    }   //r를 누르면 window1로 넘어간다.

    answerPrecodeInfo() {
        let code = document.getElementsByClassName('input_code')[0].value;

        location.href = "/window3/answerPrecodeInfo?INDEX="+this.seq+"&CODE="+code;
    }

    moveTo2(){
        location.href='../window2?INDEX='+this.seq;
    }

    openDelMenu() {
        location.href='../window14?INDEX='+this.seq;
    }

    chsDelete(str) {
        location.href = '../window15?Drink=' + str;
    }   //window-12에서 삭제버튼 클릭

    backToPage(page) {
        location.href = '../window'+page+'?INDEX='+this.seq;
    }

    choosePrepayment() {
        location.href='../window3';
    }   //window-1에서 선결제 코드 인풋박스를 클릭시

    openChgMenu(str) {
        location.href = '../window16?Drink=' + str;
    }   //window-12에서 음료 클릭

    removeItemList(str) {
        location.href = '../window15/removeItemlist?D_NAME='+str+"&INDEX="+this.seq;
    }

    addItemlist(name, price) {
        location.href = '../window13/addItemlist?NAME='+name+'&PRICE='+price+'&INDEX='+this.seq;
    }

    changeStock(name, price, stock) {
        location.href = '../window16/changeStock?INDEX='+this.seq+'&D_NAME='+name+
            '&PRICE='+price+'&STOCK='+stock;
    }
}