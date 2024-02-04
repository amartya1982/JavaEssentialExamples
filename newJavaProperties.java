import java.util.random.RandomGenerator;

public class newJavaProperties {
    public static void main(String args[]){
        RandomGenerator random = RandomGenerator.of("L128X128MixRandom");
        for(int i=0;i<10;i++)
            System.out.println(random.nextInt(200));
    }
}
