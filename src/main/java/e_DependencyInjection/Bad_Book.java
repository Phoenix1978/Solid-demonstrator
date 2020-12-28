package e_DependencyInjection;

import java.io.FileWriter;

public class Bad_Book {

    private String title;
    private String author;

    public Bad_Book(String title, String author) {
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

    public void save() {
        try {
            FileWriter fw = new FileWriter("temp/Bad_Books.txt");
            fw.write(this.getTitle() + "-" + this.getAuthor());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Saved done in Bad_Books.txt");
    }
}

class TesterBadBook {
    static void go() {
        Bad_Book myBook = new Bad_Book("20 000 lieux sous les mers", "Jules Verne");
        myBook.save();
    }
}
