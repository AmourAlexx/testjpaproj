import model.User;
import model.dao.DAO;
import model.dao.ListDAO;
import model.dao.UserDAO;
import model.dao.UsersDAO;

public class Main {

    public static void main(String[] args){

        User a = new User();
        a.setLogin("Test234");
        a.setEmail("test@test.com");
        a.setPassword("qwerty");

        DAO d = new UserDAO(a);
        a = (User)d.save();

        ListDAO users = new UsersDAO();
        User b = (User)users.findById(a.getId());

    }
}
