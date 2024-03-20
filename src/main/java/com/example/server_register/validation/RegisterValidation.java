package com.example.server_register.validation;

import com.example.server_register.commons.exception.ErrorMessageConstant;
import com.example.server_register.commons.exception.InvalidInputException;
import com.example.server_register.commons.exception.RegisterException;
import com.example.server_register.commons.suberror.ApiMessageError;
import com.example.server_register.commons.suberror.ApiSubError;
import com.example.server_register.model.Register;
import com.example.server_register.service.RegisterService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegisterValidation {

}
