package Controller;

public class Payment {
    private String date;
    private int itemIndex;
    private static Payment payment = null;

    private Payment(){
        this.date = "";
        this.itemIndex = -1;
    }

    public static Payment getInstance() {
        if(payment == null) {
            payment = new Payment();
        }
        return payment;
    }

    public String getDate() {
        return date;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }
}
