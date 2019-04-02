/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author ihebm
 */
public interface IService<T> {
        public void insert(T o);
    public void delete(T o);
    public List<T> displayAll();
    public T displayById(int id);
    
    public boolean update(T os);
}
