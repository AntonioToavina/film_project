package com.antonio.spring_mvc.DAO;

import java.util.ArrayList;
import java.util.List;

public interface InterfaceDAO {

    public void save(Object obj);

    public void update(Object obj);

    public List<Object> findAll(Object obj);

    public void delete(Object obj);

    public Object findById(Object obj);

    List<Object> find(Object obj,boolean all,int start,int limit);
}