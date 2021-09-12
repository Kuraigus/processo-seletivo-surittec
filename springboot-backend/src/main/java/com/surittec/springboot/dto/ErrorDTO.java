package com.surittec.springboot.dto;

import java.util.List;

public class ErrorDTO {

        private String message;
        private String cause;
        private List<String> violations;

        public ErrorDTO(String message, String cause, List<String> violations) {
            this.message = message;
            this.cause = cause;
            this.violations = violations;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCause() {
            return cause;
        }

        public void setCause(String cause) {
            this.cause = cause;
        }

        public List<String> getViolations() {
            return violations;
        }

        public void setViolations(List<String> violations) {
            this.violations = violations;
        }
}
