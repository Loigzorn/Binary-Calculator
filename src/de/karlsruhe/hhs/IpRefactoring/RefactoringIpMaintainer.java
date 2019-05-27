package de.karlsruhe.hhs.IpRefactoring;

import de.karlsruhe.hhs.ConsoleInteraction;

import java.util.Scanner;

public class RefactoringIpMaintainer {

    private Scanner scanner;
    private final String openingQuestion = "Do you wish to encode(1) or decode(2) an IP?";
    private final String commendPromMessage = "Please enter a valid IPv4 address: ";
    private final String commandPromMessageBinary = "Please enter a valid IPv4 address as binaries: ";
    private final String ipPatternDecimal = "(?:[0-9]{1,3}[.]){3}[0-9]{1,3}";

    public RefactoringIpMaintainer() {
        startInteraction();
        closing();
    }

    private void startInteraction() {
        scanner = new Scanner(System.in);
        System.out.println(openingQuestion);
        String input = scanner.nextLine();

        if (input.equals("1")) {
            startEncoder();
        } else if (input.equals("2")) {
            startDecoder();
        } else {
            System.out.print("Try again. ");
            startInteraction();
        }
        scanner.close();
    }

    private void startEncoder() {
        var ipv4 = "";
        var ipa4ConditionSatisfied = false;
        do {
            System.out.print(commendPromMessage);
            ipv4 = scanner.next();
            ipa4ConditionSatisfied = isIpv4ConditionSatisfied(ipv4);
        } while (!ipa4ConditionSatisfied);

        var ipEncoder =  new IpEncoder(ipv4);
        var encodedIpv4 = ipEncoder.encode();
        System.out.println(String.format("The IPv4 represented as binary: \"%s\"", encodedIpv4));
    }

    private void startDecoder() {
        System.out.print(commandPromMessageBinary);
        var ipv4 = scanner.next();
        var ipParts = ipv4.split("\\.");
        for (var part : ipParts) {
            if(!new ConsoleInteraction().binaryToDecimalFormatCheck(part)) {
                System.out.print("Try again. ");
                startDecoder();
            }
        }
        var ipEncoder =  new IpDecoder(ipv4,ipParts[0].length());
        var decodedIpv4 = ipEncoder.decode();
        System.out.println(String.format("The IPv4 represented as decimal: \"%s\"", decodedIpv4));
    }

    private boolean isIpv4ConditionSatisfied(String ipv4) {
        var splitter = "\\.";
        var ipParts = ipv4.split(splitter);
        var matchesPattern = ipv4.matches(ipPatternDecimal);
        try {
            for (var part : ipParts) {
                var partAsInt = Integer.parseInt(part);
                if (partAsInt < 0 || partAsInt > 255) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return matchesPattern;
    }

    private void closing() {
        scanner.close();
        System.out.println("\b");
        char[] odds = {'T','a','k','y','u','f','r','u','i','g','t','i', ' ', 'o', 'l'};
        char[] evens = {'h','n',' ','o',' ','o', ' ','s','n', ' ','h','s', 't','o', '.'};
        for (int i = 0; i < odds.length; i ++) {
            System.out.print("\u001B[31m" + odds[i]);
            System.out.print("\u001B[36m" + evens[i]);
        }
    }


}
