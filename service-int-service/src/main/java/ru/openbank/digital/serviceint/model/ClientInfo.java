package ru.openbank.digital.serviceint.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ClientInfo {
    private Integer id;
    private String name;
    private String birthDay;


}
