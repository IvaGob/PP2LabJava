package Products;

/**
 * Клас Автомобіля
 * @author dacko
 */
public class Car {
    // Приватні поля
    private int id;
    private String model;
    private int year;
    private int price;
    private String regNumber;

    /**
     * Конструктор класу
     * @param id індекс авто
     * @param model модель авто
     * @param year рік випуску авто
     * @param price ціна авто
     * @param regNumber Рег.номер авто
     */
    // Конструктор
    public Car(int id, String model, int year, int price, String regNumber) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.regNumber = regNumber;
    }
    // Геттери та сеттери для полів
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    /**
     * @return Повертає дані про машину
     */
    // Метод toString() для виведення інформації про автомобіль
    @Override
    public String toString() {
        return "Машина" +
                " номер= " + id +
                ", модель= " + model +
                ", рік= " + year +
                ", ціна= " + price +
                ", Рег.Номер= " + regNumber;
    }
}
