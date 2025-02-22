package WarmUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Movie implements Comparable<Movie> {

    String name;
    int year;
    String director;

    public static void main(String args[]){
         List<Movie> movies = new ArrayList<>();
//
        ///

     //   Singleton singleton = new Singleton();
        //based on year
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if(o1.year<o2.year)
                return 1;
                else
                    return -1;
            }
        });

Collections.sort(movies, (o1, o2)->{return o1.year-o2.year;});
      //  Collections.sort(movies, );

        //

        //
        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if(o1.year<o2.year)
                    return 1;
                else
                    return -1;
            }
        });
    }


    @Override
    public int compareTo(Movie o) {
        return 0;
    }
}
