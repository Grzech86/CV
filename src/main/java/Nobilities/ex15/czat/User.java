package Nobilities.ex15.czat;

import java.util.Objects;

public class User {
    private final String nick;

    public User(String nick) {
        this.nick = nick;
    }

    private Message createNextMessage() {
        return new Message("ala ma kota");
    }

    public Message read(Chat chat) {
        return chat.read(this);
    }

    public void write(Chat chat, User to) {
        chat.write(to, createNextMessage());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return nick.equals(user.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick);
    }
}
