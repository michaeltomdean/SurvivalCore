
package survivalcore.survivalcore;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.scoreboard.*;
import survivalcore.survivalcore.Commands.MessageCommand;
import survivalcore.survivalcore.Commands.StaffChat;
import survivalcore.survivalcore.Commands.StaffMode;
import survivalcore.survivalcore.Commands.StaffRandomTeleport;

import survivalcore.survivalcore.Events.CancellingCreepers;
import survivalcore.survivalcore.Events.ChangingGamemode;
import survivalcore.survivalcore.Events.ChatFormatting;
import survivalcore.survivalcore.Events.JoiningMessages;

public final class Main extends JavaPlugin {
    public static Main instance;

    public static HashSet<UUID> InStaff = new HashSet<>();

    @Override
    public void onEnable() {

        //Instance of my plugin
        instance = this;

        //Events registered
        getServer().getPluginManager().registerEvents(new ChangingGamemode(), this);
        getServer().getPluginManager().registerEvents(new JoiningMessages(), this);
        getServer().getPluginManager().registerEvents(new CancellingCreepers(), this);
        getServer().getPluginManager().registerEvents(new ChatFormatting(), this);

        //Commands registered
        getCommand("t").setExecutor(new StaffRandomTeleport());
        getCommand("msg").setExecutor(new MessageCommand());
        getCommand("w").setExecutor(new MessageCommand());
        getCommand("reply").setExecutor(new MessageCommand());
        getCommand("r").setExecutor(new MessageCommand());
        getCommand("staffmode").setExecutor(new StaffMode());
        getCommand("staffchat").setExecutor(new StaffChat());
        getCommand("sc").setExecutor(new StaffChat());
        getCommand("ac").setExecutor(new StaffChat());

        //Scoreboard (In main so that it can run with bukkit scheduler)
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
            public void run(){
                for(Player player : Bukkit.getOnlinePlayers()){

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                    LocalTime time = LocalTime.now();

                    ScoreboardManager manager = Bukkit.getScoreboardManager();
                    Scoreboard scoreboard = manager.getNewScoreboard();

                    Objective objective = scoreboard.registerNewObjective("Test", "dummy", ChatColor.GREEN + "" + ChatColor.BOLD + "Survival");
                    objective.setDisplaySlot(DisplaySlot.SIDEBAR);

                    Location loc = new Location(Bukkit.getWorld("world"), -2749, 64, -1152);

                    if (player.getLocation().distance(loc)<200){
                        Score location = objective.getScore("Location: " + ChatColor.GREEN + "Town");
                        location.setScore(4);

                    }else{
                        Score location = objective.getScore("Location: " + ChatColor.GREEN + "The Wild");
                        location.setScore(4);
                    }

                    Score blank = objective.getScore(" ");
                    blank.setScore(7);

                    Score Time = objective.getScore("Time: " + ChatColor.GREEN + time.format(formatter));
                    Time.setScore(6);

                    Score level = objective.getScore("Level: " + ChatColor.GREEN + player.getLevel());
                    level.setScore(3);

                    Score blank2 = objective.getScore("");
                    blank2.setScore(1);

                    Score server = objective.getScore(ChatColor.AQUA + "discord.me/ExeMine");
                    server.setScore(1);

                    Score name = objective.getScore("Name: " + ChatColor.GREEN + player.getName());
                    name.setScore(5);

                    Score Ping = objective.getScore("Ping: " + ChatColor.GREEN + player.getPing());
                    Ping.setScore(2);

                    player.setScoreboard(scoreboard);

                }
            }
        }, 20l, 20l);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }


}
