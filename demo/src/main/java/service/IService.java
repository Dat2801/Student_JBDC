package service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    T save(int id, T t);
    T edit(int id, T t);
    T findById(int id);
    void delete(int id);

}
