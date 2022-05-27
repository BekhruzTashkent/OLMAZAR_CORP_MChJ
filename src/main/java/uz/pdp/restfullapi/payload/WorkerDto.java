package uz.pdp.restfullapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class WorkerDto {

    private String homeNumber;
    private String street;
    private String corpName;
    private String directorName;
    private String departmentName;
    private String workerName;
    private String phoneNumber;


}
