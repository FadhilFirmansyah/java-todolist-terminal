package test.service;

import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepo = new TodoListRepositoryImpl();
        todoListRepo.data[0] = new Todolist("Object Pertama");
        todoListRepo.data[1] = new Todolist("Object Kedua");
        todoListRepo.data[2] = new Todolist("Object Ketiga");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepo);

        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListServiceImpl todoListServiceImpl = new TodoListServiceImpl(todoListRepository);

        todoListServiceImpl.addTodoList("Satu");
        todoListServiceImpl.addTodoList("Dua");
        todoListServiceImpl.addTodoList("Tiga");
        todoListServiceImpl.addTodoList("Empat");

        todoListServiceImpl.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListServiceImpl todoListServiceImpl = new TodoListServiceImpl(todoListRepository);

        todoListServiceImpl.addTodoList("Satu");
        todoListServiceImpl.addTodoList("Dua");
        todoListServiceImpl.addTodoList("Tiga");
        todoListServiceImpl.addTodoList("Empat");

        todoListServiceImpl.showTodoList();

        todoListServiceImpl.removeTodoList(2);
        todoListServiceImpl.showTodoList();
        todoListServiceImpl.removeTodoList(5);
        todoListServiceImpl.showTodoList();
        todoListServiceImpl.removeTodoList(1);
        todoListServiceImpl.showTodoList();
    }
}
