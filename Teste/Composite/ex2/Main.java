package Composite.ex2;

public class Main {
    public static void main(String[] args) {
        File f1 = new File("file1.txt", 5);
        File f2 = new File("file2.txt", 3);
        File f3 = new File("file3.txt", 8);
        File f4 = new File("file4.txt", 12);
        File f5 = new File("file5.txt", 7);
        File f6 = new File("file6.txt", 1);

        Repository r1 = new Repository("Repositoy1");
        Repository r2 = new Repository("Repositoy2");

        r1.addFile(f1);
        r1.addFile(f2);
        r1.addFile(f6);

        r2.addFile(f5);
        r2.addFile(f4);
        r2.addFile(f3);

        r1.show();
        r2.show();
    
    }   
}
