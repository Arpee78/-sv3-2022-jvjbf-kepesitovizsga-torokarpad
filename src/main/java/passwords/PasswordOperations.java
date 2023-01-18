package passwords;

public class PasswordOperations {

    public PasswordStrength checkPasswordStrength(String password) {

        PasswordStrength strength = null;

        boolean allLetter = password.matches("[a-zA-Z]+");
        boolean allNumbers = password.matches("[0-9]+");
        boolean containsLowerCase = password.matches(".*[a-z]+.*");
        boolean containsNumbers = password.matches(".*[0-9]+.*");
        boolean containsUppercase = password.matches(".*[A-Z]+.*");

        if ( allLetter ||  allNumbers) {
            strength = PasswordStrength.WEAK;
        }
        if (containsNumbers && containsLowerCase && !containsUppercase) {
            strength = PasswordStrength.MEDIUM;
        }
        if (containsNumbers && containsUppercase) {
            strength = PasswordStrength.STRONG;
        }

        return strength;

    }
}
