package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{
    private TodoListRepository todoListRepository;
    
    public TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        Todolist[] models = todoListRepository.findAll();

        System.out.println("\nTodoList\n");

        for(int i = 0; i < models.length; i++){
            var todo = models[i];
            int no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("Sukses");
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if(success){
            System.out.println("Sukses Menghapus");
        }else{
            System.out.println("Gagal Menghapus");
        }
    }
}
