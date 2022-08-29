package ru.openbank.digital.serviceint.api;

import ru.openbank.digital.serviceint.dto.RegistrationRequest;

public interface PrepareClient {

    void prepareClientInfo(RegistrationRequest request);
}
