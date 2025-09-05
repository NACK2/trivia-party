package com.nack2.trivia_party_server.player;

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
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @DeleteMapping("/{playerId}")
    public void removePlayer(@PathVariable String playerId) {
        playerService.removePlayer(playerId);
    }
}
