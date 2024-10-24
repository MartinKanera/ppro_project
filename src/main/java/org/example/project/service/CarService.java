package org.example.project.service;

import org.example.project.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CarService {
    ArrayList<Car> getAllCars();
    Car getCarById(int id);
    void removeCarById(int id);
    void saveCar(Car car);
}
