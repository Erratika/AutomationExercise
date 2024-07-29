package com.sparta.automationexercise.stepdefinitions;

import com.sparta.automationexercise.pages.Website;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestSetup {
    private static ChromeDriverService service;
    private static WebDriver webDriver;
    private static final String BASE_URL = "https://automationexercise.com/";
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver";

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return options;
    }

    public static void startChromeService() throws IOException {
        if (service == null) {
            service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(DRIVER_LOCATION))
                    .usingAnyFreePort()
                    .build();
            service.start();
        }
    }

    public static void stopService() {
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }

    public static void createWebDriver() {
        if (webDriver == null) {
            webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
        }
    }

    public static void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public static Website getWebsite(String url) {
        createWebDriver();
        webDriver.get(url);
        return new Website(webDriver);
    }
}
