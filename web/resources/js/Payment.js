
class Payment {
    constructor(){
        this.date = "";
        this.itemIndex = -1;
    }
    prePayment(itemPrice) {         //void
        const LO = document.getElementById("LO").innerHTML;
        const LA = document.getElementById("LA").innerHTML;
        if (this.requestPayment(itemPrice)) {
            location.href='../window6?INDEX='+getParam("DVM_SEQ")+
                '&D_NAME='+getParam("D_NAME")+'&LO='+LO+'&LA='+LA;
        }
        else
            alert("결제에 실패하였습니다.");
    }
    requestPayment(itemPrice) {     //boolean
        //일반적인 카드리더기에서는 잔고에 대한 내용을 알수없으므로 특정 확률에 따라 결제 실패와 성공여부를 판단
        if (Math.floor(Math.random()*10) == 4) return false;
        return true;
    }
    getPaymentList(seq) {
        location.href = '../window17?INDEX='+seq;
    }
}