package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;
    public TodoListView(TodoListService todoListService){
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true) {
            todoListService.showTodoList();

            System.out.println("=====Menu=====");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = InputUtil.input("Pilihan Menu");

            if(input.equals("1")){
                addTodoList();
            }else if(input.equals("2")){
                removeTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Tolong masukan antara 1, 2, dan x");
            }
        }
        System.out.println("Sampai Jumpa kembali!");
    }

    public void addTodoList(){
        System.out.println("Menambah TodoList");

        String todo = InputUtil.input("Todo (x, untuk cancel)");

        if(todo.equals("x")){
            System.out.println("Membatalkan menambah TodoList");
        }else{
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList(){
        System.out.println("Menghapus TodoList");

        String number = InputUtil.input("Nomor Todo (x, untuk cancel)");

        if(number.equals("x")){
            System.out.println("Membatalkan menghapus TodoList");
        }else{
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}
