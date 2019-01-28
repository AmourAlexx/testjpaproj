package model.dao;

public interface DAO<T> {

    T save();
    boolean remove();


}
