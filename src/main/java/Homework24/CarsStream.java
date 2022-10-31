package Homework24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class CarsStream {
    public static void main(String[] args) {
        Car c1 = new Car("Mitsubishi", "Lancer", 33_000);
        Car c2 = new Car("Mitsubishi", "Lancer Evo 4", 64_000);
        Car c3 = new Car("Subaru", "WRX STI", 62_000);
        Car c4 = new Car("Subaru", "Forrester", 23_000);
        Car c5 = new Car("Nissan", "GTR", 73_000);
        Car c6 = new Car("Mitsubishi", "Gallant", 14_000);
        List<Car> cars = List.of(c1, c2, c3, c4, c5, c6);
        System.out.println(sortByPriceCar(cars));

    }

    public static TreeMap<String, List<Car>> sortByPriceCar(List<Car> cars) {
        return cars.stream()

                .collect(TreeMap::new,
                        (stringListTreeMap, car) -> {
                            String key = car.getMaker();
                            List<Car> l = stringListTreeMap.containsKey(key) ? stringListTreeMap.get(key) : new ArrayList<>();
                            l.add(car);
                            l.sort(Comparator.comparing(Car::getPrice).reversed());
                            stringListTreeMap.put(key, l);
                        },
                        TreeMap::putAll
                );

    }
}

class Car {
    public String maker;
    public String model;
    public double price;

    public Car(String maker, String model, double price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }



    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "c{" +
                "ma='" + maker + '\'' +
                ", mo='" + model + '\'' +
                ", p=" + price +
                '}';
    }
}