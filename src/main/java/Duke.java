import java.util.Scanner;
import java.util.ArrayList;


public class Duke {
    protected static final ArrayList<Task> taskList = new ArrayList<>();
    protected static boolean canExit = false;
    private final TaskList tasks;
    private final Storage storage;
    private final Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(taskList);

    }



    public void Greet() {
        String greeting = "____________________________________________________________\n"
                + "Hello! I'm Duke, 恭喜发财 \u263a.\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(greeting);

    }

    public void run() throws InvalidCommandException {
        Scanner sc = new Scanner(System.in);
        String description = sc.nextLine();
        Parser parser = new Parser(taskList, tasks);
        parser.readCommand(description);
    }


    public void Exit() {
            String exit = "____________________________________________________________\n"
            + "Bye. Hope to see you again soon!\n"
            + "Wish you all the best for CS2103T\n"
            + "____________________________________________________________\n";

            canExit = true;
            System.out.println(exit);

        }

    public static void main(String[] args) {

        String path = "duke.txt";
        Duke duke = new Duke(path);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);

        duke.Greet();


        Storage dukeBot = new Storage(path);
        dukeBot.taskRecorder();
        dukeBot.taskHistory(path);
        dukeBot.load(taskList);


        while(!canExit) {
            try {
                duke.run();
            } catch (InvalidCommandException e) {
                System.out.println(e.toString());
            }
        }

        dukeBot.record(taskList);
        duke.Exit();

    }
}
