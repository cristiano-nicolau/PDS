package Composite.ex2;

import java.util.ArrayList;

public class Repository implements Interface{
    private String name;
    ArrayList<Interface> files = new ArrayList<Interface>();

    public Repository(String r){
        name = r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Interface> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<Interface> files) {
        this.files = files;
    }

    public void addFile(File f){
        files.add(f);
    }

    public void removeFile(File f){
        files.remove(f);
    }

    @Override
    public void show() {
        System.out.println("Repository name: " +name);
        System.out.println("Repository size: " + files.size());
        for (Interface f : files){
            f.show();
        }

    }

    
    
}
