public class ProxyTest {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("photo1.jpg");
        Image img2 = new ProxyImage("photo2.jpg");

        System.out.println("--- First display (loads + displays) ---");
        img1.display();

        System.out.println("--- Second display (cached, no load) ---");
        img1.display();

        System.out.println("--- Display img2 (loads + displays) ---");
        img2.display();
    }
}