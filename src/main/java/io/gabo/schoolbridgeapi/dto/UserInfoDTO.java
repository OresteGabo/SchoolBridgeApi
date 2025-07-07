package io.gabo.schoolbridgeapi.dto;

import java.util.Set;

public class UserInfoDTO {
    public Long   id;
    public String userName;
    public String email;
    public String fullName;
    public Set<String> roles;
    public UserInfoDTO() {}
    public UserInfoDTO(Long id, String userName, String email, String fullName, Set<String> roles) {
        this.id = id; this.userName = userName; this.email = email; this.fullName = fullName; this.roles = roles;
    }
}



//package io.gabo.schoolbridgeapi.dto;
//
//import java.util.Set;
//
//public class UserInfoDTO {
//    private Long id;
//    private String userName;
//    private String email;
//    private String fullName;
//    private Set<String> roles;
//
//    public UserInfoDTO() {}
//
//    public UserInfoDTO(Long id, String userName, String email, String fullName, Set<String> roles) {
//        this.id = id;
//        this.userName = userName;
//        this.email = email;
//        this.fullName = fullName;
//        this.roles = roles;
//    }
//
//}
//
