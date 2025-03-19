# Troubleshooting JavaFX Application Errors

## Common Issues and Solutions

### 1. JavaFX Runtime Components Missing

If you see an error related to JavaFX runtime components, ensure your `pom.xml` correctly includes JavaFX dependencies:

```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>17</version>
</dependency>
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>17</version>
</dependency>
```

### 2. FXML Loading Errors

If your application fails when loading FXML files:
- Check for errors in your FXML files (missing closing tags, incorrect IDs)
- Ensure controller classes are properly referenced
- Verify that all referenced components exist

### 3. Controller Initialization Errors

Common causes:
- Missing `@FXML` annotations on fields
- Incorrect variable types
- Null pointer exceptions during initialization

### 4. Maven Execution Issues

If Maven fails to run your application:
- Verify the JavaFX Maven plugin configuration
- Ensure the main class is correctly specified
- Check for Java version compatibility issues

## Running with Debug Output

Use the provided `run-debug.bat` script to get more detailed error information:

