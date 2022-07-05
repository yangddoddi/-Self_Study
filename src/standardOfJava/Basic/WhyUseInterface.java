package standardOfJava.Basic;


interface Playable {
    void play();
}

class Character implements Playable {
    String name;
    Character(String name) {
        this.name = name;
    }
    public void play() {
        System.out.println("play " + toString() + "!");
    }
    public String toString() {
        return this.name;
    }
}
class User {
    public void play(Playable playable) {
        playable.play();
    } // 직접적으로 Character 클래스에 접근하지 않기 때문에 Character 클래스가 어떻게 구현되든 상관없이 인터페이스만 있으면 구현 가능
}

class WhyUseInterface {
    public static void main(String[] args) {
        User user = new User();
        user.play(new Character("Jinx"));
        user.play(new Character("Garen"));
    }
}