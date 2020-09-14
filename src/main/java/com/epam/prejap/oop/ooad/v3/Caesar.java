package com.epam.prejap.oop.ooad.v3;

import java.util.Scanner;

/**
 * A program for encoding and decoding of text messages using Caesar cipher.
 */
class Caesar {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ave Caesar! Morituri te salutant!");
        String input, output;
        do {
            input = readOperationType(in);
            if (input.equals("encrypt")) {
                encryptMessage(in);
                break;
            } else if (input.equals("decrypt")) {
                decryptMessage(in);
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

    public static void decryptMessage(Scanner in) {
        String input;
        String output;
        System.out.println("Enter a message to decrypt: ");
        input = in.nextLine();
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

    public static void encryptMessage(Scanner in) {
        String input;
        String output;
        System.out.println("Enter a message to encrypt: ");
        input = in.nextLine();
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
