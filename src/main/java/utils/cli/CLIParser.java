package utils.cli;


import org.apache.commons.cli.*;

public class CLIParser {
    private Options options;
    private CommandLineParser parser = new PosixParser();
    private CommandLine line;
    private HelpPrinter printer;

    public CLIParser() {
        options = new Options();

        Option height = Option.builder("h")
                .required(true)
                .longOpt("height")
                .hasArg()
                .desc("Number of field's rows")
                .build();

        Option width = Option.builder("w")
                .required(true)
                .longOpt("width")
                .hasArg()
                .desc("Number of field's columns")
                .build();

        Option factor = Option.builder("f")
                .required(true)
                .longOpt("factor")
                .hasArg()
                .desc("Fill factor. Double number, between 0 and 1")
                .build();

        Option help = Option.builder("?")
                .required(false)
                .longOpt("help")
                .desc("If you need the help")
                .build();

        options.addOption(height);
        options.addOption(width);
        options.addOption(factor);
        options.addOption(help);
    }

    public IncomeData parse(String[] args) throws ParseException {
        if (args.length == 0) {
            throw new ParseException("No arguments");
        }
        line = parser.parse(options, args);
        int height = Integer.parseInt(line.getOptionValue("height"));
        int width = Integer.parseInt(line.getOptionValue("width"));
        double fillFactor = Double.parseDouble(line.getOptionValue("factor"));

        if (!checkIncomeArgs(height, width, fillFactor)) {
            printer.printHelp(options);
        }
        return new IncomeData(height, width, fillFactor);
    }

    private boolean checkIncomeArgs(int height, int width, double fillFactor) {
        if ((height > 0 && width > 0 && (0.0 <= fillFactor && fillFactor <= 1.0))) {
            return true;
        }
        return false;
    }


}
