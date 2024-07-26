package com.sparta.automationexercise.stepdefinitions;

import com.sparta.automationexercise.pages.HomePage;
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

    static void stopService() {
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }

    static void createWebdriver() {
        if (webDriver == null) {
            webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
        }
    }

    static void quitWebdriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    static Website getWebsite(String url) {
        createWebdriver();
        webDriver.get(url);
        return new Website(webDriver);
    }
}

