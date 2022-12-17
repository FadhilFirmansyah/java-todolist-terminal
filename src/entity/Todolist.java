package entity;

public class Todolist {
    private String todo;

    public Todolist(){

    }

    public Todolist(String todo){
        this.todo = todo;
    }

    public void setTodo(String todo){
        this.todo = todo;
    }

    public String getTodo(){
        return this.todo;
    }
}
