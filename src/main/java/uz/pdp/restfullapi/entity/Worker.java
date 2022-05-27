package uz.pdp.restfullapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Worker {  //INFO ABOUT WORKER OPTIONAL, YOU CAN WRITE JUST COMPANY INFO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne
    private Address workerAddress;

    @OneToOne
    private Department department;

}
