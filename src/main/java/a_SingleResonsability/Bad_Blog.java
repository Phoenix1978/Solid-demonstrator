package a_SingleResonsability;

import java.io.FileWriter;

public class Bad_Blog {
    String title = "Microservices";
    String author = "Feynmann";

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void printBlog() {
        System.out.println(this.getAuthor() + "-" + this.getTitle());
    }

    public void persist() {
        try {
            FileWriter fw = new FileWriter("temp/BAD" + getTitle() + "-" + getAuthor() + ".txt");
            fw.write(getTitle() + "-" + getAuthor());
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class TesterBadBlog {
    static void go(){
        Bad_Blog badBlog = new Bad_Blog();
        badBlog.printBlog();
        badBlog.persist();
    }
}
