package ru.openbank.digital.serviceint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.openbank.digital.serviceint.dto.RegistrationRequest;
import ru.openbank.digital.serviceint.dto.RegistrationResponse;
import ru.openbank.digital.serviceint.service.RegistrationService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping(value = "/register")
    public RegistrationResponse addNewEmailRequest(@RequestBody @Valid RegistrationRequest request) {
        return registrationService.acceptRegistrationApplication(request);
    }
}
