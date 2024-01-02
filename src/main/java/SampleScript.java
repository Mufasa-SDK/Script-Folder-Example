import helpers.*;
import helpers.utils.OptionType;

import java.util.Map;

import static helpers.Interfaces.condition;
import static helpers.Interfaces.logger;

@ScriptManifest(
        name = "SampleScript",
        description = "Sample script description",
        version = "1.01",
        category = ScriptCategory.Fletching
)
@ScriptConfiguration.List(
        {
                // Example config with a selection dropdown
                @ScriptConfiguration(
                        name =  "Method",
                        description = "Which operation would you like to perform?",
                        defaultValue = "Cut",
                        allowedValues = {
                                @AllowedValue(optionName = "Cut"),
                                @AllowedValue(optionName = "String")
                        },
                        optionType = OptionType.STRING
                ),
                @ScriptConfiguration(
                // Example config with a selection dropdown that includes item images (based on itemID)
                        name =  "Tier",
                        description = "Which tier of logs/bows would you like to use?",
                        defaultValue = "Maple logs",
                        allowedValues = {
                                @AllowedValue(optionIcon = "1511", optionName = "Logs"),
                                @AllowedValue(optionIcon = "1521", optionName = "Oak logs"),
                                @AllowedValue(optionIcon = "1519", optionName = "Willow logs"),
                                @AllowedValue(optionIcon = "1517", optionName = "Maple logs"),
                                @AllowedValue(optionIcon = "1515", optionName = "Yew logs"),
                                @AllowedValue(optionIcon = "1513", optionName = "Magic logs")
                        },
                        optionType = OptionType.STRING
                ),
                // Example config with a selection dropdown
                @ScriptConfiguration(
                        name =  "Product",
                        description = "Would you like to make short or longbows?",
                        defaultValue = "Longbow",
                        allowedValues = {
                                @AllowedValue(optionName = "Shortbow"),
                                @AllowedValue(optionName = "Longbow")
                        },
                        optionType = OptionType.STRING
                ),
                // Example config with integer options (spinner)
                @ScriptConfiguration(
                        name =  "Some integer option",
                        description = "Some integer option description",
                        defaultValue = "0",
                        minMaxIntValues = {0, 9},
                        allowedValues = {
                                @AllowedValue(optionName = "0"),
                                @AllowedValue(optionName = "1"),
                                @AllowedValue(optionName = "2"),
                                @AllowedValue(optionName = "3"),
                                @AllowedValue(optionName = "4"),
                                @AllowedValue(optionName = "5"),
                                @AllowedValue(optionName = "6"),
                                @AllowedValue(optionName = "7"),
                                @AllowedValue(optionName = "8"),
                                @AllowedValue(optionName = "9"),
                        },
                        optionType = OptionType.INTEGER
                ),
                // Example config for bank tabs
                @ScriptConfiguration(
                        name =  "BankTab",
                        description = "What bank tab is your resources located in?",
                        defaultValue = "0",
                        optionType = OptionType.BANK
                )
        }
)

public class SampleScript extends AbstractScript {
    String chosenTest; //Lets save the 1st config value
    String anotherConfig; //Lets save the 2nd config value
    String selectedBankTab;

    @Override
    public void onStart(){
        Map<String, String> configs = getConfigurations(); //Get the script configuration
        chosenTest = configs.get("Test configuration"); //Set this value to the 'chosenTest' string
        anotherConfig = configs.get("Another configuration"); //Get the value from the 2nd configuration option

        //Logs for debugging purposes
        logger.log("We are starting the sample script and running onStart()");
        logger.log("Test configuration set to: " + chosenTest);
        logger.log("2nd config value set to: " + anotherConfig);
        System.out.println("Starting the SampleScript!");
    }

    @Override
    public void poll() {
        logger.log("We are looping the poll() method!");
        condition.sleep(5000);
        System.out.println("Executing main logic of the SampleScript!");
        // Main logic for the script
    }
}