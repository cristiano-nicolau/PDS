package ex2;
public class Contact {
    //create contact
    private String name;
    private String phone;
    
    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return  name + "\t"+ phone;
    }
    
}
