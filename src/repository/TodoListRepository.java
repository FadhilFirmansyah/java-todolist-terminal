package repository;

import entity.Todolist;

public interface TodoListRepository {
    Todolist[] findAll();
    void add(Todolist todolist);
    boolean remove(Integer number);
}
