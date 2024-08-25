public class Players extends Person {

    public Players() {
        super("");
        money = 1000;
    }

    public Players(String firstName){
        super(firstName);
        money = 1000;
    }

    public Players(String firstName, String lastName){
        super(firstName, lastName);
        money = 1000;
    }
    private double money;

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double reward) {
        money += reward;
    }

    @Override
    public String toString() {
        return getFirstName() + "'s cash: $" + money;
    }

}

