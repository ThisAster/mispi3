package area_zone;

import beans.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleAreaJUnitTest {
    private Area area = new Area() {
        @Override
        public Area getNextDecorator() {
            return super.getNextDecorator();
        }

        @Override
        public void setNextDecorator(Area nextDecorator) {
            super.setNextDecorator(nextDecorator);
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }

        @Override
        protected boolean canEqual(Object other) {
            return super.canEqual(other);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        protected boolean cheakArea(Point point) {
            return super.cheakArea(point);
        }

        @Override
        public boolean cheakAreaDecorate(Point point) {
            return super.cheakAreaDecorate(point);
        }

        @Override
        public void addArea(Area area) {
            super.addArea(area);
        }
    };
    private RectangleArea rectangleArea = new RectangleArea(area);
    private Point point;

    @Before
    public void beforeRunJUnit() {
        point = new Point();
    }

    @Test
    public void test_When_XLessThan0_Should_ReturnFalse() {
        point.setX(-1);
        point.setY(1);
        point.setR(10);

        Boolean expected_bool = false;
        Boolean real_bool = rectangleArea.cheakArea(point);

        assertEquals(expected_bool, real_bool);
    }

    @Test
    public void test_When_XLessThan0AndGreaterThanR_Should_ReturnFalse() {
        point.setX(100);
        point.setY(1);
        point.setR(10);

        Boolean expected_bool = false;
        Boolean real_bool = rectangleArea.cheakArea(point);

        assertEquals(expected_bool, real_bool);
    }

    @Test
    public void test_When_YLessThan0_Should_ReturnFalse() {
        point.setX(1);
        point.setY(-1);
        point.setR(10);

        Boolean expected_bool = false;
        Boolean real_bool = rectangleArea.cheakArea(point);

        assertEquals(expected_bool, real_bool);
    }

    @Test
    public void test_When_YGreaterThan0AndGreaterThanHalfR_Should_ReturnFalse() {
        point.setX(1);
        point.setY(6);
        point.setR(10);

        Boolean expected_bool = false;
        Boolean real_bool = rectangleArea.cheakArea(point);

        assertEquals(expected_bool, real_bool);
    }

    @Test
    public void test_When_XAndYLessThanRAndHalfR_Should_ReturnTrue() {
        point.setX(1);
        point.setY(2);
        point.setR(10);

        Boolean expected_bool = true;
        Boolean real_bool = rectangleArea.cheakArea(point);

        assertEquals(expected_bool, real_bool);
    }

}
