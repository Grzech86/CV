package Nobilities.ex15.czat;

public class ChatMain {
    public static void main(String[] args) {
        Chat chat = new Chat();
        User user1 = new User("user 1");
        User user2 = new User("user 2");

        user1.write(chat, new User("user 2"));

        Message message1 = user2.read(chat);

        System.out.println("message is: " + message1.getContent());
    }
}
