package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File sourceFile = new File("vat-eu.csv");

        Scanner scanner = new Scanner(sourceFile);

        List<StateTaxRate> stateTaxRateList = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String takenLine = scanner.nextLine();

            stateTaxRateList.add(parsedLine(takenLine));
        }

        String expression = "";

        while (true) {

            Scanner scanner1 = new Scanner(System.in);

            System.out.print("Zadejte jméno nebo zkratku státu:");

            expression = scanner1.nextLine();

            showState(findState(stateTaxRateList, expression));


        }

//        showState(stateTaxRateList);

//        showState(filterStatesWithTaxHigherThan(stateTaxRateList, 21f));


    }

    // rozparsovani souboru

    public static StateTaxRate parsedLine(String takenLine) {

        String[] splittedLine = takenLine.split("\t");

        StateTaxRate stateTaxRate = new StateTaxRate();

        stateTaxRate.setAbbreviation(splittedLine[0]);
        stateTaxRate.setStateName(splittedLine[1]);
        stateTaxRate.setStandardTaxRate(Float.parseFloat(splittedLine[2].replace(",", ".")));
        stateTaxRate.setReducedTaxRate(Float.parseFloat(splittedLine[3].replace(",", ".")));
        stateTaxRate.setSpecialTaxRate(Boolean.parseBoolean(splittedLine[4]));

        return stateTaxRate;
    }

    // Filtrovani statu podle sazby

    public static List<StateTaxRate> filterStatesWithTaxHigherThan(List<StateTaxRate> toFilter, Float tax) {

        List<StateTaxRate> stateTaxRates = new ArrayList<>();

        for (StateTaxRate str : toFilter) {
            if (str.getStandardTaxRate() > tax) {
                stateTaxRates.add(str);
            }
        }

        return stateTaxRates;
    }

    // Staty k vypsani

    public static void showState(List<StateTaxRate> toWrite) {
        if (!toWrite.isEmpty()) {
            for (StateTaxRate str : toWrite) {
                System.out.println(str.getStateName() + "\t[" + str.getAbbreviation() + "]\n" +
                        "Plná daňová sazba: " + str.getStandardTaxRate() + "%\n" +
                        "Snížená daňová sazba: " + str.getReducedTaxRate() + "%\n" +
                        "Speciální daňová sazba: " + str.getSpecialTaxRate() + "\n" +
                        "___________________________");

            }
        }else {
            System.out.println("Stát nebyl nalezen!");
        }
    }

    // vyhledavani statu

    public static List<StateTaxRate> findState(List<StateTaxRate> searchList, String expression) {

        List<StateTaxRate> stateTaxRates = new ArrayList<>();

        for (StateTaxRate str : searchList) {
            if (expression.toLowerCase().contains(str.getStateName().toLowerCase()) ||
                    expression.toLowerCase().contains(str.getAbbreviation().toLowerCase())) {
                stateTaxRates.add(str);
            }
        }
        return stateTaxRates;
    }


}
