package com.nack2.trivia_party_server.player;

import com.nack2.trivia_party_server.Common.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<Response<List<Player>>> getPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public ResponseEntity<Response<Void>> addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Response<Void>> removePlayer(@PathVariable String playerId) {
        return playerService.removePlayer(playerId);
    }
}
