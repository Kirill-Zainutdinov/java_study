package HW_11.notebook;
//gb.ru/lessons/344155#s5578
import HW_11.notebook.controller.UserController;
import HW_11.notebook.model.repository.GBRepository;
import HW_11.notebook.model.repository.impl.UserRepository;
import HW_11.notebook.view.UserView;

import static HW_11.notebook.util.DBConnector.DB_PATH;
import static HW_11.notebook.util.DBConnector.createDB;

public class Main {
    public static void main(String[] args) {
        createDB();
        GBRepository repository = new UserRepository(DB_PATH);
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();

    }
}
