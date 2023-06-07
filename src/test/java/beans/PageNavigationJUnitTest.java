package beans;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageNavigationJUnitTest {
    private PageNavigation pageNavigation = new PageNavigation();

    @Test
    public void test_When_CallGoToMain_Should_ReturnGo() {
        String expected_string = "go";
        String real_string = pageNavigation.goToMain();

        assertEquals(expected_string, real_string);
    }

    @Test
    public void test_When_CallGoToIndex_Should_ReturnGo() {
        String expected_string = "go";
        String real_string = pageNavigation.goToIndex();

        assertEquals(expected_string, real_string);
    }
}
