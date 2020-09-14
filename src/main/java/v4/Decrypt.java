package v4;

import java.util.Scanner;

public class Decrypt {
    public static void decryptMessage(Scanner in) {
        String input;
        String output;
        input = readEncryptedMessage(in);
        output = "";
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if ('A' <= letter && letter <= 'Z') {
                output = decryptLetter(output, letter - 3 >= 'A', letter - 3, letter - 3 + 26);
            } else {
                output = output + letter;
            }
        }
        printDecryptedMessage(output);
        return;
    }

    public static String readEncryptedMessage(Scanner in) {
        String input;
        System.out.println("Enter a message to decrypt: ");
        input = in.nextLine();
        return input;
    }

    public static void printDecryptedMessage(String output) {
        System.out.println("Decrypted message: ");
        System.out.println(output);
    }

    public static String decryptLetter(String output, boolean inScope, int encodeType, int shift) {
        if (inScope) {
            output = output + (char) (encodeType);
        } else {
            output = shiftLeft(output, shift);
        }
        return output;
    }

    public static String shiftLeft(String output, int shift) {
        output = output + (char) (shift);
        return output;
    }
}