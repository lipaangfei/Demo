package com.nowcoder.code.model;

public class BookInfo {
    private int id;
    private String name;
    private String author;
    private double price;
    private int status;
    public BookInfo(){} //一定要有默认构造函数
    public BookInfo(int id, String name, String author, double price, int status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.status = status;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        return id == ((BookInfo)obj).id;
    }
    public boolean isSameBook(BookInfo bookInfo){
        return this.toString().equals(bookInfo.toString());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
