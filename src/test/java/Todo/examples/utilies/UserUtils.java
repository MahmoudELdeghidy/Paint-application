package Todo.examples.utilies;

import Todo.examples.objects.Users;
import com.github.javafaker.Faker;

public class UserUtils {
    public static Users generateRandomUsers()
    {
        String firstName=new Faker().name().firstName();
        String lastName=new Faker().name().lastName();
        String email=new Faker().internet().emailAddress();
        String password=new Faker().internet().password();

        Users users=new Users(firstName,lastName,email,password);
        return users;
    }
}
