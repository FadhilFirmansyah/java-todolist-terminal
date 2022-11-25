public class Todolist {
    public static String[] models = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan data Todo
     */
    public static void showTodoList() {
        System.out.println("\nTodoList\n");

        for(int i = 0; i < models.length; i++){
            String todo = models[i];
            int no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }
    //Testing
    public static void testingShowTodolist() {
        models[0] = "Coba";
        models[1] = "Coba";
        models[2] = "Coba";
        models[3] = "Coba";

        showTodoList();
    }
    
    /**
     * Menambahkan data Todo
     */
    public static void addTodoList(String todo) {
        //Cek penuh atau tidak
        boolean isFull = true;
        for(int i = 0; i < models.length; i++){
            if(models[i] == null){
                isFull = false;
                break;
            }
        }

        //Melakukan re zise kapasitas Array
        if(isFull){
            String[] temp = models;

            models = new String[models.length * 2];

            for(int i = 0; i < temp.length; i++){
                models[i] = temp[i];
            }
        }

        //Menambahkan todo kedalam models
        for(int i = 0; i < models.length; i++){
            if(models[i] == null){
                models[i] = todo;
                break;
            }
        }
    }
    //TEsting
    public static void tesingAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Counter-" + i);
        }
        showTodoList();
    }

    /**
     * Menghapus data Todo
     */
    public static boolean removeTodoList(Integer number) {
        if((number - 1) >= models.length){
            return false;
        }else if(models[number - 1] == null){
            return false;
        }else{
            for(int i = number - 1; i < models.length; i++){
                if(i == models.length - 1){
                    models[i] = null;
                }else{
                    models[i] = models[i + 1];
                }   
            }
            return true;
        }
    }
    //Testing
    public static void testingRemoveTodoList() {
        models[0] = "Satu";
        models[1] = "Dua";
        models[2] = "Tiga";
        models[3] = "Empat";

        boolean result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(9);
        System.out.println(result);

        result = removeTodoList(3);
        System.out.println(result);
        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }
    //Testing
    public static void testInput() {
        var obj = input("Masukan Nama");
        System.out.println("Testing from " + obj);
    }

    /**
     * Menampilan view show Todo
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("=====Menu=====");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = input("Pilihan Menu");

            if(input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            }else if(input.equals("x")){
                break;
            }else{
                System.out.println("Tolong masukan antara 1, 2, dan x");
            }
        }
        System.out.println("Sampai Jumpa kembali!");
    }
    public static void testingViewShow() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        viewShowTodoList();
    }
    
    /**
     * Menampilkan view add Todo
     */
    public static void viewAddTodoList() {
        System.out.println("Menambah TodoList");

        String todo = input("Todo (x, untuk cancel)");

        if(todo.equals("x")){
            System.out.println("Membatalkan menambah TodoList");
        }else{
            addTodoList(todo);
        }
    }
    //Testing
    public static void testingViewAdd() {
        viewAddTodoList();
        showTodoList();
    }

    /**
     * Menampilkan view remove Todo
     */
    public static void viewRemoveTodoList() {
        System.out.println("Menghapus TodoList");

        String number = input("Nomor Todo (x, untuk cancel)");

        if(number.equals("x")){
            System.out.println("Membatalkan menghapus TodoList");
        }else{
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal Menghapus Todo no: " + number);
            }
        }
    }

    public static void testingViewRemove() {
        addTodoList("Coba 1");
        addTodoList("Coba 2");
        addTodoList("Coba 3");
        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
