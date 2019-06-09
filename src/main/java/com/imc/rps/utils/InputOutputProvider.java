package com.imc.rps.utils;

import java.util.Scanner;

public class InputOutputProvider {
  private final Scanner inputScanner;

  public InputOutputProvider() {
    this.inputScanner = new Scanner(System.in);
  }

  public synchronized String getString() {
    return inputScanner.next();
  }

  public synchronized Integer getInt() {
    return inputScanner.nextInt();
  }

  public synchronized void printWithNewLine(String printableString) {
    System.out.println(printableString);
  }

  public synchronized void print(String printableString) {
    System.out.print(printableString);
  }
}
