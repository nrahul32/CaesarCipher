package nrahul32.CaesarCipher;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CaesarCipher {
    
    // All class variables
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        
        // Take an input string from the user
        String inputString = getUserInput("Enter the string to encrypt: ");
        
        // Take a key from the user
        int key = Integer.parseInt(getUserInput("Enter the key: "));
        
        // Normalise the input string
        String normalizedInput = normalizeText(inputString);
        System.out.println("Normalized string is: " + normalizedInput);
        
        // Caesarify
        String encryptedString = caesarify(normalizedInput, key);
        
        // Print the encrypted string
        System.out.println("The encrypted text is: " + encryptedString);   
    }

    /*
     * Prints the question to the user and returns the user's input as a string
     */
    private static String getUserInput(String question) {        
        System.out.print(question);
        return s.nextLine();        
    }

    /*
     * 1. Removes all the spaces from the text
     * 2. Removes any punctuation (. , : ; ’ ” ! ? ( ) )
     * 3. Turn all lower-case letters into upper-case letters
     * 4. Return the result
     * 
     * There are 2 implementations of this. One uses the replaceAll method
     * and other is by iterating through each character. Uncomment the
     * preferred one
     */
    private static String normalizeText(String input) {
        
        String result = normalizeTextUsingReplaceMethod(input);
        //  String result = normalizeTextUsingChars(input);
     
        return result;
    }

    /*
     * This shifts each letter of the string by key positions
     * and returns the string
     */
    private static String caesarify(String normalizedInput, int key) {
        char[] char_array = normalizedInput.toCharArray();

        for(int i = 0; i < char_array.length; i++) {
            char_array[i] = (char) ((char_array[i] - 'A' + key)%26 + 'A');
        }
        return new String(char_array);
    }

    private static String normalizeTextUsingReplaceMethod(String input) {
        String regex = "[^a-zA-Z]";
        return input.replaceAll(regex , "").toUpperCase();
    }

    private static String normalizeTextUsingChars(String input) {
        char[] initialArray = input.toCharArray();
        char[] finalArray = new char[input.length()];
        
        // picks up only alphabets and adds them to a new array
        for(int i = 0, j=0; i<initialArray.length; i++) {
            if(Pattern.matches("[a-zA-Z]", Character.toString(initialArray[i]))) {
                finalArray[j++]=initialArray[i];
            }
        }
        String result = new String(finalArray).trim().toUpperCase();
        return result;
    }
}

