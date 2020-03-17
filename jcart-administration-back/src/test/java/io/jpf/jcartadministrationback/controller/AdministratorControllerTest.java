package io.jpf.jcartadministrationback.controller;

import io.jpf.jcartadministrationback.constant.ClientExceptionConstant;
import io.jpf.jcartadministrationback.dto.in.AdministratorLoginInDTO;
import io.jpf.jcartadministrationback.dto.out.AdministratorLoginOutDTO;
import io.jpf.jcartadministrationback.exception.ClientException;
import io.jpf.jcartadministrationback.po.Administrator;
import io.jpf.jcartadministrationback.service.AdministratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AdministratorControllerTest {

    @Autowired
    private AdministratorController administratorController;

    @MockBean
    private AdministratorService administratorService;

    /*@Test
    void login() throws ClientException {

        AdministratorLoginInDTO administratorLoginInDTO = new AdministratorLoginInDTO();
        administratorLoginInDTO.setUsername("admin");
        administratorLoginInDTO.setPassword("admin");

        AdministratorLoginOutDTO loginOutDTO = administratorController.login(administratorLoginInDTO);
        assertNotNull(loginOutDTO);

        administratorLoginInDTO.setUsername("admin001");
        administratorLoginInDTO.setPassword("admin");
        try {
            loginOutDTO = administratorController.login(administratorLoginInDTO);
        }catch (ClientException ex){
            String errCode = ex.getErrCode();
            assertEquals(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE, errCode);
        }

        administratorLoginInDTO.setUsername("admin");
        administratorLoginInDTO.setPassword("111111");
        try {
            loginOutDTO = administratorController.login(administratorLoginInDTO);
        }catch (ClientException ex){
            String errCode = ex.getErrCode();
            assertEquals(ClientExceptionConstant.ADMINISTRATOR_PASSWORD_INVALID_ERRCODE, errCode);
        }

    }*/

    @Test
    void loginSuccess() throws ClientException {
        AdministratorLoginInDTO administratorLoginInDTO = new AdministratorLoginInDTO();
        administratorLoginInDTO.setUsername("admin");
        administratorLoginInDTO.setPassword("123456");
        Administrator mockAdministrator = new Administrator();
        mockAdministrator.setUsername("admin");
        mockAdministrator.setEncryptedPassword("$2a$12$LCQseGaU5sCdBFX98Kid.OkOvcnUYYswQrbU732Y8kN.UbWDiEua.");
        when(administratorService.getByUsername("admin")).thenReturn(mockAdministrator);
        AdministratorLoginOutDTO loginOutDTO = administratorController.login(administratorLoginInDTO);
        assertNotNull(loginOutDTO);

    }

    @Test
    void loginWrongUsername(){
        AdministratorLoginInDTO administratorLoginInDTO = new AdministratorLoginInDTO();
        administratorLoginInDTO.setUsername("admin110");
        administratorLoginInDTO.setPassword("123456");
        try {
            AdministratorLoginOutDTO loginOutDTO = administratorController.login(administratorLoginInDTO);
        }catch (ClientException ex){
            String errCode = ex.getErrCode();
            assertEquals(ClientExceptionConstant.ADMINISTRATOR_USERNAME_NOT_EXIST_ERRCODE, errCode);
        }
    }

    @Test
    void loginWrongPassword(){
        AdministratorLoginInDTO administratorLoginInDTO = new AdministratorLoginInDTO();
        administratorLoginInDTO.setUsername("admin");
        administratorLoginInDTO.setPassword("abcdef");
        try {
            AdministratorLoginOutDTO loginOutDTO = administratorController.login(administratorLoginInDTO);
        }catch (ClientException ex){
            String errCode = ex.getErrCode();
            assertEquals(ClientExceptionConstant.ADMINISTRATOR_PASSWORD_INVALID_ERRCODE, errCode);
        }
    }
}