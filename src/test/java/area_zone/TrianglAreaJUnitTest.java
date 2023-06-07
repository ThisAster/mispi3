package area_zone;

import beans.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrianglAreaJUnitTest {
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
    private TriangleArea sectorArea = new TriangleArea(area);
    private Point point;

    @Before
    public void beforeRunJUnit() {
        point = new Point();
    }

    @Test
    public void test_When_XLessThan0_Should_ReturnFalse() {
        point.setX(-1);
        point.setY(-1);
        point.setR(10);

        Boolean expected_bool = false;
        Boolean real_bool = sectorArea.cheakArea(point);

        assertEquals(expected_bool, real_bool);
    }

    @Test
    public void test_When_YGraterThan0_Should_ReturnFalse() {
        point.setX(1);
        point.setY(1);
        point.setR(10);

        Boolean expected_bool = false;
        Boolean real_bool = sectorArea.cheakArea(point);

        assertEquals(expected_bool, real_bool);
    }

    @Test
    public void test_When_YLessThanDiffHalfXAndHalfR_Should_ReturnFalse() {
        point.setX(1);
        point.setY(1);
        point.setR(1);

        Boolean expected_bool = false;
        Boolean real_bool = sectorArea.cheakArea(point);

        assertEquals(expected_bool, real_bool);
    }

    @Test
    public void test_When_YGreaterThanDiffHalfXAndHalfR_Should_ReturnTrue() {
        point.setX(1);
        point.setY(-1);
        point.setR(10);

        Boolean expected_bool = true;
        Boolean real_bool = sectorArea.cheakArea(point);

        assertEquals(expected_bool, real_bool);
    }
}
