package se.kth.iv1350.highergradetasks;

public class Main {
    private static void testInheritedSummingRandom()
    {
        InheritedSummingRandom rand = new InheritedSummingRandom(5); //Determined by random dice roll }
        double sum = 0.0;
        for(int i = 0; i < 1; i++){
            sum += rand.nextInt();
            sum += rand.nextDouble();
            sum += rand.nextInt(13);
            sum += rand.nextFloat();
            sum += rand.nextLong();
            sum += rand.nextGaussian();
            byte[] arrayOfBytes = new byte[4];
            rand.nextBytes(arrayOfBytes);
            sum += arrayOfBytes[0];
            sum += arrayOfBytes[1];
            sum += arrayOfBytes[2];
            sum += arrayOfBytes[3];
        }
        System.out.println("Sum of inherited random: " + rand.getSum() + "(should be " + sum + ")");
        System.out.println("Difference: " + Math.abs(rand.getSum() - sum));
    }

    private static void testComposedSummingRandom()
    {
        ComposedSummingRandom rand = new ComposedSummingRandom(5); //Determined by random dice roll }
        double sum = 0;
        for(int i = 0; i < 1; i++){
            sum += rand.nextInt();
            sum += rand.nextDouble();
            sum += rand.nextInt(13);
            sum += rand.nextFloat();
            sum += rand.nextLong();
            sum += rand.nextGaussian();
            byte[] arrayOfBytes = new byte[4];
            rand.nextBytes(arrayOfBytes);
            sum += arrayOfBytes[0];
            sum += arrayOfBytes[1];
            sum += arrayOfBytes[2];
            sum += arrayOfBytes[3];
        }
        System.out.println("Sum of composed random: " + rand.getSum() + "(should be " + sum + ")");
        System.out.println("Difference: " + Math.abs(rand.getSum() - sum));
    }
    public static void main(String[] args) {
        testInheritedSummingRandom();
        testComposedSummingRandom();
    }
}
