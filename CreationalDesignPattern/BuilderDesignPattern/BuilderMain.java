package CreationalDesignPattern.BuilderDesignPattern;

import java.time.Year;

public class BuilderMain {


    public static void main(String[] args){
        Book book1 = new Book.Builder("0-12-345678-9", "Moby-Dick")
                .genre(Genre.HIGH)
                .author("Herman Melville")
                .published(Year.of(1851))
                .description(
                        "The book is the sailor Ishmael's narrative of the obsessive quest of "
                                + "Ahab, captain of the whaling ship Pequod, for revenge on Moby Dick, "
                                + "the giant white sperm whale that on the ship's previous voyage bit "
                                + "off Ahab's leg at the knee."
                )
                .build();

        System.out.println(book1);

        Book.Builder bookBuilder = new Book.Builder("0-12-345678-9", "Moby-Dick")
                .genre(Genre.LOW)
                .author("Herman Melville")
                .published(Year.of(1851))
                .description("description omitted for brevity");

// Create a first Book object
        Book book2 = bookBuilder.build();

// Create a second, slightly different, object reusing the same Builder instance
        book2 = bookBuilder.published(Year.of(1952)).build();
        System.out.println(book2.getAuthor());
        System.out.println(book2.getPublished());

    }
}
