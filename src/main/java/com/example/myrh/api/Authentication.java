package com.example.myrh.api;

import com.example.myrh.config.JwtUtil;
import com.example.myrh.dto.AuthenticationRequest;
import com.example.myrh.dto.Code;
import com.example.myrh.dto.Token;
import com.example.myrh.entities.Image;
import com.example.myrh.entities.Recruteur;
import com.example.myrh.exceptions.NoSuchUserException;
import com.example.myrh.helper.Email;
import com.example.myrh.services.Implementation.RecruteurServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Authentication {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final RecruteurServiceImplementation recruteurService;
    private  final Email emailSender;
    private final JwtUtil jwtUtil;
    private String code;


    @PostMapping("/recruteur")
    public ResponseEntity<Token> RecruteurAuthentication(@RequestBody AuthenticationRequest auth) throws NoSuchUserException, JSONException {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(auth.getEmail()+ "-RECRUITER", auth.getPassword())
        );
        final UserDetails user = userDetailsService.loadUserByUsername(auth.getEmail()+ "-RECRUITER");
        if(user != null) {
              Token token =  new Token();
              token.setToken(jwtUtil.generateToken(user));
            return  ResponseEntity.ok(token);
        }
        return null;

    }

    @PostMapping(value = "/register", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity.BodyBuilder register(@RequestPart("recruteur") Recruteur recruteur,
                                               @RequestPart("ImageFile") MultipartFile file) {

        try {
            System.out.println(recruteur.getNom());
//            Set<Image> image= uploadImage(file[0]);
//            recruteur.setImage(image);
//            recruteurService.recruteurRegister(recruteur);
            System.out.println("created");
            return ResponseEntity.status(200);
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(500);
    }


    @PostMapping("/sendVerification")
    public ResponseEntity<String> verificationCodeSender() {
        code = generateCode();
        emailSender.sendEmail("elhaoudihaytham@gmail.com","VERIFICATION CODE","Votre code de verification  "+ code);
            codeInvalidator();
            return ResponseEntity.ok("code sent");

    }

    @PostMapping("/verification")
    public ResponseEntity<String> verifySms(@RequestBody Code code) {
        if (this.code.equals(code.getCode())) {
            return ResponseEntity.ok("code correct");
        } else {
            System.out.println("NOT MATCHED");
            return null;
        }
    }
    private Set<Image> uploadImage( MultipartFile multipartFiles) throws IOException {

        Set<Image> imageSet = new HashSet<>();
        Image image = new Image(
                multipartFiles.getOriginalFilename(),
                multipartFiles.getContentType(),
                multipartFiles.getBytes()
        );
        imageSet.add(image);
        return imageSet;
    }

    public String generateCode() {
        int code = (int) (Math.random() * 90000) + 10000;
        return String.valueOf(code);
    }
    private void codeInvalidator() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override

                    public void run() {
                        code = generateCode();
                    }

                },
                60000
        );
    }
}
