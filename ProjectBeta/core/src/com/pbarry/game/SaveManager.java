package com.pbarry.game;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.pbarry.game.entities.Player;

/**
 * Created by Tom on 23/01/2016.
 */
public class SaveManager {

    private int currentSaveID;
    private int currentLevelID;
    private Player playerEntity; //Needs to contain a reputation component
    //private questManager;


    public SaveManager(int currentSaveID, int currentLevelID, Player playerEntity) {
        this.currentSaveID = currentSaveID;
        this.currentLevelID = currentLevelID;
        this.playerEntity = playerEntity;
    }

    public int getSaveID(){
        return currentSaveID;
    }

    public int getLevelID(){
        return currentLevelID;
    }

    public Player getPlayerEntity(){
        return playerEntity;
    }

    /**
     * Saves the current state of the game to a json given a saveID
     * @param saveID saveID of the save file. If unique creates a new save file otherwise overwrites another save.
     * @param currentLevelID the levelID currently loaded in
     * @param player the current Player entity which stores its position and statistics
     */
    public void SaveGame(int saveID, int currentLevelID, Player player) {
        this.currentSaveID = saveID;
        this.currentLevelID = currentLevelID;
        this.playerEntity = player;
        new Json().toJson(this, SaveManager.class,new FileHandle("Saves/" + currentLevelID + ".json"));
    }


    //could create a save class to be able to return all the information without the need for getters
    /**
     * Loads this saveManager with the correct saveID, levelID and PlayerEntity
     * which then need to be retrieved by there respective getters
     * @param saveID saveID of the save you are loading from
     */
    public void LoadSaveIntoManager(int saveID){
        SaveManager newSaveManager = new Json().fromJson(SaveManager.class, "Saves/" + saveID + ".json");
        this.currentSaveID = saveID;
        this.currentLevelID = newSaveManager.currentLevelID;
        this.playerEntity = newSaveManager.playerEntity;
    }


}
