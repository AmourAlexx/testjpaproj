package ua.com.levelup.jpatestproj.model.dao;

public interface DAO<T> {

    T save();
    boolean remove();


}
