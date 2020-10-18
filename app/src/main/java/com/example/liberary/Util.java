package com.example.liberary;

import java.util.ArrayList;

public class Util  {

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;

    private static int id = 0;

    public Util(){
        if(allBooks == null){
            allBooks = new ArrayList<>();
            initallBooks();
        }
        if(currentlyReadingBooks == null){
            currentlyReadingBooks = new ArrayList<>();
        }
        if(wantToReadBooks == null){
            wantToReadBooks = new ArrayList<>();
        }
        if (alreadyReadBooks == null){
            alreadyReadBooks= new ArrayList<>();
        }

    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public boolean addCurrentlyReadingBooks (Book book){
         return   currentlyReadingBooks.add(book);
    }

    public boolean addWantToReadBooks (Book book){
        return   wantToReadBooks.add(book);
    }

    public boolean addAlreadyReadBooks (Book book){
        return   alreadyReadBooks.add(book);
    }

    public boolean removeCurrentlyReadingBook (Book book){
        return currentlyReadingBooks.remove(book);
    }

    public boolean removeWantToReadBooksk (Book book){
        return wantToReadBooks.remove(book);
    }

    public boolean removeAlreadyReadBooks (Book book){
        return alreadyReadBooks.remove(book);
    }


    private static void initallBooks(){
        //TODO: initialize all books array list

        String name = "";
        String author = "";
        int pages = 0;
        String imageUrl;
        String description;

        id++;
        name = "pride and prejudice";
        author = "Jane Austen";
        pages = 279;
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/17/PrideAndPrejudiceTitlePage.jpg";
        description = "Pride and Prejudice is a romantic novel of manners written by Jane Austen in 1813. The novel follows the character development of Elizabeth Bennet, the dynamic protagonist of the book who learns about the repercussions of hasty judgments and comes to appreciate the difference between superficial goodness and actual goodness";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));

        id++;
        name = "1984";
        author = "George Orwell";
        pages = 237;
        imageUrl = "https://upload.wikimedia.org/wikipedia/en/c/c3/1984first.jpg";
        description = "Among the seminal texts of the 20th century, Nineteen Eighty-Four is a rare work that grows more haunting as its futuristic purgatory becomes more real. Published in 1949, the book offers political satirist George Orwell's nightmarish vision of a totalitarian, bureaucratic world and one poor stiff's attempt to find individuality";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));

        id++;
        name = "The Great Gatsby";
        author = "F. Scott Fitzgerald, Francis Scott Fitzgerald";
        pages = 200;
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/a/a0/The_Great_Gatsby_cover_1925_%281%29.jpg";
        description = "The Great Gatsby, F. Scott Fitzgerald's third book, stands as the supreme achievement of his career";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));


        id++;
        name = "To Kill a Mockingbird";
        author = "Harper Lee";
        pages = 324;
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/4/4f/To_Kill_a_Mockingbird_%28first_edition_cover%29.jpg";
        description = "The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));


        id++;
        name = "Catch-22";
        author = "Joseph Heller";
        pages = 453;
        imageUrl = "https://upload.wikimedia.org/wikipedia/en/9/99/Catch22.jpg";
        description = "The novel is set during World War II, from 1942 to 1944. It mainly follows the life of Captain John Yossarian, a U.S. Army Air Forces B-25 bombardier";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));


        id++;
        name = "The Catcher in the Rye";
        author = "J.D. Salinger";
        pages = 277;
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/89/The_Catcher_in_the_Rye_%281951%2C_first_edition_cover%29.jpg";
        description = "The hero-narrator of The Catcher in the Rye is an ancient child of sixteen, a native New Yorker named Holden Caulfield";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));


        id++;
        name = "Animal Farm";
        author = " George Orwell, Russell Baker";
        pages = 141 ;
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/f/fb/Animal_Farm_-_1st_edition.jpg";
        description = "A farm is taken over by its overworked, mistreated animals. With flaming idealism and stirring slogans, they set out to create a paradise of progress, justice, and equality";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));



        id++;
        name = "Great Expectations";
        author = "Charles Dickens, Marisa Sestino";
        pages = 505 ;
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/8d/Greatexpectations_vol1.jpg";
        description = "In what may be Dickens's best novel, humble, orphaned Pip is apprenticed to the dirty work of the forge but dares to dream of becoming a gentleman";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));


        id++;
        name = "Jane Eyre";
        author = "Charlotte Brontë, Michael Mason";
        pages = 532 ;
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9b/Jane_Eyre_title_page.jpg";
        description = "Orphaned as a child, Jane has felt an outcast her whole young life";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));


        id++;
        name = "Wuthering Heights";
        author = "Charles Dickens, Marisa Sestino";
        pages = 505 ;
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/2/29/Wuthering_Heights_%281939_poster%29.jpg";
        description = "This best-selling Norton Critical Edition is based on the 1847 first edition of the novel. For the Fourth Edition, the editor has collated the 1847 text with several modern editions and has corrected a number of variants, including accidentals";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));


        id++;
        name = "Little Women";
        author = "Louisa May Alcott";
        pages = 449 ;
        imageUrl = "https://upload.wikimedia.org/wikipedia/en/9/9d/Little_Women_%282019_film%29.jpeg";
        description = "Generations of readers young and old, male and female, have fallen in love with the March sisters of Louisa May Alcott’s most popular and enduring novel, Little Women";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));


        id++;
        name = "Lord of the Flies";
        author = "William Golding";
        pages = 182 ;
        imageUrl = "https://upload.wikimedia.org/wikipedia/en/9/9b/LordOfTheFliesBookCover.jpg";
        description = "At the dawn of the next world war, a plane crashes on an uncharted island, stranding a group of schoolboys";
        allBooks.add(new Book(id, name, author,pages,imageUrl,description));


    }


}
