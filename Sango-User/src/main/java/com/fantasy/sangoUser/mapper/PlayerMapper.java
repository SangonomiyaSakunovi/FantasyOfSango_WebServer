package com.fantasy.sangoUser.mapper;

import com.fantasy.sangoUser.entity.Player;

public interface PlayerMapper {
    int insertPlayer(Player player);
    Player selectPlayerByPlayerId(int playerId);
}
