package ex2;

import java.util.*;


public class ContactEngine implements ContactsInterface{
    private List<Contact> contacts = new ArrayList<Contact>();
    private ContactsStorageInterface store;

    public void openAndLoad(ContactsStorageInterface store){
        this.store=store;
        if(store.loadContacts() != null){
            contacts = store.loadContacts();
        }
    }

    public void saveAndClose() {
        if(store.saveContacts(contacts)==false){
            System.out.println("Contacts not saved");
        }
        else{
            System.out.println("Contacts saved");
        }
    }

    public void saveAndClose(ContactsStorageInterface store) {
        //see if contacts is updated
        if(store.saveContacts(contacts)==false){
            System.out.println("Contacts not saved");
        }
        else{
            System.out.println("Contacts saved");
        }

    }

    public boolean exist(Contact contact) {
       return contacts.contains(contact);
    }

    public Contact getByName(String name) {
        for(Contact c : contacts){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public boolean add(Contact contact) {
        if(exist(contact)==false){
            contacts.add(contact);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean remove(Contact contact) {
        if(exist(contact)==true){
            contacts.remove(contact);
            return true;
        }
        else{
            return false;
        }
    }
    
}