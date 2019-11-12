package homeworks.homework8;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import homeworks.homework8.data.TestData;
import homeworks.homework8.site.JDISite;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverFactory.close;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static homeworks.homework8.entities.User.piterChailovskii;
import static homeworks.homework8.enums.HeaderItems.METALS_AND_COLORS;

public class MetalsAndColorsPageTest extends JDISite {

    @BeforeSuite
    public void beforeSuite() {
        initElements(JDISite.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @DataProvider
    public Object[][] getData() throws FileNotFoundException {
        JsonObject jsonObject = new JsonParser().parse(new FileReader("src/test/resources/homework8/" +
                "JDI_ex8_metalsColorsDataSet.json")).getAsJsonObject();

        Map<String, TestData> testData = new Gson().fromJson(jsonObject, new TypeToken<Map<String, TestData>>() {}.getType());

        Object[][] dataObjects = new Object[testData.size()][1];
        int index = 0;
        for (String key : testData.keySet()) {
            dataObjects[index++][0] = testData.get(key);
        }
        return dataObjects;
    }

    @Test(dataProvider = "getData")
    public void metalsAndColorsPageTest(TestData metalsAndColors) {
        //1.Login on JDI site as User
        homePage.open();
        homePage.checkOpened();
        homePage.login(piterChailovskii);

        //2.Open Metals & Colors page by HeaderMenu menu
        homePage.clickOnItemInHeader(METALS_AND_COLORS);
        metalsAndColorsPage.checkOpened();

        //3.Fill form Metals & Colors by data below:  Summary: 3, 8, Elements: Water, Fire, Colors: Red, Metals: Selen,
        // VegetablesList: Cucumber,Tomato
        metalsAndColorsPage.fillMetalsAndColorsForm(metalsAndColors);

        //4.Submit form Metals & Colors
        metalsAndColorsPage.submitMetalsAndColorsForm();

        //5.Result sections should contains data  below:  Summary: 11, Elements: Water, Fire, Color: Red, Metal: Selen,
        // VegetablesList: Cucumber, Tomato
        metalsAndColorsPage.checkResults(metalsAndColors);
    }
}
