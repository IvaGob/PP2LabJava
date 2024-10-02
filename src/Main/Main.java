package Main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Products.Car;

/**
 * Головний клас програми
 * @author dacko
 */
public class Main
{
    //final String[] carModels = {"Honda","Ford","Suzuki","Mitsubishi","Lanos","Skoda","Chevrolet","BMW","Mercedes"};

    /**
     * Головний метод програми
     * @param args Консольні параметри
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть бажану кількість машин: ");
        int n = scanner.nextInt();
        List<Car> cars = createCars(n);

        boolean exit  = false;
        while(!exit){
            System.out.println("Введіть номер бажаної умови пошуку:\n" +
                    "1.Пошук авто за моделлю.\n" +
                    "2.Пошук авто за моделлю, і які експлуатуються більше n років.\n" +
                    "3.Пошук автомобілів заданого року випуску з ціною більше вказаної.\n" +
                    "4.Завершити програму.");
            int choice = scanner.nextInt();
            String model;
            switch (choice){

                case 1:
                    System.out.println("Введіть модель авто:");
                    model = scanner.next();
                    printCarsList(getCarsByModel(cars,model));
                    break;
                case 2:
                    System.out.println("Введіть модель авто:");
                    model = scanner.next();
                    System.out.println("Введіть кількість років експлуатації:");
                    int ExYears = scanner.nextInt();
                    printCarsList(getCarsByModelAndYears(cars,model,ExYears));
                    break;
                case 3:
                    System.out.println("Введіть рік випуску:");
                    int prodYear = scanner.nextInt();
                    System.out.println("Введіть ціну:");
                    int price = scanner.nextInt();
                    printCarsList(getCarsByYearAndPrice(cars,prodYear,price));
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Некоректний вибір!");
                    break;
            }
        }
    }

    /**
     * Метод для створення нового списку машин, і заповнення їх даних
     * @param n Кількість машин, які треба створити
     * @return Повертає новостворений список
     */
    // Метод для створення масиву об'єктів Car
    public static List<Car> createCars(int n) {
        List<Car> cars = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        for(int i = 0;i<n;i++){
            System.out.println("Введіть дані "+i+" машини:");
            System.out.println("Введіть модель машини:");
            String model = in.next();
            System.out.println("Введіть рік виготовлення машини:");
            int year = in.nextInt();
            System.out.println("Введіть ціну машини:");
            int price = in.nextInt();
            System.out.println("Введіть Рег.номер машини:");
            String regNumber = in.next();
            cars.add(new Car(i+1, model, year, price, regNumber));
        }
        return cars;
    }

    /**
     * Метод для пошуку машин за заданою моделлю
     * @param cars Список в якому треба шукати машини
     * @param model Модель, яку треба шукати в списку
     * @return Повертає список з усіма знайденими машинами
     */
    // a) Метод для отримання списку автомобілів за моделлю
    public static List<Car> getCarsByModel(List<Car> cars, String model) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                result.add(car);
            }
        }
        return result;
    }

    /**
     * Метод для пошуку машин заданої моделі, що експлуатуються більше N років
     * @param cars Список в якому треба шукати машини
     * @param model Модель, яку треба шукати в списку
     * @param years Кількість років, в які машина була в використанні
     * @return Повертає список з усіма знайденими машинами
     */
    // b) Метод для отримання списку автомобілів заданої моделі, що експлуатуються більше n років
    public static List<Car> getCarsByModelAndYears(List<Car> cars, String model, int years) {
        List<Car> result = new ArrayList<>();
        int currentYear = java.time.Year.now().getValue();
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYear() > years)) {
                result.add(car);
            }
        }
        return result;
    }

    /**
     * Метод для отримання списку автомобілів заданого року випуску з ціною більше вказаної
     * @param cars Список в якому треба шукати машини
     * @param year Рік виготовлення
     * @param price Ціна машини
     * @return Повертає список з усіма знайденими машинами
     */
    // c) Метод для отримання списку автомобілів заданого року випуску з ціною більше вказаної
    public static List<Car> getCarsByYearAndPrice(List<Car> cars, int year, int price) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > price) {
                result.add(car);
            }
        }
        return result;
    }

    /**
     * Метод для виводу списку  машин в консоль
     * @param cars Список машин, які треба вивести в консоль
     */
    public static void printCarsList(List<Car> cars){
        for(Car car : cars){
            System.out.println(car);
        }
    }
}