public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reverseNumber = 0;


        if (number < 0) {
            number = Math.abs(number);
        }

        while (number > 0) {
            int digit = number % 10;
            reverseNumber = reverseNumber * 10 + digit;
            number /= 10;
        }

        return originalNumber == reverseNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }

    public static boolean isPerfectNumber(int number) {
        if (number <= 0) {
            return false; //
        }

        int sumOfDivisors = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sumOfDivisors += i;
            }
        }

        return sumOfDivisors == number;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(1010));
        System.out.println(numberToWords(-12));   
    }

    public static String numberToWords(int number) {
        if (number < 0) {
            return "Invalid Value";
        }

        if (number == 0) {
            return "Zero";
        }

        String[] ones = {
                "Zero", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine"
        };

        String[] tens = {
                "", "", "Twenty", "Thirty", "Forty",
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        String[] teens = {
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        StringBuilder result = new StringBuilder();
        int count = 0;
        int digit;
        boolean addSpace = false;

        while (number > 0) {
            digit = number % 10;
            number /= 10;

            if (count == 0) { //
                result.insert(0, ones[digit]);
            } else if (count == 1) { //
                if (digit == 1) {
                    int nextDigit = number % 10;
                    number /= 10;
                    result.replace(0, 1, teens[nextDigit]);
                } else {
                    result.insert(0, tens[digit]);
                }
                addSpace = true;
            } else if (count == 2) { //
                if (digit > 0) {
                    result.insert(0, ones[digit] + " Hundred");
                    addSpace = true;
                }
            } else if (count == 3) { // Binlerke
                if (digit > 0) {
                    result.insert(0, ones[digit] + " Thousand");
                    addSpace = true;
                }
            }

            if (addSpace && number > 0) {
                result.insert(0, " ");
                addSpace = false;
            }

            count++;
        }

        return result.toString();
    }
}
