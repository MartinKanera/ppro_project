package org.example.project.service;

import org.example.project.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriverService {
    List<Driver> getAllDrivers();
    Driver getDriverById(long id);
    void removeDriverById(long id);
    void saveDriver(Driver driver);
}
