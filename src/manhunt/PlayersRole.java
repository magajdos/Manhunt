package manhunt;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class PlayersRole {

    private final Server server;
    private List<Player> hunters;
    private Player prey;

    public PlayersRole(Server server) {
        this.server = server;
    }

    public boolean isPrey(Player player) {
        return player == prey;
    }

    public boolean isHunter(Player player) {
        return hunters.contains(player);
    }

    public List<Player> getHunters() {
        return hunters;
    }

    public Player getPrey() {
        return prey;
    }

    public void setPrey(String nameOfPrey) {
        this.prey = server.getOnlinePlayers().stream().filter(player -> player.getName().equals(nameOfPrey)).findFirst().orElseThrow().getPlayer();
        hunters = server.getOnlinePlayers().stream().filter(player -> !player.getName().equals(nameOfPrey)).collect(Collectors.toList());
    }

    public void reset(){
        prey = null;
        hunters.clear();
    }
}