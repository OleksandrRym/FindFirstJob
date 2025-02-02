package net.olerym;

import net.olerym.enums.LANGUAGE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = getDriver();
        String lang = LANGUAGE.Python.toString();//Chose language
        openSite(driver, lang);
    }

    private static void openSite(WebDriver driver, String lang) {
        List<String> list = List.of("https://djinni.co/jobs/?page=1&all_keywords=&any_of_keywords=&exclude_keywords=&q_company=&primary_keyword=" + lang + "&salary=0&exp_level=no_exp&exp_level=1y",
                "https://ua.indeed.com/jobs?q=" + lang + "+junior",
                "https://ua.linkedin.com/jobs/search?keywords=" + lang + "&location=Ukraine&f_E=1%2C2%2C3&position=1&pageNum=0",
                "https://jobs.dou.ua/vacancies/?category=" + lang + "&exp=1-3"
        );
        list.forEach(el -> {
            driver.get((String) el);
            driver.switchTo().newWindow(WindowType.TAB);
        });
        driver.get("https://jobs.dou.ua/vacancies/?category=" + lang + "&exp=0-1");
    }


    private static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/roa/IdeaProjects/aqa/src/test/chromedriver");
        return new ChromeDriver();
    }
}
