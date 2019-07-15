package com.spring.jpa.controller;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender<T> {

    private String url;
    private Page<T> page;
    private int totalPages;
    private int numPages;
    private int pageActual;
    private List<PageItem> pages;

    public PageRender(String url, Page<T> page){
        this.url = url;
        this.page = page;
        this.pages = new ArrayList<PageItem>();
        totalPages = page.getSize();
        numPages = page.getTotalPages();
        pageActual = page.getNumber() + 1;

        int from, to;
        if(totalPages <= numPages){
            from = 1;
            to = totalPages;
        }else {
            if(pageActual <= numPages/2){
                from = 1;
                to = numPages;
            } else if(pageActual >= (totalPages - numPages/2)){
                from = totalPages - (numPages + 1);
                to = numPages;
            } else {
                from = pageActual - (numPages/2);
                to = numPages;
            }
        }

        for(int i = 0; i < to; i++){
            pages.add(new PageItem(from + i, (pageActual == from + i) ));
        }
    }

    public int getNumPages() { return numPages; }

    public String getUrl() { return url; }

    public int getTotalPages() { return totalPages; }

    public int getPageActual() { return pageActual; }

    public List<PageItem> getPages() { return pages; }

    public boolean isFirst(){ return page.isFirst(); }

    public boolean isLast(){
        return page.isLast();
    }

    public boolean isHasNext(){ return  page.hasNext(); }

    public boolean isHasPrevius(){
        return page.hasPrevious();
    }
}
