package com.epam.prejap.oop.ooad;

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
            System.out.println("Would you like to encrypt or decrypt a message?");
            input = in.nextLine();
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

    public static void decryptMessage(Scanner in) {
        String input;
        String output;
        System.out.println("Enter a message to decrypt: ");
        input = in.nextLine();
        output = "";
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if ('A' <= letter && letter <= 'Z') {
                output = decryptOneLetter(output, letter - 3 >= 'A', letter - 3, letter - 3 + 26);
            } else {
                output = output + letter;
            }
        }
        System.out.println("Decrypted message: ");
        System.out.println(output);
        return;
    }

    public static String decryptOneLetter(String output, boolean b, int i2, int i3) {
        if (b) {
            output = output + (char) (i2);
        } else {
            output = output + (char) (i3);
        }
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
                output = encryptOneLetter(output, letter + 3 <= 'Z', letter + 3, letter + 3 - 26);
            } else {
                output = output + letter;
            }
        }
        System.out.println("Encrypted message: ");
        System.out.println(output);
        return;
    }

    public static String encryptOneLetter(String output, boolean b, int i2, int i3) {
        if (b) {
            output = output + (char) (i2);
        } else {
            output = output + (char) (i3);
        }
        return output;
    }
}
