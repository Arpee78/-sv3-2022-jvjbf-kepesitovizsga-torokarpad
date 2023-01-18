package flights;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

    private List<Flight> flights = new ArrayList<>();

    public FlightService(Path path) {
        readFile(path);
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }

    public void readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private void processLine(String line){
        String[] parts = line.split(";");
        String airline = parts[0];
        String departure = parts[1].split("-")[0];
        String arrival = parts[1].split("-")[1];
        int numberOfPassangers = Integer.parseInt(parts[2]);
        flights.add(new Flight(airline, departure, arrival, numberOfPassangers));
    }

    public int sumOfPassengersByAirline(String airline) {
        int sum = 0;
        for (Flight actual : flights) {
            if (actual.getAirline().equals(airline)) {
                sum += actual.getNumberOfPassengers();
            }
        }
        return sum;
    }
}
