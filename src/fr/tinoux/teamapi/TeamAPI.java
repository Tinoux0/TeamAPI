package fr.tinoux.teamapi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Set;

public class TeamAPI {

    private Scoreboard sc;

    public TeamAPI() {
        this.sc = Bukkit.getScoreboardManager().getNewScoreboard();
    }

    public void createTeam(String name, ChatColor color) {
        Team team = this.sc.registerNewTeam(name);
        team.setColor(color);
        team.setAllowFriendlyFire(false);
        team.setCanSeeFriendlyInvisibles(true);
    }

    public void removeTeam(Team team) {
        team.unregister();
    }

    public void addPlayer(Team team, String playerName) {
        team.addEntry(playerName);
    }

    public void removePlayer(Team team, String playerName) {
        team.removeEntry(playerName);
    }

    public Team getTeamOfPlayer(String playerName) {
        return this.sc.getEntryTeam(playerName);
    }

    public Team getTeam(String name) {
        return this.sc.getTeam(name);
    }

    public Set<String> getTeams() { return this.sc.getEntries(); }

    public Scoreboard getScoreboard() {
        return sc;
    }

}
