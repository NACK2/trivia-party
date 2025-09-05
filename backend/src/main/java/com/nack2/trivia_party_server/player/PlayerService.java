package com.nack2.trivia_party_server.player;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    public void removePlayer(String string) { playerRepository.deleteById(string); }
}
