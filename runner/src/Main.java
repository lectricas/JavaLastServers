import ru.itmo.java.message.Timer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        String help = "Usage: servers <block|no_block|async> <X> <N|M|D> <from> <to> <step> <cyclic number in N|M|D> <cyclic number in N|M|D>";
        if (args.length < 8) {
            System.out.println(help);
            return;
        }

        String architecture = args[0];
        Integer numberOfRequests = Integer.parseInt(args[1]);
        String variableParam = args[2];
        Integer from = Integer.parseInt(args[3]);
        Integer to = Integer.parseInt(args[4]);
        Integer step = Integer.parseInt(args[5]);
        Integer otherParam1 = Integer.parseInt(args[6]);
        Integer otherParam2 = Integer.parseInt(args[7]);

        System.out.println();
        FileWriter fileWriter1 = new FileWriter(architecture + "_sort");
        FileWriter fileWriter2 = new FileWriter(architecture + "_server");
        FileWriter fileWriter3 = new FileWriter(architecture + "_client");
        PrintWriter printWriter1 = new PrintWriter(fileWriter1);
        PrintWriter printWriter2 = new PrintWriter(fileWriter2);
        PrintWriter printWriter3 = new PrintWriter(fileWriter3);

        printWriter1.println(help);
        printWriter2.println(help);
        printWriter3.println(help);

        printWriter1.println(String.join(" ", args));
        printWriter2.println(String.join(" ", args));
        printWriter3.println(String.join(" ", args));

        Runner runner;
        if (architecture.equals("block")) {
            runner = new RunSimple();
        } else if (architecture.equals("no_block")) {
            runner = new RunNoLock();
        } else if (architecture.equals("async")) {
            runner = new RunAsync();
        } else {
            throw new IllegalArgumentException("no such architecture");
        }

        while (from < to) {
            if (variableParam.equals("N")) {
                runner.run(from, otherParam1, otherParam2, numberOfRequests);
            } else if (variableParam.equals("M")) {
                runner.run(otherParam1, from, otherParam1, numberOfRequests);
            } else if (variableParam.equals("D")) {
                runner.run(otherParam1, otherParam2, from, numberOfRequests);
            } else {
                throw new IllegalArgumentException("no such param");
            }
            from += step;

            double avgTimeForSort = Timer.sortingTimer.stream().mapToDouble(x -> x).average().orElse(0.0);
            double avgTimeForServer = Timer.serverResponseTimer.stream().mapToDouble(x -> x).average().orElse(0.0);
            double avgTimeForClient = Timer.clientResponseTimer.stream().mapToDouble(x -> x).average().orElse(0.0);

            printWriter1.println(avgTimeForSort);
            printWriter2.println(avgTimeForServer);
            printWriter3.println(avgTimeForClient);
            Timer.clear();
        }

        printWriter1.close();
        printWriter2.close();
        printWriter3.close();
    }
}
