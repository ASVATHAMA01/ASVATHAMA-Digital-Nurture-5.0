public class BuilderTest {
    public static void main(String[] args) {
        Computer gaming = new Computer.Builder()
                .cpu("Intel i9")
                .ram("32GB")
                .storage("1TB SSD")
                .build();

        Computer office = new Computer.Builder()
                .cpu("Intel i5")
                .ram("8GB")
                .build();

        Computer basic = new Computer.Builder()
                .cpu("Celeron")
                .build();

        System.out.println(gaming);
        System.out.println(office);
        System.out.println(basic);
    }
}