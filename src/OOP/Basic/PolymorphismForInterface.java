package OOP.Basic;

class Parser {
    Parsable getParse(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        } else if (type.equals("HTML")) {
            return new HTMLParser();
        } else {
            System.out.println("잘못된 확장자 형식입니다.");
            return null;
        }
    }
}

interface Parsable {
    abstract public void parse(String fileName);
}

class XMLParser implements Parsable {
    public void parse(String fileName) {
        System.out.println( fileName + " : 구문 분석 완료 ");
    }
}

class HTMLParser implements Parsable {
    public void parse(String fileName) {
        System.out.println( fileName + " : 구문 분석 완료 ");
    }
}

public class PolymorphismForInterface {
    public static void main (String[] args) {
        Parsable parser = new Parser().getParse("XML");
        parser.parse("document.xml");

        Parsable parser2 = new Parser().getParse("HTML");
        parser2.parse("document.html");
    }
}
