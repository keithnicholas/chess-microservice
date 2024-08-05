package com.baneff.playerdata.player;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @GetMapping()
    public String callGameControllerP1P2(){
        String player1 = "igat";
        String player2 = "banef";
        RestTemplate restTemplate = new RestTemplate();
        String gameControllerURL
                = "http://localhost:9000/game/"+player1+"/"+player2;
        return restTemplate.getForEntity(gameControllerURL, String.class).toString();
    }
//    public ResponseEntity<String> verifyToken(@RequestParam("token") String token) {
//        if (tokenService.isValidToken(token)) {
//            return new ResponseEntity<>("Token is valid", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Token is invalid", HttpStatus.UNAUTHORIZED);
//        }
//    }
}
