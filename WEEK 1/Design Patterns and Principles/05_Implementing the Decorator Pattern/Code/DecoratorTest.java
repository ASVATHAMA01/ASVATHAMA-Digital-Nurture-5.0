public class DecoratorTest {
    public static void main(String[] args) {
        Notifier email = new EmailNotifier();

        Notifier emailAndSMS = new SMSNotifierDecorator(email);

        Notifier all = new SlackNotifierDecorator(emailAndSMS);

        System.out.println("--- Email only ---");
        email.send();

        System.out.println("--- Email + SMS ---");
        emailAndSMS.send();

        System.out.println("--- Email + SMS + Slack ---");
        all.send();
    }
}