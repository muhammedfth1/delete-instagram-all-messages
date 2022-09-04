package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Kullanıcı adiniz : ");
        String username = scanner.nextLine();
        System.out.println("Sifreniz : ");
        String password = scanner.nextLine();
        App app = new App();
        app.login(username , password);
        app.goToMessagesBox();
        app.deleteMessages();
    }
}