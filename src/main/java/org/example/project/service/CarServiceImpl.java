package org.example.project.service;

import org.example.project.repository.CarRepository;
import org.example.project.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(long id) {
        Optional<Car> car = carRepository.findById(id);

        return car.orElse(null);

    }

    @Override
    public void removeCarById(long id) {
        Optional<Car> car = carRepository.findById(id);
        car.ifPresent(carRepository::delete);
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
