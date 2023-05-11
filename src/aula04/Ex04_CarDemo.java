// package aula04;
// import java.util.Scanner;
// class Car {
//     public String make;
//     public String model;
//     public int year;
//     public int kms;

//     public Car(String make, String model, int year, int kms) {
//         this.make = make;
//         this.model = model;
//         this.year = year;
//         this.kms = kms;
//     }

//     public void drive(int distance) {
//         this.kms += distance;
//     }

// }

// public class Ex04_CarDemo {

//     static Scanner sc = new Scanner(System.in);

//     static int registerCars(Car[] cars) {
//         int count = 0;
//         int year = 0;
//         int kms = 0;
//         String make = "";
//         String model = "";
//         boolean validData = false;
//         while (!validData && count < cars.length) {
//             System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
//             String line = sc.nextLine();
//             if (line.isEmpty()) {
//                 break;
//             }
//             String[] lineParts = line.split(" ");
//             if (lineParts.length < 4) {
//                 System.out.println("Dados mal formatados. Tente novamente.");
//                 continue;
//             }

//             if (lineParts.length > 4) {
//                 for (int i = 0; i < lineParts.length - 3; i++) {
//                     model +=  " " +lineParts[i] ;
//                 }
//             }
//             else{
//                 model = lineParts[1];
//             }

           

//             make = lineParts[0];
//             try {
//                 year = Integer.parseInt(lineParts[lineParts.length - 1]);
//                 kms = Integer.parseInt(lineParts[lineParts.length - 2]);
//                 if (kms < 0 || year < 0 || year > 9999) {
//                     System.out.println("Dados mal formatados. Tente novamente.");
//                     continue;
//                 }
//             } catch (NumberFormatException e) {
//                 System.out.println("Dados mal formatados. Tente novamente.");
//                 continue;
//             }


//             cars[count] = new Car(make, model, year, kms);
//             count++;
//         }
//         return count;


      


//    }

//     static void registerTrips(Car[] cars, int numCars) {
//         int car = 0;
//         int distance = 0;
//         boolean validData = false;

//         while(!validData){
//             System.out.print("Registe uma viagem no formato \"carro:distância\": ");
//             String line = sc.nextLine();
//             if (line.isEmpty()) {
//                 break;
//             }
//             String[] lineParts = line.split(":");
//             if (lineParts.length < 2) {
//                 System.out.println("Dados mal formatados. Tente novamente.");
//                 continue;
//             }
//             if (lineParts.length != 2) {
//                 System.out.println("Dados mal formatados. Tente novamente.");
//                 continue;
//             }
//             try {
//                 car = Integer.parseInt(lineParts[0]);
//                 distance = Integer.parseInt(lineParts[1]);
//                 if (car < 0 || car > numCars || distance < 0) {
//                     System.out.println("Dados mal formatados. Tente novamente.");
//                     continue;
//                 }
//             } catch (NumberFormatException e) {
//                 System.out.println("Dados mal formatados. Tente novamente.");
//                 continue;
//             }
//             cars[car].drive(distance);
//         }
        
        


//         System.out.print("Registe uma viagem no formato \"carro:distância\": ");
//     }


//     static void listCars(Car[] cars) {
//         System.out.println("\nCarros registados: ");
//         for (int i = 0; i < cars.length; i++) {
//             if (cars[i] != null) {
//                 System.out.println(cars[i].make + "," + cars[i].model + ", " + cars[i].year + ", kms: " + cars[i].kms);
//             }
//         }
        
        
        
//         System.out.println("\n");
//     }

//     public static void main(String[] args) {

//         Car[] cars = new Car[10];

//         int numCars = registerCars(cars);

//         if (numCars>0) {
//             listCars(cars);
//             registerTrips(cars, numCars);
//             listCars(cars);
//         }

//         sc.close();

//     }
// }