import helpers.*;
import helpers.utils.OptionType;

import java.util.Map;

import static helpers.Interfaces.Condition;
import static helpers.Interfaces.Logger;

@ScriptManifest(
        name = "SampleScript",
        description = "Sample script description",
        version = "1.01",
        guideLink = "",
        categories = {ScriptCategory.Fletching, ScriptCategory.Agility}
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
                        optionType = OptionType.INTEGER
                ),
                // Example config for bank tabs
                @ScriptConfiguration(
                        name =  "BankTab",
                        description = "What bank tab is your resources located in?",
                        defaultValue = "0",
                        optionType = OptionType.BANKTABS
                ),
                // Example config percentage
                @ScriptConfiguration(
                        name =  "Percentage",
                        description = "What percentage would you like to do some action at?",
                        defaultValue = "40",
                        optionType = OptionType.PERCENTAGE
                )
        }
)

public class SampleScript extends AbstractScript {
    String chosenTest; //Lets save the 1st config value
    String anotherConfig; //Lets save the 2nd config value
    String selectedBankTab;
    String percentage;

    @Override
    public void onStart(){
        Map<String, String> configs = getConfigurations(); //Get the script configuration
        chosenTest = configs.get("Method"); // Example to get value of the first option
        anotherConfig = configs.get("Tier"); // Example to get the second option
        selectedBankTab = configs.get("BankTab"); // Get the bankTab value from the last configuration option
        percentage = configs.get("Percentage");

        //Logs for debugging purposes
        Logger.log("We are starting the sample script and running onStart()");
        Logger.log("Test configuration set to: " + chosenTest);
        Logger.log("2nd config value set to: " + anotherConfig);
        Logger.log("Selected bank tab set to: " + selectedBankTab);
        Logger.log("Percentage value set to: " + percentage);
    }

    @Override
    public void poll() {
        Logger.log("We are looping the poll() method!");
        Condition.sleep(5000);
        // Main logic for the script
    }
}