package ex2;
import java.util.*;

public interface ContactsStorageInterface {
    public  List<Contact> loadContacts();
    public  boolean saveContacts(List<Contact>list);
}