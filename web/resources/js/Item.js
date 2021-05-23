class Item {
    constructor(seq, name, price, stock) {
        this.seq = seq;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    getItemQuantity() {
        return this.stock;
    }

    getItemId() {
        return this.seq;
    }

    getItemPrice() {
        return this.price;
    }


}