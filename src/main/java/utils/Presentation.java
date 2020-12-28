package utils;

public class Presentation {
    public static void showSeparation(String chapter) {
        int sizeSeparator = 60;
        System.out.println("*".repeat(sizeSeparator));
        int sizeTitle = chapter.length();
        StringBuilder lineChapter = new StringBuilder("");
        lineChapter.append("*".repeat((sizeSeparator - sizeTitle - 2) / 2))
                .append(" ")
                .append(chapter)
                .append(" ")
                .append("*".repeat((sizeSeparator - sizeTitle - 2) / 2));
        System.out.println(lineChapter.toString());
        System.out.println("*".repeat(sizeSeparator));
    }
}
