package seedu.address.commons.util;

import java.io.IOException;
import java.util.Optional;

import seedu.address.commons.core.Config;
import seedu.address.commons.exceptions.DataConversionException;

/**
 * A class for accessing the Config File.
 */
public class ConfigUtil {

    public static Optional<Config> readConfig(String configFilePath) throws DataConversionException {
        return JsonUtil.readJsonFile(configFilePath, Config.class);
    }

    public static void saveConfig(Config config, String configFilePath) throws IOException {
        JsonUtil.saveJsonFile(config, configFilePath);
    }

    /**
     * Update the appTitle field in config.json
     */
    public static void updateConfig(String configFilePath, String addressBookFileName)
        throws DataConversionException, IOException {
        Config config = readConfig(configFilePath).get();
        config.setAppTitle(addressBookFileName);
        saveConfig(config, configFilePath);
    }
}
