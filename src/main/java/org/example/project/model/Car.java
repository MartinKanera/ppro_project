package org.example.project.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Car {
    private int id = -1;

    @Size(min = 7, max = 7)
    private String spz;

    @NotBlank
    private String color;

    @Min(30)
    @Max(100)
    private float tankVolume;

    @Min(2)
    @Max(10)
    private int numberOfSeats;

    public Car() {}

    public Car(String spz, String color, float tankVolume, int numberOfSeats) {
        this.spz = spz;
        this.color = color;
        this.tankVolume = tankVolume;
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public String getSpz() {
        return spz;
    }

    public String getColor() {
        return color;
    }

    public float getTankVolume() {
        return tankVolume;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTankVolume(float tankVolume) {
        this.tankVolume = tankVolume;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
