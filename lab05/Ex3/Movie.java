package Ex3;
import java.util.*;

public class Movie {
    private final String  tittle;
    private final int     year;
    private final Person director;
    private final Person  writer;
    private final String  series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder{
        // Required parameters
        private final String  tittle;
        //Optional parameters
        private int  year = 0;
        private Person director = null;
        private Person writer = null;
        private String series = null;
        private List<Person> cast = new ArrayList<Person>();
        private List<Place> locations = new ArrayList<Place>();
        private List<String> languages = new ArrayList<String>();
        private List<String> genres = new ArrayList<String>();
        private boolean isTelevision = false;
        private boolean isNetflix = false;
        private boolean isIndependent = false;   

        public Builder(String tittle){
            this.tittle = tittle;
        }

        public Builder year(int val){
            year = val;
            return this;
        }

        public Builder director(Person val){
            director = val;
            return this;
        }

        public Builder writer(Person val){
            writer = val;
            return this;
        }

        public Builder series(String val){
            series = val;
            return this;
        }

        public Builder cast(List<Person> val){
            cast = val;
            return this;
        }

        public Builder locations(List<Place> val){
            locations = val;
            return this;
        }

        public Builder languages(List<String> val){
            languages = val;
            return this;
        }

        public Builder genres(List<String> val){
            genres = val;
            return this;
        }

        public Builder isTelevision(boolean val){
            isTelevision = val;
            return this;
        }

        public Builder isNetflix(boolean val){
            isNetflix = val;
            return this;
        }

        public Builder isIndependent(boolean val){
            isIndependent = val;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

    private Movie(Builder builder){
        tittle=builder.tittle;
        year=builder.year;
        director=builder.director;
        writer=builder.writer;
        series=builder.series;
        cast=builder.cast;
        locations=builder.locations;
        languages=builder.languages;
        genres=builder.genres;
        isTelevision=builder.isTelevision;
        isNetflix=builder.isNetflix;
        isIndependent=builder.isIndependent;
    }

    @Override
    public String toString(){
        return "Movie{"+
            "tittle='"+tittle+'\''+
            ", year="+year+
            ", director="+director+
            ", writer="+writer+
            ", series='"+series+'\''+
            ", cast="+cast+
            ", locations="+locations+
            ", languages="+languages+
            ", genres="+genres+
            ", isTelevision="+isTelevision+
            ", isNetflix="+isNetflix+
            ", isIndependent="+isIndependent+
            '}';
    }
}
