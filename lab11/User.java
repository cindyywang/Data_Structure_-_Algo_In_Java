import java.util.Arrays;

public class User implements Comparable<User> {
    /** Global counter tracking the next available id **/
    private static int nextId = 1;
    /** Identifier marking that this is the id-th user created **/
    private int id;
    /**
     * For this assignment, age is just an automatically assigned field
     * for the sake of variety.
     */
    private int age;
    private String username;
    private String email;

    public User(String username, String email) {
        id = nextId++;
        this.username = username;
        this.email = email;
        setAge();
    }

    /** Force assign an id to a created user **/
    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        setAge();
    }

    void setAge() {
        age = (id % 13) + 20;
    }

    int getAge() {
        return age;
    }

    int getId() {
        return id;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if(o.equals(age))
        {
            return true;
        }
        else if(o.equals(id))
        {
            return true;
        }
        else if(o.equals(username))
        {
            return true;
        }
        else if(o.equals(email))
        {
            return true;
        }
        else
        {
            return false;
        }// FIX ME
    }

    public int compareTo(User u)
    {
        /*if(//u.equals(age) && u.equals(username) && u.equals(email) && //u.equals(id))
        {
            if(u.equals(username))
            {
                return 0;
            }
        }
        else
        {

        }
        */
        if(id == u.getId())
        {
            if(u.equals(username))
            {
                return 0;
            }
            else
            {
                return username.compareTo(u.getUsername());
            }
        }
        else
        {
            return id-u.getId();
        }
    }

    public static void main(String[] args) {
        User[] users = {new User(2, "christine", ""), new User(4, "antares", ""), new User(5, "ching", ""),
                new User(1, "daniel", ""), new User(1, "dan", "")};
        Arrays.sort(users);
        System.out.println(Arrays.toString(users));
    }
}
