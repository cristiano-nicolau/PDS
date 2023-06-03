package Ex3;
import java.util.*;

public class Main {
    public static void main(String args[]){
        //create array list Pessoas
        ArrayList<Person> cast = new ArrayList<Person>();
        //create new person
        Person person1 = new Person("Marlon Brando");
        Person person2 = new Person("Al Pacino");
        Person person3 = new Person("James Caan");
        Person person4 = new Person("Richard S. Castellano");
        Person person5 = new Person("Robert Duvall");
        cast.add(person1);
        cast.add(person2);
        cast.add(person3);
        cast.add(person4);
        cast.add(person5);
        //create array list locations
        ArrayList<Place> locations = new ArrayList<Place>();
        //create new place
        Place place1 = new Place("New York City");
        Place place2 = new Place("New Jersey");
        Place place3 = new Place("Long Island");
        Place place4 = new Place("Hollywood");
        Place place5 = new Place("Los Angeles");
        locations.add(place1);
        locations.add(place2);
        locations.add(place3);
        locations.add(place4);
        locations.add(place5);
        //create array list languages
        ArrayList<String> languages = new ArrayList<String>();
        //create new language
        languages.add("English");
        languages.add("Italian");
        //create array list genres
        ArrayList<String> genres = new ArrayList<String>();
        //create new genre
        genres.add("Crime");
        genres.add("Drama");
        Movie movie = new Movie.Builder("The Godfather")
            .year(1972)
            .director(new Person("Francis Ford Coppola"))
            .writer(new Person("Mario Puzo"))
            .series("The Godfather")
            .cast(cast)
            .locations(locations)
            .languages(languages)
            .genres(genres)
            .isTelevision(false)
            .isNetflix(true)
            .isIndependent(false)
            .build();
            String movie1=movie.toString();
        System.out.println(movie1);
    }
}
