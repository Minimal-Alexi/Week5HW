import java.util.Random;

public class Dice {
    private Random rand;
    private int die1,die2;
    public Dice() {
        rand = new Random();
    }
    public void roll(){
        System.out.println("Rolling the dice...");
        die1 = rand.nextInt(6) + 1;
        die2 = rand.nextInt(6) + 1;
        if(isDouble()) System.out.println("You rolled a double!");
    }
    public boolean isDouble(){
        if(die1 == die2) return true;
        return false;
    }
    public int luckyDoubleCheck(){
        int numberOfTries = 1;
        roll();
        while(!isDouble()){
            roll();
            numberOfTries++;
        }
        return numberOfTries;
    }
    public int getDie1(){
        return die1;
    }
    public int getDie2(){
        return die2;
    }
}
