package org.dd2480;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.*;
import java.awt.geom.Point2D;

import org.junit.jupiter.api.Test;

public class CalculateAngleTest {
    @Test
    void shouldThrowIllegalArgumentException_whenNullPointsGiven() {
        Point2D A = null;
        Point2D B = new Point2D.Double(0, 0); // Same as A
        Point2D C = new Point2D.Double(1, 1);

        // Expecting IllegalArgumentException for null point
        assertThrows(IllegalArgumentException.class, () -> Main.calculateAngle(A, B, C));
    }@Test
    void shouldThrowIllegalArgumentException_whenSamePointsGiven() {
        Point2D pointA = new Point2D.Double(0, 0);
        Point2D pointB = new Point2D.Double(0, 0); // Same as A
        Point2D pointC = new Point2D.Double(1, 1);

        // Expecting IllegalArgumentException for undefined angle
        assertThrows(IllegalArgumentException.class, () -> Main.calculateAngle(pointA, pointB, pointC));
    }
    @Test
    void shouldReturnAngle_whenCorrectInput() {
        // Define points A, B, and C forming a right angle (90 degrees or π/2 radians)
        Point2D pointA = new Point2D.Double(0, 0);
        Point2D pointB = new Point2D.Double(1, 0);
        Point2D pointC = new Point2D.Double(0, 1);

        // Expected angle between vectors AB and BC (should be π/4 radians)
        double expectedAngle = Math.PI / 4;

        // Call the method and get the result
        double result = Main.calculateAngle(pointA, pointB, pointC);

        // Assert that the result is close to the expected value
        assertEquals(expectedAngle, result, 1e-9);
    }

    @Test
    void shouldThrowIllegalArgumentException_whenAnyPointNull() {
        Point2D pointA = null;
        Point2D pointB = null;
        // Expecting IllegalArgumentException for undefined angle
        assertThrows(IllegalArgumentException.class, () -> Main.getVectorMagnitude(pointA, pointB));
    }

    @Test
    void shouldReturnTrueValue_whenCorrectInput() {
        Point2D pointA = new Point2D.Double(0,0);
        Point2D pointB = new Point2D.Double(-1,0);
        double expectedMagnitude = 1;
        double result = Main.getVectorMagnitude(pointA,pointB);
        assertEquals(expectedMagnitude,result,1e-9);
    }
}
