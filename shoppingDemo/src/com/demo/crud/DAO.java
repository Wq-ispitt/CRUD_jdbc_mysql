package com.demo.crud;

import java.util.List;


public interface DAO {
	
    public void add(Products pro);
    
    public void update(Products pro);
    
    //delete based on id
    public void delete(int id);
    //search based on id
    public Products get(int id);
    
    public List<Products> view();
    
    public List<Products> viewRange(int start, int count);

}
