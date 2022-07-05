package standardOfJava.Basic;

class Document {
    static int count = 1;
    int serial;
    String title;
    String extension;

    {
        System.out.println("ready ..");
        extension = ".txt";
    }

    Document (String title, String extension) {
        this.title = title;
        this.extension = extension;
    }
    Document () {
        this.title = "제목 없음" + count++;
    }

}

public class Initialization {
    static {
        System.out.println("접속!");
    }

    public static void main (String[] args) {
        Document doc1 = new Document();
        Document doc2 = new Document();
        Document doc3 = new Document("나는_문서다", ".pdf");
        Document doc4 = new Document();

        System.out.println(doc1.title + doc1.extension);
        System.out.println(doc2.title + doc2.extension);
        System.out.println(doc3.title + doc3.extension);
        System.out.println(doc4.title + doc4.extension);
    }
}
