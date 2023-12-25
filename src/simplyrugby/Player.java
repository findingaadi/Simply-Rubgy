/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

/**
 *
 * @author HP
 */
public class Player {

    private Integer playerId;
    private String name;
    private String sruNum;
    private String address;
    private String phone;
    private Integer postCode;
    private String doctor;
    private String nextOfKin;
    private Team team;
     private String knownHealth;

    // Constructor
    public Player(Integer playerId, String name, String sruNum, String address, String phone, Integer postCode,
            String doctor, String nextOfKin,String knownHealth) {
        this.playerId = playerId;
        this.name = name;
        this.sruNum = sruNum;
        this.address = address;
        this.phone = phone;
        this.postCode = postCode;
        this.doctor = doctor;
        this.nextOfKin = nextOfKin;
        this.knownHealth = knownHealth;
    }

    // Getters and Setters
    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSruNum() {
        return sruNum;
    }

    public void setSruNum(String sruNum) {
        this.sruNum = sruNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public String getKnownHealth() {
        return knownHealth;
    }

    public void setKnownHealth(String knownHealth) {
        this.knownHealth = knownHealth;
    }
    

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
