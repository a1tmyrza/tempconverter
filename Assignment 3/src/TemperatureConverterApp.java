import java.util.Scanner;

// Target interface that the client code expects
interface CelsiusTemperature {
    double getCelsius();
}

// Adaptee: FahrenheitTemperature class
class FahrenheitTemperature {
    private double fahrenheit;

    public FahrenheitTemperature(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }
}

// Adapter class that adapts FahrenheitTemperature to CelsiusTemperature
class FahrenheitToCelsiusAdapter implements CelsiusTemperature {
    private FahrenheitTemperature fahrenheitTemperature;

    public FahrenheitToCelsiusAdapter(FahrenheitTemperature fahrenheitTemperature) {
        this.fahrenheitTemperature = fahrenheitTemperature;
    }

    @Override
    public double getCelsius() {
        // Conversion formula: (°F - 32) * 5/9
        return (fahrenheitTemperature.getFahrenheit() - 32) * 5.0 / 9.0;
    }
}

public class TemperatureConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheitInput = scanner.nextDouble();

        // Create a FahrenheitTemperature object with user input
        FahrenheitTemperature fahrenheitTemperature = new FahrenheitTemperature(fahrenheitInput);

        // Create an adapter to convert Fahrenheit to Celsius
        FahrenheitToCelsiusAdapter adapter = new FahrenheitToCelsiusAdapter(fahrenheitTemperature);

        // Display the temperature in Celsius
        System.out.println("Temperature in Celsius: " + adapter.getCelsius());

        scanner.close();
    }
}
