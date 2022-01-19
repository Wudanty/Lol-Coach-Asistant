package com.example.coachasistantapi3.services;

import com.example.coachasistantapi3.models.Player;
import com.example.coachasistantapi3.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getPlayerById(Integer id){
        return playerRepository.findById(id).get();
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player){
        return playerRepository.save(player);
    }

    public Player deletePlayer(Integer id){
        Player player = playerRepository.findById(id).get();
        playerRepository.delete(player);
        return player;
    }

    public Player updatePlayer(Player player){
        Player playerNew = playerRepository.findById(player.getPlayerId()).get();
        playerNew.setNickname(player.getNickname());
        playerRepository.save(playerNew);
        return playerNew;
    }
}
