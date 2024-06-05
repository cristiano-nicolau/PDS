package Observer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

        weatherData.addObserver(currentDisplay);
        weatherData.addObserver(statisticsDisplay);
        
        weatherData.setMeasurements(28, 65);
        weatherData.setMeasurements(22, 70);
        weatherData.setMeasurements(26, 90); }
}

class WeatherData {
    private float temperature;
    private float humidity;
    private ArrayList<Subscriver> subscriver = new ArrayList<Subscriver>();

    public void addObserver(Subscriver s) {
        subscriver.add(s);
    }

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObserver();
    }

    public void notifyObserver() {
        for (Subscriver s : subscriver) {
            s.update(temperature, humidity);
        }
    }
}

class CurrentConditionsDisplay implements Subscriver {
    private float temperature;
    private float humidity;

    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

}

class StatisticsDisplay implements Subscriver {
    private float temperature;
    private float humidity;


    public void update(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        System.out.println("Statistics: " + temperature + "F degrees and " + humidity + "% humidity");
    }

}

interface Subscriver{
    void update(float temperature, float humidity);
}