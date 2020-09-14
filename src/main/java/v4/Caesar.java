package v4;

import java.util.Scanner;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    public static void main(String[] args) {
        startOperation();
    }

    public static void startOperation() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ave Caesar! Morituri te salutant!");
        String input, output;
        do {
            input = readOperationType(in);
            if (input.equals("encrypt")) {
                Encrypt.encryptMessage(in);
                break;
            } else if (input.equals("decrypt")) {
                Decrypt.decryptMessage(in);
                break;
            } else {
                System.out.println("Tertium non datur!");
            }
        } while (true);
        System.out.println("Vale!");
    }

    public static String readOperationType(Scanner in) {
        String input;
        System.out.println("Would you like to encrypt or decrypt a message?");
        input = in.nextLine();
        return input;
    }

}
