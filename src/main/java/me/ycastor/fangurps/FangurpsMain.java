package me.ycastor.fangurps;

import io.micronaut.configuration.picocli.PicocliRunner;
import me.ycastor.fangurps.commands.ConvertSkillCommand;

import static picocli.CommandLine.Command;
import static picocli.CommandLine.Option;


@Command(name = "fangurps",
        header = {
                "@|green  ___          ___                  |@",
                "@|green | __|_ _ _ _ / __|_  _ _ _ _ __ ___|@",
                "@|green | _/ _` | ' \\ (_ | || | '_| '_ (_-<|@",
                "@|green |_|\\__,_|_||_\\___|\\_,_|_| | .__/__/|@",
                "@|green                           |_|      |@"
        },
        subcommands = {ConvertSkillCommand.class})
public class FangurpsMain implements Runnable {

    @Option(names = {"-h", "--help"}, description = "Shows Help")
    private boolean help;

    public static void main(String[] args) {
        PicocliRunner.execute(FangurpsMain.class, args);
    }

    @Override
    public void run() {
        if (help) {
            System.out.println("Use one of the following commands:");
            System.out.println("-> convert-skill");
        }
    }
}
