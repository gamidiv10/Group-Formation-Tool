package CSCI5308.GroupFormationTool.Question;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class HandleInputOptionsTest {
    @Test
    public void handleOptionsSuccessTest() {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getParameter("displayText-1")).thenReturn("displayText1");
        when(httpServletRequest.getParameter("storedAs-1")).thenReturn("1");
        when(httpServletRequest.getParameter("displayText-3")).thenReturn(null);
        when(httpServletRequest.getParameter("storedAs-3")).thenReturn(null);
        HandleInputOptions handleInputOptions = new HandleInputOptions();
        assertEquals(handleInputOptions.handleOptions(httpServletRequest).get(0).getDisplayText(), "displayText1");
    }

    @Test
    public void handleOptionsFailureTest() {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getParameter("displayText-1")).thenReturn("displayText1");
        when(httpServletRequest.getParameter("storedAs-1")).thenReturn("1");
        when(httpServletRequest.getParameter("displayText-3")).thenReturn(null);
        when(httpServletRequest.getParameter("storedAs-3")).thenReturn(null);
        HandleInputOptions handleInputOptions = new HandleInputOptions();
        assertNotEquals(handleInputOptions.handleOptions(httpServletRequest).get(0).getDisplayText(), "displayText2");
    }
}
