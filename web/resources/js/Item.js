class Item {
    constructor(seq, name, price, stock) {
        this.seq = seq;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    getItemId() {
        return this.seq;
    }

    getItemName() {
        return this.name;
    }

    getItemPrice() {
        return this.price;
    }

    getItemQuantity() {
        return this.stock;
    }

}