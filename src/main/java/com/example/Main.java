package com.example;

public class Main {
    public static void main(String[] args) {

        DatabaseQueryService service =
                new DatabaseQueryService();

        System.out.println(
                service.findMaxProjectsClient()
        );

        System.out.println(
                service.findLongestProject()
        );

        System.out.println(
                service.findMaxSalaryWorker()
        );

        System.out.println(
                service.findYoungestEldestWorkers()
        );

        System.out.println(
                service.printProjectPrices()
        );
    }
}