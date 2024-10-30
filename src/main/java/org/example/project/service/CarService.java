package org.example.project.service;

import org.example.project.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getAllCars();
    Car getCarById(long id);
    void removeCarById(long id);
    void saveCar(Car car);
}
