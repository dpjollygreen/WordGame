public class Hosts extends Person {
    public Hosts() {
        super("Bob");
        Numbers num = new Numbers();
    }

    public void randomizeNum() {
        Numbers num = new Numbers();
        num.generateNumber();
    }
}
