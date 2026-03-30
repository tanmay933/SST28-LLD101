package bookmyshow.repository;

import bookmyshow.model.User;
import java.util.*;

public class UserRepository {

    private Map<String, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.toString(), user);
    }

    public User get(String id) {
        return users.get(id);
    }
}