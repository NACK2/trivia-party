package com.nack2.trivia_party_server.player;

import com.nack2.trivia_party_server.Common.Response;
import com.nack2.trivia_party_server.exception.PlayerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public ResponseEntity<Response<List<Player>>> getAllPlayers() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new Response<>(new Date(), HttpStatus.OK.value(), playerRepository.findAll())
        );
    }

    public ResponseEntity<Response<Void>> addPlayer(Player player) {
        playerRepository.save(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new Response<>(new Date(), HttpStatus.CREATED.value())
        );
    }

    public ResponseEntity<Response<Void>> removePlayer(String playerId) {
        playerRepository.findById(playerId).orElseThrow(
                () -> new PlayerNotFoundException("Player id " + playerId + " doesn't exist")
        );

        playerRepository.deleteById(playerId);
        // TODO: should we even be returning a body? Is a success message needed in every case?
        // TODO: if keeping ResponseEntity body for all cases, maybe this should be extracted as a helper function?
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                new Response<>(new Date(), HttpStatus.NO_CONTENT.value())
        );
    }
}
