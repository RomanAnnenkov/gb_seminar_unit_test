package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class VehicleTest {
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setup() {
        car = new Car("AUDI","A6",2020);
        motorcycle = new Motorcycle("BMW","S 1000 XR",2020);
    }

    @Test
    @DisplayName("Car is vehicle")
    void carIsVehicle() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    @Test
    @DisplayName("Car has four wheels")
    void carHasFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    @DisplayName("Motorcycle has two wheels")
    void motorcycleHasTwoWheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    @DisplayName("Car speed is 60")
    void carSpeedTest() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    @DisplayName("Motorcycle speed is 75")
    void motorcycleSpeedTest() {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    @DisplayName("Car parking after drive")
    void carParkingTest() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    @DisplayName("Motorcycle parking after drive")
    void motorcycleParkingTest() {
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }

}