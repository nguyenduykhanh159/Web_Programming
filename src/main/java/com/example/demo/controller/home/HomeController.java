package com.example.demo.controller.home;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.config.jwt.JwtTokenProvider;
import com.example.demo.dto.auth.LoginDTO;
import com.example.demo.dto.auth.RegisterDTO;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.service.user.CustomUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Home")
public class HomeController {

    @Autowired
    private CustomUserService customUserService;

    @Operation(summary = "Đăng nhập với bệnh nhân hoặc bác sĩ", description = "")

    // @ApiResponses(value = {

    //         @ApiResponse(responseCode = "200", description = "successful",

    //                 content = @Content(

    //                         mediaType = MediaType.APPLICATION_JSON_VALUE,

    //                         schema = @Schema(implementation =

    //                         SwaggerExampleResponse.class),

    //                         examples =

    //                         @ExampleObject(value = SwaggerExampleResponse.LOGIN_RESPONSE))),

    //         @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema

    //         = @Schema(implementation = NotFoundResponse.class))),

    //         @ApiResponse(responseCode = "401", description = "Forbidden", content

    //         = @Content(schema = @Schema(implementation = NotFoundResponse.class))),

    //         @ApiResponse(responseCode = "403", description =

    //         "Forbidden", content = @Content(schema = @Schema(implementation = NotFoundResponse.class))),

    //         @ApiResponse(responseCode = "500", description =

    //         "Internal Server Error", content = @Content(schema = @Schema(implementation = NotFoundResponse.class))) })

    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {

            // @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,

            //         examples = @ExampleObject(value =

            //         SwaggerExampleRequest.LOGIN_REQUEST))
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                     


    })

    @PostMapping("/login")
    public BaseResponse login(@RequestBody UserDTO userDTO) {
        return customUserService.login(userDTO);
    }

    @PostMapping(value = "/register")
    public BaseResponse register(@RequestBody UserDTO registerDto) {

        return customUserService.registerUser(registerDto);
    }

    @GetMapping("/remove/{id}")
    public BaseResponse removeUser(@PathVariable("id") Integer userId) {
        System.out.println(userId);
        return customUserService.removeUser(userId);
    }

}
