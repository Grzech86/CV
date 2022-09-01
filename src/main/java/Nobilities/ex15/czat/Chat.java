package Nobilities.ex15.czat;

import java.util.HashMap;
import java.util.Map;

public class Chat {
    private final Map<User, Message> messages = new HashMap<>();
    public Message read(User user) {
        return messages.getOrDefault(user, new Message("sorry, no new messages"));
    }

    public void write(User to, Message message) {
        messages.put(to, message);
    }
}
