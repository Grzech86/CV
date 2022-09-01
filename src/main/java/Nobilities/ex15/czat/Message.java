package Nobilities.ex15.czat;

import java.util.Objects;

public class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return content.equals(message.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
