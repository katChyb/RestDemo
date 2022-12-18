package general;

import org.junit.jupiter.params.provider.Arguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class DataProviderWeatherTest {

    private static Logger log = LoggerFactory.getLogger(DataProviderWeatherTest.class);
    private static Stream<Arguments> testDataLocations() {
        log.info(">>>>>>>> Data provider started <<<<<<<<<");
        return Stream.of(
                Arguments.of("London,uk"),
                Arguments.of("Oxford,uk"),
                Arguments.of("Gdańsk, pl")
        );
    }
}
