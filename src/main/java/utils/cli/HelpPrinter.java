package utils.cli;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;


public class HelpPrinter {
    public void printHelp(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        String header = "Something wrong with your input, check input values:\n\n";
        String footer = "";
        helpFormatter.printHelp("Help:", header, options, footer, true);
    }
}
