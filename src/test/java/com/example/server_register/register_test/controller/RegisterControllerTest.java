package com.example.server_register.register_test.controller;

import com.example.server_register.controller.RegisterController;
import com.example.server_register.model.Register;
import com.example.server_register.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
public class RegisterControllerTest {

//    @Mock
//    private RegisterService registerService;
//
//    @InjectMocks
//    private RegisterController registerController;
//
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    @Rollback
//    public void testGetRegisterOfStudent() {
//        // Arrange
//        Integer idStudentDepartment = 2;
//        Integer idSemesterSchoolYear = 8;
//        List<Register> expectedResult = Arrays.asList(new Register(), new Register());
//
//        // Mocking the behavior of registerService.getRegisterOfStudent
//        when(registerService.getRegisterOfStudent(idStudentDepartment, idSemesterSchoolYear)).thenReturn(expectedResult);
//
//        // Act
//        RegisterRespone<List<Register>> response = registerController.getRegisterOfStudent(idStudentDepartment, idSemesterSchoolYear);
//
//        // Assert
//        assertNotNull(response); // Ensure response is not null
//        assertEquals(expectedResult, response.getData()); // Ensure data returned matches the expected result
//    }
}
