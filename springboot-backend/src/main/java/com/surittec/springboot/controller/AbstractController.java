package com.surittec.springboot.controller;

import com.surittec.springboot.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbstractController {

    protected interface RestFunctionNoArg<R> {
        R apply() throws Exception;
    }

    protected interface RestFunctionVoidNoArg {
        void apply() throws Exception;
    }

    protected <R> ResponseEntity buildResponse(RestFunctionNoArg<R> f) {
        try {
            return ResponseEntity.ok(f.apply());
        } catch (Exception ex) {
            return tratamentoErro(ex);
        }
    }

    protected ResponseEntity buildResponse(RestFunctionVoidNoArg f) {
        try {
            f.apply();
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return tratamentoErro(ex);
        }
    }

    protected ResponseEntity tratamentoErro(Exception ex) {

        if(ex instanceof TransactionSystemException){
            if(Objects.nonNull(ex.getCause()) && Objects.nonNull(ex.getCause().getCause()) && ex.getCause().getCause() instanceof ConstraintViolationException){
                ConstraintViolationException cve = (ConstraintViolationException) ex.getCause().getCause();
                List<String> violatiosn = cve.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
                return ResponseEntity.badRequest().body(new ErrorDTO("Erros de Violação", "", violatiosn));
            }
        }
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDTO(ex.getMessage(), "Ocorreu um erro", new ArrayList<>()));
    }

}
