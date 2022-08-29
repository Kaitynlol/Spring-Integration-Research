package ru.openbank.digital.serviceint.api;

import ru.openbank.digital.serviceint.model.ClientInfo;

public interface RegisterClientInCdi {
    void register(ClientInfo clientInfo);
}
