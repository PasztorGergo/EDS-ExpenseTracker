package Enginear.eds.ExpenseTracker;

public class App {
    public static void main(String[] args) {
        AppFrame appFrame = new AppFrame();
        Model model = new Model();

        AppController controller = new AppController(model, appFrame);
    }
}
