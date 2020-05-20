package controllerTest;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class SomeControllerTest {
    @Mock
    CompanyController companyController;
    @Mock
    CompanyUserController companyUserController;
    @Mock
    Model model;
    @Mock
    User user;
    @BeforeMethod
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        companyController = new CompanyController(companyUserController, companyController);
        user = new User();
    }

    @Test
    void getUser() {
        String viewName = companyController.getUser((org.testng.mustache.Model) model);
        assertEquals("user/data", viewName);
        verify(companyUserController, times(1)).find();
        verify(model, times(1)).addAttribute(eq("user"), anyCollection());
    }
}
