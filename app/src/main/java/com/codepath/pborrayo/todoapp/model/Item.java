package com.codepath.pborrayo.todoapp.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by pborrayo on 9/29/16.
 */

@Table(name = "Item")
public class Item extends Model {

    @Column(name = "itemText")
    public String itemText;

    public Item() {
        super();
    }

    public Item(String description) {
        super();
        this.itemText = description;
    }

    public static List<Item> getAll() {
        return new Select()
            .from(Item.class)
            .execute();
    }

}
