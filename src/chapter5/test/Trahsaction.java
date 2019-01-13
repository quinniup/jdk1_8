package chapter5.test;

public class Trahsaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Trahsaction(Trader trader,int year,int value){
        this.trader=trader;
        this.year=year;
        this.value=value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Trahsaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
