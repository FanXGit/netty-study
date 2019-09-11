import java.util.Random;

public class test {


    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            int  random=new Random().nextInt(3);
            System.out.println(random);
        }

    }
}
