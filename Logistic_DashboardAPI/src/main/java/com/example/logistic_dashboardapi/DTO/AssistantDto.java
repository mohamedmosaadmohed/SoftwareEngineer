package com.example.logistic_dashboardapi.DTO;

public class AssistantDto {

        private String name;
        private String password;
        private String username;
        private String email;
        private String privilege;
        private String role;

        // Getter and Setter for name
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Getter and Setter for password
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        // Getter and Setter for username
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        // Getter and Setter for email
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        // Getter and Setter for privilege
        public String getPrivilege() {
            return privilege;
        }

        public void setPrivilege(String privilege) {
            this.privilege = privilege;
        }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
            this.role = role;
    }
}
