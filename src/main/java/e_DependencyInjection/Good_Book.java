package e_DependencyInjection;

import java.io.FileWriter;

public class Good_Book {

    private String title;
    private String author;

    public Good_Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class HomeWork extends Good_Book{
    private String matter;

    public HomeWork(String title, String author, String matter) {
        super(title, author);
        this.matter = matter;
    }

    public String getMatter() {
        return matter;
    }
}

class BookDB {
    BookPersist bookPersist;

    public void save(Good_Book book) {
        bookPersist.save(book);
    }
}

interface BookPersist {
    public void save(Good_Book book);
    public void save(HomeWork book);
}

class FilePersist implements BookPersist {

    @Override
    public void save(Good_Book book) {
        try {
            FileWriter fw = new FileWriter("temp/Good_Book.txt");
            fw.write(book.getTitle() + "-" + book.getAuthor());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Saved done in Good_Book.txt");
    }

    @Override
    public void save(HomeWork homeWork) {
        try {
            FileWriter fw = new FileWriter("temp/Good_Homework.txt");
            fw.write(homeWork.getTitle() + "-" + homeWork.getAuthor() + "-" + homeWork.getMatter());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Saved done in Good_Homework.txt");
    }

}

class TesterGoodBook {
    static void go() {
        Good_Book myBook = new Good_Book("20 000 lieux sous les mers", "Jules Verne");
        FilePersist myPersister = new FilePersist();
        myPersister.save(myBook);
        HomeWork myHomework = new HomeWork("Preparation au bac S", "The professor", "Mathematics");
        myPersister.save(myHomework);
    }
}
