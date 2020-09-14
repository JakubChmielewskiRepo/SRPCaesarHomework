package v4;

import java.util.Scanner;

public class Encrypt {
    public static void encryptMessage(Scanner in) {
        String input;
        String output;
        input = readPlainTextMessage(in);
        output = "";
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if ('A' <= letter && letter <= 'Z') {
                output = encryptLetter(output, letter + 3 <= 'Z', letter + 3, letter + 3 - 26);
            } else {
                output = output + letter;
            }
        }
        printEncryptedMessage(output);
        return;
    }

    public static String readPlainTextMessage(Scanner in) {
        String input;
        System.out.println("Enter a message to encrypt: ");
        input = in.nextLine();
        return input;
    }

    public static void printEncryptedMessage(String output) {
        System.out.println("Encrypted message: ");
        System.out.println(output);
    }

    public static String encryptLetter(String output, boolean inScope, int encodeType, int shift) {
        if (inScope) {
            output = output + (char) (encodeType);
        } else {
            output = shiftRight(output, shift);
        }
        return output;
    }

    public static String shiftRight(String output, int shift) {
        output = output + (char) (shift);
        return output;
    }
}