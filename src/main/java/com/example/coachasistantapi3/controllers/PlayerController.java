package com.example.coachasistantapi3.controllers;

import com.example.coachasistantapi3.models.Player;
import com.example.coachasistantapi3.services.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT})
public class PlayerController {
    private PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/create")
    public Player AddPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }

    @GetMapping("/get/{id}")
    public Player GetPlayer(@PathVariable Integer id){
        return playerService.getPlayerById(id);
    }

    @GetMapping("/getall")
    public List<Player> GetAllPlayers(){
        return playerService.getAllPlayers();
    }

    @DeleteMapping("/delete/{id}")
    public Player deletePlayer(@PathVariable Integer id){
        playerService.deletePlayer(id);
        return playerService.getPlayerById(id);
    }

    @PutMapping("/update")
    public Player updatePlayer(@RequestBody Player player){
        return playerService.updatePlayer(player);
    }
}
