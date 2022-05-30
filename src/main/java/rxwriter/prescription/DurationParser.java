package rxwriter.prescription;

public class DurationParser {
    public static int parseDays(String durationString) {
        String[] parts = durationString.split(" ");
        if (parts.length == 2) {
            return unitValueCalculation(parts[1], parts[0]);
        }
        else if (parts.length == 1) {
            if (parts[0].equalsIgnoreCase("once")) return 1;
        }

        return 0;
    }

    private static int unitValueCalculation(String unitString, String valueString) {
        DurationUnit unit = DurationUnit.getByTextValue(unitString);

        if (unit == null) {
            return 0;
        }

        return (parseValue(valueString) * unit.getMultiplier());
    }

    private static int parseValue(String valueString) {
        try {
            return Integer.parseInt(valueString);
        }
        catch (Throwable t) {
            return 0;
        }
    }
}
