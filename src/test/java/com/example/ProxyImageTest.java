package com.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ProxyImageTest {
    @Test
    void testProxyImage() {
        // Capture stdout to verify loading behavior
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        MyImage image = new ProxyImage("test.jpg");
        
        // Should not load yet
        String output = outContent.toString();
        assertFalse(output.contains("Loading test.jpg"));

        image.display();
        
        // Should load and display
        output = outContent.toString();
        assertTrue(output.contains("Loading test.jpg"));
        assertTrue(output.contains("Displaying test.jpg"));
        
        // Reset stream
        outContent.reset();
        
        image.display();
        // Should only display, not load again
        output = outContent.toString();
        assertFalse(output.contains("Loading test.jpg"));
        assertTrue(output.contains("Displaying test.jpg"));
    }
}
