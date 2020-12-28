package a_SingleResonsability;

import java.io.FileWriter;

public class Good_Blog {
    String title = "Microservices";
    String author = "Feynmann";

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

interface Printer {
    public void print(Good_Blog blog);
}

class CLIPrinter implements Printer {
    @Override
    public void print(Good_Blog blog) {
        System.out.println(blog.getAuthor() + "-" + blog.getTitle());
    }
}

interface Persist {
    public void save(Good_Blog blog);
}

class FilePersist implements Persist {
    @Override
    public void save(Good_Blog blog) {
        try {
            FileWriter fw = new FileWriter("temp/GOOD" + blog.getTitle() + "-" + blog.getAuthor() + ".txt");
            fw.write(blog.getTitle() + "-" + blog.getAuthor());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class TesterGoodBlog {
    static void go() {
        Good_Blog goodBlog = new Good_Blog();
        CLIPrinter myPrinter = new CLIPrinter();
        myPrinter.print(goodBlog);
        FilePersist myPersister = new FilePersist();
        myPersister.save(goodBlog);
    }
}