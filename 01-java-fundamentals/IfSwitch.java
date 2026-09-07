/*
 * if / else if / else, and switch (classic + modern arrow-style)
 */
public class IfSwitch {
    public static void main(String[] args) {
        int score = 82;

        // if / else if / else
        String grade;
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else {
            grade = "F";
        }
        System.out.println("Grade (if-else): " + grade);

        // Classic switch with fall-through and break
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Some other day");
        }

        // Modern switch expression (Java 14+)
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid";
        };
        System.out.println("Day type (switch expression): " + dayType);
    }
}
