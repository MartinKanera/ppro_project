package org.example.project.service;

import org.example.project.model.Driver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface DriverService {
    ArrayList<Driver> getAllDrivers();
    Driver getDriverById(int id);
    void removeDriverById(int id);
    void saveDriver(Driver driver);
}
