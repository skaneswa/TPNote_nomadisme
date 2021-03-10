package fr.upec.episen.resources.object;


import lombok.Data;

import java.util.ArrayList;

@Data
public class Book {

    public Book(){
        super();
    }

    public Book(String title, String isbn, int price){
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    private String title;
    private int price;
    private String isbn;
    private int quantity;


}
