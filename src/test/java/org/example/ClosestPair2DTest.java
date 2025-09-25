package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPair2DTest {

    @Test
    void findsCorrectDistanceForTwoPoints() {
        ClosestPair2D.Point[] pts = {
                new ClosestPair2D.Point(0, 0),
                new ClosestPair2D.Point(3, 4)
        };

        ClosestPair2D algo = new ClosestPair2D();
        double result = algo.run(pts);

        assertEquals(5.0, result, 1e-9, "Расстояние между (0,0) и (3,4) должно быть 5");
    }

    @Test
    void findsClosestPairInSet() {
        ClosestPair2D.Point[] pts = {
                new ClosestPair2D.Point(2, 3),
                new ClosestPair2D.Point(12, 30),
                new ClosestPair2D.Point(40, 50),
                new ClosestPair2D.Point(5, 1),
                new ClosestPair2D.Point(12, 10),
                new ClosestPair2D.Point(3, 4)
        };

        ClosestPair2D algo = new ClosestPair2D();
        double result = algo.run(pts);

        assertTrue(result > 0, "Должно находиться положительное расстояние");
        assertEquals(Math.hypot(2 - 3, 3 - 4), result, 1e-9,
                "Ближайшая пара должна быть (2,3) и (3,4)");
    }

    @Test
    void handlesPointsOnLine() {
        ClosestPair2D.Point[] pts = {
                new ClosestPair2D.Point(0, 0),
                new ClosestPair2D.Point(1, 0),
                new ClosestPair2D.Point(2, 0),
                new ClosestPair2D.Point(3, 0)
        };

        ClosestPair2D algo = new ClosestPair2D();
        double result = algo.run(pts);

        assertEquals(1.0, result, 1e-9, "Минимальное расстояние на линии должно быть 1");
    }

    @Test
    void handlesSinglePair() {
        ClosestPair2D.Point[] pts = {
                new ClosestPair2D.Point(7, 7),
                new ClosestPair2D.Point(10, 10)
        };

        ClosestPair2D algo = new ClosestPair2D();
        double result = algo.run(pts);

        assertEquals(Math.sqrt(18), result, 1e-9);
    }

    @Test
    void handlesMultipleIdenticalPoints() {
        ClosestPair2D.Point[] pts = {
                new ClosestPair2D.Point(1, 1),
                new ClosestPair2D.Point(1, 1),
                new ClosestPair2D.Point(2, 2)
        };

        ClosestPair2D algo = new ClosestPair2D();
        double result = algo.run(pts);

        assertEquals(0.0, result, 1e-9, "Одинаковые точки должны давать расстояние 0");
    }
}
