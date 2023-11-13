import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class SchoolEnrollment {
    private static final int Enrollment_Age_Start = 11;
    private static final int Enrollment_Age_Finish = 12;
    private static final int Cut_Off_Month = 9;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Enter the student's birthdate with the format 'dd-mm-yyyy': ");
        String birthdateInfo = input.nextLine();
        LocalDate birthdate = LocalDate.parse(birthdateInfo, formatter);

        System.out.println("Enter the today's date with the format 'dd-mm-yyyy': ");
        String currentDateInfo = input.nextLine();
        LocalDate currentDate = LocalDate.parse(currentDateInfo, formatter);
        // assuming the user wouldn't enter the date after 01.September since the school is already starting.
        // it means it is gonna be the next year.

        //LocalDate cutOffDate = LocalDate.of(currentDate.getYear(), 9, 1);

        // the age of the student
        int age = (int)ChronoUnit.YEARS.between(birthdate, currentDate);

        // set the age for the school of enrollment = 11 or 12 years old

        if(age >= Enrollment_Age_Start && age <= Enrollment_Age_Finish){
            if(birthdate.getMonthValue() < Cut_Off_Month){
                System.out.println("The student can be enrolled in the school.");
            }else {
                System.out.println("The student's age is enough but you will be enrolled next year.");
            }
        }else {
            System.out.println("Your age doesn't fit the age requirement for the school enrollment.");}
    }
}
