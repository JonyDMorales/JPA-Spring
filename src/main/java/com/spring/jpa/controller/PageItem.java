package com.spring.jpa.controller;

public class PageItem {

    private int numItem;
    private boolean actual;

    public PageItem(int numItem, boolean actual) {
        this.numItem = numItem;
        this.actual = actual;
    }

    public int getNumItem() {
        return numItem;
    }

    public boolean isActual() {
        return actual;
    }
}
