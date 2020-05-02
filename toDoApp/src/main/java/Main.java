import java.util.Scanner;

public class Main {

    static String [] tasks = new String[100];
    static String [] changeLog = new String[100];

    static int tasksCount = 0;
    static int projectsCount = 0;
    static int changeLogCount = 0;

    public static void displayMenu() {
        System.out.println("1 - Create new task");
        System.out.println("2 - Remove task");
        System.out.println("3 - Display all tasks");
        System.out.println("4 - Display change log");
        System.out.println("0 - Exit app");
    }

    public static void addTask(String task) {
        boolean hasCapacityForNewTask = tasksCount < tasks.length;
        if (hasCapacityForNewTask) {
            tasks[tasksCount] = task;
            tasksCount++;
            addLog("Dodano nowe zadanie: " + task);
        } else {
            addLog("Nie udało się dodać nowego zadania: " + task);
        }
    }

    public static void removeTask(int indexTask) {
        boolean isTaskExist = indexTask < tasksCount;
        if (isTaskExist) {
            addLog("Usunięto zadanie: " + tasks[indexTask]);
            for(int i=indexTask; i<tasksCount-1;i++) {
                tasks[i] = tasks[i+1];
            }
            tasksCount--;
        } else {
            addLog("Nie udało się usunąć zadania: " + tasks[indexTask]);
        }

    }

    public static void displayTasks() {
        System.out.println("List of tasks: ");
        for (int i=0; i<tasksCount;i++) {
            System.out.println(tasks[i]);
        }
        addLog("Wyświetlono listę zadań");
    }


    public static void addLog(String log){
        boolean hasCapacityForNewLog = changeLogCount < changeLog.length;
        if (hasCapacityForNewLog) {
            changeLog[changeLogCount] = log;
            changeLogCount++;
        }
    }

    public static void displayChangeLog() {
        System.out.println("Change log: ");
        for (int i=0; i<changeLogCount;i++) {
            System.out.println(changeLog[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radix;
        boolean isApplicationRun = true;
        while(isApplicationRun) {
            displayMenu();
            System.out.print("Type number to choose option: ");
            radix = scanner.nextInt();

            switch(radix) {
                case 1:
                    System.out.println("Podaj nazwę zadania do dodania: ");
                    String task = scanner.next();
                    addTask(task);
                    break;
                case 2:
                    System.out.println("Podaj index zadania do usunięcia: ");
                    int index = scanner.nextInt();
                    removeTask(index);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    displayChangeLog();
                    break;
                case 0:
                    isApplicationRun=false;
                    break;
                default:
                    System.out.println("Nie ma takiej opcji.");
                    break;
            }
        }

    }
}