package com.example.demo.Repositories;

import com.example.demo.Models.AssetTeam;
import com.example.demo.Models.Oi;
import com.example.demo.Models.Patent;
import com.example.demo.Models.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetTeamRepo extends JpaRepository<AssetTeam, Long> {
    List<AssetTeam> findAllByOi(Oi oi);
}
