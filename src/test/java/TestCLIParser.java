import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.Test;
import utils.cli.CLIParser;
import utils.cli.IncomeData;

import static org.junit.Assert.*;

public class TestCLIParser {
    @Test
    public void testParse() throws Exception {
        String[] incomeArguments = {"-height", "5", "-width", "5", "-factor", "0.2"};
        IncomeData data = new CLIParser().parse(incomeArguments);
        assertEquals(data.getHeight(), 5);
        assertEquals(data.getWidth(), 5);
        assertTrue(Double.compare(data.getFillFactor(), 0.2) == 0);
    }

    @Test(expected = UnrecognizedOptionException.class)
    public void testUnrecognizedOption() throws Exception{
        String[] incomeArguments = {"-height", "5", "-empty", "5", "-factor", "0.2"};
        new CLIParser().parse(incomeArguments);
    }

    @Test(expected = MissingArgumentException.class)
    public void testMissingArgument() throws Exception{
        String[] incomeArguments = {"-height", "5", "-width", "-factor", "0.2"};
        new CLIParser().parse(incomeArguments);
    }

    @Test(expected = NumberFormatException.class)
    public void parseWithNoNumberArgument() throws Exception {
        String[] incomeArguments = {"-h", "Five", "-w", "6", "-f", "0.35"};
        new CLIParser().parse(incomeArguments);
    }


}
