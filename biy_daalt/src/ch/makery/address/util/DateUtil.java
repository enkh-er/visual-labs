package ch.makery.address.util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Ognootoi haritsah tuslah function-uudiig aguulah class
 *
 * @author Marco Jakob
 */
public class DateUtil {

    /**Odriig horwvvleh helber. */
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    /** The date formatter. */
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * Parametreer orj irsen ognoog ogodson formatiin daguu string-rvv horwvvlne.
     * {@link DateUtil#DATE_PATTERN} = deer duridsan ene formatiig ashiglana.
     *
     * @param date ognoog string-rvv horwvvlne
     * @return formatted string
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * {@link DateUtil#DATE_PATTERN} end ogogdson helberiin daguu string-ees
     * @link LocalDate} -rvv horwvvlne.
     *
     * Herew horwvvlj chadahgvi bol null utga butsaana.
     *
     * @param dateString ognoonii string deh helber
     * @return herew dateString-iig horwvvlj chadahgvi bol null utga butsaana
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    /**
     * String helbert baigaa ognoog zow esehiig shalgana.
     *
     * @param dateString
     * @return true if the String is a valid date
     */
    public static boolean validDate(String dateString) {
        // Try to parse the String.
        return DateUtil.parse(dateString) != null;
    }

}
