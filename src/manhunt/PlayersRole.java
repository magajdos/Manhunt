package manhunt;

import com.google.common.collect.Sets;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class PlayersRole {


    private final Set<String> players;
    private Set<String> hunters;
    private String prey;

    public PlayersRole(Set<Player> players) {
        this.players = players.stream()
                .map(Player::getName)
                .collect(Collectors.toSet());
    }

    public boolean isPrey(Player player) {
        return player.getName().equals(prey);
    }

    public boolean isHunter(Player player) {
        return hunters.contains(player.getName());
    }

    public Set<String> getHunters() {
        return hunters;
    }

    public String getPrey() {
        return prey;
    }

    public Optional<Player> getPrey(List<Player> players) {
        for (var player : players) {
            if (player.getName().equals(prey)) {
                return Optional.of(player);
            }
        }
        return Optional.empty();
    }

    public void setPrey(Player prey) {
        setPrey(prey.getName());
    }

    public void setPrey(String prey) {
        hunters = Sets.newHashSet(players);
        this.prey = prey;
        hunters.remove(prey);
    }
}