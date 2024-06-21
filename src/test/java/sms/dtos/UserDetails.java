package sms.dtos;

import lombok.Builder;
import lombok.Getter;
import sms.constants.Contract;
import sms.constants.Gender;

@Getter
@Builder
public class UserDetails {
    String firstName;
    String lastName;
    String country;
    Gender gender;
    String interests;
    String phoneNumber;
    String email;
    String address;
    String designation;
    Contract contract;
    String joinedDate;

}
