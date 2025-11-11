package View;

import javafx.scene.control.TextField;

/**
 * @Aira Althafeliq Nurfirly
 */
public class InputValidator {

    public static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    public static boolean isNumeric(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInRange(String text, double min, double max) {
        if (!isNumeric(text)) {
            return false;
        }
        double value = Double.parseDouble(text);
        return value >= min && value <= max;
    }

    public static void highlightError(TextField field) {
        field.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
    }

    public static void clearHighlight(TextField field) {
        field.setStyle("");
    }
}
