# Chapter 3: Test Utilities: The Swiss Army Knife

# Motivation
Sometimes you need to do things that aren't specific to any one page, like taking a screenshot when a test fails or waiting for a slow element to appear. **Test Utilities** are the "Swiss Army Knife" of our project—handy tools that we can use anywhere.

# Core Explanation
The `TestUtil` class contains static methods that help with common tasks. This prevents us from repeating the same code over and over in different tests. It's all about keeping our code "DRY" (Don't Repeat Yourself).

# Code Examples
<details><summary>code block</summary>

```java
public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}
```
</details>

# Internal Walkthrough
Utilities are usually called directly by the [Test Base](01_test_base.md) or by individual tests when they need a specific helper function.
```mermaid
graph LR
    Test --> Util[TestUtil.takeScreenshot()]
    Base --> Util[TestUtil.PAGE_LOAD_TIMEOUT]
```

# Cross-Linking
The [Test Base](01_test_base.md) uses utilities to set up browser timeouts, and the [Event Listener](09_event_listening.md) uses them to capture evidence of what happened.

# Conclusion
Utilities keep our project clean and efficient. Now let's look at how we manage all the different settings for our framework in [Configuration Management](04_configuration_management.md).
