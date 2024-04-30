import java.util.ArrayList;
import java.util.List;

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class ChatRoom {
    private String roomName;
    private List<User> users;
    private List<String> messages;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void sendMessage(User sender, String message) {
        messages.add(sender.getUsername() + ": " + message);
    }

    public void displayMessages() {
        System.out.println("Chat Room: " + roomName);
        for (String msg : messages) {
            System.out.println(msg);
        }
    }
}

public class ChatApplication {
    public static void main(String[] args) {
        User user1 = new User("Alvaro");
        User user2 = new User("Xavi");

        ChatRoom generalChat = new ChatRoom("General");
        generalChat.addUser(user1);
        generalChat.addUser(user2);

        generalChat.sendMessage(user1, "Bienvenido, Alvaro!");
        generalChat.sendMessage(user2, "Hola, Xavi!");

        generalChat.displayMessages();
    }
}
