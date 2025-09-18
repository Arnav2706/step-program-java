class Weather {
    protected String condition;

    public Weather(String condition) {
        this.condition = condition;
        System.out.println("Weather constructor: " + condition);
    }

    public void showWeather() {
        System.out.println("General weather: " + condition);
    }
}

class Storm extends Weather {
    protected int windSpeed;

    public Storm(String condition, int windSpeed) {
        super(condition);
        this.windSpeed = windSpeed;
        System.out.println("Storm constructor called");
    }

    @Override
    public void showWeather() {
        super.showWeather();
        System.out.println("Storm with wind speed " + windSpeed + " km/h");
    }
}

class Thunderstorm extends Storm {
    private int lightningStrikes;

    public Thunderstorm(String condition, int windSpeed, int lightningStrikes) {
        super(condition, windSpeed);
        this.lightningStrikes = lightningStrikes;
        System.out.println("Thunderstorm constructor called");
    }

    @Override
    public void showWeather() {
        super.showWeather();
        System.out.println("Thunderstorm with " + lightningStrikes + " lightning strikes");
    }
}

class Sunshine extends Weather {
    private int temperature;

    public Sunshine(String condition, int temperature) {
        super(condition);
        this.temperature = temperature;
        System.out.println("Sunshine constructor called");
    }

    @Override
    public void showWeather() {
        super.showWeather();
        System.out.println("Sunshine with temperature " + temperature + "°C");
    }
}

public class WeatherTest {
    public static void main(String[] args) {
        Weather[] forecasts = {
            new Weather("Cloudy"),
            new Storm("Stormy", 80),
            new Thunderstorm("Thunderstorm", 100, 15),
            new Sunshine("Sunny", 30)
        };

        System.out.println("\n--- Forecast Details ---");
        for (Weather w : forecasts) {
            w.showWeather();
            System.out.println();
        }
    }
}
