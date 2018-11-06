package com.eatogether.Controller;

import java.util.Comparator;

import com.eatogether.model.Chat;

class Sortbyid implements Comparator<Chat> 
{ 
    public int compare(Chat a, Chat b) 
    { 
        return Integer.parseInt(a.getId()) -  Integer.parseInt(b.getId()); 
    } 
} 